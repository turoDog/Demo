package com.nasus.batch.config;

import com.nasus.batch.csv.CsvBeanValidator;
import com.nasus.batch.csv.CsvItemProcessor;
import com.nasus.batch.csv.CsvJobListener;
import com.nasus.batch.domain.Student;
import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Project Name:springboot_batch_demo <br/>
 * Package Name:com.nasus.batch.config <br/>
 * Date:2019/3/31 15:55 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
@Configuration
@EnableBatchProcessing
public class CsvBatchConfig{

    @Bean
    public ItemReader<Student> reader() throws Exception {
        FlatFileItemReader<Student> reader = new FlatFileItemReader<Student>(); // 使用 FlatFileItemReader 读取文件
        reader.setResource(new ClassPathResource("Student.csv")); // FlatFileItemReader 的 ClassPathResource 设置 csv 文件的路径
        reader.setLineMapper(new DefaultLineMapper<Student>() {{ // 对 csv 文件的数据以及实体做对应的映射
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "name","age", "gender"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Student>() {{
                setTargetType(Student.class);
            }});
        }});
        return reader;
    }

    @Bean
    public ItemProcessor<Student, Student> processor() {
        CsvItemProcessor processor = new CsvItemProcessor(); // 使用自定义的 itemProcessor 实现 CsvItemProcessor
        processor.setValidator(csvBeanValidator()); // 为 processor 指定校验器为 CsvBeanValidator
        return processor;
    }



    @Bean
    public ItemWriter<Student> writer(DataSource dataSource) {// Spring 能让容器中已有 bean 以参数的形式注入，SpringBoot 已为我们定义了 dataSource
        JdbcBatchItemWriter<Student> writer = new JdbcBatchItemWriter<Student>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Student>());
        String sql = "insert into student " + "(id,name,age,gender) "
                + "values(hibernate_sequence.nextval, :name, :age, :gender)";
        writer.setSql(sql); // 设置要执行批处理的 sql 语句
        writer.setDataSource(dataSource);
        return writer;
    }


    @Bean
    public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager transactionManager)
            throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(dataSource);
        jobRepositoryFactoryBean.setTransactionManager(transactionManager);
        jobRepositoryFactoryBean.setDatabaseType("mysql");
        return jobRepositoryFactoryBean.getObject();
    }

    @Bean
    public SimpleJobLauncher jobLauncher(DataSource dataSource, PlatformTransactionManager transactionManager)
            throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository(dataSource, transactionManager));
        return jobLauncher;
    }

    @Bean
    public Job importJob(JobBuilderFactory jobs, Step s1) {
        return jobs.get("importJob")
                .incrementer(new RunIdIncrementer())
                .flow(s1) //为 job 指定 step
                .end()
                .listener(csvJobListener()) //绑定监听器 csvJobListener
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<Student> reader, ItemWriter<Student> writer,
            ItemProcessor<Student,Student> processor) {
        return stepBuilderFactory
                .get("step1")
                .<Student, Student>chunk(65000) //批处理每次提交 65000 条数据
                .reader(reader) // 给 step 绑定 reader
                .processor(processor) // 给 step 绑定 processor
                .writer(writer) // 给 step 绑定 writer
                .build();
    }



    @Bean
    public CsvJobListener csvJobListener() {
        return new CsvJobListener();
    }

    @Bean
    public Validator<Student> csvBeanValidator() {
        return new CsvBeanValidator<Student>();
    }

}

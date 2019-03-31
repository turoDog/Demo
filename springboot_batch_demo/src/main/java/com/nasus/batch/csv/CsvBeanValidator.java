package com.nasus.batch.csv;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

/**
 * Project Name:springboot_batch_demo <br/>
 * Package Name:com.nasus.batch.csv <br/>
 * Date:2019/3/31 15:38 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public class CsvBeanValidator<T> implements Validator<T>, InitializingBean {


    private javax.validation.Validator validator;

    @Override
    public void validate(T t) throws ValidationException {
        // 使用 validator 的 validate 方法校验数据
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

        if (constraintViolations.size() > 0){
            StringBuilder message = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation : constraintViolations){
                message.append(constraintViolation.getMessage() + "\n");
            }
            throw new ValidationException(message.toString());
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 使用 JSR-303 的 Validator 校验数据，在此处进行 JSR-303 的 Validator 的初始化
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }
}

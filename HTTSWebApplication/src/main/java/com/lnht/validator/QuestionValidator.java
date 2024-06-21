/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.validator;

import com.lnht.pojo.Binhluan;
import com.lnht.pojo.CommentDTO;
import com.lnht.pojo.QuestionDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author minh-nguyen
 */
@Component
public class QuestionValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return QuestionDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        QuestionDTO b = (QuestionDTO) target;
        
         if(b.getId()==null
                ){
            errors.rejectValue("hoten", "value.NullMsg");
        }
        if(b.getHoten().isEmpty()==true || b.getHoten()==null
                ){
            errors.rejectValue("hoten", "value.NullMsg");
        }
        if(b.getThoidiemdate().isEmpty()==true || b.getThoidiemdate()==null){
            errors.rejectValue("thoidiemdate", "value.NullMsg");
        }

    }
    
}

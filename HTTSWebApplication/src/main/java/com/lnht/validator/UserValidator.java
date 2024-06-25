/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.validator;

import com.lnht.pojo.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author minh-nguyen
 */
@Component
public class UserValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO user = (UserDTO) target;
        if(user.getHoten().isEmpty()==true){
            errors.rejectValue("hoten", "value.EmptyMsg");
        }
        if(user.getPassword().equals(user.getConfirmPassword())==false){
            errors.rejectValue("password", "value.PasswordEqualMsg");
            errors.rejectValue("confirmPassword", "value.PasswordEqualMsg");
        }
        if(user.getUsername().isEmpty()==false){
            errors.rejectValue("username", "value.EmptyMsg");
        }
    }
    
}

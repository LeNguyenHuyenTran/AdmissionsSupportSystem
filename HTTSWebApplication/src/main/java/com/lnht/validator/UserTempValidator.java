/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.validator;

import com.lnht.pojo.UserDTO;
import java.util.Objects;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author minh-nguyen
 */
public class UserTempValidator extends ValidatorTemp{
    
    
    public boolean usernameValidator(String username){
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[\\W_]).{8,}$";

        if(username.length()<6){
            this.getErrors().add(this.getLengthUsernameMsg());
            return false;
        }else{
            if(username.matches(regex)==false){
                this.getErrors().add(this.getUsernameMsg());
                return false;
            }else{
                return true;
            }
        }
    }
    
    public boolean passwordValidator(String password){
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[\\W_]).{8,}$";
        if(password.length()<8){
            this.getErrors().add(this.getLengthPasswordMsg());
            return false;
        }else{
            if(password.matches(regex)==false){
                this.getErrors().add(this.getPasswordMsg());
                return false;
            }else{
                return true;
            }
        }
        
    }
    
    public boolean validate(UserDTO target) {
        Boolean hasErrors=false;
        UserDTO user = target;
        
        if(user.getId().toString().isEmpty()==true){
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(user.getId()));
            this.getErrors().add(this.getEmptyMsg());
            hasErrors=true;
        }
        if(user.getHoten().isEmpty()==true){
            this.setEmptyMsg(this.getEmptyMsg(), user.getHoten());
            this.getErrors().add(this.getEmptyMsg());
            hasErrors=true;
        }
        if(this.usernameValidator(user.getUsername())==false){
            this.getErrors().add(this.getUsernameMsg());
            hasErrors=true;
        }
        Boolean isPassword = false;
        Boolean isConfirmPassword = false;

        if(this.passwordValidator(user.getPassword())==false){
            this.getErrors().add(this.getPasswordMsg());
            hasErrors=true;
        }else{
            isPassword=true;
        }
        if(this.passwordValidator(user.getConfirmPassword())==false){
            this.getErrors().add(this.getPasswordMsg());
            hasErrors=true;
        }else{
            isConfirmPassword=true;
        }
        if(Objects.equals(isConfirmPassword, isPassword)){
            if(user.getConfirmPassword().equals(user.getPassword())==false){
                this.getErrors().add(this.getPasswordMatchMsg());
                hasErrors=true;
            }
        }
        if(hasErrors==true){
            return false;
        }else{
            return true;
        }
    }
    

    
}

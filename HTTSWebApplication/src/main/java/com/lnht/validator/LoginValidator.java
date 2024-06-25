/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.validator;

/**
 *
 * @author minh-nguyen
 */
public class LoginValidator extends ValidatorTemp{
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
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.validator;

import com.lnht.pojo.FacultyDTO;

/**
 *
 * @author minh-nguyen
 */
public class FacultyValidator extends ValidatorTemp{
    public boolean validator(FacultyDTO target){
        Boolean hasErrors =false;
        
        if(String.valueOf(target.getId()).isEmpty()==true){
            hasErrors=true;
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getId()));
            this.getErrors().add(this.getEmptyMsg());
        }
        if(target.getTenkhoa().isEmpty()==true){
            hasErrors=true;
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getTenkhoa()));
            this.getErrors().add(this.getEmptyMsg());
        }
        if(target.getVideo().isEmpty()==true){
            hasErrors=true;
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getVideo()));
            this.getErrors().add(this.getEmptyMsg());
        }
        if(target.getNoidung().isEmpty()==true){
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getNoidung()));
            this.getErrors().add(this.getEmptyMsg());
            hasErrors=true;
        }
        
        
        
        if(hasErrors==true){
            return false;
        }else{
            return true;
        }
    }
}

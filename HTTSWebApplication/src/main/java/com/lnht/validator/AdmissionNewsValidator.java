/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.validator;

import com.lnht.pojo.AdmissionNewsDTO;

/**
 *
 * @author minh-nguyen
 */
public class AdmissionNewsValidator extends ValidatorTemp{
    public boolean validate(AdmissionNewsDTO target){
        Boolean hasErrors=false;
        
        if(String.valueOf(target.getId()).isEmpty()==true){
            hasErrors=true;
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getId()));
            this.getErrors().add(this.getEmptyMsg());
        }
        if(target.getLoaituyensinhid().isEmpty()==true){
            hasErrors=true;
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getLoaituyensinhid()));
            this.getErrors().add(this.getEmptyMsg());
        }
        if(target.getTieude().isEmpty()==true){
            hasErrors=true;
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getTieude()));
            this.getErrors().add(this.getEmptyMsg());
        }
        if(target.getNoidung().isEmpty()==true){
            hasErrors=true;
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getNoidung()));
            this.getErrors().add(this.getEmptyMsg());
        }
        
        if(hasErrors==true){
            return false;
        }else{
            return true;
        }
    }
}

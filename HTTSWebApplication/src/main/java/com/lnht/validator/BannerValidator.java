/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.validator;

import com.lnht.pojo.BannerDTO;

/**
 *
 * @author minh-nguyen
 */
public class BannerValidator extends ValidatorTemp{
     public boolean validator(BannerDTO target){
        Boolean hasErrors=false;
        
        if(String.valueOf(target.getId()).isEmpty()==true){
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getId()));
            this.getErrors().add(this.getEmptyMsg());
            hasErrors=true;
        }
        if(target.getFile().isEmpty()==true
                ||target.getFile()==null
                ||target.getFile().getSize()==0
                ){
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getFile().getOriginalFilename()));
            this.getErrors().add(this.getEmptyMsg());
            hasErrors=true;
        }
        if(target.getUserid().isEmpty()==true){
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getUserid()));
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

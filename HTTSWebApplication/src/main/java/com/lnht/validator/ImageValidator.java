/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.validator;

import com.lnht.pojo.ImageDTO;

/**
 *
 * @author minh-nguyen
 */
public class ImageValidator extends ValidatorTemp{
    public boolean validator(ImageDTO target){
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
        if(target.getNguoidangid().isEmpty()==true){
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getNguoidangid()));
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.validator;

import com.lnht.pojo.EducationProgramDTO;

/**
 *
 * @author minh-nguyen
 */
public class EducationProgramValidator extends ValidatorTemp {

    public boolean validate(EducationProgramDTO target) {
        Boolean hasErrors = false;

        if (String.valueOf(target.getId()).isEmpty() == true) {
            hasErrors = true;
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getId()));
            this.getErrors().add(this.getEmptyMsg());
        }
        if (target.getTen().isEmpty() == true) {
            hasErrors = true;
            this.setEmptyMsg(this.getEmptyMsg(), target.getTen());
            this.getErrors().add(this.getEmptyMsg());
        }
        if (target.getMota().isEmpty() == true) {
            hasErrors = true;
            this.setEmptyMsg(this.getEmptyMsg(), target.getMota());
            this.getErrors().add(this.getEmptyMsg());
        }

        if (hasErrors == true) {
            return false;
        } else {
            return true;
        }
    }
}

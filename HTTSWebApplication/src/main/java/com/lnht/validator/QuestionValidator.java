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
public class QuestionValidator extends ValidatorTemp {

    public boolean validate(QuestionDTO target) {
        Boolean hasErrors = false;

        if (String.valueOf(target.getId()).isEmpty()==true) {
            hasErrors = true;
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getId()));
            this.getErrors().add(this.getEmptyMsg());
        }
        if (target.getThoidiem().isEmpty() == true) {
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getThoidiem()));
            this.getErrors().add(this.getEmptyMsg());
            hasErrors = true;
        }
        if (target.getNoidung().isEmpty() == true) {
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getNoidung()));

            this.getErrors().add(this.getEmptyMsg());
            hasErrors = true;
        }
        if (target.getLivestreamnotifyid().isEmpty() == true) {
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getLivestreamnotifyid()));

            this.getErrors().add(this.getEmptyMsg());
            hasErrors = true;

        }
        if (target.getUserid().isEmpty() == true) {

            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getUserid()));

            this.getErrors().add(this.getEmptyMsg());
            hasErrors = true;
        }
        if (target.getVideolivestreamid().isEmpty() == true) {

            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getVideolivestreamid()));

            this.getErrors().add(this.getEmptyMsg());
            hasErrors = true;
        }
        if (hasErrors == true) {
            return false;
        } else {
            return true;
        }
    }

}

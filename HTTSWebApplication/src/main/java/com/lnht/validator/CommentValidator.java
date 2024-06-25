/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.validator;

import com.lnht.pojo.CommentDTO;

/**
 *
 * @author minh-nguyen
 */
public class CommentValidator extends ValidatorTemp {

    public boolean validate(CommentDTO target) {
        Boolean hasErrors = false;

        if (target.getId().isEmpty() == true) {
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getId()));
            this.getErrors().add(this.getEmptyMsg());
            hasErrors = true;
        }
        if (target.getAdmissionnewsid().isEmpty() == true) {
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getAdmissionnewsid()));
            this.getErrors().add(this.getEmptyMsg());
            hasErrors = true;
        }
        if (target.getUserid().isEmpty() == true) {
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getUserid()));
            this.getErrors().add(this.getEmptyMsg());
            hasErrors = true;
        }
        if (target.getBinhluan().isEmpty() == true) {
            this.setEmptyMsg(this.getEmptyMsg(), String.valueOf(target.getBinhluan()));
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

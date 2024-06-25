/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.validator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minh-nguyen
 */
public class ValidatorTemp {
    private String lengthPasswordMsg="Password must over 8";
    private String lengthUsernameMsg="Username must over 6";
    private String passwordMatchMsg="Passwords are not match";
    private String existUser="User is exist";
    

    private String nullMsg = "Value is null";
    private String emptyMsg = "Value is empty";
    private String ScoreMsg = "Score is under 30";
    private String YearMsg = "Year is YYYY";
    private String UsernameMsg="Username include alphabet, digit, special chars";
    private String passwordMsg="Password include alphabet, digit, special chars";
    private List<String> errors = new ArrayList<>();
    

    /**
     * @return the nullMsg
     */
    public String getNullMsg() {
        return nullMsg;
    }

    /**
     * @param nullMsg the nullMsg to set
     * @param name
     */
    public void setNullMsg(String nullMsg, String name) {
        this.nullMsg = name+", "+nullMsg;
    }

    /**
     * @return the emptyMsg
     */
    public String getEmptyMsg() {
        return emptyMsg;
    }

    /**
     * @param emptyMsg the emptyMsg to set
     * @param name
     */
    public void setEmptyMsg(String emptyMsg, String name) {
        this.emptyMsg = name+", "+emptyMsg;
    }

    /**
     * @return the ScoreMsg
     */
    public String getScoreMsg() {
        return ScoreMsg;
    }

    /**
     * @param ScoreMsg the ScoreMsg to set
     */
    public void setScoreMsg(String ScoreMsg) {
        this.ScoreMsg = ScoreMsg;
    }

    /**
     * @return the YearMsg
     */
    public String getYearMsg() {
        return YearMsg;
    }

    /**
     * @param YearMsg the YearMsg to set
     */
    public void setYearMsg(String YearMsg) {
        this.YearMsg = YearMsg;
    }

    /**
     * @return the UsernameMsg
     */
    public String getUsernameMsg() {
        return UsernameMsg;
    }

    /**
     * @param UsernameMsg the UsernameMsg to set
     */
    public void setUsernameMsg(String UsernameMsg) {
        this.UsernameMsg = UsernameMsg;
    }



    /**
     * @return the errors
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * @param errors the errors to set
     */
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    /**
     * @return the lengthPasswordMsg
     */
    public String getLengthPasswordMsg() {
        return lengthPasswordMsg;
    }

    /**
     * @param lengthPasswordMsg the lengthPasswordMsg to set
     */
    public void setLengthPasswordMsg(String lengthPasswordMsg) {
        this.lengthPasswordMsg = lengthPasswordMsg;
    }

    /**
     * @return the passwordMsg
     */
    public String getPasswordMsg() {
        return passwordMsg;
    }

    /**
     * @param passwordMsg the passwordMsg to set
     */
    public void setPasswordMsg(String passwordMsg) {
        this.passwordMsg = passwordMsg;
    }

    /**
     * @return the lengthUsernameMsg
     */
    public String getLengthUsernameMsg() {
        return lengthUsernameMsg;
    }

    /**
     * @param lengthUsernameMsg the lengthUsernameMsg to set
     */
    public void setLengthUsernameMsg(String lengthUsernameMsg) {
        this.lengthUsernameMsg = lengthUsernameMsg;
    }

    /**
     * @return the passwordMatchMsg
     */
    public String getPasswordMatchMsg() {
        return passwordMatchMsg;
    }

    /**
     * @param passwordMatchMsg the passwordMatchMsg to set
     */
    public void setPasswordMatchMsg(String passwordMatchMsg) {
        this.passwordMatchMsg = passwordMatchMsg;
    }

    /**
     * @return the existUser
     */
    public String getExistUser() {
        return existUser;
    }

    /**
     * @param existUser the existUser to set
     */
    public void setExistUser(String existUser) {
        this.existUser = existUser;
    }

}

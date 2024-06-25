/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.validator;

import com.lnht.pojo.AdmissionScoreDTO;

/**
 *
 * @author minh-nguyen
 */
public class AdmissionScoreValidator extends ValidatorTemp{
    public boolean ScoreValidator(String score){
        if(score.isEmpty()==true){
            return false;
        }
        Double Score = Double.valueOf(score);
        double max=30;
        return Score < 30;
    }
    public boolean YearValidator(String year){
        if(year.isEmpty()==true){
            return false;
        }
        String y = String.valueOf(year);
        return y.length()==4;
    }
    public boolean validator(AdmissionScoreDTO target){
        Boolean hasErrors = false;
        if(String.valueOf(target.getId()).isEmpty()==true){
            this.setEmptyMsg(this.getEmptyMsg(),String.valueOf(target.getId()));
            this.getErrors().add(this.getEmptyMsg());
            hasErrors=true;
        }
        if(this.ScoreValidator(target.getDiem())==false){
            this.getErrors().add(this.getScoreMsg());
            hasErrors=true;
        }
        if(this.YearValidator(target.getNamhoc())==false){
            this.getErrors().add(this.getYearMsg());
            hasErrors=true;
        }
        if(target.getChuongtrinhdaotaoid().isEmpty()==true){
            this.setEmptyMsg(this.getEmptyMsg(), target.getChuongtrinhdaotaoid());
            this.getErrors().add(this.getEmptyMsg());
                        hasErrors=true;

        }
        if(target.getKhoaid().isEmpty()==true){
            this.setEmptyMsg(this.getEmptyMsg(), target.getKhoaid());
            this.getErrors().add(this.getEmptyMsg());
            hasErrors=true;

        }
        if(target.getNganhid().isEmpty()==true){
            this.setEmptyMsg(this.getEmptyMsg(), target.getNganhid());
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

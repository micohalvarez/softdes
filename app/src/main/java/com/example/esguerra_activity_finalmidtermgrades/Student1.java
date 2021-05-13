package com.example.esguerra_activity_finalmidtermgrades;

public class Student1 {
    private String finalmidterm;
    private String finalfinal;
    private String finaloverall;
    private String finalconvertgrade;
    private String finalstatus;

    public Student1() {
    }

    public Student1(String finalmidterm, String finalfinal, String finaloverall, String finalconvertgrade, String finalstatus) {
        this.finalmidterm = finalmidterm;
        this.finalfinal = finalfinal;
        this.finaloverall = finaloverall;
        this.finalconvertgrade = finalconvertgrade;
        this.finalstatus = finalstatus;

    }

    public String getFinalstatus() {
        return finalstatus;
    }

    public void setFinalstatus(String finalstatus) {
        this.finalstatus = finalstatus;
    }

    public String getFinalmidterm() {
        return finalmidterm;
    }

    public void setFinalmidterm(String finalmidterm){
        this.finalmidterm = finalmidterm;
    }

    public String getFinalfinal() {
        return finalfinal;
    }

    public void setFinalfinal(String finalfinal) {
        this.finalfinal = finalfinal;
    }

    public String getFinaloverall() {
        return finaloverall;
    }

    public void setFinaloverall(String finaloverall) {
        this.finaloverall = finaloverall;
    }

    public String getFinalconvertgrade() {
        return finalconvertgrade;
    }

    public void setFinalconvertgrade(String finalconvertgrade) { this.finalconvertgrade = finalconvertgrade; }



}

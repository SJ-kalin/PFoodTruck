package com.example.ckh.foodtruck.seller;

import java.io.Serializable;

/**
 * Created by HOME on 2016-09-22.
 */

/*
*   변수들을 private 선언 및 getter/setter 메서드 추가하여 DTO 를 구현하였음
*   170527 kalin
* */
public class MovingPeopleDTO implements Serializable {
    // Serializable로 직렬화 했다. ArrayList에 담기는 객체를 직렬화 해야 인텐트에 전달시킬 수 있음
    public MovingPeopleDTO(String examin_spot_cd, int male, int female, int twyoBelow, int twnt_thrts, int frts_ffts,
                           int sxts_above, String examin_spot_name, double Xcode, double Ycode, String guCode, String guname) {
        this.examin_spot_cd = examin_spot_cd;
        this.examin_spot_name = examin_spot_name;
        this.male = male;
        this.female = female;
        this.twyoBelow = twyoBelow;
        this.twnt_thrts = twnt_thrts;
        this.sxts_above = sxts_above;
        this.frts_ffts = frts_ffts;
        this.Xcode = Xcode;
        this.Ycode = Ycode;
        this.guCode = guCode;
        this.guname = guname;
    }

    private String examin_spot_cd;
    private String guCode;
    private String examin_spot_name;
    private int male;
    private int female;
    private int twyoBelow;
    private int twnt_thrts;
    private int frts_ffts;
    private int sxts_above;
    private double Xcode;
    private double Ycode;
    private String guname;

    @Override
    public String toString() {
        return "[" + examin_spot_cd + "\t" + male + " " + female + "\t" + twyoBelow + " " + twnt_thrts + " " + frts_ffts
                + " " + sxts_above + "\t" + examin_spot_name + "\t" + Xcode + " " + Ycode + "\t" + guCode + " " + guname
                + "]";

    }

    public String getExamin_spot_cd() {
        return examin_spot_cd;
    }

    public void setExamin_spot_cd(String examin_spot_cd) {
        this.examin_spot_cd = examin_spot_cd;
    }

    public String getGuCode() {
        return guCode;
    }

    public void setGuCode(String guCode) {
        this.guCode = guCode;
    }

    public String getExamin_spot_name() {
        return examin_spot_name;
    }

    public void setExamin_spot_name(String examin_spot_name) {
        this.examin_spot_name = examin_spot_name;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
    }

    public int getTwyoBelow() {
        return twyoBelow;
    }

    public void setTwyoBelow(int twyoBelow) {
        this.twyoBelow = twyoBelow;
    }

    public int getTwnt_thrts() {
        return twnt_thrts;
    }

    public void setTwnt_thrts(int twnt_thrts) {
        this.twnt_thrts = twnt_thrts;
    }

    public int getFrts_ffts() {
        return frts_ffts;
    }

    public void setFrts_ffts(int frts_ffts) {
        this.frts_ffts = frts_ffts;
    }

    public int getSxts_above() {
        return sxts_above;
    }

    public void setSxts_above(int sxts_above) {
        this.sxts_above = sxts_above;
    }

    public double getXcode() {
        return Xcode;
    }

    public void setXcode(double xcode) {
        Xcode = xcode;
    }

    public double getYcode() {
        return Ycode;
    }

    public void setYcode(double ycode) {
        Ycode = ycode;
    }

    public String getGuname() {
        return guname;
    }

    public void setGuname(String guname) {
        this.guname = guname;
    }

    public String toStringXcode() {
        return "" + Xcode;
    }

    public String toStringYcode() {
        return "" + Ycode;
    }

}
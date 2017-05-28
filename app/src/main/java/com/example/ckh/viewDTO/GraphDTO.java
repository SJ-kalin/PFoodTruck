package com.example.ckh.viewDTO;

import com.example.ckh.foodtruck.seller.MovingPeopleDTO;

/**
 * Created by kalin on 2017-05-28.
 */

public class GraphDTO {
    private MovingPeopleDTO targetRatio;
    private int maleRatio;
    private int femaleRatio;
    private int totalGender;
    private float twyoBelowRatio;
    private float twnt_thrtsRatio;
    private float frts_fftsRatio;
    private float sxts_aboveRatio;
    private int totalAge;

    public MovingPeopleDTO getTargetRatio() {
        return targetRatio;
    }

    public void setTargetRatio(MovingPeopleDTO targetRatio) {
        this.targetRatio = targetRatio;
    }

    public int getMaleRatio() {
        return maleRatio;
    }

    public void setMaleRatio(int maleRatio) {
        this.maleRatio = maleRatio;
    }

    public int getFemaleRatio() {
        return femaleRatio;
    }

    public void setFemaleRatio(int femaleRatio) {
        this.femaleRatio = femaleRatio;
    }

    public int getTotalGender() {
        return totalGender;
    }

    public void setTotalGender(int totalGender) {
        this.totalGender = totalGender;
    }

    public float getTwyoBelowRatio() {
        return twyoBelowRatio;
    }

    public void setTwyoBelowRatio(float twyoBelowRatio) {
        this.twyoBelowRatio = twyoBelowRatio;
    }

    public float getTwnt_thrtsRatio() {
        return twnt_thrtsRatio;
    }

    public void setTwnt_thrtsRatio(float twnt_thrtsRatio) {
        this.twnt_thrtsRatio = twnt_thrtsRatio;
    }

    public float getFrts_fftsRatio() {
        return frts_fftsRatio;
    }

    public void setFrts_fftsRatio(float frts_fftsRatio) {
        this.frts_fftsRatio = frts_fftsRatio;
    }

    public float getSxts_aboveRatio() {
        return sxts_aboveRatio;
    }

    public void setSxts_aboveRatio(float sxts_aboveRatio) {
        this.sxts_aboveRatio = sxts_aboveRatio;
    }

    public int getTotalAge() {
        return totalAge;
    }

    public void setTotalAge(int totalAge) {
        this.totalAge = totalAge;
    }


}


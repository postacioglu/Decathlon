package com.decathlon.postaci.entity;


import java.util.Comparator;
import java.util.Objects;

public class DecathlonResults implements Comparator<DecathlonResults> {

    public String fullName;
    public String m100;
    public String longJump;
    public String shotPut;
    public String highJump;
    public String m400;
    public String m110Hurdles;
    public String discusThrow;
    public String poleVault;
    public String javelinThrow;
    public String m1500;
    public Points points;
    public String rank;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getM100() {
        return m100;
    }

    public void setM100(String m100) {
        this.m100 = m100;
    }

    public String getLongJump() {
        return longJump;
    }

    public void setLongJump(String longJump) {
        this.longJump = longJump;
    }

    public String getShotPut() {
        return shotPut;
    }

    public void setShotPut(String shotPut) {
        this.shotPut = shotPut;
    }

    public String getHighJump() {
        return highJump;
    }

    public void setHighJump(String highJump) {
        this.highJump = highJump;
    }

    public String getM400() {
        return m400;
    }

    public void setM400(String m400) {
        this.m400 = m400;
    }

    public String getM110Hurdles() {
        return m110Hurdles;
    }

    public void setM110Hurdles(String m110Hurdles) {
        this.m110Hurdles = m110Hurdles;
    }

    public String getDiscusThrow() {
        return discusThrow;
    }

    public void setDiscusThrow(String discusThrow) {
        this.discusThrow = discusThrow;
    }

    public String getPoleVault() {
        return poleVault;
    }

    public void setPoleVault(String poleVault) {
        this.poleVault = poleVault;
    }

    public String getJavelinThrow() {
        return javelinThrow;
    }

    public void setJavelinThrow(String javelinThrow) {
        this.javelinThrow = javelinThrow;
    }

    public String getM1500() {
        return m1500;
    }

    public void setM1500(String m1500) {
        this.m1500 = m1500;
    }

    public Points getPoints() {
        return points;
    }

    public void setPoints(Points points) {
        this.points = points;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int compare(DecathlonResults ath1, DecathlonResults ath2){
        //return ath1.getPoints().getTotalPoint() - ath2.getPoints().getTotalPoint();
        return Integer.compare(ath1.getPoints().getTotalPoint(),ath2.getPoints().getTotalPoint());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DecathlonResults)) return false;
        DecathlonResults athlete = (DecathlonResults) o;
        return Objects.equals(getPoints(), athlete.getPoints());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoints());
    }
}
package com.decathlon.postaci.entity;

import java.util.Objects;

public class Points {

    public int m100Point;
    public int longJumpPoint;
    public int shotPutPoint;
    public int highJumpPoint;
    public int m400Point;
    public int m110HurdlesPoint;
    public int discusThrowPoint;
    public int poleVaultPoint;
    public int javelinThrowPoint;
    public int m1500Point;
    public int totalPoint;

    public int getM100Point() {
        return m100Point;
    }

    public void setM100Point(int m100Point) {
        this.m100Point = m100Point;
    }

    public int getLongJumpPoint() {
        return longJumpPoint;
    }

    public void setLongJumpPoint(int longJumpPoint) {
        this.longJumpPoint = longJumpPoint;
    }

    public int getShotPutPoint() {
        return shotPutPoint;
    }

    public void setShotPutPoint(int shotPutPoint) {
        this.shotPutPoint = shotPutPoint;
    }

    public int getHighJumpPoint() {
        return highJumpPoint;
    }

    public void setHighJumpPoint(int highJumpPoint) {
        this.highJumpPoint = highJumpPoint;
    }

    public int getM400Point() {
        return m400Point;
    }

    public void setM400Point(int m400Point) {
        this.m400Point = m400Point;
    }

    public int getM110HurdlesPoint() {
        return m110HurdlesPoint;
    }

    public void setM110HurdlesPoint(int m110HurdlesPoint) {
        this.m110HurdlesPoint = m110HurdlesPoint;
    }

    public int getDiscusThrowPoint() {
        return discusThrowPoint;
    }

    public void setDiscusThrowPoint(int discusThrowPoint) {
        this.discusThrowPoint = discusThrowPoint;
    }

    public int getPoleVaultPoint() {
        return poleVaultPoint;
    }

    public void setPoleVaultPoint(int poleVaultPoint) {
        this.poleVaultPoint = poleVaultPoint;
    }

    public int getJavelinThrowPoint() {
        return javelinThrowPoint;
    }

    public void setJavelinThrowPoint(int javelinThrowPoint) {
        this.javelinThrowPoint = javelinThrowPoint;
    }

    public int getM1500Point() {
        return m1500Point;
    }

    public void setM1500Point(int m1500Point) {
        this.m1500Point = m1500Point;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Points)) return false;
        Points points = (Points) o;
        return getTotalPoint() == points.getTotalPoint();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTotalPoint());
    }
}
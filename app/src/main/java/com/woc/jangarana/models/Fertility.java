package com.woc.jangarana.models;

public class Fertility {
    String id;
    int noLivingSon,noLivingDaughter,noBornSon,noBornDaughter,noBornAliveSonLastYear,noBornAliveDaughterLastYear;

    public Fertility() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNoLivingSon() {
        return noLivingSon;
    }

    public void setNoLivingSon(int noLivingSon) {
        this.noLivingSon = noLivingSon;
    }

    public int getNoLivingDaughter() {
        return noLivingDaughter;
    }

    public void setNoLivingDaughter(int noLivingDaughter) {
        this.noLivingDaughter = noLivingDaughter;
    }

    public int getNoBornSon() {
        return noBornSon;
    }

    public void setNoBornSon(int noBornSon) {
        this.noBornSon = noBornSon;
    }

    public int getNoBornDaughter() {
        return noBornDaughter;
    }

    public void setNoBornDaughter(int noBornDaughter) {
        this.noBornDaughter = noBornDaughter;
    }

    public int getNoBornAliveSonLastYear() {
        return noBornAliveSonLastYear;
    }

    public void setNoBornAliveSonLastYear(int noBornAliveSonLastYear) {
        this.noBornAliveSonLastYear = noBornAliveSonLastYear;
    }

    public int getNoBornAliveDaughterLastYear() {
        return noBornAliveDaughterLastYear;
    }

    public void setNoBornAliveDaughterLastYear(int noBornAliveDaughterLastYear) {
        this.noBornAliveDaughterLastYear = noBornAliveDaughterLastYear;
    }
}

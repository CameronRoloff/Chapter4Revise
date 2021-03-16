package com.company.helper;

public class CookieCutter {
    /* Fields  */
    private String design;
    private int basePrice;
    private int[] featurePrices;

    /* Constructor */
    public CookieCutter(String design_, int basePrice_, int[] featurePrices_){
        this.design = design_;
        this.basePrice = basePrice_;
        this.featurePrices = featurePrices_;
    }

    /* Getters and Setters */
    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public int[] getFeaturePrices() {
        return featurePrices;
    }

    public int getFeaturePrice(int position) {
        if(this.featurePrices.length != 0){
            return this.featurePrices[position - 1];
        }
        else{
            return 0;
        }
    }

    public void setFeaturePrices(int[] featurePrices) {
        this.featurePrices = featurePrices;
    }

}
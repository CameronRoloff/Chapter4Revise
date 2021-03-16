package com.company.helper;

import java.util.ArrayList;

public class CookieCutters {
    ArrayList<CookieCutter> cookieCutters = new ArrayList<>();

    public void addCookieCutter(String design_, int basePrice_, int[] featurePrices_){
        CookieCutter cc = new CookieCutter(design_,basePrice_,featurePrices_);
        this.cookieCutters.add(cc);
    }

    public ArrayList<CookieCutter> getCookieCutters() {
        return cookieCutters;
    }

    public CookieCutter getCookieCutterByDesign(String design) {
        for(int i = 0; i < cookieCutters.size(); i++) {
            if (cookieCutters.get(i).getDesign().equals(design)) {
                return cookieCutters.get(i);
            }
        }
        return null;
    }

    public int getSize() {
        return cookieCutters.size();
    }

}

package com.example.pokemon.model.dv;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DvCatchChance {

    private final int _catchRate;
    private final double _catchChance;

    private static Map<Integer, DvCatchChance> _catchChanceMap = new HashMap<Integer, DvCatchChance>();

    private DvCatchChance(int catchRate) {
        _catchRate = catchRate;
        _catchChance = calcCatchChance();
    }

    public static DvCatchChance valueOf(int catchRate) {
        if(validCatchRate(catchRate)) {
            if(!_catchChanceMap.containsKey(catchRate)) {
                _catchChanceMap.put(catchRate, new DvCatchChance(catchRate));
            }
            return _catchChanceMap.get(catchRate);
        }
        else {
            throw new RuntimeException("No valid catch rate.");
        }
    }

    private static boolean validCatchRate(int catchRate) {
        return catchRate >= 1 && catchRate <= 255;
    }

    private double calcCatchChance() {
        return Math.pow((((double)_catchRate)/255), 0.75);
    }


    public String toString() {
        return _catchRate + " (" + chanceToPercent() + ")";
    }

    private String chanceToPercent() {
        double d = 100;
        double percentDouble = (Math.round(_catchChance * d) / d);
        int percentValue = (int) Math.round(percentDouble * 100);
        return "" + percentValue + "%";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DvCatchChance that = (DvCatchChance) o;
        return _catchRate == that._catchRate && _catchChance == that._catchChance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_catchRate, _catchChance);
    }

    public int getCatchRate() {
        return _catchRate;
    }
}

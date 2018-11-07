package com.example.my_pc.agecalculator.model;

/**
 * Created by Md Shamim Hossain
 */

public class TimeConvert {
    public static double time(String inputUnit, String outputUnit, double inputValue) {
        double outputValue = 0;    // output value

        inputUnit = inputUnit.replace(" ", "");
        outputUnit = outputUnit.replace(" ", "");

        // convert all input unit into hour
        if (inputUnit.equalsIgnoreCase("second")) {
            inputValue *= 0.000277778;
        } else if (inputUnit.equalsIgnoreCase("minute")) {
            inputValue *= 0.0166667;
        } else if (inputUnit.equalsIgnoreCase("hour")) {
            inputValue = inputValue;
        } else if (inputUnit.equalsIgnoreCase("day")) {
            inputValue *= 24;
        } else if (inputUnit.equalsIgnoreCase("week")) {
            inputValue *= 168;
        } else if (inputUnit.equalsIgnoreCase("month")) {
            inputValue *= 730.001;
        } else if (inputUnit.equalsIgnoreCase("year")) {
            inputValue *= 8760;
        } else if (inputUnit.equalsIgnoreCase("century")) {
            inputValue *= 876000;
        } else if (inputUnit.equalsIgnoreCase("millisecond")) {
            inputValue *= 0.000000277;
        } else if (inputUnit.equalsIgnoreCase("nanosecond")) {

            inputValue = inputValue * (2.77778 * Math.pow(10.0, -12.0));
        } else if (inputUnit.equalsIgnoreCase("microsecond")) {
            inputValue = inputValue * (2.77778 * Math.pow(10.0, -10.0));
        }


        if (outputUnit.equalsIgnoreCase("second")) {
            outputValue = inputValue * 3600;
        } else if (outputUnit.equalsIgnoreCase("minute")) {
            outputValue = inputValue * 60;
        } else if (outputUnit.equalsIgnoreCase("hour")) {
            outputValue = inputValue;
        } else if (outputUnit.equalsIgnoreCase("day")) {
            outputValue = inputValue * 0.0416667;
        } else if (outputUnit.equalsIgnoreCase("week")) {
            outputValue = inputValue * 0.00595238;
        } else if (outputUnit.equalsIgnoreCase("month")) {
            outputValue = inputValue * 0.00136986;
        } else if (outputUnit.equalsIgnoreCase("year")) {
            outputValue = inputValue * 0.000114155;
        } else if (outputUnit.equalsIgnoreCase("century")) {
            outputValue = inputValue * 0.000001141;
        } else if (outputUnit.equalsIgnoreCase("nanosecond")) {
            outputValue = inputValue * (3.6 * (Math.pow(10.0, 12.0)));
        } else if (outputUnit.equalsIgnoreCase("microsecond")) {
            outputValue = inputValue * (3.6 * (Math.pow(10.0, 9.0)));
        } else if (outputUnit.equalsIgnoreCase("millisecond")) {
            outputValue = inputValue * (3.6 * (Math.pow(10.0, 6.0)));
        }

        return outputValue;
    }


}

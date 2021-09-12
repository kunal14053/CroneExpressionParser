package com.expressionparser.main.constants.enums;

public enum AnyValue {

    MINUTES("Every Minute"),
    HOUR("Every Hour"),
    DAY_OF_MONTH("Every Day Of Month"),
    MONTH("Every Month od Year"),
    DAY_OF_WEEK("Every Day Of Week");

    private final String duration;

    AnyValue(String duration){
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }
}

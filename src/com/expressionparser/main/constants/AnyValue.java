package com.expressionparser.main.constants;

public enum AnyValue {

    MINUTES("Every Minute"),
    HOUR("Every Hour"),
    DAY_OF_MONTH("Every Day Of Month"),
    MONTH("Every Day of Month"),
    DAY_OF_WEEK("Every Day Of Week");

    private String duration;

    AnyValue(String duration){
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }
}

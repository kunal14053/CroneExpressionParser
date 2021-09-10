package com.expressionparser.main.constants;

public enum Range {
    MINUTE(0,59),
    HOUR(0,23),
    DAY_OF_MONTH(1,31),
    MONTH(1,12),
    DAY_OF_WEEK(0,6),
    COMMAND();


    private int start, end;

    Range(){

    }

    Range(int start, int end){
        this.end=end;
        this.start=start;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

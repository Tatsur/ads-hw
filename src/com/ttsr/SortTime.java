package com.ttsr;

import java.util.concurrent.TimeUnit;

public class SortTime {

    private Long startTime;

    private Long finishTime;

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }

    public void getResultTime(String sortType) {
        long resultTime = TimeUnit.NANOSECONDS.toMillis(finishTime - startTime);
        System.out.println(sortType + ": " + Long.toString(resultTime) + " ms");
    }
}

package com.yevdokymov.task1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Violation {
    @JsonProperty("Violation")
    public String violationName;
    @JsonProperty("Fine amount")
    public Double fineAmount = 0.0;

    public Violation(String violationName, Double fineAmount) {
        this.violationName = violationName;
        this.fineAmount = fineAmount;
    }
    public Violation() {
    }
    @Override
    public String toString() {
        return "Violation{" +
                "violationName='" + violationName + '\'' +
                ", fineAmount='" + fineAmount + '\'' +
                '}';
    }

    public String getViolationName() {
        return violationName;
    }

    public Double getFineAmount() {
        return fineAmount;
    }

    public void setViolationName(String violationName) {
        this.violationName = violationName;
    }

    public void setFineAmount(Double fineAmount) {
        this.fineAmount = fineAmount;
    }
}

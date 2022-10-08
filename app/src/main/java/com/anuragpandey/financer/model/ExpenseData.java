package com.anuragpandey.financer.model;

public class ExpenseData {

    private String expenseName;


    public ExpenseData(String expenseName) {
        this.expenseName = expenseName;
    }



    public String getExpenseName() {
        return expenseName;
    }


    @Override
    public String toString() {
        return "ExpenseData{" +
                "expenseName='" + expenseName + '\'' +
                '}';
    }
}

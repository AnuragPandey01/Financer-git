package com.anuragpandey.financer.model;

public class ExpenseData {

    private String expenseName;
    private int expenseAmount;

    public ExpenseData(String expenseName, int expenseAmount) {
        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public int getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(int expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    @Override
    public String toString() {
        return "ExpenseData{" +
                "expenseName='" + expenseName + '\'' +
                ", expenseAmount=" + expenseAmount +
                '}';
    }
}

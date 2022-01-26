package com.it.emp;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author nikai
 * @Date 2022/1/26 10:35
 * @Version 1.0
 **/
public class Emp {
    private int id; //id
    private String NAME; //姓名
    private double balance; //工资

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                ", balance=" + balance +
                '}';
    }
}

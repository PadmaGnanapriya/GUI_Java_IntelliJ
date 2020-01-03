package com.pbaumgarten.makeagui;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person  {
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate dOB;

    public Person(String name, String email, String phoneNumber, LocalDate dOB) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dOB = dOB;
    }

    public Person(String name, String email, String phoneNumber, String dOB) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.setdOB(dOB);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getdOB() {
        return dOB;
    }

    public void setdOB(LocalDate dOB) {
        this.dOB = dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = LocalDate.parse(dOB, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public int getAge()
    {
        LocalDate today=LocalDate.now();
        Period period = Period.between(this.dOB, today);
        return period.getYears();
    }
}

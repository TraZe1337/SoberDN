package com.example.soberdn.components;

import com.google.zxing.WriterException;

import java.io.IOException;

public class User {

    private static final int AMOUNT_OF_COINS_PER_SOBER = 6;
    private static int idCounter = 0;
    private final String name;
    private final String password;
    private final SimpleSoberDNService service;
    private int id;
    private int balance;
    private int amount;

    public User(String name, String password, SimpleSoberDNService service) {
        this.name = name;
        this.password = password;
        this.service = service;
        id = idCounter++ * 1024;
        balance = 0;
    }

    public String createAddQRCode() throws IOException, WriterException {
        return service.createAddQRCode(id);
    }

    public String createPayQRCode(int amount) throws IOException, WriterException {
        return service.createPayQRCode(id, amount);
    }

    public void addCoins() {
        balance += AMOUNT_OF_COINS_PER_SOBER;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public int removeCoins(int amount) {
        return balance - amount;
    }

    public String getPassword() {
        return password;
    }
}

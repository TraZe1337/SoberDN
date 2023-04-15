package com.example.soberdn.components;

import com.google.zxing.WriterException;
import java.io.IOException;

public class User {
  private static int idCounter = 0;
  private final String name;
  private final SimpleSoberDNServiceUser service;
  private int id;
  private int balance;

  public User(String name, SimpleSoberDNServiceUser service) {
    this.name = name;
    this.service = service;
    id = idCounter++ * 1024;
    balance = 0;
  }

  public String createAddQRCode() throws IOException, WriterException {
    return service.createQRCode(true, getId());
  }

  public void createPayQRCode() {

  }
  public void setBalance(int balance) {
    this.balance = balance;
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
}

package com.example.soberdn.components;

import java.io.File;

public class Bar {

  private static int idCounter = 0;
  private final String name;
  private final SimpleSoberDNService service;
  private int id;
  private int scanned;

  public Bar(String name, SimpleSoberDNService service) {
    this.name = name;
    this.service = service;
    id = idCounter++ * 1024;
    scanned = 0;
  }

  public void uploadQRCode(File file) {
    service.scanQRCode(file, id);
  }

  public void addScanned() {
    scanned++;
  }

  public int getId() {
    return id;
  }

  public int getScanned() {
    return scanned;
  }

  public String getName() {
    return name;
  }
}


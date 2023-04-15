package com.example.soberdn.components;

import com.example.soberdn.api.SoberDNServiceBar;
import com.google.zxing.NotFoundException;
import java.io.IOException;

public class SimpleSoberDNServiceBar implements SoberDNServiceBar {

  public static void main(String[] args) {
    SimpleSoberDNServiceBar t = new SimpleSoberDNServiceBar();
    t.scanQRCode();
  }
  @Override
  public void scanQRCode() {
    //wanna decrypt?
    try {
      QRCodeReader.readQRcode("src/main/resources/com/example/soberdn/qrcodes/test.jpg");
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (NotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void addCoins() {

  }

  @Override
  public void payDrink() {

  }
}

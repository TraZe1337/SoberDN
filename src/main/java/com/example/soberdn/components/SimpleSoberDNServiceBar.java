package com.example.soberdn.components;

import com.example.soberdn.MainView;
import com.example.soberdn.api.SoberDNServiceBar;
import com.google.zxing.NotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class SimpleSoberDNServiceBar implements SoberDNServiceBar {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(SimpleSoberDNServiceBar.class);

  public static void main(String[] args) {
    SimpleSoberDNServiceBar t = new SimpleSoberDNServiceBar();
    //t.scanQRCode();
  }

  @Override
  public void scanQRCode() {
    //wanna decrypt?
    try {
      String res = QRCodeReader.readQRcode("src/main/resources/com/example/soberdn/qrcodes/test.jpg");
      if (res.contains("addCoin")) {
        addCoins(Arrays.toString(res.split("-")));
      } else if (res.contains("payCoin")) {
        payDrink(Arrays.toString(res.split("-")));
      } else {
        throw new IllegalArgumentException("Not a valid QR-Code");
      }
    } catch (IOException | NotFoundException e) {
      throw new RuntimeException(e);
    } catch (IllegalArgumentException e) {
      logger.info("invalid qr-code");
    }


  }

  @Override
  public void addCoins(String id) {

  }

  @Override
  public void payDrink(String id) {

  }
}

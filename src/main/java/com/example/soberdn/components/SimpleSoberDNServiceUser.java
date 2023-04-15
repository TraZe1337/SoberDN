package com.example.soberdn.components;

import com.example.soberdn.api.SoberDNServiceUser;
import com.google.zxing.WriterException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class SimpleSoberDNServiceUser implements SoberDNServiceUser {

  public static void main(String[] args) {
    SimpleSoberDNServiceUser s = new SimpleSoberDNServiceUser();
    try {
      s.createQRCode("blabla");
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (WriterException e) {
      throw new RuntimeException(e);
    }
  }
  @Override
  public void createQRCode(String userID) throws IOException, WriterException {
    //wanna encrypt?
    QRCodeGenerator.generateQRcode(userID);
  }
}

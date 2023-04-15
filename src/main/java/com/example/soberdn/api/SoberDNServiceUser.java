package com.example.soberdn.api;

import com.google.zxing.WriterException;
import java.io.IOException;

public interface SoberDNServiceUser {
  void createQRCode(String userID) throws IOException, WriterException;
}

package com.example.soberdn.api;

import com.google.zxing.WriterException;
import java.io.IOException;

public interface SoberDNServiceUser {
  String createQRCode(boolean adding, int userID) throws IOException, WriterException;
}

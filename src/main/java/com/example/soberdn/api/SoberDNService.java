package com.example.soberdn.api;

import com.google.zxing.WriterException;
import java.io.IOException;

public interface SoberDNService {
  String createQRCode(boolean adding, int userID) throws IOException, WriterException;

  void scanQRCode(int barId);
  void addCoins(int userId, int barId);

  void payDrink(int userId, int barId);
}

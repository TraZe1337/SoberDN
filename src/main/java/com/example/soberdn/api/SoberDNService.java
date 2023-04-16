package com.example.soberdn.api;

import com.google.zxing.WriterException;
import java.io.File;
import java.io.IOException;

public interface SoberDNService {

  String createAddQRCode(int userID) throws IOException, WriterException;

  String createPayQRCode(int userID, int amount) throws IOException, WriterException;

  void scanQRCode(File file, int barId);

  void addCoins(int userId, int barId);

  void payDrink(int userId, int barId, int amount);

  void removeCoins(int userId, int amount);
}

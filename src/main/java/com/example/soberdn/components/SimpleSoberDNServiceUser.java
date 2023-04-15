package com.example.soberdn.components;

import com.example.soberdn.api.SoberDNServiceUser;
import com.google.zxing.WriterException;
import java.io.IOException;
import java.util.ArrayList;

public class SimpleSoberDNServiceUser implements SoberDNServiceUser {
  private ArrayList<User> users = new ArrayList<>();

  public static void main(String[] args) {
    SimpleSoberDNServiceUser s = new SimpleSoberDNServiceUser();
    try {
      s.createQRCode(true,1234);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (WriterException e) {
      throw new RuntimeException(e);
    }
  }
  @Override
  public String createQRCode(boolean adding, int userID) throws IOException, WriterException {
    //wanna encrypt?
    String clearText;
    if (adding) {
      clearText = "addCoin-" + userID;
    } else {
      clearText = "payCoin-" + userID;
    }
    return QRCodeGenerator.generateQRCode(clearText);
  }

  public User createUser(String name) {
    User tmp = new User(name, this);
    users.add(tmp);
    return tmp;
  }

  public void deleteUser(int id) {
    users.remove(getUserById(id));
  }

  private User getUserById(int id) {
    for (User u : users) {
      if (u.getId() == id) {
        return u;
      }
    }
    return null;
  }
}

package com.example.soberdn.components;

import com.example.soberdn.MainView;
import com.example.soberdn.api.SoberDNService;
import com.example.soberdn.javafx.controllers.template.SingletonAttributeStore;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SimpleSoberDNService implements SoberDNService {

  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(SimpleSoberDNService.class);

  private ArrayList<User> users = new ArrayList<>();
  private ArrayList<Bar> bars = new ArrayList<>();

  public static void main(String[] args) {
    SimpleSoberDNService s = new SimpleSoberDNService();

    MainView mainView = new MainView();

    try {
      s.createAddQRCode(1234);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (WriterException e) {
      throw new RuntimeException(e);
    }
  }

  public SimpleSoberDNService() {
    createUser("Stefan", "12345");
    createBar("NichtAnwendBar", "Passwort");
  }

  @Override
  public String createAddQRCode(int userID) throws IOException, WriterException {
    //wanna encrypt?
    String clearText = "addCoin-" + userID;
    ;
    return QRCodeGenerator.generateQRCode(clearText);
  }

  @Override
  public String createPayQRCode(int userID, int amount)
      throws IOException, WriterException {
    //wanna encrypt?
    String clearText = "payCoin-" + userID + "-" + amount;

    return QRCodeGenerator.generateQRCode(clearText);
  }

  @Override
  public void scanQRCode(File file, int barId) {
    //wanna decrypt?
    try {
      String res = QRCodeReader.readQRcode(file.getPath());
      String[] parse = res.split("-");
      Bar bar = getBarById(barId);
      if (parse[0].equals("addCoin")) {
        addCoins(Integer.parseInt(parse[1]), barId);
        bar.addScanned();
      } else if (parse[0].equals("payCoin")) {
        payDrink(Integer.parseInt(parse[1]), barId, Integer.parseInt(parse[2]));
        bar.addScanned();
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
  public void addCoins(int userId, int barId) {
    User user = getUserById(userId);
    if (user != null) {
      user.addCoins();

    }
  }

  @Override
  public void payDrink(int userId, int barId, int amount) {
    User user = getUserById(userId);
    if (user != null) {
      user.removeCoins(amount);
    }
  }

  public User createUser(String name, String password) {
    User tmp = new User(name, password, this);
    users.add(tmp);
    SingletonAttributeStore.getReference().setAttribute("userId",tmp.getId());
    return tmp;
  }

  public void deleteUser(int id) {
    users.remove(getUserById(id));
  }

  public User getUserById(int id) {
    for (User u : users) {
      if (u.getId() == id) {
        return u;
      }
    }
    return null;
  }

  public Bar createBar(String name, String password) {
    Bar tmp = new Bar(name, password, this);
    bars.add(tmp);
    SingletonAttributeStore.getReference().setAttribute("barId",tmp.getId());
    return tmp;
  }

  public void deleteBar(int id) {
    bars.remove(getBarById(id));
  }

  public Bar getBarById(int id) {
    for (Bar b : bars) {
      if (b.getId() == id) {
        return b;
      }
    }
    return null;
  }

  public boolean checkUserLogin(String username, String password) {
    for (User u : users) {
      if (u.getName().equals(username)) {
        if (u.getPassword().equals(password)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean checkBarLogin(String username, String password) {
    for (Bar b : bars) {
      if (b.getName().equals(username)) {
        if (b.getPassword().equals(password)) {
          return true;
        }
      }
    }
    return false;
  }
}

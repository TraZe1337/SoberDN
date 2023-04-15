package com.example.soberdn.components;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QRCodeGenerator {

  //static function that creates QR Code
  public static String generateQRCode(String textToQR)
      throws WriterException, IOException {
    int h = 200, w = 200;

    String path = "src/main/resources/com/example/soberdn/qrcodes/" + textToQR + ".png";
    Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
//generates QR code with Low level(L) error correction capability
    hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//invoking the user-defined method that creates the QR code
    String charset = "UTF-8";
//the BitMatrix class represents the 2D matrix of bits
//MultiFormatWriter is a factory class that finds the appropriate Writer subclass for the BarcodeFormat requested and encodes the barcode with the supplied contents.
    BitMatrix matrix = new MultiFormatWriter().encode(
        new String(textToQR.getBytes(charset), charset),
        BarcodeFormat.QR_CODE, w, h);
    MatrixToImageWriter.writeToFile(matrix, "png", new File(path));
    return "/com/example/soberdn/qrcodes/" + textToQR + ".png";
  }
}

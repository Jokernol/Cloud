package se.edu.badgateway.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class QRCodeUtil {
    private static final String CHARSET = "utf-8";
    private static final String FORMAT_NAME = "JPG";
    // 二维码尺寸
    private static final int QRCODE_SIZE = 1024;

    public static void encode(String content, String destPath, Integer onColor) {
        try {
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
            hints.put(EncodeHintType.MARGIN, 1);

            MatrixToImageConfig config = new MatrixToImageConfig(onColor, 0xFFFFFFFF);
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);

            MatrixToImageWriter.writeToPath(bitMatrix, FORMAT_NAME, Paths.get(destPath), config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String decode(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            LuminanceSource luminanceSource = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(luminanceSource);

            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);

            Map<DecodeHintType, Object> hints = new HashMap<>();
            hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
            hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            hints.put(DecodeHintType.POSSIBLE_FORMATS, BarcodeFormat.QR_CODE);

            Result result = new QRCodeReader().decode(binaryBitmap, hints);

            return result.getText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

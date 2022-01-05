package se.edu.badgateway.service;

import org.springframework.stereotype.Service;
import se.edu.badgateway.utils.QRCodeUtil;

@Service
public class QRCodeService {
    private static final String path = "src/main/webapp/qrcode/";
    private static final Integer onColorRed = 0xFFEE2C2C;
    private static final Integer onColorGrey = 0xFFBEBEBE;
    private static final Integer onColorGreen = 0xFF00EE76;
    private static final Integer onColorYellow = 0xFFFFD700;

    public void encodeRed(Integer id) {
        String filePath = path + id.toString() + ".jpg";

        QRCodeUtil.encode(id.toString(), filePath, onColorRed);
    }

    public void encodeGrey(Integer id) {
        String filePath = path + id.toString() + ".jpg";

        QRCodeUtil.encode(id.toString(), filePath, onColorGrey);
    }

    public void encodeGreen(Integer id) {
        String filePath = path + id.toString() + ".jpg";

        QRCodeUtil.encode(id.toString(), filePath, onColorGreen);
    }

    public void encodeYellow(Integer id) {
        String filePath = path + id.toString() + ".jpg";

        QRCodeUtil.encode(id.toString(), filePath, onColorYellow);
    }
}

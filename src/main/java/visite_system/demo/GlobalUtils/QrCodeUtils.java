package visite_system.demo.GlobalUtils;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;

@Component
public class QrCodeUtils {
    @Autowired
    private QrConfig qrConfig;

    public  String createQrCode(String content){
        BufferedImage image = QrCodeUtil.generate(content, qrConfig);
        String base64 = ImageUtils.bufferedImageToBase64(image);
        return base64;

    }
}

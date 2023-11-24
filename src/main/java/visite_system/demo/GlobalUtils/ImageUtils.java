package visite_system.demo.GlobalUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.binary.Base64;

public class ImageUtils {


    /**
     * BufferedImage 转换为 base64编码
     * @param bufferedImage
     * @return
     */
    public static String bufferedImageToBase64(BufferedImage bufferedImage){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "png", stream);
        }catch (Exception e){
            e.printStackTrace();
        }
            Base64 base = new Base64();
            String base64 = base.encodeToString(stream.toByteArray());
            return "data:image/png;base64," + base64;
    }

    /**
     * base64编码 转换为 BufferedImage
     * @param base64
     * @return
     */
    public static BufferedImage base64ToBufferedImage(String base64) throws IOException {
        Base64 base = new Base64();
        byte[] image = base.decode(base64.replace("data:image/png;base64,", ""));
        InputStream stream = new ByteArrayInputStream(image);
        BufferedImage bufferedImage = ImageIO.read(stream);
        return bufferedImage;
    }
}

package BackEnd.ScreenMirroring;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageUtils {
    /**
     *
     * @param image : the image which is to be divided into packets.
     * @param packetSize : the size of each packet i.e the image will be divided into packets with size of packetSize.
     *
     * @return 2-dimensional array representing the whole image.
     */
    public static byte[][] splitImage(final BufferedImage image, int packetSize) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image,"jpg",baos);
        byte[] imageData = baos.toByteArray();
        int totalPackets = imageData.length/packetSize;
        byte[][] imageBytes = new byte[totalPackets][packetSize];
        for(int i = 0; i<totalPackets; i++) {
            for (int j = 0; j < packetSize; j++) {
                imageBytes[i][j] = imageData[(i * packetSize) + j];
            }
        }
        return imageBytes;
    }

    /**
     *
     * @param imageBytes : a 2-dimensional array representing the whole image which is to be converted back to original form.
     *
     * //@param packetSize : the packetSize which was used to split the image into packets.//
     *
     * NOTE : the @param packetSize should be same which was used to split the bufferedImage.
     *
     * @return : the BufferedImage converted using the byte[][] i.e imageBytes.
     */
    public static BufferedImage combineImage(final byte[][] imageBytes) throws IOException {
        BufferedImage image = null;
        int totalPackets = imageBytes.length;
        int packetSize = imageBytes[0].length;
        byte[] imageData = new byte[totalPackets*packetSize];
        for(int i = 0; i<totalPackets; i++) {
            for (int j = 0; j < packetSize; j++) {
                imageData[(i * packetSize) + j] = imageBytes[i][j];
            }
        }
        return ImageIO.read(new ByteArrayInputStream(imageData));
    }
}

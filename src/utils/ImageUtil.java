package utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageUtil {
	public static Image resize(Image image, int width, int height) {
		Image imagez = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return imagez;
	}

	public static byte[] toByteArray(Image image, String type) throws IOException {
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
				BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = bufferedImage.createGraphics();
		graphics2d.drawImage(image, 0, 0, null);
		graphics2d.dispose();
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, type, arrayOutputStream);
		byte[] ImageByte = arrayOutputStream.toByteArray();
		return ImageByte;
	}
}

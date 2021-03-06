package graphics.tools;

import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;

/**
 * A helper class used for manipulating arrays of integers, such as pixels in 
 * images.
 * 
 * @author John Barbero Unenge
 *
 */
public class PixelCastingTool {

	/**
	 * Convert a one dimensional integer array into a two dimensional one.
	 * 
	 * @param width The width of the array to create
	 * @param height The height of the array to create
	 * @param pixels The one dimensional integer array
	 * @return The two dimensional integer array
	 */
	public static int[][] get2dTileMatrixFromPixelArray(int width, int height,
			int[] pixels) {
		int[][] tiles = new int[width][height];

		for (int y = 0; y < width; y++) {
			for (int x = 0; x < height; x++) {
				tiles[x][y] = pixels[y * width + x];
			}
		}

		return tiles;
	}

	/** 
	 * Get a one dimensional integer array from a raster.
	 * 
	 * This is used for getter the individual pixels from an Image such 
	 * as BufferedImage.
	 * 
	 * @param raster The raster
	 * @param imageWidth The image width
	 * @param imageHeight The image height
	 * @return The one dimensional integer array
	 */
	public static int[] getARGBarrayFromDataBuffer(Raster raster,
			int imageWidth, int imageHeight) {
		DataBuffer buffer = raster.getDataBuffer();

		if (buffer.getClass() == DataBufferByte.class) {
			tools.Logger.log("Getting pixels from DataBufferByte");

			int[] pixels = new int[imageWidth * imageHeight];
			byte[] data = ((DataBufferByte) buffer).getData();

			if (data.length == pixels.length * 4) {
				tools.Logger.log("Image has alpha");

				for (int i = 0; i < pixels.length; i++) {
					int a = 0xff000000 & (data[i * 4] << 24);
					int r = 0x00ff0000 & (data[i * 4 + 3] << 16);
					int g = 0x0000ff00 & (data[i * 4 + 2] << 8);
					int b = 0x000000ff & (data[i * 4 + 1]);
					pixels[i] = (a | r | g | b);
				}
			} else if (data.length == pixels.length * 3) {
				tools.Logger.log("Image doesn't have alpha");
				for (int i = 0; i < pixels.length; i++) {
					int a = 0xff000000;
					int r = 0x00ff0000 & (data[i * 3 + 2] << 16);
					int g = 0x0000ff00 & (data[i * 3 + 1] << 8);
					int b = 0x000000ff & (data[i * 3 + 0] << 0);

					pixels[i] = (a | r | g | b);
				}
			} else {
				pixels = null;
			}
			return pixels;
		} else if (buffer.getClass() == DataBufferInt.class) {
			tools.Logger.log("Getting pixels from DataBufferInt");
			return ((DataBufferInt) buffer).getData();
		}
		return null;
	}

}

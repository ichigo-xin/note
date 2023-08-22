package com.xin.filetransfer;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WatermarkUtil {

    public static void addWatermark(File originalImageFile, File watermarkImageFile, File outputImageFile)
            throws IOException {
        // Load the original image
        BufferedImage originalImage = ImageIO.read(originalImageFile);

        // Load the watermark image
        BufferedImage watermarkImage = ImageIO.read(watermarkImageFile);

        // Set the size of the watermark image
        int watermarkWidth = 400; // Customize the watermark width
        int watermarkHeight = 200; // Customize the watermark height
        BufferedImage resizedWatermark = Thumbnails.of(watermarkImage)
                .size(watermarkWidth, watermarkHeight)
                .asBufferedImage();

        // Add the watermark to the original image at the specified position
        int x = 10; // Customize the x-coordinate of the watermark position
        int y = 10; // Customize the y-coordinate of the watermark position
        Thumbnails.of(originalImage)
                .size(originalImage.getWidth(), originalImage.getHeight())
//                .rotate(90)
                .watermark(Positions.BOTTOM_RIGHT, resizedWatermark, 1.0f)
                .outputQuality(1.0)
                .toFile(outputImageFile);
    }

    public static void main(String[] args) {
        File originalImageFile = new File("E:\\music_eg\\test1.pdf");
        File watermarkImageFile = new File("E:\\music_eg\\404.jpg");
        File outputImageFile = new File("E:\\music_eg\\10m-water.jpg");

        try {
            addWatermark(originalImageFile, watermarkImageFile, outputImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

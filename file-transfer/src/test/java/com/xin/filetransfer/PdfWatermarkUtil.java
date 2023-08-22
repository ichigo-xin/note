package com.xin.filetransfer;

import java.io.File;
import java.io.IOException;

public class PdfWatermarkUtil {

    public static void addWatermark(File originalPdfFile, File watermarkImageFile, File outputPdfFile)
            throws IOException {
//        try (PDDocument document = PDDocument.load(originalPdfFile)) {
//            int pageCount = document.getNumberOfPages();
//
//            // Load the watermark image
//            BufferedImage watermarkImage = ImageIO.read(watermarkImageFile);
//            PDImageXObject xImage = PDImageXObject.createFromFileByContent(watermarkImageFile, document);
//
//            // Add the watermark to each page of the PDF
//            for (int i = 0; i < pageCount; i++) {
//                PDPage page = document.getPage(i);
//                PDRectangle pageSize = page.getMediaBox();
//                float pageWidth = pageSize.getWidth();
//                float pageHeight = pageSize.getHeight();
//
//                // Create a new content stream to add the watermark
//                PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, true);
//
//                // Calculate the position to place the watermark at the center of the page
//                float x = (pageWidth - watermarkImage.getWidth()) / 2;
//                float y = (pageHeight - watermarkImage.getHeight()) / 2;
//
//                // Draw the watermark image on the page
//                contentStream.drawImage(xImage, x, y, watermarkImage.getWidth(), watermarkImage.getHeight());
//                contentStream.close();
//            }
//
//            // Save the modified PDF with watermark
//            document.save(outputPdfFile);
//        }
    }

    public static void main(String[] args) {
        File originalPdfFile = new File("path/to/original.pdf");
        File watermarkImageFile = new File("path/to/watermark/image.png");
        File outputPdfFile = new File("path/to/output.pdf");

        try {
            addWatermark(originalPdfFile, watermarkImageFile, outputPdfFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

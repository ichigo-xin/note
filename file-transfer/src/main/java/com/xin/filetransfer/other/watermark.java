package com.xin.filetransfer.other;

import com.spire.pdf.*;

import java.awt.geom.Rectangle2D;

public class watermark {

    public static void main(String[] args) {

        //实例化PdfDocument类的对象，并加载测试文档
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("src/main/resources/static/test1.pdf");

        for (Object page : doc.getPages()) {
            ((PdfPageBase) page).setBackgroundImage("src/main/resources/static/404.jpg");
            Rectangle2D.Float rect = new Rectangle2D.Float();
            rect.setRect(150, 150, 300, 150);
            ((PdfPageBase) page).setBackgroundRegion(rect);
        }

        //获取文档第1页
//        PdfPageBase page = doc.getPages().get(0);
//
//        //加载图片，设置为背景水印
//        page.setBackgroundImage("src/main/resources/static/404.jpg");
//
//        //指定水印在文档中的位置及图片大小
//        Rectangle2D.Float rect = new Rectangle2D.Float();
//        rect.setRect(150, 150, 300, 150);
//        page.setBackgroundRegion(rect);

        //保存文档
        doc.saveToFile("src/main/resources/static/out/imageWaterMark.pdf");
        doc.close();
    }
}
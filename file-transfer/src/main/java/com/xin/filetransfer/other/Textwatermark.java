package com.xin.filetransfer.other;

import com.spire.pdf.*;
import com.spire.pdf.graphics.*;

import java.awt.*;
import java.awt.geom.*;

public class Textwatermark {
    public static void main(String[] args) {
        //创建PdfDocument类的对象
        PdfDocument pdf = new PdfDocument();
        // 使用相对于项目根目录的相对路径加载测试文档
        pdf.loadFromFile("src/main/resources/static/test2.pdf");

        //循环遍历PDF文档中的所有页面以逐个添加水印
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("黑体", Font.BOLD, 20));
        for (int i = 0; i < pdf.getPages().getCount(); i++) {
            PdfPageBase page = pdf.getPages().get(i);
            insertTextWatermark(page, font, "请勿复制", 3, 3);
        }
        pdf.saveToFile("src/main/resources/static/out/textWaterMark.pdf");
    }

    static void insertTextWatermark(PdfPageBase page, PdfTrueTypeFont font, String watermark, int row, int column) {

        //计算两个偏移变量的值以用于计算坐标的平移量
        float set1 = (float)(font.measureString(watermark).getWidth() * Math.sqrt(2)/4);
        float set2 = (float)(font.measureString(watermark).getHeight() * Math.sqrt(2)/4);

        //创建一个平铺笔刷
        PdfTilingBrush brush = new PdfTilingBrush(new Dimension((int) (page.getActualSize().getWidth() / column),
                (int) (page.getActualSize().getHeight() / row)));
        // 设置笔刷的透明度
        brush.getGraphics().setTransparency(0.3f);
        brush.getGraphics().save();
        //设置坐标的偏移量
        brush.getGraphics().translateTransform(brush.getSize().getWidth() / 2 - set1 - set2,
                brush.getSize().getHeight() / 2 + set1 - set2);
        // 旋转笔刷
        brush.getGraphics().rotateTransform(-45);

        //绘制水印文本到平铺笔刷
        brush.getGraphics().drawString(watermark, font, PdfBrushes.getViolet(), 0, 0);
        brush.getGraphics().restore();

        //使用该平铺笔刷绘制水印
        page.getCanvas().drawRectangle(brush, new Rectangle(new Point(0, 0),
                new Dimension((int) (page.getActualSize().getWidth()), (int) (page.getActualSize().getHeight()))));
    }

}
package com.xin.filetransfer;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import javax.xml.transform.Source;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author : ichigo-xin
 * @date 2023/7/24
 */
public class ManyOpenFileTest {

    public static void main(String[] args) {
        ManyOpenFileTest manyOpenFileTest = new ManyOpenFileTest();
        new Thread(() -> {
            manyOpenFileTest.openFile();
        }).start();
        new Thread(() -> {
            manyOpenFileTest.openFile();
        }).start();
    }

    private void openFile() {
        String path = "E:\\music_eg\\";
        // 打开下面的10m.jpg文件
        String fileName = "10m.jpg";
//        File file = new File(path + fileName);
//        System.out.println(file.getName());
        Path source = Paths.get(path + fileName);
        Path destination = Paths.get(path + "copy_"+ Thread.currentThread().getName() + fileName);
        try {
            Files.copy(source, destination);
            Thread.sleep(1000 * 60);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

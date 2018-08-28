package com.quantum.tesseract;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;

public class TesseractExample {
    private static ITesseract instance;
    static {
        String defaultDataPath = LoadLibs.extractTessResources("tessdata").getPath();
        instance = new Tesseract();
        instance.setDatapath(defaultDataPath);
        instance.setLanguage("chi_sim+eng");
    }
    public static void main(String[] args) {
        // System.setProperty("jna.library.path", "32".equals(System.getProperty("sun.arch.data.model")) ? "lib/win32-x86" : "lib/win32-x86-64");
        File imageFile = new File("/home/zhangquanquan/Downloads/1349979753.jpg");
        if (args.length > 0){
            imageFile = new File(args[0]);
        }
        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
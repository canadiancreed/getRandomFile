package com.creedprojects.app;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class getRandomFile {

    final static String path = "E:\\Pictures";
    //final static String path = new File(".").getAbsolutePath();

    final static File dir = new File(path);

    public static void main(String[] args) throws IOException {

        final List<File> fileListing = listf(path);

        Random rand = new Random();

        Desktop dt = Desktop.getDesktop();

        dt.open(new File(fileListing.get(rand.nextInt(fileListing.size())).getAbsolutePath()));

        System.out.println("Random file is -> " + fileListing.get(rand.nextInt(fileListing.size())).getAbsolutePath());
    }

    public static List<File> listf(String directoryName) {
        File directory = new File(directoryName);

        List<File> resultList = new ArrayList<File>();

        // get all the files from a directory
        File[] fList = directory.listFiles();

        for (File file : fList) {
            if (file.isFile()) {
                String fileName = file.getName();
                String fileExtension = fileName.substring(fileName.indexOf(".") + 1, file.getName().length());
                fileExtension = fileExtension.toLowerCase();
                if (fileExtension.equals("png") || fileExtension.equals("jpg")){
                    resultList.add(new File(file.getAbsolutePath()));
                }
            } else if (file.isDirectory()) {
                System.out.println(file.getAbsolutePath());
                resultList.addAll(listf(file.getAbsolutePath()));
            }
        }

        return resultList;
    }
}
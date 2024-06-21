/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lnht.utils;

import java.nio.file.*;

/**
 *
 * @author minh-nguyen
 */
public class FileUtils {
    public static String findRelativePath(String fileName){
        String directory = "/HTTSWebApplication/resources/images/";
        Path path = Paths.get(directory + fileName);
//        String path_= path.toFile().getAbsolutePath().replaceAll("^[A-Za-z]{1}:{1}", "");
//        path = Paths.get(path_);
            // relative path
        return path.toFile().toPath().toString();
    }
}

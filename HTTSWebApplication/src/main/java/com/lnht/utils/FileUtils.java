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
    public static String findAvatarPath(String fileName){
        String directory = "/admissionsupport_backend_v1/resources/images/";
        Path path = Paths.get(directory + fileName);
        return path.toFile().getAbsolutePath();
    }
}

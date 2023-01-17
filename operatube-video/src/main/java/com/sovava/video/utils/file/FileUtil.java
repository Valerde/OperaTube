package com.sovava.video.utils.file;

import com.sovava.video.enums.FileTypeEnum;

public class FileUtil {

    private static String[] videoType = {
            ".MP4", ".MKV", ".OGM", ".WMV", ".MPG", ".WEBM", ".OGV", ".MOV", ".ASX", ".MPEG", "M4V", ".AVI", ".FLV"
    };

    private static String[] photoType = {
            ".JPEG", ".JPG", ".GIF", ".PNG", ".TIFF", ".PJP", ".JFIF", ".SVG", ".BMP", ".SVGZ", ".WEBP", ".ICO"
            , ".XBM", ".DIB", ".TIF", ".PJEPG", ".AVIF"

    };

    public static String getFileSuffix(String fileName) {
        int index = fileName.lastIndexOf(".");
        if (index <= 0) {
            return "";
        }
        return fileName.substring(index).toUpperCase();
    }

    public static FileTypeEnum getFileType(String fileName) {
        String fileSuffix = FileUtil.getFileSuffix(fileName);
        for (String suffix : videoType) {
            if (suffix.equals(fileSuffix)) return FileTypeEnum.VIDEO;
        }
        for (String suffix : photoType) {
            if (suffix.equals(fileSuffix)) return FileTypeEnum.PHOTO;
        }
        return FileTypeEnum.ARTICLE;
    }
}

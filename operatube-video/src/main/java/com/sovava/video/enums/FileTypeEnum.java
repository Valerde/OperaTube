package com.sovava.video.enums;

public enum FileTypeEnum {
    VIDEO(0, "视频类型"),
    PHOTO(1, "图片类型"),
    ARTICLE(2, "文章投稿");


    int code;
    String msg;

    FileTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

}

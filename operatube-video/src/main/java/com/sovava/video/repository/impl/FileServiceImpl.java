package com.sovava.video.repository.impl;

import com.sovava.video.constant.file.FileConstant;
import com.sovava.video.enums.FileTypeEnum;
import com.sovava.video.repository.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
public class FileServiceImpl implements FileService {
    private final Path location;


    @Autowired
    public FileServiceImpl() throws IOException {
        this.location = Paths.get(FileConstant.ROOT_PATH);

        if (Files.notExists(this.location)) {
            Files.createFile(this.location);
        }
    }

    @Override
    public Path loadFile(String loadPath) throws FileNotFoundException {

        Path path = this.location.resolve(loadPath);
        if (Files.notExists(path)) {
            throw new FileNotFoundException("file:" + loadPath + "not exist!");
        }
        return path;

    }
}

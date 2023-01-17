package com.sovava.video.repository;

import java.io.FileNotFoundException;
import java.nio.file.Path;

public interface FileService {

    Path loadFile(String loadPath) throws FileNotFoundException;
}

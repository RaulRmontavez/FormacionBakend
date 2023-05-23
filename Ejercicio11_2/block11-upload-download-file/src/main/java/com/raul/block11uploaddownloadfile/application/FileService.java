package com.raul.block11uploaddownloadfile.application;

import com.raul.block11uploaddownloadfile.FileInputDto;
import com.raul.block11uploaddownloadfile.FileOutputDto;

import java.util.List;

public interface FileService {
    FileOutputDto addFile(FileInputDto fileInputDto) throws Exception;
}

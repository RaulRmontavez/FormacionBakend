package com.raul.block11uploaddownloadfile.application;

import com.raul.block11uploaddownloadfile.FileInputDto;
import com.raul.block11uploaddownloadfile.FileOutputDto;
import com.raul.block11uploaddownloadfile.domain.FilesO;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    FilesO uploadFile(String ruta, MultipartFile file) throws Exception;

    Resource downloadFile(String filename) throws Exception;

    FileOutputDto getFileById(int id);

    List<FileOutputDto> getFileByName(String name);
}

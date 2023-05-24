package com.raul.block11uploaddownloadfile.controller;

import com.raul.block11uploaddownloadfile.FileOutputDto;
import com.raul.block11uploaddownloadfile.application.FileService;
import com.raul.block11uploaddownloadfile.application.FileServiceImpl;
import com.raul.block11uploaddownloadfile.domain.FilesO;
import com.raul.block11uploaddownloadfile.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/")
public class Controlador {
    @Autowired
    FileService fileService;


    @RequestMapping(method = POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<FileOutputDto> addFile(@RequestParam(name = "ruta", defaultValue = "guardarficheros", required = false) String ruta, @RequestParam("file")MultipartFile file){

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(fileService.uploadFile(ruta,file).fileToOutputDto());
        } catch (Exception e) {
            ResponseEntity.badRequest().body("Error al subir el fichero");
            throw new RuntimeException("Error al subir el fichero");
        }
    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

        try{
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");
            return ResponseEntity.ok().headers(headers).body(fileService.downloadFile(filename));
        } catch (Exception e){
            // Manejar la situación cuando el archivo no existe
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<FileOutputDto> getFileById(@PathVariable int id) {

        try {
            return ResponseEntity.ok().body(fileService.getFileById(id));

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("name/{name}")
    public ResponseEntity<List<FileOutputDto>> getFileByName(@PathVariable String name) {

        try {
            return ResponseEntity.ok().body(fileService.getFileByName(name));

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

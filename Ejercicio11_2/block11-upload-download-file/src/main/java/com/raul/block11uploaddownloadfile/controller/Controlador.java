package com.raul.block11uploaddownloadfile.controller;

import com.raul.block11uploaddownloadfile.application.FileService;
import com.raul.block11uploaddownloadfile.application.FileServiceImpl;
import com.raul.block11uploaddownloadfile.domain.FilesO;
import com.raul.block11uploaddownloadfile.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/")
public class Controlador {
    @Autowired
    FileService fileService;
    @Autowired
    FileRepository fileRepository;
    int contador= 0;

    @RequestMapping(method = POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity addFile(@RequestParam(name = "ruta", defaultValue = "guardarficheros", required = false) String ruta, @RequestParam("file")MultipartFile file){
        try {
            // Verificar si se proporcionó un archivo
            if (file.isEmpty()) {
                return new ResponseEntity<>("No se proporcionó ningún archivo.", HttpStatus.BAD_REQUEST);
            }

            // Guardar el archivo
            Path directorioDestino = Paths.get(ruta);
            File directorio = directorioDestino.toFile();

            // Crear el directorio si no existe
            if (!directorio.exists()) {
                directorio.mkdirs();
            }
            file.transferTo(Path.of(directorio + "/" + file.getOriginalFilename()));

            /*file.transferTo(new File("/guardarficheros/" + ruta));*/
            contador = contador + 1;
            FilesO archivoDatos = new FilesO();
            archivoDatos.setName(file.getOriginalFilename());
            archivoDatos.setFecha(LocalDateTime.now().toString());
            archivoDatos.setCategoria(StringUtils.getFilenameExtension(archivoDatos.getName()));
            archivoDatos.setId(contador);
            archivoDatos.setRuta(ruta);
            fileRepository.save(archivoDatos);
            return ResponseEntity.status(HttpStatus.CREATED).body(archivoDatos);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error al subir el fichero");
        }
    }

}

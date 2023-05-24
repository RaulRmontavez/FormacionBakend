package com.raul.block11uploaddownloadfile.application;


import com.raul.block11uploaddownloadfile.FileOutputDto;
import com.raul.block11uploaddownloadfile.domain.FilesO;
import com.raul.block11uploaddownloadfile.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    FileRepository fileRepository;


    @Override
    public FilesO uploadFile(String ruta, MultipartFile file) throws Exception {

            // Verificar si se proporcionó un archivo
            if (file.isEmpty()) {
                throw new Exception();
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

            FilesO archivoDatos = new FilesO();
            archivoDatos.setName(file.getOriginalFilename());
            archivoDatos.setFecha(LocalDateTime.now().toString());
            archivoDatos.setCategoria(StringUtils.getFilenameExtension(archivoDatos.getName()));
            archivoDatos.setRuta(ruta);
            fileRepository.save(archivoDatos);
            return archivoDatos;

    }
    @Override
    public Resource downloadFile(String filename) throws Exception {

        FilesO fileO = new FilesO();

        for (FilesO fil : fileRepository.findByName(filename)) {
            if (fil.getName().equals(filename)) {
                fileO.setName(fil.getName());
                fileO.setId(fil.getId());
                fileO.setRuta(fil.getRuta());
                fileO.setCategoria((fil.getCategoria()));
                System.out.println(fil.getName());
            }
        }

        // Obtener el archivo del sistema de archivos
        Resource file = new FileSystemResource(fileO.getRuta() + "\\" + filename);

        // Verificar si el archivo existe
        if (!file.exists()) {
            System.out.println("Existe");
            throw new Exception();
        }
        return file;
    }

    @Override
    public FileOutputDto getFileById(int id) {
        Optional<FilesO> filesOOptional = fileRepository.findById(id);
        FilesO file = filesOOptional.orElseThrow(() -> new RuntimeException("No se ha encontrado a ningun fichero por ese id"));
        FileOutputDto personaOutputDto = file.fileToOutputDto();
        return personaOutputDto;
    }

    @Override
    public List<FileOutputDto> getFileByName(String name) {
        List<FileOutputDto> lista = new ArrayList<>();

        for (FilesO fil : fileRepository.findByName(name)) {
            if (fil.getName().equals(name)) {
                lista.add(fil.fileToOutputDto());
            }
        }
        return lista;
    }
}

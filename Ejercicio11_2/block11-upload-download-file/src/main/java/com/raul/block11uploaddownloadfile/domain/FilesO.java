package com.raul.block11uploaddownloadfile.domain;

import com.raul.block11uploaddownloadfile.FileOutputDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilesO {
    @Id
    //@GeneratedValue
    private int id;
    private String name;
    private String fecha;

    private String categoria;

    private String ruta;

    public FileOutputDto fileToOutputDto(){
        return new FileOutputDto(this.id, this.name, this.fecha, this.categoria);
    }
}

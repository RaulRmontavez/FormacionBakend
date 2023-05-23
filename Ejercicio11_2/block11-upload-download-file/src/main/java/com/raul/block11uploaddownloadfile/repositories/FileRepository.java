package com.raul.block11uploaddownloadfile.repositories;

import com.raul.block11uploaddownloadfile.domain.FilesO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FilesO, Integer> {
    List<FilesO> findByName(String name);

    List<FilesO> findAll();


}

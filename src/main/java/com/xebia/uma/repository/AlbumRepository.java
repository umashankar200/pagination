package com.xebia.uma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xebia.uma.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long>, AlbumRepositoryJPA {

}

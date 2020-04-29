package com.xebia.uma.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xebia.uma.model.Album;

public interface AlbumRepositoryJPA extends JPA {

	public Page<Album> searchAlbums(final String artist, final Pageable pageable);
}

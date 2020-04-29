package com.xebia.uma.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.uma.model.Album;
import com.xebia.uma.pagination.PaginatedResource;
import com.xebia.uma.pagination.PaginatedResourceAssembler;
import com.xebia.uma.repository.AlbumRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class WebController {
	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private PaginatedResourceAssembler<Album> pagedResourcesAssembler;

	@GetMapping("/api/albums")
	// @formatter:off
	@ApiOperation(nickname = "get-albums-page", consumes = APPLICATION_JSON_VALUE, 
		produces = APPLICATION_JSON_VALUE, 
		value = "Gets a page of Albums matching the selection filters and sort criteria", 
		notes = "", response = PaginatedResource.class
	)
	public ResponseEntity<PaginatedResource<Album>> getAllAlbums(
			@ApiParam(name = "artist", value = "Artist Name, ex. Sidhu Mooseaala, Babbu Maan", example = "Sidhu Mooseaala") 
			@RequestParam(value = "artist", required = false) final String artist,
			@ApiIgnore @PageableDefault(page = 0, size = 2, sort = {
					"title" }, direction = Sort.Direction.ASC) final Pageable pageable) {
		// @formatter:on

		Page<Album> albums = this.albumRepository.searchAlbums(artist, pageable);

		if (albums.isEmpty()) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("X-info", "No Albums found matching given filters");
			return ResponseEntity.ok().headers(headers).build();
		} else {
			return ResponseEntity.ok(this.pagedResourcesAssembler.assemble(albums));
		}
	}
}

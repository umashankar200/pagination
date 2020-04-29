package com.xebia.uma.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Album.class)
public abstract class Album_ {

	public static volatile SingularAttribute<Album, String> artist;
	public static volatile SingularAttribute<Album, String> releaseDate;
	public static volatile SingularAttribute<Album, String> description;
	public static volatile SingularAttribute<Album, Long> id;
	public static volatile SingularAttribute<Album, String> title;

	public static final String ARTIST = "artist";
	public static final String RELEASE_DATE = "releaseDate";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String TITLE = "title";

}


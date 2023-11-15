package hh.sof03.music.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {

    List<Album> findByAlbumName(String string);

}

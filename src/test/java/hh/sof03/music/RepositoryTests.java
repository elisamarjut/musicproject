package hh.sof03.music;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.music.domain.Album;
import hh.sof03.music.domain.AlbumRepository;
import hh.sof03.music.domain.Artist;
import hh.sof03.music.domain.ArtistRepository;
import hh.sof03.music.domain.Genre;
import hh.sof03.music.domain.GenreRepository;
import hh.sof03.music.domain.Song;
import hh.sof03.music.domain.SongRepository;

@DataJpaTest
public class RepositoryTests {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    @Test
    public void createNewArtist() {
        Artist artist = new Artist("J. Karkalainen", 1981, null, null);
        artistRepository.save(artist);
        assertThat(artist.getArtistId()).isNotNull();
    }

    @Test
    public void createNewGenre() {
        Genre genre = new Genre("Iskelmä", null);
        genreRepository.save(genre);
        assertThat(genre.getGenreId()).isNotNull();
    }

    @Test
    public void createNewAlbum() {
        Album album = new Album("Tähtilampun alla", 1992, null, null);
        albumRepository.save(album);
        assertThat(album.getAlbumId()).isNotNull();
    }

    @Test
    public void createNewSong() {
        Song song = new Song("Telepatiaa", 3.57, null, null, null);
        songRepository.save(song);
        assertThat(song.getSongId()).isNotNull();
    }

    @Test
    public void findByAlbumNameShouldReturnPublishYear() {
        List<Album> albums = albumRepository.findByAlbumName("Pehmee");
        assertThat(albums).hasSize(1);
        assertThat(albums.get(0).getPublishYear()).isEqualTo(2023);
    }
}

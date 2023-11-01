package hh.sof03.music.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long genreId;

    private String genreName;

    @OneToMany // Genre @OneToMany Song
    private List<Song> songs;

    @OneToMany // Genre @OneToMany Album
    private List<Album> albums;

    public Genre() {
    }

    public Genre(String genreName, List<Song> songs, List<Album> albums) {
        this.genreName = genreName;
        this.songs = songs;
        this.albums = albums;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return genreName;
    }

}

package hh.sof03.music.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long artistId;

    @NotEmpty
    private String artistName;
    private int startingYear;

    @ManyToMany(mappedBy = "artists")
    private List<Song> songs = new ArrayList<Song>();

    @OneToMany // Artist @OneToMany Album
    private List<Album> albums;

    public Artist() {
    }

    public Artist(String artistName, int startingYear, List<Song> songs, List<Album> albums) {
        this.artistName = artistName;
        this.startingYear = startingYear;
        this.songs = songs;
        this.albums = albums;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getStartingYear() {
        return startingYear;
    }

    public void setStartingYear(int startingYear) {
        this.startingYear = startingYear;
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
        return artistName;
    }

}

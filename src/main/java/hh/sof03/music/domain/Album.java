package hh.sof03.music.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long albumId;

    @NotEmpty
    private String albumName;
    private int publishYear;

    @ManyToOne // Album @ManyToOne Artist
    @JoinColumn(name = "artistId") // foreign key määritys tietokannan Album-taulua varten
    private Artist artist;

    @OneToMany // Album @OneToMany Song
    private List<Song> songs;

    public Album() {
    }

    public Album(String albumName, int publishYear, Artist artist, List<Song> songs) {
        this.albumName = albumName;
        this.publishYear = publishYear;
        this.artist = artist;
        this.songs = songs;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return albumName;
    }

}

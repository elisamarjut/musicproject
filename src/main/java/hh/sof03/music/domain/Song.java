package hh.sof03.music.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long songId;

    private String songName, lyrics;
    private double length;

    @ManyToMany
    private List<Artist> artists;

    @ManyToOne // Song @ManyToOne Genre
    @JoinColumn(name = "genreId")
    private Genre genre;

    @ManyToOne // Song @ManyToOne Album
    private Album album;

    public Song() {
    }

    public Song(String songName, String lyrics, double length, List<Artist> artists, Genre genre, Album album) {
        this.songName = songName;
        this.lyrics = lyrics;
        this.length = length;
        this.artists = artists;
        this.genre = genre;
        this.album = album;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return songName;
    }

}

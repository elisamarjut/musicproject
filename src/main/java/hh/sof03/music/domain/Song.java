package hh.sof03.music.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long songId;

    private String songName;
    private double length;

    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(name = "Songs_artist", joinColumns = { @JoinColumn(name = "songId") }, inverseJoinColumns = {
            @JoinColumn(name = "artistId") })
    Set<Artist> artists = new HashSet<>();

    @ManyToOne // Song @ManyToOne Genre
    @JoinColumn(name = "genreId")
    private Genre genre;

    @ManyToOne // Song @ManyToOne Album
    private Album album;

    public Song() {
    }

    public Song(String songName, double length, Set<Artist> artists, Genre genre, Album album) {
        this.songName = songName;
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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
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

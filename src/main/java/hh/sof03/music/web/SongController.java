package hh.sof03.music.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof03.music.domain.GenreRepository;
import hh.sof03.music.domain.Song;
import hh.sof03.music.domain.SongRepository;

@Controller
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping({ "/", "index" })
    public String welcome() {
        return "welcome";
    }

    // List all songs
    @GetMapping("/list/songlist")
    public String listSongs(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "list/songlist";
    }

    // Add a new song
    @GetMapping("/add/addsong")
    public String addSong(Model model) {
        model.addAttribute("song", new Song());
        model.addAttribute("genres", genreRepository.findAll());
        return "add/addsong";
    }

    // Save song
    @PostMapping("/savesong")
    public String saveSong(Song song) {
        songRepository.save(song);
        return "redirect:/list/songlist";
    }

    // Delete song
    @GetMapping("/deletesong/{id}")
    public String deleteSong(@PathVariable("id") Long songId, Model model) {
        songRepository.deleteById(songId);
        return "redirect:../list/songlist";
    }

    // Edit song
    @GetMapping("/edit/editsong/{id}")
    public String editSong(@PathVariable("id") Long songId, Model model) {
        model.addAttribute("song", songRepository.findById(songId));
        model.addAttribute("genres", genreRepository.findAll());
        return "edit/editsong";
    }
}

package hh.sof03.music.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.music.domain.AlbumRepository;
import hh.sof03.music.domain.ArtistRepository;
import hh.sof03.music.domain.GenreRepository;
import hh.sof03.music.domain.Song;
import hh.sof03.music.domain.SongRepository;
import jakarta.validation.Valid;

@Controller
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

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
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addSong(Model model) {
        model.addAttribute("song", new Song());
        model.addAttribute("artists", artistRepository.findAll());
        model.addAttribute("albums", albumRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        return "add/addsong";
    }

    // Save a new song
    @PostMapping("/savesong")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveSong(@Valid Song song, BindingResult bindingResult, Model model) {
        model.addAttribute("artists", artistRepository.findAll());
        model.addAttribute("albums", albumRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        if (bindingResult.hasErrors()) {
            return "add/addsong";
        } else {
            songRepository.save(song);
            return "redirect:/list/songlist";
        }
    }

    // Delete song
    @GetMapping("/deletesong/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteSong(@PathVariable("id") Long songId, Model model) {
        songRepository.deleteById(songId);
        return "redirect:../list/songlist";
    }

    // Edit song
    @GetMapping("/edit/editsong/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editSong(@PathVariable("id") Long songId, Model model) {
        model.addAttribute("song", songRepository.findById(songId));
        model.addAttribute("artists", artistRepository.findAll());
        model.addAttribute("albums", albumRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        return "edit/editsong";
    }

    // Save edited song
    @PostMapping("/saveeditsong")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveEditSong(@Valid @ModelAttribute("song") Song song, BindingResult bindingResult, Model model) {
        model.addAttribute("artists", artistRepository.findAll());
        model.addAttribute("albums", albumRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        if (bindingResult.hasErrors()) {
            return "edit/editsong";
        } else {
            songRepository.save(song);
            return "redirect:/list/songlist";
        }
    }

    // RESTful service to get all songs
    @GetMapping("/rest/list/songs")
    public @ResponseBody List<Song> songListRest() {
        return (List<Song>) songRepository.findAll();
    }
}

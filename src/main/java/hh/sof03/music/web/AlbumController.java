package hh.sof03.music.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.music.domain.Album;
import hh.sof03.music.domain.AlbumRepository;
import hh.sof03.music.domain.ArtistRepository;
import jakarta.validation.Valid;

@CrossOrigin
@Controller
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    // List all albums
    @GetMapping("/list/albumlist")
    public String listAlbums(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        return "list/albumlist";
    }

    // Add a new album
    @GetMapping("/add/addalbum")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addAlbum(Model model) {
        model.addAttribute("album", new Album());
        model.addAttribute("artists", artistRepository.findAll());
        return "add/addalbum";
    }

    // Save new album
    @PostMapping("/savealbum")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveAlbum(@Valid Album album, BindingResult bindingResult, Model model) {
        model.addAttribute("artists", artistRepository.findAll());
        if (bindingResult.hasErrors()) {
            return "add/addalbum";
        } else {
            albumRepository.save(album);
            return "redirect:/list/albumlist";
        }
    }

    // Delete album
    @GetMapping("/deletealbum/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteAlbum(@PathVariable("id") Long albumId, Model model) {
        albumRepository.deleteById(albumId);
        return "redirect:../list/albumlist";
    }

    // Edit album
    @GetMapping("/edit/editalbum/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editALbum(@PathVariable("id") Long albumId, Model model) {
        model.addAttribute("album", albumRepository.findById(albumId));
        model.addAttribute("artists", artistRepository.findAll());
        return "edit/editalbum";
    }

    // Save edited album
    @PostMapping("/saveeditalbum")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveEditAlbum(@Valid @ModelAttribute("album") Album album, BindingResult bindingResult, Model model) {
        model.addAttribute("artists", artistRepository.findAll());
        if (bindingResult.hasErrors()) {
            return "edit/editalbum";
        } else {
            albumRepository.save(album);
            return "redirect:/list/albumlist";
        }
    }

    // RESTful service to get all albums
    @GetMapping("/rest/list/albums")
    public @ResponseBody List<Album> albumListRest() {
        return (List<Album>) albumRepository.findAll();
    }

}

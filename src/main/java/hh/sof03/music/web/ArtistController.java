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

import hh.sof03.music.domain.Artist;
import hh.sof03.music.domain.ArtistRepository;
import jakarta.validation.Valid;

@Controller
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    // List all artists
    @GetMapping("/list/artistlist")
    public String listArtists(Model model) {
        model.addAttribute("artists", artistRepository.findAll());
        return "list/artistlist";
    }

    // Add a new artist
    @GetMapping("/add/addartist")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addArtist(Model model) {
        model.addAttribute("artist", new Artist());
        return "add/addartist";
    }

    // Save new artist
    @PostMapping("/saveartist")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveArtist(@Valid Artist artist, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add/addartist";
        } else {
            artistRepository.save(artist);
            return "redirect:/list/artistlist";
        }
    }

    // Delete artist
    @GetMapping("/deleteartist/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteArtisr(@PathVariable("id") Long artistId, Model model) {
        artistRepository.deleteById(artistId);
        return "redirect:../list/artistlist";
    }

    // Edit artist
    @GetMapping("/edit/editartist/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editArtist(@PathVariable("id") Long artistId, Model model) {
        model.addAttribute("artist", artistRepository.findById(artistId));
        return "edit/editartist";
    }

    // Save edited artist
    @PostMapping("/saveeditartist")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveEditArtist(@Valid @ModelAttribute("artist") Artist artist, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit/editartist";
        } else {
            artistRepository.save(artist);
            return "redirect:/list/artistlist";
        }
    }

    // RESTful service to gel all artists
    @GetMapping("rest/list/artists")
    public @ResponseBody List<Artist> artistListRest() {
        return (List<Artist>) artistRepository.findAll();
    }
}

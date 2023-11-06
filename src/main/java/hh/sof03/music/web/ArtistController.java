package hh.sof03.music.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.music.domain.ArtistRepository;

@Controller
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    // List all artists
    @RequestMapping("/list/artistlist")
    public String listArtists(Model model) {
        model.addAttribute("artists", artistRepository.findAll());
        return "list/artistlist";
    }

    // Add a new artist

    // Save new artist

    // Delete artist

    // Edit artist

    // Save edited artist
}

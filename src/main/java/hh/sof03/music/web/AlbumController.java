package hh.sof03.music.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.music.domain.AlbumRepository;

@Controller
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepository;

    @RequestMapping("/albumlist")
    public String listAlbums(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        return "albumlist";
    }
}

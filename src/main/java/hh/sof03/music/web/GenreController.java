package hh.sof03.music.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.music.domain.GenreRepository;

@Controller
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @RequestMapping("/genrelist")
    public String genreList(Model model) {
        model.addAttribute("genres", genreRepository.findAll());
        return "genrelist";
    }
}

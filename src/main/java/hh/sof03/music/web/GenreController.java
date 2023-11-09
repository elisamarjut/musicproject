package hh.sof03.music.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof03.music.domain.Genre;
import hh.sof03.music.domain.GenreRepository;

@Controller
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/list/genrelist")
    public String genreList(Model model) {
        model.addAttribute("genres", genreRepository.findAll());
        return "list/genrelist";
    }

    // Add a new genre
    @GetMapping("/add/addgenre")
    public String addGenre(Model model) {
        model.addAttribute("genre", new Genre());
        return "add/addgenre";
    }

    // Save new genre
    @PostMapping("/savegenre")
    public String saveGenre(Genre genre) {
        genreRepository.save(genre);
        return "redirect:/list/genrelist";
    }

    // Delete genre
    @GetMapping("/deletegenre/{id}")
    public String deleteGenre(@PathVariable("id") Long genreId, Model model) {
        genreRepository.deleteById(genreId);
        return "redirect:../list/genrelist";
    }

    // Edit genre
    @GetMapping("/edit/editgenre/{id}")
    public String editGenre(@PathVariable("id") Long genreId, Model model) {
        model.addAttribute("genre", genreRepository.findById(genreId));
        return "edit/editgenre";
    }

    // Save edited genre
    @PostMapping("/saveeditgenre")
    public String saveEditGenre(@ModelAttribute("genre") Genre genre) {
        genreRepository.save(genre);
        return "redirect:/list/genrelist";
    }
}

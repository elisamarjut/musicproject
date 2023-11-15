package hh.sof03.music;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.music.domain.Album;
import hh.sof03.music.domain.AlbumRepository;
import hh.sof03.music.domain.Artist;
import hh.sof03.music.domain.ArtistRepository;
import hh.sof03.music.domain.Genre;
import hh.sof03.music.domain.GenreRepository;
import hh.sof03.music.domain.Song;
import hh.sof03.music.domain.SongRepository;
import hh.sof03.music.domain.User;
import hh.sof03.music.domain.UserRepository;

@SpringBootApplication
public class MusicApplication {
	private static final Logger log = LoggerFactory.getLogger(MusicApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}

	@Bean
	public CommandLineRunner demodata(SongRepository songRepository, UserRepository userRepository,
			ArtistRepository artistRepository, AlbumRepository albumRepository, GenreRepository genreRepository) {
		return (args) -> {

			log.info("Save a few genres");
			Genre g1 = new Genre("Rap", null);
			Genre g2 = new Genre("Tropipop", null);
			Genre g3 = new Genre("Pop", null);
			Genre g4 = new Genre("Folk-pop", null);
			Genre g5 = new Genre("R&B", null);

			genreRepository.save(g1);
			genreRepository.save(g2);
			genreRepository.save(g3);
			genreRepository.save(g4);
			genreRepository.save(g5);

			log.info("Save a few artists");
			Artist art1 = new Artist("JVG", 2019, null, null);
			Artist art2 = new Artist("Evelina", 2012, null, null);
			Artist art3 = new Artist("Maluma", 2010, null, null);
			Artist art4 = new Artist("KUUMAA", 2016, null, null);
			Artist art5 = new Artist("Ed Sheeran", 2004, null, null);
			Artist art6 = new Artist("Gasellit", 2008, null, null);

			artistRepository.save(art1);
			artistRepository.save(art2);
			artistRepository.save(art3);
			artistRepository.save(art4);
			artistRepository.save(art5);
			artistRepository.save(art6);

			log.info("Save a few albums");
			Album album1 = new Album("Rata/Raitti", 0, art1, null);
			Album album2 = new Album("Don Juan", 2023, art3, null);
			Album album3 = new Album("Pehmee", 2023, art2, null);
			Album album4 = new Album("X", 2014, art5, null);
			Album album5 = new Album("Zen", 2021, art6, null);

			albumRepository.save(album1);
			albumRepository.save(album2);
			albumRepository.save(album3);
			albumRepository.save(album4);
			albumRepository.save(album5);

			log.info("Save a few songs");
			Song s1 = new Song("Tässä on kaikki", 2.47, null, g3,
					null);
			Song s2 = new Song("Kyynelii", 3.23, null, g3,
					album3);
			Song s3 = new Song("Junio", 2.48, null, g2,
					album2);
			Song s4 = new Song("Photograph", 4.19, null, g4, album4);
			Song s5 = new Song("Sing", 3.55, null, g5, album4);
			Song s6 = new Song("Tenerife Sea", 4.01, null, g4, album4);
			Song s7 = new Song("Disko", 2.53, null, g1, album5);
			Song s8 = new Song("Kuvittele meidät siellä", 3.10, null, g1, album5);

			songRepository.save(s1);
			songRepository.save(s2);
			songRepository.save(s3);
			songRepository.save(s4);
			songRepository.save(s5);
			songRepository.save(s6);
			songRepository.save(s7);
			songRepository.save(s8);

			// Creating user: admin/admin
			User user1 = new User("admin", "$2a$10$uuY8JpD4EwyvBh0GKDn1u.55msv3CPSIFWjH4pQo0YiGD6E8/8zr6",
					"admin@mail.com", "ADMIN");

			userRepository.save(user1);
		};
	}

}

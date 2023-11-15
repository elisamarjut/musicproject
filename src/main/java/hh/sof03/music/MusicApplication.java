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
			Genre g1 = new Genre("Undefined", null);
			Genre g2 = new Genre("Tropipop", null);
			Genre g3 = new Genre("Pop", null);

			genreRepository.save(g1);
			genreRepository.save(g2);
			genreRepository.save(g3);

			log.info("Save a few artists");
			Artist art1 = new Artist("Unknown", 0, null, null);
			Artist art2 = new Artist("Evelina", 2012, null, null);
			Artist art3 = new Artist("Maluma", 2010, null, null);
			Artist art4 = new Artist("KUUMAA", 2016, null, null);

			artistRepository.save(art1);
			artistRepository.save(art2);
			artistRepository.save(art3);
			artistRepository.save(art4);

			log.info("Save a few albums");
			Album album1 = new Album("Unknown", 0, art1, null);
			Album album2 = new Album("Don Juan", 2023, art3, null);
			Album album3 = new Album("Pehmee", 2023, art2, null);

			albumRepository.save(album1);
			albumRepository.save(album2);
			albumRepository.save(album3);

			log.info("Save a few songs");
			Song s1 = new Song("Tässä on kaikki", 2.47, null, g3,
					null);
			Song s2 = new Song("Kyynelii", 3.23, null, g3,
					album3);
			Song s3 = new Song("Junio", 2.48, null, g2,
					album2);

			songRepository.save(s1);
			songRepository.save(s2);
			songRepository.save(s3);

			// Creating user: admin/admin
			User user1 = new User("admin", "$2a$10$uuY8JpD4EwyvBh0GKDn1u.55msv3CPSIFWjH4pQo0YiGD6E8/8zr6",
					"admin@mail.com", "ADMIN");

			userRepository.save(user1);
		};
	}

}

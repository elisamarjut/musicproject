package hh.sof03.music;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.music.domain.Artist;
import hh.sof03.music.domain.ArtistRepository;
import hh.sof03.music.domain.Song;
import hh.sof03.music.domain.SongRepository;
import hh.sof03.music.domain.UserRepository;

@SpringBootApplication
public class MusicApplication {
	private static final Logger log = LoggerFactory.getLogger(MusicApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}

	@Bean
	public CommandLineRunner demodata(SongRepository songRepository, UserRepository userRepository,
			ArtistRepository artistRepository) {
		return (args) -> {
			log.info("Save a few songs");
			Song s1 = new Song("Tässä on kaikki", 2.47, null, null,
					null);
			Song s2 = new Song("Kyynelii", 3.23, null, null,
					null);
			Song s3 = new Song("Junio", 2.48, null, null,
					null);

			songRepository.save(s1);
			songRepository.save(s2);
			songRepository.save(s3);

			log.info("Save a few artists");
			Artist a1 = new Artist("KUUMAA", 2016, null, null);
			Artist a2 = new Artist("Evelina", 2012, null, null);
			Artist a3 = new Artist("Maluma", 2010, null, null);

			artistRepository.save(a1);
			artistRepository.save(a2);
			artistRepository.save(a3);

		};
	}

}

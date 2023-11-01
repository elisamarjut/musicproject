package hh.sof03.music;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	public CommandLineRunner demodata(SongRepository songRepository, UserRepository userRepository) {
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

		};
	}

}

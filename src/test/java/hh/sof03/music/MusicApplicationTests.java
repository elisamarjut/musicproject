package hh.sof03.music;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hh.sof03.music.web.AlbumController;
import hh.sof03.music.web.ArtistController;
import hh.sof03.music.web.GenreController;
import hh.sof03.music.web.SongController;

@SpringBootTest
class MusicApplicationTests {

	@Autowired
	private SongController songController;

	@Autowired
	private ArtistController artistController;

	@Autowired
	private AlbumController albumController;

	@Autowired
	private GenreController genreController;

	@Test
	public void songControllerLoads() throws Exception {
		assertThat(songController).isNotNull();
	}

	@Test
	public void artistControllerLoads() throws Exception {
		assertThat(artistController).isNotNull();
	}

	@Test
	public void albumControllerLoads() throws Exception {
		assertThat(albumController).isNotNull();
	}

	@Test
	public void genreControllerLoads() throws Exception {
		assertThat(genreController).isNotNull();
	}
}

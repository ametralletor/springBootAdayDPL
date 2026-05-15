package com.example.demo.service;
import com.example.demo.model.Anime;
import com.example.demo.repository.AnimeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import  static org.junit.jupiter.api.Assertions.*;
import  static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AnimeServiceTest {
    @Mock
    private AnimeRepository repository;

    @InjectMocks
    private AnimeService service;
    private Anime anime;

    @BeforeEach
    public void setUp() {
        anime = new Anime();
        anime.setId(2L);
        anime.setTitulo("Ponyo");
        anime.setGenero("Aventura");
        anime.setEpisodios(1);
    }

    @Test
    void testGuardarAnime() {
        when(repository.save(any(Anime.class))).thenReturn(anime);

        Anime guardado = service.save(anime);

        assertNotNull(guardado);
        assertEquals("Ponyo", guardado.getTitulo());
        verify(repository, times(1)).save(any(Anime.class));
    }

    @Test
    void testObtenerTodos(){
            when(repository.findAll()).thenReturn(List.of(anime));
			
			List<Anime> lista = service.findAll();

			assertFalse(lista.isEmpty());
			assertEquals(1, lista.size());
			verify(repository, times(1)).findAll();
    }
}

package com.example.demo.controller;

import com.example.demo.model.Anime;
import com.example.demo.service.AnimeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import  static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(AnimeController.class)
public class AnimeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AnimeService service;

    @Test
    void  testListarTodosEndpoint() throws  Exception {
		Anime  a = new  Anime();
		a.setTitulo("One Piece");

		when(service.obtenerTodos()).thenReturn(List.of(a));

		mockMvc.perform(get("/api/animes"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].titulo").value("One Piece"));
	}
}

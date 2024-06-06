package com.app_service_back.Categoria;

import com.app_service_back.categoria.CategoriaEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoriaTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Verificar se a rota de categoria está respondendo corretamente")
    void index() throws Exception{
        mockMvc.perform(get("/categoria")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Verificar se está criando uma categoria")
    @Transactional
    @Rollback
    void create() throws Exception{
        CategoriaEntity categoriaExemplo = new CategoriaEntity();
        categoriaExemplo.setCategoriaNome("Jardinagem");
        categoriaExemplo.setCategoriaDescricao("Serviços de Jardinagem");

        String jsonRequest = objectMapper.writeValueAsString(categoriaExemplo);

        mockMvc.perform(post("/categoria")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest)).andExpect(status().isCreated());
        TestTransaction.end();
    }

    @Test
    @DisplayName("Verifica se está alterando o registro corretamente")
    @Transactional
    @Rollback
    void update() throws Exception{
        CategoriaEntity categoriaExemplo = new CategoriaEntity();
        categoriaExemplo.setCategoriaNome("Pintora");
        categoriaExemplo.setCategoriaDescricao("Serviçus de pintora");

        String jsonRequest = objectMapper.writeValueAsString(categoriaExemplo);

        String response = mockMvc.perform(post("/categoria")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest)).andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

//        System.out.println(response);

        JsonNode JsonNode = objectMapper.readTree(response);
        Long id = JsonNode.get("idCategoria").asLong();

        CategoriaEntity categoriaUpdate = new CategoriaEntity();
        categoriaUpdate.setCategoriaNome("Pintura");
        categoriaUpdate.setCategoriaDescricao("Serviços de pintura");
        categoriaExemplo.setIdCategoria(id);

        String jsonUpdateRequest = objectMapper.writeValueAsString(categoriaUpdate);

        mockMvc.perform(put("/categoria/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonUpdateRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categoriaNome").value("Pintura"));

    }

}


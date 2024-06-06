package com.app_service_back.Endereco;

import com.app_service_back.categoria.CategoriaEntity;
import com.app_service_back.endereco.EnderecoEntity;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EnderecoTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Verificar se a rota de endereço está respondendo corretamente")
    void index() throws Exception{
        mockMvc.perform(get("/endereco")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Verificar se está criando um endereço")
    @Transactional
    @Rollback
    void create() throws Exception{
        EnderecoEntity enderecoExemplo = new EnderecoEntity();
        enderecoExemplo.setEnderecoCep("88804010");
        enderecoExemplo.setEnderecoBairro("Santa Bárbara");
        enderecoExemplo.setEnderecoCidade("Criciúma");
        enderecoExemplo.setEnderecoEstado("Santa Catarina");
        enderecoExemplo.setEnderecoNumero(1717);
        enderecoExemplo.setEnderecoRua("Henrique Lage");

        String jsonRequest = objectMapper.writeValueAsString(enderecoExemplo);

        mockMvc.perform(post("/endereco")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest)).andExpect(status().isCreated());
        TestTransaction.end();
    }
    @Test
    @DisplayName("Verifica se está alterando o registro corretamente")
    @Transactional
    @Rollback
    void update() throws Exception{
        EnderecoEntity enderecoExemplo = new EnderecoEntity();
        enderecoExemplo.setEnderecoCep("88804010");
        enderecoExemplo.setEnderecoBairro("Santa Bárbara");
        enderecoExemplo.setEnderecoCidade("Criciúma");
        enderecoExemplo.setEnderecoEstado("Santa Catalina");
        enderecoExemplo.setEnderecoNumero(1717);
        enderecoExemplo.setEnderecoRua("Henrique Lages");

        String jsonRequest = objectMapper.writeValueAsString(enderecoExemplo);

        String response = mockMvc.perform(post("/endereco")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)).andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();

//        System.out.println(response);

        JsonNode JsonNode = objectMapper.readTree(response);
        Long id = JsonNode.get("idEndereco").asLong();

        EnderecoEntity enderecoUpdate = new EnderecoEntity();
        enderecoUpdate.setEnderecoCep("88804010");
        enderecoUpdate.setEnderecoBairro("Santa Bárbara");
        enderecoUpdate.setEnderecoCidade("Criciúma");
        enderecoUpdate.setEnderecoEstado("Santa Catarina");
        enderecoUpdate.setEnderecoNumero(1717);
        enderecoUpdate.setEnderecoRua("Henrique Lage");

        String jsonUpdateRequest = objectMapper.writeValueAsString(enderecoUpdate);

        mockMvc.perform(put("/endereco/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonUpdateRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.enderecoRua").value("Henrique Lage"));

    }
}

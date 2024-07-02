package com.app_service_back.Cliente;

import com.app_service_back.cliente.ClienteDTO;
import com.app_service_back.cliente.ClienteEntity;
import com.app_service_back.cliente.ClienteService;
import com.app_service_back.endereco.EnderecoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EnderecoService enderecoService;

    @MockBean
    private ClienteService clienteService;




    @Test
    @DisplayName("Validar se inválido está salvando no banco")
    void validaCpf() throws Exception{
        ClienteEntity cliente = new ClienteEntity();
        cliente.setClienteCpf("111.111.111-11");
        cliente.setClienteNome("Cliente");
        cliente.setClienteEmail("a@a.com");
        cliente.setClienteDataNascimento(LocalDate.now());

        String jsonRequest = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isBadRequest());


    }

    @Test
    void create() throws Exception{
        ClienteEntity cliente = new ClienteEntity();
        cliente.setClienteCpf("992.397.300-01");
        cliente.setClienteNome("");
        cliente.setClienteEmail("");
        cliente.setClienteDataNascimento(LocalDate.now());
        cliente.setClienteSenha("123456");


        String jsonRequest = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createCorreto() throws Exception{
        ClienteEntity cliente = new ClienteEntity();
        cliente.setClienteCpf("628.746.020-27");
        cliente.setClienteNome("Nome");
        cliente.setClienteEmail("email@email.com");
        cliente.setClienteDataNascimento(LocalDate.now());
        cliente.setClienteSenha("123456");


        String jsonRequest = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isCreated());
    }

//    @Test
//    void getById(){
//        Long id = 1L;
//
//        ClienteDTO cliente = clienteService.findById(id);
//
//        cliente.setClienteNome("Nome não vazio");
//
//        String jsonRequest = objectMapper.writeValueAsString(cliente);
//
//
//    }

}

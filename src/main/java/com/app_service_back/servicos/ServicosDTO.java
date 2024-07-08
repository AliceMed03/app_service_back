package com.app_service_back.servicos;

import com.app_service_back.agendamento.AgendamentoEntity;
import com.app_service_back.categoria.CategoriaEntity;
import com.app_service_back.prestador.PrestadorEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idServicos;
    @NotBlank(message = "O campo NOME é requerido.")
    private String servicosNome;
    @NotBlank(message = "O campo PREÇO é requerido.")
    private Double servicosPreco;
    @NotBlank(message = "O campo DESCRIÇÃO é requerido.")
    private String servicosDescricao;
    private String servicosInformacoesAdicionais;
    private String servicosClassificacao;
    private CategoriaEntity categoria;
    private PrestadorEntity prestador;
    private List<AgendamentoEntity> agendamento;

}

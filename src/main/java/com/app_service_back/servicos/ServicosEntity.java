package com.app_service_back.servicos;

import com.app_service_back.agendamento.AgendamentoEntity;
import com.app_service_back.categoria.CategoriaEntity;
import com.app_service_back.endereco.EnderecoEntity;
import com.app_service_back.prestador.PrestadorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "servicos")
public class ServicosEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idServicos;
    private String servicosNome;
    private Double servicosPreco;
    private String servicosDescricao;
    private String servicosInformacoesAdicionais;
    private String servicosClassificacao;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servicosIdCategoria", nullable = false)
    private CategoriaEntity categoria;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servicosIdPrestador", nullable = false)
    private PrestadorEntity prestador;
    @OneToMany(fetch = FetchType.EAGER)
    private List<AgendamentoEntity> agendamento = new ArrayList<>();


}

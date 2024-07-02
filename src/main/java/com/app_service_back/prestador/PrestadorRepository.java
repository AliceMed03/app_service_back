package com.app_service_back.prestador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestadorRepository extends JpaRepository<PrestadorEntity, Long> {
    //cria uma interface para ser implementada
//    @Query("SELECT p FROM Prestador p WHERE p.servico.id = :servicoId")
//    List<Prestadores> findByServicoId(@Param("servicoId") Long servicoId);
}

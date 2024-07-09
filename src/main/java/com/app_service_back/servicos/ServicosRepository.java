
package com.app_service_back.servicos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicosRepository extends JpaRepository<ServicosEntity,Long> {
    //cria uma interface para ser implementada
    @Query("SELECT s FROM ServicosEntity s WHERE s.servicosNome = :servicosName")
    List<ServicosEntity> findByServicosNome(@Param("servicosName") String servicosName);
}

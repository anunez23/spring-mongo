package com.preving.mongo_spring.repository;

import com.preving.mongo_spring.documents.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

@Repository
@CrossOrigin(value = {})
public interface UsuarioRepository extends MongoRepository<Usuario, Serializable> {

    @RestResource(path = "apellido", rel = "apellido")
    public List<Usuario> findByApellidoOrderByNombre(@Param("apellido")String apellido, Pageable pageable);

    @RestResource(path = "borrarPorNombre", rel = "borrarPorNombre")
    public void deleteByNombre(@Param("nombre")String nombre);

}

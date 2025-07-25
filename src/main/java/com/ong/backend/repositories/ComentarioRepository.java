package com.ong.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ong.backend.entities.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository <Comentario, Long>{
	
	List<Comentario> findByIdBlogId(Long idBlog);

}

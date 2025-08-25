package com.ong.backend.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_notificacao")
public class Notificacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String assunto;
	private String descricao;
	private String imgUrl;
	
	@Enumerated(EnumType.STRING)
	private StatusVisualizacao status = StatusVisualizacao.NAO_VISTO;
	private LocalTime dataEnvio;
	
	@OneToMany(mappedBy = "notificacao")
	private List<NotificacaoUsuario> notificacoesUsuarios = new ArrayList<>();
	
	public Notificacao() {}

	public Notificacao(Long id, String assunto, String descricao, String imgUrl, StatusVisualizacao status,
			LocalTime dataEnvio) {
		this.id = id;
		this.assunto = assunto;
		this.descricao = descricao;
		this.imgUrl = imgUrl;
		this.status = status;
		this.dataEnvio = dataEnvio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public StatusVisualizacao getStatus() {
		return status;
	}

	public void setStatus(StatusVisualizacao status) {
		this.status = status;
	}

	public LocalTime getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public List<NotificacaoUsuario> getNotificacoesUsuarios() {
		return notificacoesUsuarios;
	}

	public void setNotificacoesUsuarios(List<NotificacaoUsuario> notificacoesUsuarios) {
		this.notificacoesUsuarios = notificacoesUsuarios;
	}
}

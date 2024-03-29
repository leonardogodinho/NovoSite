package modelo;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="candidatura")
@SequenceGenerator(name="seq_id_candidatura", sequenceName="seq_id_candidatura")
public class Candidatura {
	
	@Id
	@Column(name="id_candidatura")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="seq_id_candidatura")
	private int idCandidatura;

	@Column(name="id_usuario")
	private int idUsuario;
	
	@Column(name="id_oportunidade")
	private int idOportunidade;
	
	@Column(name="dt_inscricao")
	private Date dataInscricao;
	
	@Column(name="in_supervisor_aceite")
	private String supervisorAceite;
	
	@Column(name="in_aprovado")
	private String aprovado;
	
	@Column(name="nr_cpf")
	private int cpfSupervisor;

	public int getIdCandidatura() {
		return idCandidatura;
	}

	public void setIdCandidatura(int idCandidatura) {
		this.idCandidatura = idCandidatura;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdOportunidade() {
		return idOportunidade;
	}

	public void setIdOportunidade(int idOportunidade) {
		this.idOportunidade = idOportunidade;
	}

	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	public String getSupervisorAceite() {
		return supervisorAceite;
	}

	public void setSupervisorAceite(String supervisorAceite) {
		this.supervisorAceite = supervisorAceite;
	}

	public String getAprovado() {
		return aprovado;
	}

	public void setAprovado(String aprovado) {
		this.aprovado = aprovado;
	}

	public int getCpfSupervisor() {
		return cpfSupervisor;
	}

	public void setCpfSupervisor(int cpfSupervisor) {
		this.cpfSupervisor = cpfSupervisor;
	}
	
}

package dao;

import java.util.ArrayList;

import modelo.*;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

public class DAOCandidatura {
	private SessionFactory fabrica;

	public DAOCandidatura() {
		fabrica = Conexao.obtemFabrica();
	}

	public void cadastrar(Candidatura c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.save(c);
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	
	public void alterar(Candidatura c) throws Exception {
		Session sessao = fabrica.openSession();
		Transaction transacao = sessao.beginTransaction();
		sessao.update(c);
		transacao.commit();
		sessao.flush();
		sessao.close();
	}
	
	public Candidatura consultar(Candidatura c) throws Exception {
		Session sessao = fabrica.openSession();
		Criteria cr = sessao.createCriteria(Candidatura.class).add(
				Restrictions.eq("idCandidatura", c.getIdCandidatura()));
		c = (Candidatura) cr.uniqueResult();
		sessao.flush();
		sessao.close();
		return c;
	}
	
	public ArrayList consultarCandidaturasAprovar() throws Exception {
		Session sessao = fabrica.openSession();
		Criteria cr = sessao.createCriteria(Candidatura.class)
							.add(Restrictions.isNull("supervisorAceite"));
		ArrayList lista = (ArrayList) cr.list();
		sessao.flush();
		sessao.close();
		return lista;
	}
	
	public boolean verificaID(Candidatura c) throws Exception {
		Session sessao = fabrica.openSession();
		Criteria cr = sessao.createCriteria(Candidatura.class)
							.add(Restrictions.eq("idUsuario", c.getIdUsuario()))
							.add(Restrictions.eq("idOportunidade", c.getIdOportunidade()));
		Candidatura u = (Candidatura) cr.uniqueResult();
		if (u == null)
			return true;
		else
			return false;
	}
}

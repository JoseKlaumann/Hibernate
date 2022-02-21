package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Contato;

public class ContatoDao {
	
	EntityManagerFactory emf; //analogia -Connect-
	EntityManager em; // -Prepared statement-

	public ContatoDao() {
		emf = Persistence.createEntityManagerFactory("JPAPU");
		em = emf.createEntityManager();
	}
	
	//insert
	public void salvar(Contato contato) {
		em.getTransaction().begin();//Faz a conexao
		em.persist(contato);//Serve para inserir no banco com o hibernate
		em.getTransaction().commit();//Fecha a conexao e faz o commit
		em.close();
		}
	
	//Find by id
	public Contato pegarUm (Long id) {
		return em.find(Contato.class, id);		
	}
	
	//Update
	public boolean update(Contato contato) {
		//Faz a consulta no banco
		/*Contato cont = em.find(Contato.class, contato.getId());//Contato vindo do banco
		cont.setNome(contato.getNome());
		cont.setEmail(contato.getEmail());
		cont.setCelular(contato.getCelular());*/
		
		//Salva no banco
		em.getTransaction().begin();
		em.merge(contato);//Faz o update no banco de dados
		em.getTransaction().commit();
		em.close();
		return true;
	}
	
	 @SuppressWarnings("unchecked")
     public List<Contato> findAll() { //Faz a chamda de todos os dados do banco de dados
       return em.createQuery("FROM " +
       Contato.class.getName()).getResultList();
     }
}

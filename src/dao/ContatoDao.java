package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Contato;

/**
 * @author José Augusto Klaumann
 * @version 1.0
 */
public class ContatoDao {
	
	EntityManagerFactory emf; //analogia -Connect-
	EntityManager em; // -Prepared statement-

	/**
	 * @param construtor para o hibernate fazer a conexao com o banoco de dados
	 */
	public ContatoDao() {
		emf = Persistence.createEntityManagerFactory("JPAPU");
		em = emf.createEntityManager();
	}
	
	/**
	 * @param contato construtor que faz o insert 
	 */
	//insert
	public void salvar(Contato contato) {
		em.getTransaction().begin();//Faz a conexao
		em.persist(contato);//Serve para inserir no banco com o hibernate
		em.getTransaction().commit();//Fecha a conexao e faz o commit
		em.close();
		}
	
	/**
	 * @param id construtor que encontra pelo id
	 */
	//Find by id
	public Contato pegarUm (Long id) {
		return em.find(Contato.class, id);		
	}
	
	/**
	 * @param contato construtor que faz o update
	 */
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
	
	/**
	 * @param construtor que encontra todos os dados gravados no banco relacionados ao contato
	 */
	 @SuppressWarnings("unchecked")
     public List<Contato> findAll() { //Faz a chamda de todos os dados do banco de dados
       return em.createQuery("FROM " +
       Contato.class.getName()).getResultList();
     }
}

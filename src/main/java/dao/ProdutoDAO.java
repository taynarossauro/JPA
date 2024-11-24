package dao;

import models.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtoPU");
    //método que insere produtos no banco de daods
    public void criar(Produto produto) {
        EntityManager em = emf.createEntityManager(); 
        em.getTransaction().begin(); 
        em.persist(produto); 
        em.getTransaction().commit(); 
        em.close(); 
    }

    //método que lê produtos
    public Produto ler(Long id) {
        EntityManager em = emf.createEntityManager();
        Produto produto = em.find(Produto.class, id); 
        em.close(); 
        return produto;
    }

    //método que lista produtos
    public List<Produto> listarTodos() {
        EntityManager em = emf.createEntityManager(); 
        
        List<Produto> produtos = em.createQuery("FROM Produto", Produto.class).getResultList();
        em.close();
        return produtos; 
    }

    //método que atualiza produtos
    public void atualizar(Produto produto) {
        EntityManager em = emf.createEntityManager(); 
        em.getTransaction().begin(); 
        em.merge(produto); 
        em.getTransaction().commit(); 
        em.close(); 
    }
    //método que exclui produtos
    public void excluir(Long id) {
        EntityManager em = emf.createEntityManager(); 
        Produto produto = em.find(Produto.class, id); 
        if (produto != null) { 
            em.getTransaction().begin(); 
            em.remove(produto);
            em.getTransaction().commit();
        }
        em.close(); 
    }
}
package br.com.aposentadoria.daos;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutorEntityManager {
   private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
 
   @Produces
   public EntityManager criaEntityManager() {
      return factory.createEntityManager();
   }
}
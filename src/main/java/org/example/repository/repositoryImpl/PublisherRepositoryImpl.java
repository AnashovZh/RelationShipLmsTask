package org.example.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.model.Publisher;
import org.example.repository.PublisherRepository;

import java.util.List;

public class PublisherRepositoryImpl implements PublisherRepository {
    EntityManager entityManager= HibernateConfig.getEntityManager();
    @Override
    public String savePublisher(Publisher publisher) {
        entityManager.getTransaction().begin();
        entityManager.persist(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved";
    }

    @Override
    public Publisher getPublisherById(Long id) {
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public List<Publisher> getAllPublishers(String ascOrDesc) {
        entityManager.getTransaction().begin();
        List resultList = entityManager.createQuery("select p from Publisher p order by p.name "+ascOrDesc)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }

    @Override
    public String updatePublisher(Long publisherId, Publisher publisher) {
        entityManager.getTransaction().begin();
       entityManager.createNativeQuery("update publishers set address=:a, name=:n where id=:i").setParameter("a",publisher.getAddress()).
       setParameter("n",publisher.getName()).setParameter("i",publisherId).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully updated";
    }

    @Override
    public String deletePublisherByName(String name) {
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("delete from  publishers where name=:n").
        setParameter("n",name).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully deleted";
    }
}

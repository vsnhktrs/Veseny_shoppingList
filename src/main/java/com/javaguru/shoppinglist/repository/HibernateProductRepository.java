package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Profile("Hibernate")
@Transactional
public class HibernateProductRepository implements ProductRepasitory {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateProductRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long add(Product product){
        sessionFactory.getCurrentSession().save(product);
        return product.getId();
    }

    @Override
    public Optional<Product> findby(Long id){
        Product product = (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
        return Optional.ofNullable(product);
    }



}

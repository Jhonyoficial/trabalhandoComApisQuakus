package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Payment;

@ApplicationScoped
public class RepositoryPayment implements PanacheRepository<Payment> {

    public Payment persistPayment(Payment payment) {
        persist(payment);
        return payment;
    }

    public int update(String id) {
        return update("receipt = 'sandrolax' where id = ?1", id);
    }

}

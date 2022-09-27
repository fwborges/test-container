package br.com.springboot.testcontainer.example.repository;

import br.com.springboot.testcontainer.example.entity.CreditCard;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE CreditCard c SET active = ? WHERE c.name = ?",
            nativeQuery = true)
    void updateActiveStatus(boolean active, String name);
}

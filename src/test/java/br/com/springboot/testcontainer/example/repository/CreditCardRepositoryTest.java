package br.com.springboot.testcontainer.example.repository;

import br.com.springboot.testcontainer.example.entity.CreditCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CreditCardRepositoryTest {

	@Autowired
	private CreditCardRepository creditCardRepository;

	@Transactional
	@Test
	void should_block_credit_card() {
		insertCreditCards();

		creditCardRepository.updateActiveStatus(false, "Seya");

		CreditCard seyaCreditCard = creditCardRepository.findById(1l).orElseThrow();

		assertTrue(seyaCreditCard.getName().equals("Seya"));
		assertFalse(seyaCreditCard.isActive());
	}

	private void insertCreditCards() {
		creditCardRepository.save(new CreditCard(1l, "Seya", true));
		creditCardRepository.save(new CreditCard(2l, "Ikki", false));
		creditCardRepository.save(new CreditCard(3l, "Shun", false));
		creditCardRepository.save(new CreditCard(4l, "Hyoga", true));
		creditCardRepository.save(new CreditCard(5l, "Shiryu", true));
	}

}

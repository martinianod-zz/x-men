/**
 * 
 */
package com.mdambrosio.xmens.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mdambrosio.xmens.repository.DnaRepository;

/**
 * @author mdambrosio
 *
 */
@RunWith(SpringRunner.class)
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class DnaTest {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private DnaRepository repository;

	@BeforeAll
	public void init() {
		boolean exists = repository.existsByDna("AAAACCCCAAAAGGGG");

		System.out.println("EXISTE: " + exists);

		if (exists) {
			throw new IllegalArgumentException("La cadena que se desea testear ya existe en la base de datos");
		}
	}

	@Test
	@Order(1)
	public void testAddNewCadenaDna() {

		Dna dna = new Dna();
		dna.setDna("AAAACCCCAAAAGGGG");
		dna.setIsMutant(true);

		Dna dnaSaved = repository.save(dna);

		assertNotNull(dnaSaved.getDna());
		assertEquals("AAAACCCCAAAAGGGG", dnaSaved.getDna());

		assertNotNull(dnaSaved.getIsMutant());
		assertEquals(true, dnaSaved.getIsMutant());
	}

	@Test
	@Order(2)
	public void testDeleteCadenaEntity() {

		Dna dnaSaved = repository.findByDna("AAAACCCCAAAAGGGG");

		repository.delete(dnaSaved);

		assertTrue(!repository.existsByDna("AAAACCCCAAAAGGGG"));

	}

}

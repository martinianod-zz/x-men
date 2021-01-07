package com.mdambrosio.xmens.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mdambrosio.xmens.model.Dna;

/**
 * @author mdambrosio
 *
 */
@Repository
public interface DnaRepository extends CrudRepository<Dna, Long> {

	Dna findByDna(String cadenaDna);

}

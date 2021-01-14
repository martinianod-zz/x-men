package com.mdambrosio.xmens.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mdambrosio.xmens.model.Dna;
import com.mdambrosio.xmens.service.IStats;

/**
 * @author mdambrosio
 *
 */
@Repository
public interface DnaRepository extends CrudRepository<Dna, Long> {
	
	/**
	 * 
	 * @param cadenaDna
	 * @return
	 */
	Dna findByDna(String cadenaDna);

	/**
	 * 
	 * @return
	 */
	@Query(value = "SELECT SUM(CASE WHEN is_mutant THEN 1 ELSE 0 END) as countMutantDna , \r\n"
			+ "		SUM(CASE WHEN NOT is_mutant THEN 1 ELSE 0 END) as countHumanDna \r\n"
			+ "FROM dna", nativeQuery = true)
	public IStats getStats();

	/**
	 * 
	 * @param string
	 * @return
	 */
	boolean existsByDna(String string);

}

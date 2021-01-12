/**
 * 
 */
package com.mdambrosio.xmens.service;

import java.text.DecimalFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdambrosio.xmens.dto.StatsDTO;
import com.mdambrosio.xmens.interfaces.IConsultaStats;
import com.mdambrosio.xmens.repository.DnaRepository;

/**
 * @author mdambrosio
 *
 */
@Service
public class StatsService implements IConsultaStats {

	@Autowired
	private DnaRepository dnaRepository;

//	@Autowired
//	private ModelMapper modelMapper;

	private static final Logger logger = LogManager.getLogger(StatsService.class);

	public StatsDTO getStats() throws Exception {
		logger.info("In StatsService ... getStats()");

		StatsDTO statsResponse = new StatsDTO();

		try {

			IStats stats = dnaRepository.getStats();
			statsResponse.setCount_human_dna(stats.getCountHumanDna());
			statsResponse.setCount_mutant_dna(stats.getCountMutantDna());
			
			 double ratio = ((double)stats.getCountMutantDna() / stats.getCountHumanDna());
			statsResponse.setRatio(ratio);

			return statsResponse;

		} catch (Exception err) {
			logger.warn("Exception, datos no encontrados");
			throw new Exception("Exception, datos no encontrados");
		}
	}

}

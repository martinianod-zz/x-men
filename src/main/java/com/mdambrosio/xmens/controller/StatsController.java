/**
 * 
 */
package com.mdambrosio.xmens.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdambrosio.xmens.dto.StatsDTO;
import com.mdambrosio.xmens.interfaces.IConsultaStats;

/**
 * @author mdambrosio
 *
 */
@RestController
@RequestMapping(value = "v1/api/stats")
public class StatsController {

	private static final Logger logger = LogManager.getLogger(DnaController.class);

	@Autowired
	IConsultaStats iConsultaStats;

	/**
	 * 
	 * <h1>getStats()</h1> metodo encargado de devolver las estadisticas de adn
	 * almacenados en base de datos.
	 * s
	 * @return ResponseEntity 200 OK con las estadisticas obtenidas.
	 * @throws Exception
	 */
	@GetMapping()
	public ResponseEntity<StatsDTO> getStats() throws Exception {

		StatsDTO stats = iConsultaStats.getStats();

//		ResponseStats responseStats = new ResponseStats();
//		responseStats.setStats_dto(stats);
//			throw new ForbiddenException();

		return ResponseEntity.ok(stats);

	}
}

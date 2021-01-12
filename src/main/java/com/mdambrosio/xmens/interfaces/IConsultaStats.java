/**
 * 
 */
package com.mdambrosio.xmens.interfaces;

import com.mdambrosio.xmens.dto.StatsDTO;

/**
 * @author mdambrosio
 *
 */
@FunctionalInterface
public interface IConsultaStats {
	
	StatsDTO getStats() throws Exception;

}

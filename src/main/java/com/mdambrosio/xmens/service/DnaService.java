package com.mdambrosio.xmens.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdambrosio.xmens.dto.DnaListDTO;
import com.mdambrosio.xmens.model.Dna;
import com.mdambrosio.xmens.repository.DnaRepository;

/**
 * 
 * @author mdambrosio
 *
 */
@Service
public class DnaService implements IDna {

	@Autowired
	DnaRepository dnaRepository;

	public boolean isMutant(DnaListDTO dna) {

		List<String> list = new ArrayList<>(Arrays.asList(dna.getDna()));

		String cadenaDna = list.stream().map(x -> x).collect(Collectors.joining());

		Dna dnaEntity = dnaRepository.findByDna(cadenaDna);

		if (dnaEntity == null) {

			Dna newDna = new Dna();

			newDna.setDna(cadenaDna);
			newDna.setIsMutant(this.checkDnaIsMutant(cadenaDna, list.size()));

			return dnaRepository.save(newDna).getIsMutant();

		} else {
			return dnaEntity.getIsMutant();
		}
	}

	private Boolean checkDnaIsMutant(String cadenaDna, int size) {

		int cantSecuenciasEncontradas = 0;
		int maxHorizontalesContinuas = 0;
		boolean compararHorizontal = false;
		boolean compararVertical = false;

		for (int i = 0; i < cadenaDna.length(); i++) {

			System.out.println("[" + i + "] " + "comparo: " + cadenaDna.charAt(i));

			if (i % size == 0) {
				maxHorizontalesContinuas = size - 3;
				compararHorizontal = true;
			}

			if (i / size < 3) {
				compararVertical = true;
			} else {
				compararVertical = false;
			}

			if (compararHorizontal) {

				if (this.esSecuenciaMutant(cadenaDna, i, 1))
					cantSecuenciasEncontradas++;

			}

			if (compararVertical) {

				if (this.esSecuenciaMutant(cadenaDna, i, size))
					cantSecuenciasEncontradas++;

			}

			if (compararHorizontal && compararVertical) {

				if (this.esSecuenciaMutant(cadenaDna, i, size + 1))
					cantSecuenciasEncontradas++;

			}

			if (cantSecuenciasEncontradas > 1)
				return true;

			maxHorizontalesContinuas--;
			if (maxHorizontalesContinuas == 0) {
				compararHorizontal = false;
			}

		}

		return false;
	}

	private boolean esSecuenciaMutant(String cadenaDna, int i, int size) {
		for (int j = 0; j < 3; j++) {

//			System.out.println("[" + i + "] " + "comparo: " + cadenaDna.charAt(i) + " con: "
//					+ cadenaDna.charAt((size * (j + 1)) + i) + "[" + ((size * (j + 1)) + i) + "]");

			if (cadenaDna.charAt(i) != cadenaDna.charAt((size * (j + 1)) + i)) {
				return false;
			}

		}

		return true;
	}
}

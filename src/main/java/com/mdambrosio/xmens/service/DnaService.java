package com.mdambrosio.xmens.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdambrosio.xmens.dto.DnaListDTO;
import com.mdambrosio.xmens.exceptions.ForbiddenException;
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
	private DnaRepository dnaRepository;

	/**
	 * 
	 * @param dna
	 * @return
	 * @throws ForbiddenException
	 */
	public void isMutant(DnaListDTO dna) throws ForbiddenException {

		boolean isDnaMutant;

		List<String> list = new ArrayList<>(Arrays.asList(dna.getDna()));

		String cadenaDna = list.stream().map(x -> x).collect(Collectors.joining());

		Dna dnaEntity = dnaRepository.findByDna(cadenaDna);

		// Verifico si la cadena ya existe en la base de datos, de ser verifico si es
		// mutante o no.
		// Caso contrario analizo la cadena de Dna.
		if (dnaEntity == null) {

			Dna newDna = new Dna();

			newDna.setDna(cadenaDna);
			newDna.setIsMutant(this.checkDnaIsMutant(cadenaDna, list.size()));

			isDnaMutant = dnaRepository.save(newDna).getIsMutant();

		} else {
			isDnaMutant = dnaEntity.getIsMutant();
		}

		// En caso de no ser mutande devuelvo una excepcion
		if (!isDnaMutant)
			throw new ForbiddenException();
	}

	/**
	 * <h1>checkDnaIsMutant
	 * <h1>método que verifica si la cadena de Dna pertenece a un mutante o no.
	 * 
	 * @param cadenaDna representa la cadena completa de Dna.
	 * @param size      representa la cantidad de tramos que posee la cadena de Dna.
	 * @return true en caso de ser mutante o false en caso de no serlo.
	 */
	private Boolean checkDnaIsMutant(String cadenaDna, int size) {

		int cantSecuenciasEncontradas = 0;
		int maxHorizontalesContinuas = 0;
		boolean compararHorizontal = false;
		boolean compararVertical = false;

		for (int i = 0; i < cadenaDna.length(); i++) {

			System.out.println("[" + i + "] " + "comparo: " + cadenaDna.charAt(i));

			// Busco si la posicion de la cadena es multiplo del tamaño de cada tramo para
			// volver a comparar de forma horizontal ciertos caracteres.
			if (i % size == 0) {
				maxHorizontalesContinuas = size - 3;
				compararHorizontal = true;
			}

			// Si el resultado de la división entre la posición y el tamaño de cada tramo es
			// menor a 3 se puede buscar de forma vertical, caso contrario ya no hay
			// posibilidades de encontrar secuencias de 4 caracteres de forma vertical.
			if (i / size < 3) {
				compararVertical = true;
			} else {
				compararVertical = false;
			}

			// busco de forma horizontal(_)
			if (compararHorizontal) {

				if (this.esSecuenciaMutant(cadenaDna, i, 1))
					cantSecuenciasEncontradas++;

			}

			// busco de forma vertical(|)
			if (compararVertical) {

				if (this.esSecuenciaMutant(cadenaDna, i, size))
					cantSecuenciasEncontradas++;

			}

			// busco de forma oblicua hacia adelante(\)
			if (compararHorizontal && compararVertical) {

				if (this.esSecuenciaMutant(cadenaDna, i, size + 1))
					cantSecuenciasEncontradas++;

			}

			// busco de forma oblicua hacia atras(/)
			if (!compararHorizontal && compararVertical) {

				if (this.esSecuenciaMutant(cadenaDna, i, size - 1))
					cantSecuenciasEncontradas++;

			}

			// Si las cantides de secuencias de 4 caracteres iguales es mayor a 1 es
			// mutante.
			if (cantSecuenciasEncontradas > 1)
				return true;

			// disminuyo en cada iteración las posibilidades horizontales sobre los
			// caracteres de la cadena para no buscar casos horizontales innecesarios.
			maxHorizontalesContinuas--;
			if (maxHorizontalesContinuas == 0) {
				compararHorizontal = false;
			}

		}

		return false;
	}

	/**
	 * <h1>esSecuenciaMutant
	 * <h1>método que se encarga de iterar sobre los caracteres para validar la
	 * secuencia de Dna.
	 * 
	 * @param cadenaDna cadena completa de Dna.
	 * @param i         representa la posición del caracter a comparar.
	 * @param size      representa el largo de cada tramo de la cadena de Dna.
	 * @return true si es una secuencia de 4 caracteres iguales, caso contrario
	 *         retorna false.
	 */
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

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

			newDna.setIsMutant(true);

			dnaRepository.save(newDna);

		} else {
			return dnaEntity.getIsMutant();
		}

		int cantidaDeCaracteresDeLaCadena = dna.getDna()[0].length();

		int cantidadDeCadenas = dna.getDna().length;

		String[] arrayOfDna = dna.getDna();

		ArrayList<ArrayList<Character>> graph = new ArrayList<>(cantidadDeCadenas);

		int cantSecuenciasEncontradas = 0;

		for (int i = 0; i < cantidadDeCadenas; i++) {

			String cadenaActual = dna.getDna()[i];

			char characterActual = cadenaActual.charAt(i);

			ArrayList<Character> cadenaCaracteres = new ArrayList<Character>();

			// Los ultimos 3 caracteres de cada fila no pueden conformar una secuencia
			// esperada.
			int lengthMaximo = cadenaActual.length();

			for (int j = i + 1; j < lengthMaximo; j++) {

				if (i < lengthMaximo - 3) {

					if (j < lengthMaximo) {

						// Busco en las tres direcciones

					} else {
						// Solo busco de forma vertical
						int cantHorizontalesEncontradas = this.getSoloVertical();
					}
				} else {
					// Solo busco de forma horizontal
					int cantHorizontalesEncontradas = this.getSoloHorizontal(cadenaActual.substring(i, i + 4));

					cantSecuenciasEncontradas += cantHorizontalesEncontradas;

				}

				char characterSiguiente = cadenaActual.charAt(j);

				String cadenaSiguiente = dna.getDna()[j];

				char characterVertical = cadenaSiguiente.charAt(i);
				char characterOblicuo = cadenaSiguiente.charAt(j);

			}

			graph.add(cadenaCaracteres);
			System.out.println(cadenaCaracteres);
		}

		System.out.println(graph);

		return false;
	}

	private int getSoloHorizontal(String cadena) {
		int n = cadena.length();
		for (int i = 0; i < n - 3; i++)
			if (cadena.charAt(i) != cadena.charAt(i + 1))

				return false;

		return true;
		return 0;
	}

	private int getSoloVertical() {
		// TODO Auto-generated method stub
		return 0;
	}

}

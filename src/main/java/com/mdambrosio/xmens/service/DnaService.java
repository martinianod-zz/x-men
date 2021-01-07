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

		for (int i = 0; i < cantidadDeCadenas; i++) {
			String cadena = dna.getDna()[i];

			ArrayList<Character> cadenaCaracteres = new ArrayList<Character>();
			for (int j = 0; j < cadena.length(); j++) {
				cadenaCaracteres.add(cadena.charAt(j));
			}

			graph.add(cadenaCaracteres);
			System.out.println(cadenaCaracteres);
		}

		System.out.println(graph);

		return false;
	}

}

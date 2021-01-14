/**
 * 
 */
package com.mdambrosio.xmens.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mdambrosio.xmens.dto.DnaListDTO;
import com.mdambrosio.xmens.exceptions.ForbiddenException;
import com.mdambrosio.xmens.repository.DnaRepository;

/**
 * @author mdambrosio
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DnaServiceTest {
	
	@Mock
    private DnaRepository dnaRepository;

    @InjectMocks
    private DnaService dnaService;
    
    @Test
    void isMutantTest() throws ForbiddenException{
    	
    	DnaListDTO dna = null;
		dnaService.isMutant(dna);
    	
    }

}

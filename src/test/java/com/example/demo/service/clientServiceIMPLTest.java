package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.clientModel;
import com.example.demo.repository.clientRepository;



@SpringBootTest
class clientServiceIMPLTest {

	@Mock
	private clientRepository clientRepositoryTest;

	@Autowired
	private clientServiceIMPL clientSerciveImplement;

	@BeforeAll
	public void setup() {
		MockitoAnnotations.initMocks(this);
		clientSerciveImplement = new clientServiceIMPL(clientRepositoryTest);
	}

	@Test
	void testClientServiceIMPL() {
		fail("Not yet implemented");
	}

	@Test
	void testCreated() {
		clientModel clienModelObjeto = clientModel.builder()
				.idClient(1L)
				.codigo(7)
				.nombre("Geuris")
				.sexo("Masculino")
				.telefono("8296266086")
				.cedula("010008854775")
				.numIdentificador("77")
				.ciudad("Santo Domingo")
				.provincia("Null")
				.barrio("30 de Mayo")
				.direccion1("barrio 30 de Mayo, Santo Domingo")
				.direccion2("residencial el millo, Santo Domingo")
				.estatus("Activo").build();
		when(clientRepositoryTest.save(clienModelObjeto)).thenReturn(clienModelObjeto);
		clientModel find = clientSerciveImplement.findById(1L);
		assertThat(find.getIdClient() == 1L);
	}

	@Test
	void testFindAll() {
		List<clientModel> actual = clientSerciveImplement.findAll();
		when(clientRepositoryTest.findAll()).thenReturn(actual);
		assertThat(actual).size().isGreaterThan(0);
	}

	@Test
	void testFindById() {
		Long idClient = 1L;
		clientModel findById = clientSerciveImplement.findById(idClient);
		assertThat(findById.getIdClient()).isEqualTo(idClient);
	}

	@Test
	void testDelete() {
		long idClient = 4L;
		boolean deleteClient = clientRepositoryTest.findById(idClient).isPresent();
		assertTrue(deleteClient);
	}

	@Test
	void testUpdate() {		
		clientModel clienModelObjeto = clientModel.builder()
				.idClient(1L)
				.codigo(7)
				.nombre("Geuris")
				.sexo("Masculino")
				.telefono("8296266086")
				.cedula("010008854775")
				.numIdentificador("77")
				.ciudad("Santo Domingo")
				.provincia("Null")
				.barrio("30 de Mayo")
				.direccion1("barrio 30 de Mayo, Santo Domingo")
				.direccion2("residencial el millo, Santo Domingo")
				.estatus("Activo").build();
		when(clientRepositoryTest.save(clienModelObjeto)).thenReturn(clienModelObjeto);
		assertThat(clienModelObjeto.getNombre()).isEqualTo("Geuris");
	}

}

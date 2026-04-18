package unitTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.yanes.global.dao.CountryDAO;
import ru.yanes.global.entity.Country;
import ru.yanes.services.CountryService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {

	@Mock
	private CountryDAO repository;

	@InjectMocks
	private CountryService service;

	@Test
	public void testSaveCountry() {
		Country country = new Country();
		country.builder()
				.code("999")
				.alpha3("KKK")
				.alpha2("KK")
				.full_name("United Kingdom of Great Britain and Northern Ireland")
				.flag("a7K3xP9mQ2wR5tY8uI4oL6pZ1xC0vB9nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9x")
				.build();

		when(repository.findById("999")).thenReturn(Optional.of(country));
		when(repository.save(country)).thenReturn(country);

		Country result = repository.save(country);
		assertEquals("999", result.getCode());
		verify(repository).findById("999");
	}
}

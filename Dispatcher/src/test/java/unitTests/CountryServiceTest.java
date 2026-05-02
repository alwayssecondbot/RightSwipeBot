package unitTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.yanes.EntityNotFoundException;
import ru.yanes.global.dao.CountryDAO;
import ru.yanes.global.entity.Country;
import ru.yanes.global.service.CountryService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {

	@Mock
	private CountryDAO repository;

	@InjectMocks
	private CountryService service;

	Country country = Country.builder()
			.code("999")
			.alpha3("KKK")
			.alpha2("KK")
			.full_name("United Kingdom of Great Britain and Northern Ireland")
			.flag("a7K3xP9mQ2wR5tY8uI4oL6pZ1xC0vB9nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9xC0vB1nM2jH3kL5qW8eR7tY1uI2oP3aS4dF6gH7jK8lZ9x")
			.build();

	@Test
	public void testSaveCountry() {
		when(repository.save(any(Country.class))).thenReturn(country);

		Country result = service.save(country);

		assertEquals("999", result.getCode());
		assertEquals("KKK", result.getAlpha3());

		verify(repository, times(1)).save(any(Country.class));
	}

	@Test
	public void testCountryNotFound() {
		when(repository.findById(any(String.class))).thenReturn(Optional.empty());
		assertThrows(EntityNotFoundException.class, () -> service.findById("999"));

		verify(repository, never()).save(any());
	}

	@Test
	public void testFindCountryById() {

		// 2. Mock repository behavior
		when(repository.findById("999")).thenReturn(Optional.of(country));

		// 3. Call service method
		Country result = service.findById("999");

		// 4. Verify results
		assertNotNull(result);
		assertEquals("999", result.getCode());

		// 5. Verify repository.findById was called
		verify(repository, times(1)).findById("999");
	}
}

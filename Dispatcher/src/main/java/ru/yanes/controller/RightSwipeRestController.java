package ru.yanes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yanes.global.entity.Country;
import ru.yanes.global.service.impl.CountryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class RightSwipeRestController {

	private final CountryServiceImpl countryService;

	public RightSwipeRestController(CountryServiceImpl countryService) {
		this.countryService = countryService;
	}

	@GetMapping("/all")
	public List<Country> getCountries() {
		return countryService.findAll();
	}

	@GetMapping("/specific")
	public Country findById(@RequestParam String id) {
		return countryService.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Country createCountry(@RequestBody Country country) {
		return countryService.save(country);
	}
}

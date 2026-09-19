package ru.yanes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yanes.global.entity.Country;
import ru.yanes.global.projections.CountryShortView;
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
	public List<CountryShortView> getCountries() {
		return countryService.findAllShortViewsBy();
	}

	@GetMapping("/specific")
	public CountryShortView findById(@RequestParam String id) {
		return countryService.findShortViewById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Country createCountry(@RequestBody Country country) {
		return countryService.save(country);
	}
}

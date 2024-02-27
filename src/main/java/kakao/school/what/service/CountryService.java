package kakao.school.what.service;

import kakao.school.what.domain.Country;
import kakao.school.what.dto.CountryDto;
import kakao.school.what.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public CountryDto getCountryById(Long countryId) {
        Optional<Country> countryOptional = countryRepository.findById(countryId);
        if (countryOptional.isPresent()) {
            Country country = countryOptional.get();
            CountryDto countryDto = new CountryDto();
            countryDto.setCountryId(country.getCountryId());
            countryDto.setName(country.getName());
            return countryDto;
        } else {
            // Handle the case where the country is not found
            return null;
        }
    }
}

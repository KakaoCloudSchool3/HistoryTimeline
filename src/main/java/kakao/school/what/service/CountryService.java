package kakao.school.what.service;

import kakao.school.what.domain.Country;
import kakao.school.what.dto.response.CountryResponseDto;
import kakao.school.what.repository.CountryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public CountryResponseDto getCountryById(Long countryId) {
        Optional<Country> countryOptional = countryRepository.findById(countryId);
        if (countryOptional.isPresent()) {
            Country country = countryOptional.get();
            CountryResponseDto countryResponseDto = new CountryResponseDto();
            countryResponseDto.setCountryId(country.getCountryId());
            countryResponseDto.setName(country.getName());

            log.info("^MS^ CountryService : "+countryResponseDto.toString());

            return countryResponseDto;
        } else {
            // Handle the case where the country is not found
            return null;
        }
    }
}

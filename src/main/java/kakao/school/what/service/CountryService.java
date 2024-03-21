package kakao.school.what.service;

import kakao.school.what.domain.Country;
import kakao.school.what.dto.response.CountryResponseDto;
import kakao.school.what.repository.CountryRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import kakao.school.what.dto.response.CountryResponseDto;
import kakao.school.what.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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

            log.info("^MS^ CountryService : " + countryResponseDto);

            return countryResponseDto;
        } else {
            // Handle the case where the country is not found
            return null;
        }
    }

    // country list에 쓸 country dto 를 반환
    public List<CountryResponseDto> listCountryDto(){
        return CountryEntityToDto(countryRepository.findAllByOrderByName());
    }

    // Country에서 CountryResponseDto로 바꾸는 메소드
    private List<CountryResponseDto> CountryEntityToDto(List<Country> countries) {
        List<CountryResponseDto> dtoList = new ArrayList<>();
        for (Country country : countries) {
            dtoList.add(new CountryResponseDto(country.getCountryId(), country.getName()));
        }
        return dtoList;

    }
}

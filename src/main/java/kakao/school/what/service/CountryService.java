package kakao.school.what.service;

import kakao.school.what.domain.Country;
import kakao.school.what.dto.CountryResponseDto;
import kakao.school.what.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

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

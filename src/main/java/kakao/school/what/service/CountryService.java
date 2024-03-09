package kakao.school.what.service;

import kakao.school.what.domain.Country;
import kakao.school.what.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> listCountry(){
        return countryRepository.findAllByOrderByName();
    }
}

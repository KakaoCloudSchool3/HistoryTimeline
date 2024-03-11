package kakao.school.what.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import kakao.school.what.domain.Country;
import kakao.school.what.dto.CountryResponseDto;
import kakao.school.what.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "CountryController", description = "Country 관련 Controller")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    @ResponseBody
    public List<CountryResponseDto> getCountryList() {
        return countryService.listCountryDto();
    }
}

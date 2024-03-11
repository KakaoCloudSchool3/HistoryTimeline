package kakao.school.what.web;


import kakao.school.what.dto.response.CountryResponseDto;
import kakao.school.what.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import kakao.school.what.domain.Country;
import kakao.school.what.dto.CountryResponseDto;
import kakao.school.what.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author minsun
 * @description countryId에 해당하는 나라 정보(countryId, name) 출력
 * @path /api/countries/{countryId}
 *
 * 추후 front에서 비교하여 사용하면 될 것 같음... 맞겠지..?
 */
@RestController
@RequestMapping("/countries")
@Tag(name = "CountryController", description = "Country 관련 Controller")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/{countryId}")
    public ResponseEntity<CountryResponseDto> getCountryById(@PathVariable Long countryId) {
        CountryResponseDto countryResponseDto = countryService.getCountryById(countryId);

        if (countryResponseDto != null) {
            return new ResponseEntity<>(countryResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
  
    @GetMapping("/countries")
    @ResponseBody
    public List<CountryResponseDto> getCountryList() {
        return countryService.listCountryDto();
    }
}

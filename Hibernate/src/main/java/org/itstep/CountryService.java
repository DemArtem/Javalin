package org.itstep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> findAll(){
        return countryRepository.findAll();
    }

    public Country findById(Long id){
        return countryRepository.findById(id).orElse(null);
    }

    public List<Country> findAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return countryRepository.findAll(pageable).getContent();
    }

    public void saveAll(List<Country> countries) {
        countryRepository.saveAll(countries);
    }
}

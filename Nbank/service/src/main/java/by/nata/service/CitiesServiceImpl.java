package by.nata.service;

import by.nata.data.dao.CitiesDao;
import by.nata.data.model.CitiesDto;
import by.nata.service.model.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service
//@Transactional
public class CitiesServiceImpl implements CitiesService{
private final CitiesDao citiesDao;
//@Autowired
    public CitiesServiceImpl(CitiesDao citiesDao) {
        this.citiesDao = citiesDao;
    }

//    @Override
//    public void saveCities(Cities cities) {
//        CitiesDto citiesDto = new CitiesDto(
//                cities.getId(),
//                cities.getName()
//        );
//        citiesDao.save(citiesDto);
//    }
}

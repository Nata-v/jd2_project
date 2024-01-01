package by.nata.service;

import by.nata.data.dao.IssuingAuthorityDaoImpl;
import by.nata.data.model.IssuingAuthorityDto;
import by.nata.service.model.IssuingAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class IssuingAuthorityServiceImpl implements IssuingAuthorityService{
    private final IssuingAuthorityDaoImpl issuingAuthorityDao;
   // @Autowired
    public IssuingAuthorityServiceImpl(IssuingAuthorityDaoImpl issuingAuthorityDao) {
        this.issuingAuthorityDao = issuingAuthorityDao;
    }

//    @Override
//    public void saveIssuingAuthority(IssuingAuthority issuingAuthority) {
//        IssuingAuthorityDto issuingAuthorityDto = new IssuingAuthorityDto(
//                issuingAuthority.getId(),
//                issuingAuthority.getName()
//        );
//        issuingAuthorityDao.save(issuingAuthorityDto);
//    }


}

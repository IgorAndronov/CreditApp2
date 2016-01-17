package com.mycompany.credit.dao.interfaces;

import com.mycompany.credit.dao.entity.DicStreetType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by igor on 25.07.15.
 */
public interface DictionaryAddressService {

    public void persistStreetType(DicStreetType dicStreetType);
    public List<DicStreetType> getListStreetType(String criteria);
}

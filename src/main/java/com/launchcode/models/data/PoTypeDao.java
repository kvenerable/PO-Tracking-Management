package com.launchcode.models.data;

import com.launchcode.models.PoType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PoTypeDao extends CrudRepository<PoType,Integer> {


}

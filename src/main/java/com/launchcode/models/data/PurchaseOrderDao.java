package com.launchcode.models.data;

import com.launchcode.models.PurchaseOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PurchaseOrderDao extends CrudRepository<PurchaseOrder,Integer> {
}

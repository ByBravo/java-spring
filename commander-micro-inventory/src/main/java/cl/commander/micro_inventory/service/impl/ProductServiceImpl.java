package cl.commander.micro_inventory.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.commander.micro_inventory.error.MessageException;
import cl.commander.micro_inventory.model.Product;
import cl.commander.micro_inventory.repository.IProductRepository;
import cl.commander.micro_inventory.service.IProductService;
import cl.commander.micro_inventory.viewmodel.ProductRequest;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    IProductRepository repository;

    @Override
    public void saveProduct(String idClient,ProductRequest in) {
        
        Product p = new Product();
        p.setUserId(idClient);
        p.setBarcode(in.getBarcode());
        p.setCategoryId(in.getCategoryId());
        p.setName(in.getName());
        p.setDescription(in.getDescription());
        p.setQuantity(in.getQuantity());
        p.setSalePrice(in.getSalePrice());
        p.setPurchasePrice(in.getPurchasePrice());
        p.setSupplierId(in.getSupplierId());
        Date d= new Date();
        Timestamp stamp = new Timestamp(d.getTime());
        p.setDateAdded(stamp);
        // p.setLastUpdate(lastUpdate date);
   
        repository.saveAndFlush(p);
        
    }

    @Override
    public void deleteProduct(String idClient, String idProduct) {


        long beforeDeleteSize = repository.count();

        logger.info("beforeDeleteSize :" +beforeDeleteSize);

        repository.deleteByIdProductAndUser(Integer.valueOf(idProduct), idClient); 

        long afterDeleteSize = repository.count();
        logger.info("afterDeleteSize :" +afterDeleteSize);

    }
    
}

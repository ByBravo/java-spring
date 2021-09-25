package cl.commander.micro_inventory.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.commander.micro_inventory.model.Product;
import cl.commander.micro_inventory.repository.IProductRepository;
import cl.commander.micro_inventory.service.IProductService;
import cl.commander.micro_inventory.viewmodel.ProductRequest;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductRepository repository;

    @Override
    public void saveProduct(String idClient,ProductRequest in) {
        
        Product p = new Product();
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
    
}

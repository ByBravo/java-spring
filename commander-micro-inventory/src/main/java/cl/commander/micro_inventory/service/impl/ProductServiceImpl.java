package cl.commander.micro_inventory.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<cl.commander.micro_inventory.viewmodel.Product> getAllProducts(String idClient) {

        List<cl.commander.micro_inventory.viewmodel.Product> responseList = new ArrayList<cl.commander.micro_inventory.viewmodel.Product>();
        
        List<Product> result = repository.findAllByUserId(idClient);

        if(null != result && !result.isEmpty()){
            logger.info("[USER:"+idClient+"] have " +result.size()+" product(s) stored");
            for (Product product : result) {
                logger.info("[USER:"+idClient+"] product : " +product.getId());
                cl.commander.micro_inventory.viewmodel.Product p= new cl.commander.micro_inventory.viewmodel.Product();
                p.setBarcode(product.getBarcode());
                p.setCategoryId(product.getCategoryId());
                p.setDateAdded(product.getDateAdded().toString());
                p.setDescription(product.getDescription());
                p.setId(product.getId().toString());
    
                if(null != product.getLastUpdate()){
                    p.setLastUpdate(product.getLastUpdate().toString());
                }else{
                    p.setLastUpdate("");
                }
            
                p.setName(product.getName());
                p.setPurchasePrice(product.getPurchasePrice());
                p.setQuantity(product.getQuantity());
                p.setSalePrice(product.getSalePrice());
                p.setSupplierId(product.getSupplierId());
    
                responseList.add(p);
            }
        }else{
            logger.info("[USER:"+idClient+"] does not have product(s) stored");
        }

        return responseList;
        
    }
    
}

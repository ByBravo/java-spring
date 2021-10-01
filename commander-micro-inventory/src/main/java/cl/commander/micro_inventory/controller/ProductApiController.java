package cl.commander.micro_inventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import cl.commander.micro_inventory.service.IProductService;
import cl.commander.micro_inventory.viewmodel.GenericResponse;
import cl.commander.micro_inventory.viewmodel.ProductRequest;
import cl.commander.micro_inventory.viewmodel.ProductResponse;
import cl.commander.micro_inventory.viewmodel.ProductsResponse;


import javax.validation.Valid;

@Controller
@RequestMapping("${openapi.commanderMicroInventory.base-path:}")
public class ProductApiController implements ProductApi {


	private static final Logger logger = LoggerFactory.getLogger(ProductApiController.class);


    @Autowired
    private IProductService productService;

    @Override
    public ResponseEntity<GenericResponse> deleteProduct(String idProduct, String idUser) {


        GenericResponse response = new GenericResponse();
        String prefix="[deleteProduct][user:"+idUser+"][idProduct:"+idProduct+"]";
        logger.info(prefix +" starting ");
        logger.info(prefix +" deleting product");
        productService.deleteProduct(idUser,idProduct);

        response.setCode("SUCCESS");
        response.setMessage("the product was remove from the stored correctly");
        logger.info(prefix +"  end");

        return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductResponse> getProduct(String idProduct, String idUser) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<ProductsResponse> getProductByCategory(String idCategory, String idUser) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<ProductsResponse> getProductByCategoryAndSupplier(String idCategory, String idSupplier,
            String idUser) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<ProductsResponse> getProductBySupplier(String idSupplier, String idUser) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<ProductsResponse> getProducts(String idUser) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<GenericResponse> postProduct(String idUser, @Valid ProductRequest productRequest) {
       
        GenericResponse response = new GenericResponse();
        String prefix="[postProduct][user:"+idUser+"]";
        logger.info(prefix +" starting ");
        logger.info(prefix +" saving product :"+productRequest.getName());
        productService.saveProduct(idUser,productRequest);

        response.setCode("SUCCESS");
        response.setMessage("the product was stored correctly");
        logger.info(prefix +"  end");

        return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> putProduct(String idUser, String idProduct,
            @Valid ProductRequest productRequest) {
        // TODO Auto-generated method stub
        return null;
    }

 

}

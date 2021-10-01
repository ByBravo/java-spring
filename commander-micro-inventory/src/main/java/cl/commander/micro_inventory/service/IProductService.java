package cl.commander.micro_inventory.service;

import cl.commander.micro_inventory.viewmodel.ProductRequest;

public interface IProductService {

     
    /**
	 * Save a customer's product
	 * 
	 * @param idClient id user or client or customer
     * @param in ProductRequest data to save
	 * @return 
	 */
    public void saveProduct(String idClient,ProductRequest in);


	 /**
	 * Delete a customer's product
	 * 
	 * @param idClient id user or client or customer
     * @param idProduct product identifier
	 * @return 
	 */
    public void deleteProduct(String idClient, String idProduct);

}

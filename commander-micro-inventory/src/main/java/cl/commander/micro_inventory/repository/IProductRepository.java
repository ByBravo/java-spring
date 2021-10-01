package cl.commander.micro_inventory.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cl.commander.micro_inventory.model.Product;

public interface IProductRepository extends JpaRepository<Product,Long>{
    



    @Qualifier
    @Modifying
	@Query(value = "DELETE FROM inventory.product\n"
    +"WHERE ID =:ID AND user_id =:USERID", nativeQuery = true)
	public void deleteByIdProductAndUser(@Param("ID") Integer idProduct,@Param("USERID")String userId);
	
}

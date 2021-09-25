package cl.commander.micro_inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.commander.micro_inventory.model.Product;

public interface IProductRepository extends JpaRepository<Product,Long>{
    
}

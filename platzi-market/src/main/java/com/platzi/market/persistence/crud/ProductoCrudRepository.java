package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ? ", nativeQuery = true)
    //El siguiente método es una lista de productos ordenados por el nombre de la categoría del producto
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //LessThan == "menor que"
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}

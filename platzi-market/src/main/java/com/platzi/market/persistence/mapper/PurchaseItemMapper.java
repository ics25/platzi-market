package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseItem;
import com.platzi.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//@Mapper se usa con el objetivo de poder inyectarlo en otros lugares
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            //cuando el mapeo de los atributos es igual, no es necesario incluirlo dentro del mapping,
            //como por ejemplo para el caso de @Mapping(source = "total", target = "total"),
            @Mapping(source = "estado", target = "active")
    })

    PurchaseItem toPurchaseItem(ComprasProducto producto);

    //Se realiza el mapeo contrario
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseItem item);
}

package pl.edu.vistula.firstrestapi.product.support.exeption;

import pl.edu.vistula.firstrestapi.product.support.exeption.ProductNotFoundExeption;
import java.util.function.Supplier;

public class ProductExeptionSupplier {
    public static Supplier<ProductNotFoundExeption> productNotFound(Long id){
        return() -> new ProductNotFoundExeption(id);
    }
}

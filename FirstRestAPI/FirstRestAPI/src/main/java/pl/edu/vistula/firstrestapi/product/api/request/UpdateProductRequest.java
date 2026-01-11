package pl.edu.vistula.firstrestapi.product.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.hibernate.sql.Update;

public class UpdateProductRequest extends ProductRequest{
    private final Long id;

    @JsonCreator
    public UpdateProductRequest(String name, Long id){
        super(name);
        this.id = id;
    }

    public Long getId(){
        return id;
    }
}

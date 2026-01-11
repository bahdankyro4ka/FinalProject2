package pl.edu.vistula.firstrestapi.product.support.exeption;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.edu.vistula.firstrestapi.shared.api.response.ErrorMessageResponse;

import static org.slf4j.LoggerFactory.getLogger;

@ControllerAdvice
public class ProductExeptionAdvisor {

    private static final Logger LOG = getLogger(ProductExeptionAdvisor.class);

    @ExceptionHandler(ProductNotFoundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse productNotFound(Exception e){
        LOG.error(e.getMessage(), e);
        return new ErrorMessageResponse(e.getLocalizedMessage());
    }
}

package roomreservation

import grails.rest.RestfulController
import org.springframework.http.HttpStatus

class NonDeleteRestfulController<T> extends RestfulController<T>{

    NonDeleteRestfulController(Class<T> resource) {
        super(resource)
    }

    NonDeleteRestfulController(Class<T> resource, boolean readOnly) {
        super(resource, readOnly)
    }

    @Override
    Object delete() {
        // Return method not allowed HTTP status code
        render status: HttpStatus.METHOD_NOT_ALLOWED
    }
}

package roomreservation

import grails.rest.Resource

@Resource(uri = "/people")
class Person {

    String firstName
    String lastName
    String email

    String toString() {
        return firstName + " " + lastName
    }

    static constraints = {
        firstName(blank: false, nullable: false)
        lastName(blank: false, nullable: false)
        email nullable: false, email: true
    }
}

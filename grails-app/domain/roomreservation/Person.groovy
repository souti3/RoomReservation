package roomreservation

class Person {

    String firstName
    String lastName
    String email

    static constraints = {
        firstName(blank: false)
        lastName(blank: false)
        email(unique: true, email: true)
    }
}

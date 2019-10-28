package roomreservation

class Person {

    String firstName
    String lastName
    String email

    @Override
    String toString() {
        return firstName + " " + lastName
    }
    static constraints = {
        firstName(blank: false)
        lastName(blank: false)
        email(unique: true, email: true)
    }
}

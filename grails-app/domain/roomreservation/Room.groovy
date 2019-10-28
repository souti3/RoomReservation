package roomreservation

class Room {

    String name
    int max

    static constraints = {
        name(blank: false)
        max(min: 1)
    }
}

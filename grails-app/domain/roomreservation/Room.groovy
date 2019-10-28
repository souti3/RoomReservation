package roomreservation

class Room {

    String name
    int max

    @Override
    String toString() {
        return "$name ($max)"
        //return name + " (" + max + ")"
    }
    static constraints = {
        name(blank: false)
        max(min: 1)
    }
}

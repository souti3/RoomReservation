package roomreservation

class BookingController {

    static scaffold = Booking

    def all() {
        def bookings = Booking.findAll()
        respond bookings
    }

    def forDierk(){
        //Returns all bookings made by 'dirk.koenig@fhnw.ch'
        def booker = Person.findByEmail('dierk.koenig@fhnw.ch')
        def bookings = Booking.findAllByBooker(booker)
        respond bookings
    }

}

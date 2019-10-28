package roomreservation

class Booking {
    Person booker
    Room room
    Date date
    String slot

    final static String AM = "08:00 - 11:00"
    final static String PM1 = "12:00 - 15:00"
    final static String PM2 = "15:00 - 18:00"

    static constraints = {
        slot inList: [AM, PM1, PM2]
    }
}

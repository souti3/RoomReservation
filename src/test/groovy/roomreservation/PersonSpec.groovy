package roomreservation

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PersonSpec extends Specification implements DomainUnitTest<Person> {

    void "First name can NEITHER be null NOR blank"() {
        expect:
        domain != null
        when:
        domain.firstName = null
        then:
        !domain.validate(['firstName'])
        domain.errors['firstName'].code == 'nullable'

        expect:
        domain != null
        when:
        domain.firstName = '  '
        then:
        !domain.validate(['firstName'])
        domain.errors['firstName'].code == 'blank'
    }

    void "Email has to be an email"() {
        expect:
        domain != null
        when:
        domain.email = 'This is NOT an email'
        then:
        !domain.validate(['email'])
        domain.errors['email'].code == 'email.invalid'

        expect:
        domain != null
        when:
        domain.email = 'christian.ribeaud@fhnw.ch'
        then:
        domain.validate(['email'])
    }
    
}

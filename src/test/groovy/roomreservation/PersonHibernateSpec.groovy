package roomreservation;

import grails.test.hibernate.HibernateSpec;

class PersonHibernateSpec extends HibernateSpec {

    void "Insert a new person and delete it"() {
        // Insert
        setup: 'You instantiate a person with name and an email address which has been never used before'
        def person = new Person(firstName: 'Christian', lastName: 'Ribeaud', email: 'christian.ribeaud@fhnw.ch')
        // Assert we do NOT have any person yet
        assert Person.count() == 0

        when: 'person is valid instance'
        person.validate()
        then: 'we can save it, and we get back a not null GORM Entity'
        person.save()
        and: 'there is one additional Person'
        // 'old()': BEFORE the 'when' is executed
        Person.count() == old(Person.count()) + 1
        and: 'An UID has been automatically generated'
        person.id == 1

        // Delete
        when: 'You try to find the person by ID'
        // def found = Person.findById(1)
        def found = Person.get(1)
        then:
        person.id == 1
        person.firstName == 'Christian'
        and:
        found.delete(flush: true)
        and:
        Person.count() == 0
    }
}
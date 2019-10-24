package roomreservation;

import geb.spock.GebSpec
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse;
import grails.testing.mixin.integration.Integration
import spock.lang.Shared;

@Integration
class PeopleRestSpec extends GebSpec {

    @Shared RestBuilder rest = new RestBuilder()

    void "Test fetching people created in 'BootStrap.groovy' as JSON"() {
        when:"Accessing '/people.json'"
        RestResponse resp = rest.get("http://localhost:${serverPort}/people.json")

        then:
        resp.status == 200
        resp.json.size() == 2
        resp.json.find { it.firstName == 'Dierk' && it.lastName == 'König' }
        resp.json.find { it.firstName == 'Christian' &&  it.lastName == 'Ribeaud' }
    }
}
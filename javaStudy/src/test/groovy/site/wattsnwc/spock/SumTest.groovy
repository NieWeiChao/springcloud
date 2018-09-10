package site.wattsnwc.spock

import spock.lang.Specification
import spock.lang.Unroll

/**
 * 这里需要写注释  
 */
@Unroll
class SumTest extends Specification {

    def sum = new Sum()

    def "test sum #first + #second"(){
        when:
            def result = sum.sum(a,b)
        then:
            result == c
        where:
        a | b || c
        1 | 1 || 2
        2 | 3 || 5
        3 | 3 || 5
    }

    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [3, 5, 9]
        b << [7, 4, 9]
        c << [7, 5, 9]
    }

    def "minimum of #a and #b is #c"() {
        expect:
        Math.min(a, b) == c

        where:
        a | b || c
        3 | 7 || 3
        5 | 4 || 4
        9 | 9 || 9
    }

    def "#person.name is a #sex.toLowerCase() person"() {
        expect:
        person.getSex() == sex

        where:
        person                    || sex
        new Person(name: "Fred")  || "Male"
        new Person(name: "Wilma") || "Female"
    }

    static class Person {
        String name
        String getSex() {
            name == "Fred" ? "Male" : "Female"
        }
    }
}

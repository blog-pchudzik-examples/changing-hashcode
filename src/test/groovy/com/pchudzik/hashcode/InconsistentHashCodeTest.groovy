package com.pchudzik.hashcode

import spock.lang.Specification

/**
 * Created by pawel on 19.10.16.
 */
class InconsistentHashCodeTest extends Specification {
	def "hashCode value should be consistent during execution of application set.contains example"() {
		given:
		final hashCode = new InconsistentHashCode(name: "John", age: 21)

		and:
		final set = new HashSet([hashCode])

		when:
		hashCode.age = 42

		then:
		set.contains(hashCode)
	}

	def "hashCode value should be consistent during execution of application set.add example"() {
		given:
		final hashCode = new InconsistentHashCode(name: "John", age: 21)

		and:
		final set = new HashSet([hashCode])

		when:
		hashCode.age = 42

		then:
		set.add(hashCode) == false
	}

	def "hashCode value should be consistent during execution of application set.size example"() {
		given:
		final hashCode = new InconsistentHashCode(name: "John", age: 21)

		and:
		final set = new HashSet([hashCode])

		when:
		hashCode.age = 42

		and:
		set.add(hashCode)

		then:
		set.size() == 1
	}

}

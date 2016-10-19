package com.pchudzik.hashcode;

import java.util.Objects;

class InconsistentHashCode {
	public String name;
	public int age;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		InconsistentHashCode that = (InconsistentHashCode) o;
		return Objects.equals(name, that.name) && Objects.equals(age, that.age);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
}

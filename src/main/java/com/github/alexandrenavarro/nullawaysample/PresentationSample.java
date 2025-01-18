package com.github.alexandrenavarro.nullawaysample;

import io.vavr.control.Try;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public final class PresentationSample {

    public static void main(String[] args) {

        // On nullable object
        final Person person = Person.builder()
                .firstName("firstName")
                .lastName("lastName")
                .driverLicense(DriverLicense.builder()
                        .id("aDriverLicenseId")
                        .build())
                .build();

        final List<Person> personList = List.of(person);

        // On nullable list
        String driverLicenseId = Optional.ofNullable(person)
                .map(Person::getDriverLicense)
                .map(DriverLicense::getId)
                .orElse(null);

        List<String> driverLicenseIdList = Optional.ofNullable(personList)
                .orElse(Collections.emptyList())
                .stream()
                .map(aPerson -> Optional.ofNullable(aPerson)
                        .map(Person::getDriverLicense)
                        .map(DriverLicense::getId)
                        .orElse(null))
                .toList();

        // Container empty on neutral Object when it is possible
        List<Object> emptyList = Collections.emptyList();
        Map<Object, Object> emptyMap = Collections.emptyMap();
        Optional<Object> emptyOptional = Optional.empty();
        Integer validIntegerOrZero = Try.of(() -> Integer.parseInt("12"))
                .getOrElse(0);

        // Force to init correctly

        // Return null if you can not create a valid Price
        Price nullablePrice = Price.ofNullable(null, null);

        // Use static of method if less than 2 arguments
        Price oneEuro = Price.of(BigDecimal.ONE, "EUR");

        // Or use a StagedBuilder to always return a valid Person
        Person johnDoe = Person.builder()
                .firstName("John")
                .lastName("Doe")
                .build();

    }


}

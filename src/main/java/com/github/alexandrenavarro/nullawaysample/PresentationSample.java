package com.github.alexandrenavarro.nullawaysample;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public final class PresentationSample {

    public static void main(String[] args) {

        // Yoda condition
        final List<String> jedis = List.of("Yoda", "Luke", null);
        final String aJedi = jedis.get(new Random().nextInt(jedis.size() - 1));
        if (aJedi.equals("Yoda")) { // Bad practise
            System.out.println("You must set first your notNull variable in your condition");
        }
        if ("Yoda".equals(aJedi)) { // Good practise
            System.out.println("Good, young padawan");
        }

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

        // Container empty not null
//        Collections.emptyList();
//        Collections.emptyMap();
//        Optional.empty();

    }
}

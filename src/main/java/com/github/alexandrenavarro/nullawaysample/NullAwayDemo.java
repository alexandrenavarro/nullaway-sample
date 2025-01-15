package com.github.alexandrenavarro.nullawaysample;


import org.jspecify.annotations.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.Optional;
import java.util.Random;

public final class NullAwayDemo {

    public static void main(String... args) {
        // Check if there is a compilation error because you can not pass null on not null parameter on a constructor or a method OK
//        final Person person1 = new Person(null, "lastname", null, null);
//        System.out.println(person1);

        // Check if you can pass null on mandatory field on the builder or any method OK
//        final Person person2 = Person.builder()
//                .firstName(null)
//                .lastName("lastName")
//                .build();
//        System.out.println(person2);

        // Check if you can pass null on optional field and call method on a nullable field OK
//        final Person person3 = Person.builder()
//                .firstName("firstname")
//                .lastName("lastname")
//                .middleName(null)
//                .build();
//        System.out.println(person3.getMiddleName().toString());

        // Check if there is a compilation error because calling with null a method accepting only NonNull KO
//        final String s = Collections.max(null);
//        System.out.println(s);

        // Check if there is a compilation error because calling with null a method accepting only NonNull methods added in LibraryModelsHandler OK
//        final Optional<Object> optional = Optional.of(null);
//        System.out.println(optional);

        // Check if there is a compilation error because you call a method on a potential null Spring Object OK
//        final String textQuoted = StringUtils.quote(null);
//        System.out.println(textQuoted.toString());

        // Check if there is a compilation error a potential local nullable variable can be pass on an NunNullable field OK
//        final boolean b = new Random().nextBoolean();
//        final String a = (b) ? null : "";
//        final String b1 = "";
//        final Person person5 = Person.builder()
//                .firstName(a)
//                .lastName(b1)
//                .build();
//        System.out.println(person5.toString());

    }


}

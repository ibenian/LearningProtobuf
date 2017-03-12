package step3;

import step3.AddressBookProtos.Person;

/**
 * Created by ibenian on 3/11/17.
 *
 * Use toBuilder() to make a copy and compare instances.
 *
 */
public class TestApp {

    public static void main(String[] args) {
        Person john =
            Person.newBuilder()
                .setId(1234)
                .setName("John Doe")
                .setEmail("jdoe@example.com")
                .build();
        System.out.println(john);
        System.out.printf("Serialized size: %d\n", john.getSerializedSize());

        // Use another builder to modify the same message
        Person.Builder builder2 = john.toBuilder();

        Person jane0 = builder2.build();        // Build jane before making any changes

        Person jane = builder2.setName("Jane Doe")
                .build();                       // Build jane after making a change

        System.out.println("Updated using builder2 to build jane");
        System.out.println(jane);

        System.out.println("Reprinting john");
        System.out.println(john);               // Has john been modified?
        System.out.println(john.getName().equals(jane.getName()));

        System.out.printf("Is john same as jane0? %b\n", john == jane0);     // Are they the same object?
        System.out.printf("Is john same as jane? %b\n", john == jane);       // Are they the same object?
        System.out.printf("Is jane same as jane0? %b\n", jane == jane0);     // Are they the same object?

    }
}

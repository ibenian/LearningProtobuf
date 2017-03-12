package step2;

import step2.AddressBookProtos.Person;

/**
 * Created by ibenian on 3/11/17.
 *
 * Build a person message using Person.Builder
 *
 */
public class TestApp {

    public static void main(String[] args) {
        Person john =
            Person.newBuilder()                     // Builder required to make changes
                .setId(1234)
                .setName("John Doe")
                .setEmail("jdoe@example.com")
                .build();                           // Build the message object that is immutable.
        System.out.println(john);
        System.out.printf("Serialized size: %d", john.getSerializedSize());
    }
}

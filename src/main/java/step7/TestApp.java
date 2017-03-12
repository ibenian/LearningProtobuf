package step7;

import com.google.protobuf.InvalidProtocolBufferException;
import step7.AddressBookProtos.Person;

/**
 * Created by ibenian on 3/11/17.
 *
 * Add an PhoneNumber sub-message and check the behavior.
 *
 */
public class TestApp {

    public static void main(String[] args)
            throws InvalidProtocolBufferException {
        Person john =
                Person.newBuilder()
                        .setId(1234)
                        .setName("John Doe")
                        .setEmail("jdoe@example.com")
                        .addPhoneNumber(
                            Person.PhoneNumber.newBuilder() // Must create for sub-message
                                .setNumber("123 345 5678")
                                .setType("Cell"))
                        .addPhoneNumber(
                            Person.PhoneNumber.newBuilder() // Must create for sub-message
                                .setNumber("123 345 5679")
                                .setType("Cell2"))
                        .build();

        System.out.println(john);
        System.out.printf("Serialized size: %d\n", john.getSerializedSize());

        // Write to byte array
        byte[] buffer = john.toByteArray();
        System.out.printf("Size of the written byte array: %d\n", buffer.length);

        // Read from byte array
        Person john2 = Person.parseFrom(buffer);

        System.out.println("Printing John2 (unmarshaled from byte array)");
        System.out.println(john2);

        // Test equals() behavior
        System.out.printf("Is john2's contents same as john? %b\n", john2.equals(john));
    }
}

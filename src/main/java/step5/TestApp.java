package step5;

import com.google.protobuf.InvalidProtocolBufferException;
import step5.AddressBookProtos.Person;

import java.io.ByteArrayInputStream;

/**
 * Created by ibenian on 3/11/17.
 *
 * Write to byte array (toByteArray()) and read from byte array (parseFrom())
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

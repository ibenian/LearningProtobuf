package step10;

import com.google.protobuf.InvalidProtocolBufferException;
import step10.AddressBookProtos.Person;

/**
 * Created by ibenian on 3/11/17.
 *
 * Adding a field that reuse previously used index and change the type
 *
 */
public class TestApp {

    public static void main(String[] args)
            throws InvalidProtocolBufferException {
        Person john =
                Person.newBuilder()
                        .setId(1234)
                        .setName("John Doe")
                        .setEmail("100")
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

        // Read message serialized by older version
        step10v2.AddressBookProtos.Person john2 = step10v2.AddressBookProtos.Person.parseFrom(buffer);

        System.out.println("Printing John2 (unmarshaled from byte array serialized from by version)");
        System.out.println(john2);

        System.out.printf("Fields for john %s\n", john.getDescriptorForType().getFields());
        System.out.printf("Fields for john2 %s\n\n", john2.getDescriptorForType().getFields());

        System.out.printf("John's email: %s\n", john.getEmail());
        System.out.printf("John2's age: %s\n", john2.getAge());     // age field read from email without warning
    }
}

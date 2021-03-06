package step8;

import com.google.protobuf.InvalidProtocolBufferException;
import step8.AddressBookProtos.Person;

/**
 * Created by ibenian on 3/11/17.
 *
 * Write a message, and read it from a new version (Backward compatibility)
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

        // Read message serialized by older version
        step8v2.AddressBookProtos.Person john2 = step8v2.AddressBookProtos.Person.parseFrom(buffer);

        System.out.println("Printing John2 (unmarshaled from byte array serialized from by version)");
        System.out.println(john2);

        // Test equals() behavior.  Newer version contains a new field, so the contents aren't equal.
        System.out.printf("Is john2's contents same as john? %b\n", john2.equals(john));
        System.out.printf("Type descriptor for john %s\n", john.getDescriptorForType().getFullName());
        System.out.printf("Type descriptor for john2 %s\n\n", john2.getDescriptorForType().getFullName());
        System.out.printf("Fields for john %s\n", john.getDescriptorForType().getFields());
        System.out.printf("Fields for john2 %s\n\n", john2.getDescriptorForType().getFields());
        System.out.printf("Proto for john:\n%s\n\n", john.getDescriptorForType().toProto());
        System.out.printf("Proto for john2:\n%s\n\n", john2.getDescriptorForType().toProto());

    }
}

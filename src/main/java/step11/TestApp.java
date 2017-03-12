package step11;

import com.google.protobuf.InvalidProtocolBufferException;
import step11.AddressBookProtos.Person;

/**
 * Created by ibenian on 3/11/17.
 *
 * Remove an existing field from schema (Backward compatibility is maintained)
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
        step11v2.AddressBookProtos.Person john2 = step11v2.AddressBookProtos.Person.parseFrom(buffer);

        System.out.println("Printing John2 (unmarshaled from byte array serialized from by version)");
        System.out.println(john2);
        System.out.println("Unreadable field 3 is also dumped above\n");

        System.out.printf("Fields for john %s\n", john.getDescriptorForType().getFields());
        System.out.printf("Fields for john2 %s\n\n", john2.getDescriptorForType().getFields());

    }
}

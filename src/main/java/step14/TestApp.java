package step14;

import com.google.protobuf.InvalidProtocolBufferException;
import step14.AddressBookProtos.SearchRequest;

import java.util.Arrays;

/**
 * Created by ibenian on 3/11/17.
 *
 * Repeated and packed repeated scalar types
 *
 */
public class TestApp {

    public static void main(String[] args)
            throws InvalidProtocolBufferException {
        SearchRequest request =
                SearchRequest.newBuilder()
                        .setQuery("query string ...")
                        .build();

        System.out.println(request);
        System.out.printf("Serialized size: %d\n", request.getSerializedSize());
        // Write to byte array
        byte[] buffer = request.toByteArray();
        System.out.printf("Size of the written byte array: %d\n", buffer.length);

        System.out.println("\n\nNew version using a reserved range");
        // Use new version with [packed=true]
        step14v2.AddressBookProtos.SearchRequest request2 =
                step14v2.AddressBookProtos.SearchRequest.newBuilder()
                        .setQuery("query string 2 ...")
                        .addAllSamples(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                        .build();

        System.out.println(request2);
        System.out.printf("Serialized size of v2: %d\n", request2.getSerializedSize());
        // Write to byte array
        byte[] buffer2 = request2.toByteArray();
        System.out.printf("Size of the written byte array for v2: %d\n", buffer2.length);

        System.out.println("\n\nRead v2 serialized version from v1");
        SearchRequest request1 = SearchRequest.parseFrom(buffer2);
        System.out.println(request1);
        System.out.println("v1 read from v2 also dumps out the unreadable but reserved field 4");
        System.out.printf("Serialized size of v1 read from v2: %d\n", request1.getSerializedSize());

    }
}

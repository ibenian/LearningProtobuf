package step13;

import com.google.protobuf.InvalidProtocolBufferException;
import step13.AddressBookProtos.SearchRequest;

import javax.naming.directory.SearchResult;
import java.util.ArrayList;
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
                        .addAllSamples(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                        .build();

        System.out.println(request);
        System.out.printf("Serialized size: %d\n", request.getSerializedSize());
        // Write to byte array
        byte[] buffer = request.toByteArray();
        System.out.printf("Size of the written byte array: %d\n", buffer.length);

        System.out.println("\n\nSerialize with [packet=true] for repeated scalar");
        // Use new version with [packed=true]
        step13v2.AddressBookProtos.SearchRequest request2 =
                step13v2.AddressBookProtos.SearchRequest.newBuilder()
                        .setQuery("query string 2 ...")
                        .addAllSamples(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                        .build();

        System.out.println(request2);
        System.out.printf("Serialized size of v2: %d\n", request2.getSerializedSize());
        // Write to byte array
        byte[] buffer2 = request2.toByteArray();
        System.out.printf("Size of the written byte array for v2: %d\n", buffer2.length);

    }
}

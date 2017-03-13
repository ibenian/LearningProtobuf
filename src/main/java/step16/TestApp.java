package step15;

import com.google.protobuf.InvalidProtocolBufferException;
import step15.AddressBookProtos.SearchRequest;

import java.util.Arrays;

/**
 * Created by ibenian on 3/11/17.
 *
 * Enum field
 *
 */
public class TestApp {

    public static void main(String[] args)
            throws InvalidProtocolBufferException {
        SearchRequest request =
                SearchRequest.newBuilder()
                        .setQuery("query string ...")
                        .addAllSamples(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                        .setCorpus(SearchRequest.Corpus.NEWS)
                        .build();

        System.out.println(request);
        System.out.printf("Serialized size: %d\n", request.getSerializedSize());
        // Write to byte array
        byte[] buffer = request.toByteArray();
        System.out.printf("Size of the written byte array: %d\n", buffer.length);

        SearchRequest request2 = SearchRequest.parseFrom(buffer);
        System.out.println(request2);

    }
}
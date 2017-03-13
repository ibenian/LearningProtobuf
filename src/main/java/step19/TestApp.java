package step19;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import step19.AddressBookProtos.SearchResponse;

import java.util.Arrays;

/**
 * Created by ibenian on 3/11/17.
 *
 * Merge two messages to create a new message
 *
 */
public class TestApp {

    public static void main(String[] args)
            throws InvalidProtocolBufferException {
        SearchResponse response1 =
                SearchResponse.newBuilder()
                        .setResult(SearchResponse.Result.newBuilder()
                            .setUrl("www...")
                            .setTitle("title")
                            .addAllSnippets(Arrays.asList("a"))
                            .buildPartial())
                        .buildPartial();

        System.out.println("response1:");
        System.out.println(response1);

        SearchResponse response2 =
                SearchResponse.newBuilder()
                        .setResult(SearchResponse.Result.newBuilder()
                                .addAllSnippets(Arrays.asList("b", "c"))    // appends to the existing list
                                .setTitle("title2")                         // title2 overrides
                                .buildPartial())
                        .setStatus("OK")                                    // additional field
                        .buildPartial();
        System.out.println("response2:");
        System.out.println(response2);

        // Merge the response1 and response2
        SearchResponse response3 =
            response1.toBuilder()
                .mergeFrom(response2).buildPartial();
        System.out.println("response3:");
        System.out.println(response3);

    }
}
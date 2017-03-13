package step18;

import com.google.protobuf.InvalidProtocolBufferException;
import step18.AddressBookProtos.SearchResponse;

import java.util.Arrays;

/**
 * Created by ibenian on 3/11/17.
 *
 * Importing proto file
 *
 */
public class TestApp {

    public static void main(String[] args)
            throws InvalidProtocolBufferException {
        SearchResponse response =
                SearchResponse.newBuilder()
                        .addResult(SearchResponse.Result.newBuilder()
                            .setUrl("www...")
                            .setTitle("title")
                            .addAllSnippets(Arrays.asList("abc", "def"))
                            .build())
                        .setStatus("OK")
                        .build();

        byte[] buffer = response.toByteArray();
        SearchResponse responseRead = SearchResponse.parseFrom(buffer);
        System.out.println(responseRead);
    }
}
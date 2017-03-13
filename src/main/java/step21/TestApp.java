package step21;

import com.google.protobuf.InvalidProtocolBufferException;
import step21.AddressBookProtos.SearchRequest;

import java.util.HashMap;


/**
 * Created by ibenian on 3/11/17.
 *
 * map field
 *
 */
public class TestApp {

    public static void main(String[] args)
            throws InvalidProtocolBufferException {

        SearchRequest.Builder builder = SearchRequest.newBuilder();
        builder
            .setQuery("query string ...")
            .putSearchterms("width", "1024");
        builder.putSearchterms("height", "768");
        builder.putSearchterms("type", "logo");

        SearchRequest request = builder.build();

        System.out.println("request:");
        System.out.println(request);

        SearchRequest requestRead = SearchRequest.parseFrom(request.toByteArray());
        System.out.println("request read from buffer:");
        System.out.println(requestRead);

        System.out.println("Search terms map:");
        System.out.println(requestRead.getSearchtermsMap());
    }
}
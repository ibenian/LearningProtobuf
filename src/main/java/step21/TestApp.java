package step21;

import com.google.protobuf.InvalidProtocolBufferException;
import step21.AddressBookProtos.SearchRequest;


/**
 * Created by ibenian on 3/11/17.
 *
 * oneof fields (only one of the given fields can be set)
 *
 */
public class TestApp {

    public static void main(String[] args)
            throws InvalidProtocolBufferException {

        SearchRequest.Builder requestBuilder = SearchRequest.newBuilder();

        requestBuilder
                .setQuery("query string 1 ...")
                .setCorpus(SearchRequest.Corpus.IMAGES);

        System.out.println("requestBuilder:");
        System.out.println(requestBuilder);
        System.out.println("One of case: " + requestBuilder.getTestOneofCase());
        System.out.println();

        requestBuilder
                .setQuery("query string 2 ...")
                .setCorpusId(1);                // When corpusId is set, corpus is reset
        System.out.println("requestBuilder:");
        System.out.println(requestBuilder);
        System.out.println("One of case: " + requestBuilder.getTestOneofCase());
        System.out.println();

        SearchRequest request1 = requestBuilder.build();

        System.out.println("request1:");
        System.out.println(request1);

        SearchRequest request1Read = SearchRequest.parseFrom(request1.toByteArray());
        System.out.println("request1 read from buffer:");
        System.out.println(request1Read);
        System.out.println("One of case: " + request1Read.getTestOneofCase());
        System.out.println();

        SearchRequest request2 =
                request1.toBuilder()
                        .setQuery("query string ...")
                        .setCorpusText("universal")
                        .build();

        System.out.println("request2:");
        System.out.println(request2);

        SearchRequest request2Read = SearchRequest.parseFrom(request2.toByteArray());
        System.out.println("request2 read from buffer:");
        System.out.println(request2Read);

        System.out.println("One of case: " + request2Read.getTestOneofCase());
    }
}
package step22;

import com.google.protobuf.*;
import step22.AddressBookProtos.SearchRequest;
import step22.AddressBookProtos.SearchResponse;
import static step22.AddressBookProtos.SearchService;


/**
 * Created by ibenian on 3/11/17.
 *
 * SearchService
 *
 */
public class TestApp {

    public static void main(String[] args)
            throws InvalidProtocolBufferException {

        SearchRequest.Builder builder = SearchRequest.newBuilder();
        builder
            .setQuery("query string ...");

        SearchRequest request = builder.build();

        System.out.println("request:");
        System.out.println(request);

        SearchRequest requestRead = SearchRequest.parseFrom(request.toByteArray());
        System.out.println("request read from buffer:");
        System.out.println(requestRead);

        /*SearchService service;
        RpcController controller;
        service.search(controller, request, response ->
            System.out.println(resposne)
        );*/
    }
}
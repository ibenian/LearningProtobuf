package step23;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import step23.AddressBookProtos.SearchRequest;
import step23.AddressBookProtos.SpecialArgs;


/**
 * Created by ibenian on 3/11/17.
 *
 * Any field
 *
 */
public class TestApp {

    public static void main(String[] args)
            throws InvalidProtocolBufferException {

        SearchRequest.Builder builder = SearchRequest.newBuilder();
        builder
            .setQuery("query string ...")
            .setArgs(Any.pack(SpecialArgs.newBuilder()
                .setProjection("projection...")
                .setTimeOut(1000).build()));

        SearchRequest request = builder.build();

        System.out.println("request:");
        System.out.println(request);

        SearchRequest requestRead = SearchRequest.parseFrom(request.toByteArray());
        System.out.println("request read from buffer:");
        System.out.println(requestRead);

        // Extract any type from the read object
        if (requestRead.hasArgs()) {
            System.out.println("Reading args:");
            Any any = requestRead.getArgs();
            System.out.println("  Extracted any field's type URL: " + any.getTypeUrl());
            System.out.println("  Contents of the any field: ");
            SpecialArgs specialArgs = any.unpack(SpecialArgs.class);
            System.out.println(specialArgs);
        }
        else {
            System.out.println("Args not found!!");
        }
    }
}
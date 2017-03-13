package step17;

import com.google.protobuf.InvalidProtocolBufferException;
import step17.AddressBookProtos.SearchRequest;
import step17.other.Corpus;

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
        SearchRequest requestForPicture =
                SearchRequest.newBuilder()
                        .setQuery("query string ...")
                        .addAllSamples(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                        .setCorpus(Corpus.IMAGES)
                        .build();

        byte[] buffer1 = requestForPicture.toByteArray();
        SearchRequest requestForPictureRead = SearchRequest.parseFrom(buffer1);
        System.out.println(requestForPictureRead);
    }
}
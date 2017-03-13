package step16;

import com.google.protobuf.InvalidProtocolBufferException;
import step16.AddressBookProtos.SearchRequest;

import java.util.Arrays;

/**
 * Created by ibenian on 3/11/17.
 *
 * Enum field with alias
 *
 */
public class TestApp {

    public static void main(String[] args)
            throws InvalidProtocolBufferException {
        SearchRequest requestForPicture =
                SearchRequest.newBuilder()
                        .setQuery("query string ...")
                        .addAllSamples(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                        .setCorpus(SearchRequest.Corpus.PICTURES)
                        .build();

        byte[] buffer1 = requestForPicture.toByteArray();
        SearchRequest requestForPictureRead = SearchRequest.parseFrom(buffer1);
        System.out.println(requestForPictureRead);

        System.out.println("Written as PICTURES, read as IMAGES\n\n");

        SearchRequest requestForImage =
                SearchRequest.newBuilder()
                        .setQuery("query string ...")
                        .addAllSamples(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                        .setCorpus(SearchRequest.Corpus.IMAGES)
                        .build();

        byte[] buffer2 = requestForPicture.toByteArray();
        SearchRequest requestForImageRead = SearchRequest.parseFrom(buffer2);
        System.out.println(requestForImageRead);

        System.out.println("Written as IMAGES, read as IMAGES\n\n");

    }
}
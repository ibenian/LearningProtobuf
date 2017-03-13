package step20;

import com.google.protobuf.InvalidProtocolBufferException;
import step20.AddressBookProtos.SearchRequest;
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
                        .addExtension(step20.AddressBookProtos.samples, 10) // Add to extension repeated field
                        .addExtension(step20.AddressBookProtos.samples, 20)
                        .addExtension(step20.AddressBookProtos.samples, 30)
                        .setExtension(step20.AddressBookProtos.corpus, step20.AddressBookProtos.Corpus.IMAGES) // Set exteension field
                        .build();

        byte[] buffer1 = requestForPicture.toByteArray();
        SearchRequest requestForPictureRead = SearchRequest.parseFrom(buffer1);
        System.out.println(requestForPictureRead);

        System.out.println("Extension fields are listed with their tags, not their names");

    }
}
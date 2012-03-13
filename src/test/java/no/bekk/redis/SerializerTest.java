package no.bekk.redis;

import no.bekk.domain.Story;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class SerializerTest {

    @Test
    public void testStringSerializing() {
        DiggerSerializer<String> serializer = new DiggerSerializer<String>();
        byte[] bytes = serializer.serialize("Hello");
        String value = serializer.deserialize(bytes);
        assertEquals("Hello", value);
    }

    @Test
    public void testObjectSerializing() {
        DiggerSerializer<Story> serializer = new DiggerSerializer<Story>();
        Story story = new Story("Tittel", "Url", "Descrption", "User");
        byte[] bytes = serializer.serialize(story);
        Story value = serializer.deserialize(bytes);
        assertEquals(story, value);
    }
}

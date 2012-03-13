package no.bekk.redis;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.ObjectBuffer;
import no.bekk.domain.Story;
import org.springframework.data.redis.serializer.RedisSerializer;

public class DiggerSerializer<T> implements RedisSerializer<T> {

    private Kryo kryo = new Kryo();

    public DiggerSerializer() {
        kryo.register(Story.class);
    }

    public byte[] serialize(T t) {
        ObjectBuffer buffer = new ObjectBuffer(kryo);
        return buffer.writeClassAndObject(t);
    }

    public T deserialize(byte[] bytes) {
        if(bytes == null) {
            return null;
        }
        ObjectBuffer buffer = new ObjectBuffer(kryo);
        return (T) buffer.readClassAndObject(bytes);
    }
}
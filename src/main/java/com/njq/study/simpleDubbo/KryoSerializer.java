package com.njq.study.simpleDubbo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;

/**
 * Created by kai.yang on 2018/9/23.
 */

public class KryoSerializer<T> {

    private Class<T> ct = null;

    private final ThreadLocal<Kryo> kryoThreadLocal=new ThreadLocal<Kryo>(){

        @Override
        protected Kryo initialValue() {
            Kryo kryo = new Kryo();
            kryo.setReferences(true);
            kryo.register(ct, new JavaSerializer());
            return kryo;
        }


    };

    public KryoSerializer(Class<T> ct) {
        this.ct = ct;
        kryoThreadLocal.get();
    }



    public byte[] serialize(Object obj) {
        Kryo kryo = kryoThreadLocal.get();
        ByteArrayOutputStream byteArrayOutputStream=null;
        Output output=null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            output = new Output(byteArrayOutputStream);
            kryo.writeObjectOrNull(output, obj, obj.getClass());
            output.flush();
            return byteArrayOutputStream.toByteArray();

        } finally {
            output.close();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }




    @SuppressWarnings("unchecked")
    public  T deserialize(byte[] bytes, int offset, int count) {
        Kryo kryo = kryoThreadLocal.get();
        Input input = new Input(bytes, offset, count);
        return (T) kryo.readObjectOrNull(input, ct);
    }

    public  T deserialize(byte[] bytes) {
        return deserialize(bytes, 0, bytes.length);
    }



}

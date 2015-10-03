package com.curso.ejercicio1;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Calendar;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.curso.ejercicio1.DateSerializer;

/**
 * @author juan.calvopina
 * */

public class DataSerializerTest {

    DateSerializer dateSerializer;
    JsonGenerator jsonGenerator;
    Calendar fecha;

    @Before
    public void setUp() {
        dateSerializer = new DateSerializer();
        jsonGenerator = Mockito.mock(JsonGenerator.class);
        fecha = Calendar.getInstance();
        fecha.set(2015, Calendar.SEPTEMBER, 1,0,0,0);
    }

    /**
     * Se setea una fecha valida y se espera recibir la fecha que se envia
     * */
    @Test
    public void testWriteString() throws JsonProcessingException, IOException {
        dateSerializer.serialize(fecha.getTime(), jsonGenerator, null);
        Mockito.verify(jsonGenerator).writeString("2015-09-01T00:00:00");
    }

    /**
     * Se envia JsonGenerator en null
     * */
    @Test(expected = NullPointerException.class)
    public void testJsonGeneratorNull() throws JsonProcessingException, IOException {
        dateSerializer.serialize(Calendar.getInstance().getTime(), null, null);
        Mockito.doThrow(new NullPointerException()).when(jsonGenerator).writeString("2015-09-01T00:00:00");
    }

    /**
     * Se envia la fecha en null
     * */
    @Test(expected = NullPointerException.class)
    public void testDateNull() throws JsonProcessingException, IOException {
        dateSerializer.serialize(null, jsonGenerator, null);
        fail("NullPointerException");
    }

    /**
     * Se envia todos los parametros en null
     * */
    @Test(expected = NullPointerException.class)
    public void testAllParametersNull() throws JsonProcessingException, IOException {
        dateSerializer.serialize(null, null, null);
        fail("NullPointerException");
    }

    /**
     * Se setea una fecha invalida y se espera recibir la fecha que se envia
     * */
    /*@Test(expected = NullPointerException.class)
    public void testDate() throws JsonProcessingException, IOException {
        fecha.set(0,0,0,0,0,0);
        dateSerializer.serialize(fecha.getTime(), jsonGenerator, null);
        Mockito.verify(jsonGenerator).writeString("0-0-0T00:00:00");
    }*/

}

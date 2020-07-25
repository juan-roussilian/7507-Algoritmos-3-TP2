package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

public class PreguntasVerdaderoFalsoTest {

    @Test
    public void test01CreoUnaPreguntaVerdaderoFalsoSeEligeLaCorrectaYDevuelve1Punto(){

        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "El cielo es azul?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,verdaderoFalso,tipoClasico);
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta);
        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(1,puntos);

    }

    @Test
    public void test02CreoUnaPreguntaVerdaderoFalsoSeEligeLaIncorrectaYDevuelve0Puntos(){

        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "Diciembre tiene 31 dias?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,verdaderoFalso,tipoClasico);

        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaIncorrecta);
        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(0,puntos);

    }


    @Test
    public void test03SiCreoUnaPreguntaVerdaderoFalsoYLeIntentoAgregarMasDeDosRespuestasLanzaExcepcion(){

        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "El sistema solar tiene 12 planetas?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Falso");
        RespuestaCorrecta otraRespuestaCorrecta = new RespuestaCorrecta("Otro falso");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Verdadero");


        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta);
        respuestasCorrectas.add(otraRespuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        assertThrows(CantidadErroneaDeRespuestasParaPreguntaException.class,
                ()->{Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,verdaderoFalso,tipoClasico);}
                );
    }

    @Test
    public void test04CreoUnaPreguntaVerdaderoFalsoYSeDaMasDeUnaRespuestaDeberiaLanzarExcepcion(){

        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "Diciembre tiene 31 dias?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();


        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,verdaderoFalso,tipoClasico);

        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaIncorrecta);
        respuestasJugador.add(respuestaIncorrecta);

        assertThrows(CantidadErroneaDeRespuestasParaPreguntaException.class,
                ()->{unaPregunta.responder(respuestasJugador);}
        );
    }

    @Test
    public void test05CreoUnaPreguntaVerdaderoFalsoYNoSeDaUnaRespuestaDeberiaLanzarExcepcion(){

        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "Diciembre tiene 31 dias?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();


        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,verdaderoFalso,tipoClasico);

        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();

        assertThrows(CantidadErroneaDeRespuestasParaPreguntaException.class,
                ()->{unaPregunta.responder(respuestasJugador);}
        );

    }

    @Test
    public void test06CreoUnaPreguntaVerdaderoFalsoPenalizableRespondoBienYDevuelve1Punto(){
        String enunciado = "El patron poxi existe?";

        TipoPuntajePenalizable tipoPenalizable = new TipoPuntajePenalizable();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Falso");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Verdadero");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();


        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,verdaderoFalso,tipoPenalizable);

        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta);
        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(1,puntos);

    }

    @Test
    public void test07CreoUnaPreguntaVerdaderoFalsoPenalizableRespondoMalYPierdo1Punto(){
        String enunciado = "El patron poxi existe?";

        TipoPuntajePenalizable tipoPenalizable = new TipoPuntajePenalizable();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Falso");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Verdadero");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();


        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,verdaderoFalso,tipoPenalizable);

        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaIncorrecta);
        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(-1,puntos);

    }

}


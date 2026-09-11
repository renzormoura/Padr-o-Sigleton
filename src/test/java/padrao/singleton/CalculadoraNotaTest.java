package padrao.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraNotaTest {

    @Test
    void deveRetornarSempreAMesmaInstancia() {
        CalculadoraNota primeiraCalculadora = CalculadoraNota.getInstancia();
        CalculadoraNota segundaCalculadora = CalculadoraNota.getInstancia();

        assertSame(primeiraCalculadora, segundaCalculadora);
    }

    @Test
    void deveAprovarAlunoComNotaEfrequenciaSuficientes() {
        CalculadoraNota calculadora = CalculadoraNota.getInstancia();
        calculadora.setNota(8);
        calculadora.setFrequencia(75);

        assertEquals("aprovado", calculadora.calcularSituacao());
    }

    @Test
    void deveEnviarAlunoParaRecuperacao() {
        CalculadoraNota calculadora = CalculadoraNota.getInstancia();
        calculadora.setNota(6);
        calculadora.setFrequencia(80);

        assertEquals("recuperacao", calculadora.calcularSituacao());
    }

    @Test
    void deveReprovarAlunoPorFalta() {
        CalculadoraNota calculadora = CalculadoraNota.getInstancia();
        calculadora.setNota(9);
        calculadora.setFrequencia(74);

        assertEquals("reprovado por falta", calculadora.calcularSituacao());
    }

    @Test
    void naoDeveAceitarNotaInvalida() {
        assertThrows(IllegalArgumentException.class, () ->
                CalculadoraNota.getInstancia().setNota(11));
    }
}
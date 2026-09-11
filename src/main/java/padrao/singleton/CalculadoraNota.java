package padrao.singleton;

public class CalculadoraNota {
    private static final CalculadoraNota instancia = new CalculadoraNota();
    private float nota;
    private float frequencia;

    private CalculadoraNota() {
    }

    public static CalculadoraNota getInstancia() {
        return instancia;
    }

    public float getNota() {
        return this.nota;
    }

    public void setNota(float nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("nota invalida");
        }
        this.nota = nota;
    }

    public float getFrequencia() {
        return this.frequencia;
    }

    public void setFrequencia(float frequencia) {
        if (frequencia < 0 || frequencia > 100) {
            throw new IllegalArgumentException("frequencia invalida");
        }
        this.frequencia = frequencia;
    }

    public String calcularSituacao() {
        String resultado;

        if (this.frequencia < 75) {
            resultado = "reprovado por falta";
        } else {
            if (this.nota < 5) {
                resultado = "reprovado";
            } else {
                if (this.nota < 7) {
                    resultado = "recuperacao";
                } else {
                    resultado = "aprovado";
                }
            }
        }
        return resultado;
    }
}
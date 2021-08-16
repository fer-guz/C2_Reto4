

public class Req2 {
    private int estrato;
    private String fechaInicio;
    private int financiable;

    private double porcentaje;

    public Req2(int estrato, String fechaInicio, int financiable, double porcentaje) {
        this.estrato = estrato;
        this.fechaInicio = fechaInicio;
        this.financiable = financiable;
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "Req2 [estrato=" + estrato + ", fechaInicio=" + fechaInicio + ", financiable=" + financiable
                + ", porcentaje=" + Math.round(porcentaje) + "]";
    }

    // TODO crear el toString usando el autogenerador, (click derecho->source
    // action->generate toString )

}

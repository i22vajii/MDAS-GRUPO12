package patron_composite;

public class AparatoElectrico extends ContadorLogico {
    
    private double consumoPorHora;
    private double horasUsoEstimado;
    
    
    private static final double PRECIO_ENERGIA = 0.15; 

    public AparatoElectrico(double consumoPorHora, double horasUsoEstimado) {
        this.consumoPorHora = consumoPorHora;
        this.horasUsoEstimado = horasUsoEstimado;
    }

    // Métodos específicos del aparato 
    public double calcularHorasUso() {
        return this.horasUsoEstimado;
    }

    public double estimarCosteHora() {
        return this.consumoPorHora * PRECIO_ENERGIA;
    }

    
    @Override
    public double estimarConsumoGlobal() {
        // Consumo = horas * consumo/hora
        return calcularHorasUso() * this.consumoPorHora;
    }

    @Override
    public double calcularCosteTotal() {
        // Coste = Consumo global * precio de la energía
        return estimarConsumoGlobal() * PRECIO_ENERGIA;
    }
}

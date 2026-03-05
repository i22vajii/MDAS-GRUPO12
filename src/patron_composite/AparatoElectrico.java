package patron_composite;

public class AparatoElectrico extends ContadorLogico {
    
    private double consumoPorHora;
    private double horasUsoEstimado;
    
    // Podemos añadir un precio ficticio por kWh o por consumo para calcular el coste total
    private static final double PRECIO_ENERGIA = 0.15; 

    public AparatoElectrico(double consumoPorHora, double horasUsoEstimado) {
        this.consumoPorHora = consumoPorHora;
        this.horasUsoEstimado = horasUsoEstimado;
    }

    // Métodos específicos del aparato (según tu diagrama UML)
    public double calcularHorasUso() {
        return this.horasUsoEstimado;
    }

    public double estimarCosteHora() {
        return this.consumoPorHora * PRECIO_ENERGIA;
    }

    // Implementación de los métodos obligatorios de la clase padre (ContadorLogico)
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

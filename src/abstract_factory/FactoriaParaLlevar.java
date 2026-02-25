package abstract_factory;

public class FactoriaParaLlevar extends FactoriaAbstracta {

    // Método auxiliar privado para aplicar el incremento del 2% a cada plato
    private Plato aplicarIncremento(Plato plato) {
        float precioConIncremento = plato.getPrecio() * 1.02f;
        plato.asignarPrecio(precioConIncremento);
        return plato;
    }

    @Override
    public Menu crearMenuSemanal(TipoAcompanamiento acompanamiento) {
        Menu menu = new MenuSemanal();
        // 1º Plato y 2º Plato (¡Sin postre para llevar!)
        menu.asignarPlato(aplicarIncremento(new Plato("Sopa de fideos", 5.0f, TipoPlato.ENTRANTE, TipoAcompanamiento.NINGUNO)));
        menu.asignarPlato(aplicarIncremento(new Plato("Filete de ternera", 10.0f, TipoPlato.PRINCIPAL, acompanamiento)));
        return menu;
    }

    @Override
    public Menu crearMenuTemporada() {
        Menu menu = new MenuTemporada();
        // 1 único plato temporal
        menu.asignarPlato(aplicarIncremento(new Plato("Guiso especial de otoño", 15.0f, TipoPlato.UNICO, TipoAcompanamiento.NINGUNO)));
        return menu;
    }
}

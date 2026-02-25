package abstract_factory;

public class FactoriaRestaurante extends FactoriaAbstracta {

    @Override
    public Menu crearMenuSemanal(TipoAcompanamiento acompanamiento) {
        Menu menu = new MenuSemanal();
        // 1º Plato, 2º Plato y Postre
        menu.asignarPlato(new Plato("Sopa de fideos", 5.0f, TipoPlato.ENTRANTE, TipoAcompanamiento.NINGUNO));
        menu.asignarPlato(new Plato("Filete de ternera", 10.0f, TipoPlato.PRINCIPAL, acompanamiento));
        menu.asignarPlato(new Plato("Tarta de queso", 4.0f, TipoPlato.POSTRE, TipoAcompanamiento.NINGUNO));
        return menu;
    }

    @Override
    public Menu crearMenuTemporada() {
        Menu menu = new MenuTemporada();
        // 1 único plato temporal
        menu.asignarPlato(new Plato("Guiso especial de otoño", 15.0f, TipoPlato.UNICO, TipoAcompanamiento.NINGUNO));
        return menu;
    }
}
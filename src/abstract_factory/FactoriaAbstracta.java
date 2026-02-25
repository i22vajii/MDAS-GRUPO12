package abstract_factory;

public abstract class FactoriaAbstracta {
    // Estos son los métodos que las fábricas hijas estarán obligadas a implementar
    public abstract Menu crearMenuSemanal(TipoAcompanamiento tipoAcompanamiento);
    public abstract Menu crearMenuTemporada();
}
package model.exceptions;

public class DomainException extends RuntimeException { //RunTimeExceotion nao precisa ser tratada, ja Exception sim

    public DomainException(String msg){ super(msg); } // permiter que possa instanciar a excecao personalizada pasa uma mensagem
}

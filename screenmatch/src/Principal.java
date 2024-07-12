public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme(); //criando variavel por referencia

        //atribuindo valores
        meuFilme.nome = "O poderoso chefao";
        meuFilme.anoDeLancamento = 1970;
        meuFilme.duracaoEmMinutos = 180;

        System.out.println(meuFilme.nome); // instanciacao de obejeto
        System.out.println(meuFilme.anoDeLancamento); // instanciacao de obejeto
    }
}

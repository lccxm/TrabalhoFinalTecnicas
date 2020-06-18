import java.util.ArrayList;
package entidades;

public class Pedido {
    private ArrayList<Livro> livros;
    private String cupom;
    private Cliente cliente;
    private Livro livro;
    public Pedido(Cliente cliente, ArrayList<Livro> livros) {
        this.livros = livros;
    }

    private double getSubTotal(){
        double total = 0;
        for (Livro l: livros) {
            total+=livro.getPreco();
        }
    }

    public String getCupom() {
        return cupom;
    }

    public ArrayList<Livro> getPedidoCliente(Cliente c){
        return livros;
    }
}

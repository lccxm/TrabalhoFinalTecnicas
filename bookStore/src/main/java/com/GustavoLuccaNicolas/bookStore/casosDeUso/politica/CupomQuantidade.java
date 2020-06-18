import com.GustavoLuccaNicolas.bookStore.entidades.Genero;
import com.GustavoLuccaNicolas.bookStore.entidades.Livro;

public class CupomQuantidade extends Cupom {
    private final double DESCONTO = 0.15;

    public CupomQuantidade(String cupomStr, Venda venda){
        super(cupomStr, venda);
    }

    @Override
    public double getDesconto(){
        if (venda.getPedido().getLivros().size()>=3)
            return venda.getPedido().getSubTotal() * DESCONTO;
        else 
            throw new IllegalArgumentException("Voce precisa ter pelo menos 3 itens em seu carrinho para ativar este desconto.");
    }
}
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.function.Function;

import static java.util.function.Function.identity;

import java.awt.List;

import com.GustavoLuccaNicolas.bookStore.casosDeUso.politica.Venda;
import java.util.List;

import com.GustavoLuccaNicolas.bookStore.entidades.Genero;
import com.GustavoLuccaNicolas.bookStore.entidades.Livro;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;

public class servicosCliente{

    private RepositorioClientes rClientes;
    private RepositorioVendas rVendas;
    private RepositorioLivros rLivros;
    private ServicosPagina serv;
    


    public servicosCliente(RepositorioClientes rClientes, RepositorioVendas rVendas, RepositorioLivros rLivros, ServicoPagina serv){
        this.rClientes = rClientes;
        this.rLivros = rLivros;
        this.rVendas = rVendas;
        this.serv = serv;
    }

    public Cliente recuperarDadosCliente(Long cpf){
        return Cliente c = rClientes.findClienteByCpf(cpf);
    }

    public List<Venda> recuperarComprasPassadas(Cliente cliente){
        return List<Venda> vendas = rVendas.findByCliente(cliente.getCpf());
    }

    public List<Livro> recuperarRecomendacoes(String cpf){ 
        Cliente cliente = rClientes.findByCpf(cpf);
        List<Livro> bestSellers = serv.getBestSellers();
        Genero favorito;
        List<Livro> livros = rVendas.findByCliente(cliente).stream()
                .map(vendas -> vendas.getLivros())
                .flatMap(List::stream).collect(Collectors.toList());
        Map<Genero, Integer> freq = livros.stream().map(livro -> livro.getGenero())
                .collect(Collectors.toMap(identity(), v -> 1, Integer::sum));
        int maxValueInMap=(Collections.max(freq.values()));  
        for (Map.Entry<Genero, Integer> entry : freq.entrySet()) {  
            if (entry.getValue()==maxValueInMap) {
                favorito = entry.getKey();    
            }
        }
        return bestSellers.stream().filter(livro -> livro.getGenero() == favorito).collect(Collectors.toList());
    }
}

    public Pedido criaVenda(Cliente cliente){
        return Venda venda = new Venda(cliente));
    }
}

    public static void main(String args[]){

    }
}
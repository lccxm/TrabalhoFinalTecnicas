class ServicosPagina {
    private RepositorioVendas rVendas;
    private RepositorioLivros rLivros;
    private Livro livro;

    ServicosPagina(RepositorioVendas rVendas, RepositorioLivros rLivros){
        this.rVendas = rVendas;
        this.rLivros = rLivros;
    }

    public ArrayList<Livro> pesquisaPorTitulo(String titulo){
        ArrayList<Livro> livros = rLivros.getLivros();
        ArrayList<Livro> livrosEncontrados = new ArrayList<Livro>;
        for(Livro l : livros){
            if(titulo.equalsIgnoreCase(l.getTitulo)){
                livrosEncontrados.add(l);
            }
        }
        return livrosEncontrados;
    }

    public ArrayList<Livro> pesquisaPorGenero(Genero genero){
        ArrayList<Livro> livros = rLivros.getLivros();
        ArrayList<Livro> livrosEncontrados = new ArrayList<Livro>;
        for(Livro l : livros){
            if(titulo.equalsIgnoreCase(l.genero)){
                livrosEncontrados.add(l);
            }
        }
        return livrosEncontrados;
    }

    public ArrayList<Livro> getBestSellers(){
        ArrayList<Livro> livros = rLivros.getLivros();
        return livros.vendas.sort().reverse();
    }
}
INSERT INTO `livro` (id,autor,descricao,disponivel,genero,n_vendas,preco,titulo) VALUES (1, 'Stewart Chaney', 'blabla', true, 'ACAO', 200, 20.50, 'titulo');
INSERT INTO `livro` (id,autor,descricao,disponivel,genero,n_vendas,preco,titulo) VALUES (2, 'Stewart Chaney', 'blabla', true, 'ROMANCE', 200, 20.50, 'titulo');
INSERT INTO `livro` (id,autor,descricao,disponivel,genero,n_vendas,preco,titulo) VALUES (3, 'Stewart Chaney', 'blabla', true, 'ACAO', 200, 20.50, 'titulo');
INSERT INTO `livro` (id,autor,descricao,disponivel,genero,n_vendas,preco,titulo) VALUES (4, 'Stewart Chaney', 'blabla', true, 'HQ', 200, 20.50, 'titulo');
INSERT INTO `livro` (id,autor,descricao,disponivel,genero,n_vendas,preco,titulo) VALUES (5, 'Stewart Chaney', 'blabla', true, 'ACAO', 200, 20.50, 'titulo');
INSERT INTO `livro` (id,autor,descricao,disponivel,genero,n_vendas,preco,titulo) VALUES (6, 'Stewart Chaney', 'blabla', true, 'AVENTURA', 200, 20.50, 'titulo');

INSERT INTO cliente (id,cpf,endereco,forma_pagamento,nome,uf) VALUES (2, '7','av bla', 'Dinheiro', 'ha', 'RS');

INSERT INTO venda (id,cupom_str,cliente_id) VALUES (9, 'cupomzao', 2);

INSERT INTO venda_livros (venda_id, livros_id) VALUES (9, 1);


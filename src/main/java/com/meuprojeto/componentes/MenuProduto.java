package com.meuprojeto.componentes;

import java.time.LocalDate;
import java.util.Scanner;

import com.meuprojeto.dao.ProdutoDao;
import com.meuprojeto.dominio.Eletrodomestrico;
import com.meuprojeto.dominio.Moveis;
import com.meuprojeto.dominio.Produto;

public final class MenuProduto {

    private static final ProdutoDao dao = new ProdutoDao();

    private MenuProduto() {
    }

    public static void exibir(Scanner scanner) {
        int opcao;

        do {
            System.out.println("\n===== MENU PRODUTO =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto");
            System.out.println("4 - Atualizar produto");
            System.out.println("5 - Deletar produto");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = MenuGeral.lerOpcao(scanner);

            switch (opcao) {
                case 1 -> {
                    System.out.println("Cadastrar produto");
                    System.out.println("Tipo de produto (1 - Eletrodomestico, 2 - Movel):");
                    int tipo = MenuGeral.lerOpcao(scanner);
                    if (tipo == 1) {
                        Eletrodomestrico eletro = new Eletrodomestrico();
                        System.out.println("Informe o nome:");
                        eletro.setNome(scanner.nextLine());
                        System.out.println("Informe a marca:");
                        eletro.setMarca(scanner.nextLine());
                        System.out.println("Informe o modelo:");
                        eletro.setModelo(scanner.nextLine());
                        System.out.println("Informe a quantidade:");
                        eletro.setQuantidade(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Informe a descricao:");
                        eletro.setDescricacao(scanner.nextLine());
                        System.out.println("Informe quem criou:");
                        eletro.setCriadoPor(scanner.nextLine());
                        eletro.setDataCriacao(LocalDate.now());
                        System.out.println("Informe a voltagem:");
                        eletro.setVoltagem(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Informe o potencial:");
                        eletro.setPotencial(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Informe as especificacoes:");
                        eletro.setEspecificacoes(scanner.nextLine());
                        dao.salvar(eletro);
                    } else if (tipo == 2) {
                        Moveis movel = new Moveis();
                        System.out.println("Informe o nome:");
                        movel.setNome(scanner.nextLine());
                        System.out.println("Informe a marca:");
                        movel.setMarca(scanner.nextLine());
                        System.out.println("Informe o modelo:");
                        movel.setModelo(scanner.nextLine());
                        System.out.println("Informe a quantidade:");
                        movel.setQuantidade(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Informe a descricao:");
                        movel.setDescricacao(scanner.nextLine());
                        System.out.println("Informe quem criou:");
                        movel.setCriadoPor(scanner.nextLine());
                        movel.setDataCriacao(LocalDate.now());
                        System.out.println("Informe a composicao:");
                        movel.setComposicao(scanner.nextLine());
                        System.out.println("Informe os materiais:");
                        movel.setMateriais(scanner.nextLine());
                        System.out.println("Informe a quantidade de itens:");
                        movel.setQtdItens(Integer.parseInt(scanner.nextLine()));
                        dao.salvar(movel);
                    }
                }
                case 2 -> {
                    System.out.println("Listar produtos");
                    System.out.println(dao.listar());
                }
                case 3 -> {
                    System.out.println("Buscar produto");
                    System.out.println("Digite o indice do produto:");
                    int indice = MenuGeral.lerOpcao(scanner);
                    Produto p = dao.buscar(indice);
                    System.out.println(p);
                }
                case 4 -> {
                    System.out.println("Atualizar produto");
                    System.out.println("Digite o indice do produto:");
                    int indice = MenuGeral.lerOpcao(scanner);
                    Produto produtoExistente = dao.buscar(indice);
                    if (produtoExistente instanceof Eletrodomestrico) {
                        Eletrodomestrico eletro = new Eletrodomestrico();
                        System.out.println("Informe o nome:");
                        eletro.setNome(scanner.nextLine());
                        System.out.println("Informe a marca:");
                        eletro.setMarca(scanner.nextLine());
                        System.out.println("Informe o modelo:");
                        eletro.setModelo(scanner.nextLine());
                        System.out.println("Informe a quantidade:");
                        eletro.setQuantidade(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Informe a descricao:");
                        eletro.setDescricacao(scanner.nextLine());
                        System.out.println("Informe quem criou:");
                        eletro.setCriadoPor(scanner.nextLine());
                        eletro.setDataCriacao(LocalDate.now());
                        System.out.println("Informe a voltagem:");
                        eletro.setVoltagem(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Informe o potencial:");
                        eletro.setPotencial(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Informe as especificacoes:");
                        eletro.setEspecificacoes(scanner.nextLine());
                        dao.atualizar(indice, eletro);
                    } else if (produtoExistente instanceof Moveis) {
                        Moveis movel = new Moveis();
                        System.out.println("Informe o nome:");
                        movel.setNome(scanner.nextLine());
                        System.out.println("Informe a marca:");
                        movel.setMarca(scanner.nextLine());
                        System.out.println("Informe o modelo:");
                        movel.setModelo(scanner.nextLine());
                        System.out.println("Informe a quantidade:");
                        movel.setQuantidade(Integer.parseInt(scanner.nextLine()));
                        System.out.println("Informe a descricao:");
                        movel.setDescricacao(scanner.nextLine());
                        System.out.println("Informe quem criou:");
                        movel.setCriadoPor(scanner.nextLine());
                        movel.setDataCriacao(LocalDate.now());
                        System.out.println("Informe a composicao:");
                        movel.setComposicao(scanner.nextLine());
                        System.out.println("Informe os materiais:");
                        movel.setMateriais(scanner.nextLine());
                        System.out.println("Informe a quantidade de itens:");
                        movel.setQtdItens(Integer.parseInt(scanner.nextLine()));
                        dao.atualizar(indice, movel);
                    }
                }
                case 5 -> {
                    System.out.println("Deletar produto");
                    System.out.println("Digite o indice do produto:");
                    int indice = MenuGeral.lerOpcao(scanner);
                    dao.deletar(indice);
                }
                case 0 -> System.out.println("Voltando ao menu geral...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}

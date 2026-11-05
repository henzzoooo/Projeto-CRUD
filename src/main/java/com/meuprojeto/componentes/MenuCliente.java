package com.meuprojeto.componentes;

import java.time.LocalDate;
import java.util.Scanner;

import com.meuprojeto.dao.ClienteDao;
import com.meuprojeto.dominio.Cliente;
import com.meuprojeto.dominio.Endereco;

public final class MenuCliente {

    private MenuCliente() {
    }

    public static void exibir(Scanner scanner) {
        int opcao;
        ClienteDao dao = new ClienteDao();
        do {
            System.out.println("\n===== MENU CLIENTE =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente");
            System.out.println("4 - Atualizar cliente");
            System.out.println("5 - Deletar cliente");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = MenuGeral.lerOpcao(scanner);

            switch (opcao) {
                case 1:
                    Cliente cliente = new Cliente();
                    System.out.println("Informe seu nome:");
                    cliente.setNome(scanner.nextLine());

                    System.out.println("Informe sua data de nascimento (ano-mes-dia):");
                    String dataNascimento = scanner.nextLine();
                    cliente.setDataNascimento(LocalDate.parse(dataNascimento));

                    System.out.println("Digite seu e-mail: ");
                    String email = scanner.nextLine();
                    cliente.setEmail(email);

                    System.out.println("Digite seu numero de telefone: ");
                    String numero = scanner.nextLine();
                    cliente.setTelefone(numero);

                    System.out.println("Digite seu genero: ");
                    String genero = scanner.nextLine();
                    cliente.setGenero(genero);

                    System.out.println("Digite seu CPF: ");
                    String cpf = scanner.nextLine();
                    cliente.setCpf(cpf);
                    
                    System.out.println("Digite sua Rua: ");
                    String rua = scanner.nextLine();
                    System.out.println("Digite seu numero: ");
                    int num = Integer.parseInt(scanner.nextLine());
                    System.out.println("Digite sua cidade: ");
                    String cidade = scanner.nextLine();
                    Endereco endereco = new Endereco(rua,num,cidade);
                    cliente.setEndereco(endereco);                
                    System.out.println("Salvando no banco de dados...\n");
                    dao.salvar(cliente);
                    if(dao.listar() == null){
                        System.out.println("ERRO ao salvar!\n");
                    }else{
                        System.out.println("Salvo Com sucesso!\n");
                    }
                    break;
                    case 2:
                        
                        dao.listar();
                        System.out.println(dao.listar());
                    break;
                case 3:
                    System.out.println("Digite o indice do cliente:");
                    int indice = MenuGeral.lerOpcao(scanner);
                    Cliente clienteBuscado = dao.buscar(indice);
                    System.out.println(clienteBuscado);
                    break;
                case 4:
                    System.out.println("Atualizar cliente");
                    System.out.println("Digite o indice do cliente:");
                    int indiceAtualizar = MenuGeral.lerOpcao(scanner);
                    Cliente clienteExistente = dao.buscar(indiceAtualizar);
                    if (clienteExistente != null) {
                        Cliente clienteAtualizado = new Cliente();
                        System.out.println("Informe seu nome:");
                        clienteAtualizado.setNome(scanner.nextLine());
                        System.out.println("Informe sua data de nascimento (ano-mes-dia):");
                        String novaData = scanner.nextLine();
                        clienteAtualizado.setDataNascimento(LocalDate.parse(novaData));
                        System.out.println("Digite seu e-mail: ");
                        clienteAtualizado.setEmail(scanner.nextLine());
                        System.out.println("Digite seu numero de telefone: ");
                        clienteAtualizado.setTelefone(scanner.nextLine());
                        System.out.println("Digite seu genero: ");
                        clienteAtualizado.setGenero(scanner.nextLine());
                        System.out.println("Digite seu CPF: ");
                        clienteAtualizado.setCpf(scanner.nextLine());
                        System.out.println("Digite sua Rua: ");
                        String novaRua = scanner.nextLine();
                        System.out.println("Digite seu numero: ");
                        int novoNum = Integer.parseInt(scanner.nextLine());
                        System.out.println("Digite sua cidade: ");
                        String novaCidade = scanner.nextLine();
                        clienteAtualizado.setEndereco(new Endereco(novaRua, novoNum, novaCidade));
                        dao.atualizar(indiceAtualizar, clienteAtualizado);
                        System.out.println("Salvo Com sucesso!\n");
                    } else {
                        System.out.println("ERRO ao salvar!\n");
                    }
                    break;
                case 5:
                    System.out.println("Deletar cliente");
                    System.out.println("Digite o indice do cliente:");
                    int indiceDeletar = MenuGeral.lerOpcao(scanner);
                    dao.deletar(indiceDeletar);
                    break;
                case 0:
                    System.out.println("Voltando ao menu geral...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}

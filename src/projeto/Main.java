/**
 * 
 */
package projeto;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author 40036_38298_40298_37994
 *
 */
public class Main {
	public static Scanner input = new Scanner(System.in);
	public static Scanner inputString = new Scanner(System.in);

	// INICIO FUNCOES CLIENTE
	public static void pesquisarProduto(GereProduto listaProd) {
		System.out.println("Qual o id do produto que pretende procurar?");
		int id = input.nextInt();

		listaProd.imprimirUm(id);
	}

	public static void imprimirTodosProdutos(GereProduto listaProd) {
		listaProd.imprimirTodos();
	}

	public static void detalhesCliente(GereUtilizador listaUtil, int numUtil) {
		listaUtil.imprimirUmUtil(numUtil);
	}

	public static void consultarHistorico(GereUtilizador listaUtil, int numeroUtil) {
		listaUtil.consultarHistorico(numeroUtil);
	}

	public static void consultarEstado(GereUtilizador listaUtil) {
		System.out.println("Qual o id da encomenda que quer consultar");
		int id = input.nextInt();

		listaUtil.consultarEstado(id);

	}

	public static void realizarEncomenda(GereUtilizador listaUtil, GereProduto listaProd, int numeroUtil) {
		System.out.println("A realizar encomenda");

		Encomenda newEncomenda;
		

		System.out.println("Quantos produtos diferentes quer");
		int prods = input.nextInt();
		
		System.out.println("Qual a data para levantar? Formato AAAA-MM-DD. Minimo 24h");
		String data = inputString.next();
		LocalDate date = LocalDate.parse(data);
		
		newEncomenda = new Encomenda(date);

		for (int i = 0; i < prods; i++) {
			
			listaProd.imprimirTodos();

			System.out.println("Qual o ID do produto que quer?");
			int id = input.nextInt();
			
			Produto p = listaProd.pesquisarProduto(id);

			System.out.println("Qual a quantidade do produto que quer?");
			int quant = input.nextInt();
			
			if(listaProd.compararStock(id, quant)) {
				DetalhesEncomenda newDetalhes = new DetalhesEncomenda(p, quant);
				
				newEncomenda.registarDetalhes(newDetalhes);
			}
			else {
				System.out.println("A quantidade excede o stock. Quer:\n1." + p.getStock() + " unidades\n2.Nenhuma unidade");
				int op = input.nextInt();
				
				if (op == 1) {
					listaProd.removerStock(id, p.getStock());
					
					DetalhesEncomenda newDetalhes = new DetalhesEncomenda(p, p.getStock());
					
					newEncomenda.registarDetalhes(newDetalhes);
				}
			}
		}
		if(newEncomenda.getDetalhesE().size()!=0) {
			listaUtil.realizarEncomenda(newEncomenda, numeroUtil);
		}
		else {
			System.out.println("Encomenda vazia - Nao validada");
		}
	}

	public static void trataCliente(GereUtilizador listaUtil, GereProduto listaProd) {

		System.out.println("Qual o numero utilizador?");
		int numeroUtil = input.nextInt();

		System.out.println("Qual a password?");
		int password = input.nextInt();

		if ((listaUtil.verificaLoginCliente(numeroUtil, password) != null)) {
			System.out.println("1. Realizar Encomenda");
			System.out.println("2. Imprimir lista de produtos");
			System.out.println("3. Pesquisar um produto");
			System.out.println("4. Consultar estado encomenda");
			System.out.println("5. Consultar histórico encomendas do cliente");
			System.out.println("6. Imprimir detalhes do cliente");
			System.out.println("0. Terminar");
			System.out.println("Introduza opção:");
			int op;
			op = input.nextInt();

			while (op != 0) {
				switch (op) {
				case 1: {
					Main.realizarEncomenda(listaUtil, listaProd, numeroUtil);
				}
				break;

				case 2: {
					Main.imprimirTodosProdutos(listaProd);
				}
				break;

				case 3: {
					Main.pesquisarProduto(listaProd);
				}
				break;

				case 4: {
					Main.consultarEstado(listaUtil);
				}
				break;

				case 5: {
					Main.consultarHistorico(listaUtil, numeroUtil);
				}
				break;

				case 6: {
					Main.detalhesCliente(listaUtil, numeroUtil);
				}
				break;
				}
				System.out.println("1. Realizar Encomenda");
				System.out.println("2. Imprimir lista de produtos");
				System.out.println("3. Pesquisar um produto");
				System.out.println("4. Consultar estado encomenda");
				System.out.println("5. Consultar histórico encomendas do cliente");
				System.out.println("6. Imprimir detalhes do cliente");
				System.out.println("0. Terminar");
				System.out.println("Introduza opção:");
				op = input.nextInt();
			}
		}
	}
	// FIM FUNCOES CLIENTE

	// INICIO FUNCOES FUNCIONARIO
	public static void consultarPrecoEspecifico(GereProduto listaProd) {
		System.out.println("Qual o id do produto que quer consultar?");
		int idProd = input.nextInt();

		listaProd.consultarPreco(idProd);
	}

	public static void imprimirTodoPreco(GereProduto listaProd) {
		listaProd.imprimirTodoPreco();
	}

	public static void atualizarStock(GereProduto listaProd) {
		System.out.println("Pretende:\n1. Adicionar Stock\n 2. Removar stock");
		int escolha = input.nextInt();

		if (escolha == 1) {
			System.out.println("Qual o id do produto a que quer adicionar stock?");
			int idProd = input.nextInt();

			System.out.println("Que quantidade quer adicionar ao stock desse produto?");
			int add = input.nextInt();

			listaProd.adicionarStock(idProd, add);
		} else {
			System.out.println("Qual o id do produto a que quer remover stock?");
			int idProd = input.nextInt();

			System.out.println("Que quantidade quer remover ao stock desse produto?");
			int remove = input.nextInt();

			listaProd.removerStock(idProd, remove);
		}
	}

	public static void imprimirTodoStock(GereProduto listaProd) {
		listaProd.imprimirTodoStock();
	}

	public static void eliminarProduto(GereProduto listaProd) {
		System.out.println("Qual o id do produto que quer eliminar?");
		int idProd = input.nextInt();

		listaProd.eliminarProduto(idProd);
	}

	public static void consultarStockEspecifico(GereProduto listaProd) {
		System.out.println("Qual o id do produto que quer consultar?");
		int idProd = input.nextInt();

		listaProd.consultarStockEspecifico(idProd);
	}

	public static void registarPagamento(GereUtilizador listaUtil) {
		System.out.println("Qual o numero da encomenda que pretende pagar?");
		int idEnc = input.nextInt();

		listaUtil.registarPagamento(idEnc);
	}

	public static void imprimirTodasEncomendas(GereUtilizador listaUtil) {
		System.out.println("A imprimir encomendas");
		listaUtil.imprimirTodosEnc();
	}

	public static void consultarHistoricoEspecifico(GereUtilizador listaUtil) {
		System.out.println("Qual o numero de utilizador que pretende consultar?");
		int num = input.nextInt();

		listaUtil.consultarHistorico(num);
	}

	public static void imprimirTodosUtil(GereUtilizador listaUtil) {
		System.out.println("A imprimir todos utilizadores");
		listaUtil.imprimirTodosUtil();
	}

	public static void imprimirUmUtil(GereUtilizador listaUtil) {
		System.out.println("Qual o numero de utilizador que pretende procurar?");
		int num = input.nextInt();

		listaUtil.imprimirUmUtil(num);
	}

	public static void melhorCliente(GereUtilizador listaUtil) {
		listaUtil.melhorCliente();
	}

	public static void registaPrimeiro(GereUtilizador listaUtil) {
		Utilizador novoUtil;
		System.out.println("A registar o primeiro funcionario");

		System.out.println("Qual o numero do Funcionario");
		int num = input.nextInt();

		System.out.println("Qual a password que quer inserir?");
		String password = inputString.next();

		System.out.println("Qual o nome do utilizador?");
		String nome = inputString.next();

		novoUtil = new Utilizador(num, password, nome);

		listaUtil.registarUtilizador(novoUtil);

		System.out.println("Funcionario registado com sucesso");
	}

	public static void registarCliente(GereUtilizador listaUtil) {
		Utilizador novoUtil;

		System.out.println("Qual o numero do utilizador");
		int num = input.nextInt();

		System.out.println("Qual a password que quer inserir?");
		String password = inputString.next();

		System.out.println("Qual o nome do utilizador?");
		String nome = inputString.next();

		System.out.println("1.Cliente\n2.Funcionario");
		int esse = input.nextInt();

		if (esse == 1) {
			novoUtil = new Cliente(num, password, nome);
		} else {
			novoUtil = new Utilizador(num, password, nome);
		}

		listaUtil.registarUtilizador(novoUtil);
	}

	public static void eliminarCliente(GereUtilizador listaUtil) {
		System.out.println("Qual o numero do utilizador que pretende eliminar?");
		int num = input.nextInt();

		listaUtil.eliminarUtilizador(num);
	}

	public static void registarProduto(GereProduto listaProd) {
		Produto novoProd;

		System.out.println("Qual o nome do produto");
		String nome = inputString.next();

		System.out.println("Qual o preco do produto?");
		double preco = input.nextDouble();

		System.out.println("Qual o stock do produto?");
		int stock = input.nextInt();

		System.out.println("Qual a data de validade do produto? Formato AAAA-MM-DDh");
		String dataValidade = inputString.next();
		LocalDate date = LocalDate.parse(dataValidade);

		System.out.println("Qual o tipo de produto? Horticola ou Fruticola");
		String tipo = inputString.next();

		novoProd = new Produto(nome, preco, stock, date, tipo);

		listaProd.registarProduto(novoProd);

		System.out.println("Produto registado com sucesso");

	}

	public static void trataFunc(GereUtilizador listaUtil, GereProduto listaProd) {

		System.out.println("\nLogin\n");

		System.out.println("Qual o numero de utilizador do Funcionario?");
		int numeroUtil = input.nextInt();

		System.out.println("Qual a password?");
		int password = input.nextInt();

		if (listaUtil.verificaLoginFunc(numeroUtil, password) != null) {
			System.out.println("\n");
			System.out.println("---------------------Cliente---------------");
			System.out.println("1. Registar utilizador");
			System.out.println("2. Eliminar utilizador");
			System.out.println("3. Melhor cliente");
			System.out.println("4. Imprimir detalhes de um utilizador");
			System.out.println("5. Imprimir lista de utilizadores");
			System.out.println("6. Imprimir encomendas de um cliente");
			System.out.println("7. Imprimir todas as encomendas");
			System.out.println("8. Registar pagamento");
			System.out.println("-----------------Produto--------------");
			System.out.println("9. Registar produto");
			System.out.println("10. Eliminar produto");
			System.out.println("11. Consultar o stock de todos os produtos");
			System.out.println("12. Consultar o stock de um produto");
			System.out.println("13. Atualizar stock");
			System.out.println("14. Consultar preco de todos os produtos");
			System.out.println("15. Consultar preco de um produto");
			System.out.println("16. Imprimir todos os produtos");
			System.out.println("17. Imprimir um produto");
			System.out.println("18. Produto mais vendido");
			System.out.println("0. Terminar");
			System.out.println("Introduza opção:");
			int op = input.nextInt();

			while (op != 0) {
				switch (op) {
				case 1: {
					Main.registarCliente(listaUtil);
				}
				break;

				case 2: {
					Main.eliminarCliente(listaUtil);
				}
				break;

				case 3: {
					Main.melhorCliente(listaUtil);
				}
				break;

				case 4: {
					Main.imprimirUmUtil(listaUtil);
				}
				break;

				case 5: {
					Main.imprimirTodosUtil(listaUtil);
				}
				break;

				case 6: {
					Main.consultarHistoricoEspecifico(listaUtil);
				}
				break;

				case 7: {
					Main.imprimirTodasEncomendas(listaUtil);
				}
				break;

				case 8: {
					Main.registarPagamento(listaUtil);
				}
				break;

				case 9: {
					Main.registarProduto(listaProd);
				}
				break;

				case 10: {
					Main.eliminarProduto(listaProd);
				}
				break;

				case 11: {
					Main.imprimirTodoStock(listaProd);
				}
				break;

				case 12: {
					Main.consultarStockEspecifico(listaProd);
				}
				break;

				case 13: {
					Main.atualizarStock(listaProd);
				}
				break;

				case 14: {
					Main.imprimirTodoPreco(listaProd);
				}
				break;

				case 15: {
					Main.consultarPrecoEspecifico(listaProd);
				}
				break;

				case 16: {
					Main.imprimirTodosProdutos(listaProd);
				}
				break;

				case 17: {
					Main.pesquisarProduto(listaProd);
				}
				break;

				case 18: {
					// TODO
				}
				break;

				default:
					System.out.println("Escolha uma opcao valida");
				}
				System.out.println("\n");
				System.out.println("---------------------Cliente---------------");
				System.out.println("1. Registar utilizador");
				System.out.println("2. Eliminar utilizador");
				System.out.println("3. Melhor cliente");
				System.out.println("4. Imprimir detalhes de um utilizador");
				System.out.println("5. Imprimir lista de utilizadores");
				System.out.println("6. Imprimir encomendas de um cliente");
				System.out.println("7. Imprimir todas as encomendas");
				System.out.println("8. Registar pagamento");
				System.out.println("-----------------Produto--------------");
				System.out.println("9. Registar produto");
				System.out.println("10. Eliminar produto");
				System.out.println("11. Consultar o stock de todos os produtos");
				System.out.println("12. Consultar o stock de um produto");
				System.out.println("13. Atualizar stock");
				System.out.println("14. Consultar preco de todos os produtos");
				System.out.println("15. Consultar preco de um produto");
				System.out.println("16. Imprimir todos os produtos");
				System.out.println("17. Imprimir um produto");
				System.out.println("18. Produto mais vendido");
				System.out.println("0. Terminar");
				System.out.println("Introduza opção:");
				op = input.nextInt();
			}//fim while
		}
	}
	// FIM FUNCOES FUNCIONARIO

	public static void main(String[] args) {
		GereUtilizador listaUtil = new GereUtilizador();
		GereProduto listaProd = new GereProduto();

		Main.registaPrimeiro(listaUtil);

		System.out.println("1.Cliente\n2.Funcionário\n0. sair");
		int op1 = input.nextInt();

		while (op1 != 0) {
			switch (op1) {
			case 1: {
				Main.trataCliente(listaUtil, listaProd);
			}
			break;

			case 2: {
				Main.trataFunc(listaUtil, listaProd);
			}
			break;

			default: {
				System.out.println("Escolha uma opcao valida");
			}
			}// fim switch

			System.out.println("1.Cliente\n2.Funcionário\n0. sair");
			op1 = input.nextInt();
		} // fim while
	}
}// fim main//fim classe

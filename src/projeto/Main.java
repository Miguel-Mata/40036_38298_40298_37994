/**
 * 
 */
package projeto;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author miguel
 *
 */
public class Main
{
    public static void main(String[] args){
    Scanner input = new Scanner (System.in);
    Scanner inputString = new Scanner(System.in);
    GereUtilizador listaUtil = new GereUtilizador();
    GereProduto listaProd = new GereProduto();
    
    System.out.println("1.Cliente\n2.Funcionário\n3. Registar Utilizador");
    int op1 = input.nextInt();//es gay
    
    while (op1!=0){
        switch(op1){
            case 1:{
            	System.out.println("Qual o numero utilizador?");
            	int numeroUtil = input.nextInt();
            	
            	System.out.println("Qual a password?");
            	int password = input.nextInt();
            	
            	if(listaUtil.pesquisarUtilizador(numeroUtil)!=null) {
            		System.out.println("0. Terminar");
                    System.out.println("1. Realizar Encomenda");
                    System.out.println("2. Consultar estado encomenda");
                    System.out.println("3. Consultar histórico encomendas do cliente");
                    System.out.println("4. Imprimir detalhes do cliente");
                    System.out.println("Introduza opção:");
                    int op;
                    op = input.nextInt();
                    
                    while (op!=0){
                        switch(op){
                            case 1:{
                            	System.out.println("A realizar encomenda");
                            	
                            	Encomenda newEncomenda;
                            	
                            	System.out.println("Quantos produtos diferentes quer");
                            	int prods = input.nextInt();
                            	
                            	for(int i=0; i<prods; i++) {
                            		listaProd.imprimirTodos();
                            		
                            		System.out.println("Qual o ID do produto que quer?");
                            		int id = input.nextInt();
                            		
                            		System.out.println("Qual a quantidade do produto que quer?");
                            		int quant = input.nextInt();
                            		
                            		System.out.println("Qual a data para levantar? Formato AAAA-MM-DD. Minimo 24h");
                            		String data = inputString.next();
                            		LocalDate date = LocalDate.parse(data);
                            		
                            		newEncomenda = new Encomenda()
                            		
                            		listaProd.compararStock(id, quant);
                            		
                            		//listaUtil.realizarEncomenda(, numeroUtil);
                            	}
                            }
                            break;
                            
                            case 2:{
                            	System.out.println();
                            }
                            break;
                            
                            case 3:{
                            	
                            }
                            break;
                            
                            case 4:{
                            	
                            }
                            break;		
                            
            	}
            }}}
            break;
    
            case 2:{
            	System.out.println("0. Terminar");
                System.out.println("1. Eliminar cliente");
                System.out.println("2. Registar produto");
                System.out.println("3. Melhor cliente");
                System.out.println("4. Imprimir detalhes de um cliente");
                System.out.println("5. Imprimir lista de clientes");
                System.out.println("6. Imprimir encomendas de um cliente");
                System.out.println("Introduza opção:");
                int op;
                op = input.nextInt();
                
                while (op!=0)
                {
                    switch(op)
                    {
                        case 1:
                        {
                        	System.out.println("Qual o numero do utilizador que pretende eliminar?");
                        	int num = input.nextInt();
                        	
                        	listaUtil.eliminarUtilizador(num);
                        	
                        	System.out.println("Utilizador eliminado com sucesso");
                        }
                        break;
                        
                        case 2:
                        {
                        	
                        }
                        break;
                        
                        case 3:
                        {
                        	
                        }
                        break;
                        
                        case 4:
                        {
                        	System.out.println("Qual o numero de utilizador que pretende procurar?");
                        	int num = input.nextInt();
                        	
                        	listaUtil.imprimirUm(num);
                        }
                        break;	
                        
                        case 5:
                        {
                        	System.out.println("A imprimir lista de clientes");
                        	listaUtil.imprimirTodos();
                        }break;
                        
                        case 6:
                        {
                        	System.out.println("Qual o numero de utilizador que pretende consultar?");
                        	int num = input.nextInt();
                        	
                        	listaUtil.consultarHistorico(num);
                        }break;
                        
        	}
        }
        break;
            }
            break;
            case 3:{
            	
            	Utilizador novoUtil;
            	
            	System.out.println("Qual o numero do utilizador");
            	int num = input.nextInt();
            	
            	System.out.println("Qual a password que quer inserir?");
            	String password = inputString.next();
            	
            	System.out.println("Qual o nome do utilizador?");
            	String nome = inputString.next();
            	
            	System.out.println("1.Cliente\n2.Funcionario");
            	int esse = input.nextInt();
            	
            	if(esse == 1)
            	{
            		novoUtil = new Cliente(num, password, nome);
            	}
            	else
            	{
            		novoUtil = new Utilizador(num, password, nome);
            	}
            	
            	listaUtil.registarUtilizador(novoUtil);
            	
            	System.out.println("Utilizador registado com sucesso");
            } break;
        }//fim switch
        
        System.out.println("0. Terminar");
        System.out.println("1. Registar eletrodomesticos");
        System.out.println("2. Imprimir todos os eletrodomesticos ");
        System.out.println("3. Imprimir estado e preco de um certo eletrodomestico ");
        System.out.println("4. Valor da compra");
        System.out.println("Introduza opção:");
        
        (op = input.nextInt();
    }//fim while
  }}//fim main//fim classe

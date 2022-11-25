import java.io.IOException;
import java.util.Scanner;
import transporte.Pessoa;
import transporte.Piloto;


public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("\nOpção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }
                //Cadastre seu piloto aqui
                
                 Piloto piloto = new Piloto(); 

                 System.out.println("Informe nome do Piloto");
                 piloto.setNome(in.nextLine());
                 System.out.println("Informe o CPF do Piloto");
                 piloto.setCpf (in.nextLine());
                 System.out.println("Informe matricula do Piloto");
                 piloto.setMatricula (in.nextLine());
                 System.out.println("Informe Breve do Piloto");
                 piloto.setBreve(in.nextLine()); 
                System.out.println("\nPiloto cadastrado com sucesso.");
                
                voltarMenu(in);
                pilotos[qtdCadastrados] = piloto;
                qtdCadastrados++;

                System.out.println("quantidade de Cadastros: " +qtdCadastrados);
                

            

            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há Pilotos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui                
                System.out.println("\n*******************\nLISTAGEM DE PILOTOS\n*******************\n");
                for (Pessoa piloto : pilotos)
                    if(piloto!=null){
                    
                    System.out.println("Nome: " + piloto.getNome());
                    System.out.println("Cpf: " + piloto.getCpf());
                    System.out.println("Matricula: " + piloto.getMatricula());
                    System.out.println("Breve: " + piloto.getBreve());
                    System.out.println("===================================");
                                   
                }   
                    System.out.println("Quantidade de cadastrados: " +qtdCadastrados);
                voltarMenu(in);


                } else if (opcao == 3) {
                    
                    if(qtdCadastrados==0){
                        System.out.println("\nNão há Cadastros ");
                        continue;
                        }
                                            
                    System.out.println("\n*************\nINFORME O CPF\n*************\n");
                    String cpf= in.nextLine();
    
                    for(int i = 0; i <qtdCadastrados; i++){
                        if(cpf.equals(pilotos[i].getCpf())){
                            System.out.println("\nNome do Piloto Localizado => " +pilotos[i].getNome());
                            
                        }else{    
                        System.out.println("Dados não encontrado, tente novamente! ");
                        
                        }
                    }
    
                    voltarMenu(in);

    
                } else if (opcao == 4) {
                
                }
                else if (opcao != 0) {
                    System.out.println("\nOpção inválida!");
                }            
            } while (opcao != 0);
    
            System.out.println("Fim do programa!");
    
            in.close();
        }
    
        private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
            System.out.println("\nPressione ENTER para voltar ao menu.");
            in.nextLine();
    
            // Limpa toda a tela, deixando novamente apenas o menu
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                System.out.print("\033[H\033[2J");
            
            System.out.flush();
        }
    }
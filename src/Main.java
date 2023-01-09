import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Cadastro cadastro = new Cadastro();
    public static void main(String[] args) {

        int opcao = 0;
        boolean sair = false;

        menu();

        while(!sair){
            System.out.println("Digite sua opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){
                case 0:
                    sair = true;
                    break;

                case 1:
                    cadastrar();
                    break;

                case 2:
                    cadastro.listarFuncionarios();
                    break;

                case 3:
                    cadastro.ordenarPorSalario();
                    break;

                case 4:
                    cadastro.consultarFolha();
                    break;

                case 5:
                    menu();
                    break;
            }
        }

    }

    public static void cadastrar(){
        System.out.println("Nome: ");
        String nome = sc.nextLine();

        System.out.println("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Salário: ");
        double salario = sc.nextDouble();

        cadastro.cadastrarFuncionario(nome, id, salario);
    }

    public static void menu(){
        System.out.println("Pressione: \n" +
                "0 - para parar\n" +
                "1 - para cadastrar funcionário\n" +
                "2 - para listar funcionários\n" +
                "3 - para listar funcionários por ordem de salário\n" +
                "4 - para consultar folha de pagamento\n" +
                "5 - para ver opções");
    }


}
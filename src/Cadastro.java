import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cadastro{

    private List<Funcionario> funcionarios = new ArrayList<>();

    static final Comparator<Funcionario> ORDENAR_POR_SALARIO = new Comparator<Funcionario>() {
        @Override
        public int compare(Funcionario f1, Funcionario f2) {
            if(f1.getSalario() > f2.getSalario()){
                return -1;
            }else if(f2.getSalario() > f1.getSalario()){
                return 1;
            }else{
                return 0;
            }
        }
    };

    static final Comparator<Funcionario> ORDERNAR_POR_ID = new Comparator<Funcionario>() {
        @Override
        public int compare(Funcionario f1, Funcionario f2) {
            if(f1.getId() > f2.getId()){
                return 1;
            }else if(f2.getId() > f1.getId()){
                return -1;
            }else{
                return 0;
            }
        }
    };

    public Cadastro() {
        this.funcionarios = new ArrayList<>();
    }

    public List<Funcionario> getFuncionarios() {
        return new ArrayList<>(funcionarios);
    }

    public boolean cadastrarFuncionario(String nome, int id, double salario){
        Funcionario funcionario = procuraFuncionario(id);
        if(funcionario == null){
            this.funcionarios.add(new Funcionario(nome, id, salario));
            System.out.println("Funcionário cadastrado com sucesso");
            System.out.println("Funcionário: " + nome + ". ID: " + id + ". Salário atual: " + salario);
            return true;
        }else{
            System.out.println("Já existe um funcionário com a id: " + id);
            return false;
        }
    }

    public void listarFuncionarios(){
        Collections.sort(this.funcionarios, ORDERNAR_POR_ID);
        for(int i=0; i<this.funcionarios.size(); i++){
            Funcionario funcionario = this.funcionarios.get(i);
            System.out.println("Nome: " + funcionario.getNome() + ". ID: " + funcionario.getId() + ". Salário: " + funcionario.getSalario());
        }
    }

    public void consultarFolha(){
        int valorTotal = 0;
        Collections.sort(this.funcionarios, ORDERNAR_POR_ID);
        for(int i=0; i<this.funcionarios.size(); i++){
            Funcionario funcionario = this.funcionarios.get(i);
            System.out.println("Nome: " + funcionario.getNome() + ". ID: " + funcionario.getId() + ". Salário: " + funcionario.getSalario());
            valorTotal += funcionario.getSalario();
        }
        System.out.println("Valor da folha de pagamento: " + valorTotal);
    }

    public void ordenarPorSalario(){
        Collections.sort(this.funcionarios, ORDENAR_POR_SALARIO);
        for(int i=0; i<this.funcionarios.size(); i++){
            Funcionario funcionario = this.funcionarios.get(i);
            System.out.println("Nome: " + funcionario.getNome() + ". ID: " + funcionario.getId() + ". Salário: " + funcionario.getSalario());
        }
    }

    private Funcionario procuraFuncionario(int idDoFuncionario){
        for(int i=0; i<this.funcionarios.size(); i++){
            Funcionario funcionario = this.funcionarios.get(i);
            String id = Integer.toString(funcionario.getId());
            if(id.equals(Integer.toString(idDoFuncionario))){
                return funcionario;
            }
        }
        return null;
    }

    public class Funcionario {
        private final String nome;
        private int id = 0;
        private double salario;
        public Funcionario(String nome,int id, double salario) {
            this.nome = nome;
            this.id = id;
            this.salario = salario;
        }

        public String getNome() {
            return nome;
        }

        public int getId() {
            return id;
        }

        public double getSalario() {
            return salario;
        }
    }
}

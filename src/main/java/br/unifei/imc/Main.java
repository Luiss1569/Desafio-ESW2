package br.unifei.imc;

import br.unifei.imc.model.Aluno;
import br.unifei.imc.model.Grupo;
import br.unifei.imc.model.Menu;
import br.unifei.imc.utils.CsvFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Aluno> alunos;
        List<Grupo> grupos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao Sistema de gerenciador de grupos");

        System.out.println("Lista de alunos importada com sucesso!");

        Path path = Paths.get("./teste.csv");
        alunos = CsvFile.readFile(path);

        do{
            System.out.println("-------------------------\n");
            System.out.println("1- Listar lista de alunos");
            System.out.println("2- Listar lista de grupos");
            System.out.println("3- Criar grupo");
            System.out.println("4- Exportar dados no arquivo");
            System.out.println("-------------------------\n");

            System.out.println("Selecione uma opção:");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Listar lista de alunos");
                    Aluno.listStudents(alunos);
                    break;
                case 2:
                    System.out.println("Listar lista de grupos");
                    Grupo.listGroups(grupos);
                    break;
                case 3:
                    System.out.println("Criar grupo");
                    var grupo = new Grupo(grupos.size()+1);
                    String matricula;
                    do{
                        System.out.println("Digite a matricula do aluno:");
                        matricula = scanner.nextLine();
                        if(matricula.equals("0")){
                            break;
                        }
                        Menu.criarGrupoHandler(alunos, grupos, grupo, matricula);
                    } while ( matricula != "0" );
                    System.out.println("Digite a nota do grupo:");
                    grupo.setNota(Double.valueOf(scanner.nextLine()));
                    grupos.add(grupo);
                    break;
                case 4:
                    System.out.println("Exportar dados no arquivo");
                    CsvFile.createFile(Grupo.convertGrouposAlunos(grupos));
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (true);

    }
}

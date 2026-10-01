/**
 * Classe principal de execução (ponto de entrada) do projeto Batalha Naval dos Descobrimentos.
 * Permite selecionar e executar as diferentes tarefas laboratoriais do programa.
 * 
 * @author LETI-129793
 * @version 1.0
 */
package iscteiul.ista;

import iscteiul.ista.battleship.Fleet;
import iscteiul.ista.battleship.Tasks;

public class App
{
    /**
     * Ponto de entrada principal da aplicação.
     * 
     * @argument args argumentos passados por linha de comandos
     */
    public static void main( String[] args )
    {

        System.out.printf("\n***  Battleship Game ***\n");

        // Tasks.taskA();
        Tasks.taskB();
        //    Tasks.taskC();
        //    Tasks.taskD();
    }
}

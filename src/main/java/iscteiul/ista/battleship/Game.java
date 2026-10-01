/**
 * Classe que implementa a interface IGame, gerindo o estado global de uma partida 
 * de Batalha Naval, o registo de disparos, validações, contadores de estatísticas e visualização dos tabuleiros.
 * 
 * @author LETI-129793
 * @version 1.0
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {
    private IFleet fleet;
    private List<IPosition> shots;

    private Integer countInvalidShots;
    private Integer countRepeatedShots;
    private Integer countHits;
    private Integer countSinks;


    /**
     * Constrói uma nova instância de jogo associada a uma frota de navios.
     * Inicializa a lista de tiros e zera os contadores de estatísticas.
     * 
     * @param fleet a frota de navios do jogo
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        this.fleet = fleet;
        this.countHits = 0;
        this.countSinks = 0;
    }

    /**
     * Efetua um disparo numa determinada posição do tabuleiro, validando se é um tiro válido,
     * se já foi repetido e atualizando as estatísticas de acertos e afundamentos.
     * 
     * @param pos a posição onde vai ser efetuado o disparo
     * @return o navio que foi totalmente afundado com este tiro, ou null caso contrário
     */
    @Override
    public IShip fire(IPosition pos) {
        if (!validShot(pos))
            countInvalidShots++;
        else { // valid shot!
            if (repeatedShot(pos))
                countRepeatedShots++;
            else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);
                if (s != null) {
                    s.shoot(pos);
                    countHits++;
                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Retorna a lista de todas as posições onde foram efetuados tiros válidos.
     * 
     * @return lista com as posições dos tiros efetuados
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * Retorna o número total de tiros repetidos efetuados na partida.
     * 
     * @return quantidade de tiros repetidos
     */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /**
     * Retorna o número total de tiros inválidos (fora dos limites) efetuados.
     * 
     * @return quantidade de tiros inválidos
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**
     * Retorna o número total de acertos registados em navios.
     * 
     * @return quantidade de acertos
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /**
     * Retorna o número total de navios que já foram totalmente afundados.
     * 
     * @return quantidade de navios afundados
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**
     * Retorna o número de navios que ainda se encontram a flutuar na frota.
     * 
     * @return quantidade de navios restantes ativos
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    /**
     * Verifica se uma determinada posição se encontra dentro dos limites válidos do tabuleiro.
     * 
     * @param pos a posição a validar
     * @return true se estiver dentro dos limites, false caso contrário
     */
    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 && pos.getRow() <= Fleet.BOARD_SIZE && pos.getColumn() >= 0
                && pos.getColumn() <= Fleet.BOARD_SIZE);
    }

    /**
     * Verifica se uma posição já foi alvo de um tiro anterior.
     * 
     * @param pos a posição a verificar
     * @return true se o tiro já tiver sido efetuado antes, false caso contrário
     */
    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;
        return false;
    }


    /**
     * Imprime no terminal o tabuleiro com base num conjunto de posições e num marcador específico.
     * 
     * @param positions a lista de posições a marcar no tabuleiro
     * @param marker o caractere utilizado para representar as posições
     */
    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);
            System.out.println();
        }

    }


    /**
     * Imprime o tabuleiro mostrando todos os tiros válidos que já foram efetuados ('X').
     */
    @Override
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }


    /**
     * Imprime o tabuleiro mostrando a posição atual de toda a frota de navios ('#').
     */
    @Override
    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }

}

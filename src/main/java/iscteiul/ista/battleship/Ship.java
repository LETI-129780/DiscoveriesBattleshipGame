/**
 * Classe abstrata que implementa a interface IShip, servindo de base 
 * para todos os tipos de navios do jogo Batalha Naval dos Descobrimentos.
 * 
 * @author LETI-129780
 * @version 1.0
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Ship implements IShip {

    private static final String GALEAO = "galeao";
    private static final String FRAGATA = "fragata";
    private static final String NAU = "nau";
    private static final String CARAVELA = "caravela";
    private static final String BARCA = "barca";

    /**
     * Fábrica de navios que instancia o tipo correto de navio com base na string fornecida.
     * 
     * @param shipKind o tipo/categoria do navio em formato de texto
     * @param bearing a orientação (bússola) do navio
     * @param pos a posição inicial do navio
     * @return uma instância concreta de Ship, ou null se a categoria for inválida
     */
    static Ship buildShip(String shipKind, Compass bearing, Position pos) {
        Ship s;
        switch (shipKind) {
            case BARCA:
                s = new Barge(bearing, pos);
                break;
            case CARAVELA:
                s = new Caravel(bearing, pos);
                break;
            case NAU:
                s = new Carrack(bearing, pos);
                break;
            case FRAGATA:
                s = new Frigate(bearing, pos);
                break;
            case GALEAO:
                s = new Galleon(bearing, pos);
                break;
            default:
                s = null;
        }
        return s;
    }


    private String category;
    private Compass bearing;
    private IPosition pos;
    protected List<IPosition> positions;


    /**
     * Constrói um navio com a categoria, orientação e posição inicial especificadas.
     * 
     * @param category a categoria do navio
     * @param bearing a orientação do navio
     * @param pos a posição inicial
     */
    public Ship(String category, Compass bearing, IPosition pos) {
        assert bearing != null;
        assert pos != null;

        this.category = category;
        this.bearing = bearing;
        this.pos = pos;
        positions = new ArrayList<>();
    }

    /**
     * Retorna a categoria do navio.
     * 
     * @return a categoria do navio
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Retorna a lista de todas as posições ocupadas pelo navio.
     * 
     * @return lista de posições
     */
    public List<IPosition> getPositions() {
        return positions;
    }

    /**
     * Retorna a posição inicial do navio.
     * 
     * @return a posição inicial
     */
    @Override
    public IPosition getPosition() {
        return pos;
    }

    /**
     * Retorna a orientação do navio.
     * 
     * @return a bússola/orientação
     */
    @Override
    public Compass getBearing() {
        return bearing;
    }

    /**
     * Verifica se o navio ainda se encontra a flutuar (possui partes não atingidas).
     * 
     * @return true se ainda tiver partes a flutuar, false caso contrário
     */
    @Override
    public boolean stillFloating() {
        for (int i = 0; i < getSize(); i++)
            if (!getPositions().get(i).isHit())
                return true;
        return false;
    }

    /**
     * Retorna a coordenada da linha mais acima ocupada pelo navio.
     * 
     * @return índice da linha superior
     */
    @Override
    public int getTopMostPos() {
        int top = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() < top)
                top = getPositions().get(i).getRow();
        return top;
    }

    /**
     * Retorna a coordenada da linha mais abaixo ocupada pelo navio.
     * 
     * @return índice da linha inferior
     */
    @Override
    public int getBottomMostPos() {
        int bottom = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() > bottom)
                bottom = getPositions().get(i).getRow();
        return bottom;
    }

    /**
     * Retorna a coordenada da coluna mais à esquerda ocupada pelo navio.
     * 
     * @return índice da coluna mais à esquerda
     */
    @Override
    public int getLeftMostPos() {
        int left = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() < left)
                left = getPositions().get(i).getColumn();
        return left;
    }

    /**
     * Retorna a coordenada da coluna mais à direita ocupada pelo navio.
     * 
     * @return índice da coluna mais à direita
     */
    @Override
    public int getRightMostPos() {
        int right = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() > right)
                right = getPositions().get(i).getColumn();
        return right;
    }

    /**
     * Verifica se o navio ocupa uma determinada posição.
     * 
     * @param pos a posição a verificar
     * @return true se ocupar essa posição, false caso contrário
     */
    @Override
    public boolean occupies(IPosition pos) {
        assert pos != null;

        for (int i = 0; i < getSize(); i++)
            if (getPositions().get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Verifica se este navio está demasiado próximo de outro navio.
     * 
     * @param other o outro navio a verificar
     * @return true se estiver demasiado próximo, false caso contrário
     */
    @Override
    public boolean tooCloseTo(IShip other) {
        assert other != null;

        Iterator<IPosition> otherPos = other.getPositions().iterator();
        while (otherPos.hasNext())
            if (tooCloseTo(otherPos.next()))
                return true;

        return false;
    }

    /**
     * Verifica se este navio está demasiado próximo de uma posição específica.
     * 
     * @param pos a posição a verificar
     * @return true se estiver demasiado próximo, false caso contrário
     */
    @Override
    public boolean tooCloseTo(IPosition pos) {
        for (int i = 0; i < this.getSize(); i++)
            if (getPositions().get(i).isAdjacentTo(pos))
                return true;
        return false;
    }

    /**
     * Regista um tiro numa posição do navio, atualizando o seu estado se corresponder.
     * 
     * @param pos a posição atingida
     */
    @Override
    public void shoot(IPosition pos) {
        assert pos != null;

        for (IPosition position : getPositions()) {
            if (position.equals(pos))
                position.shoot();
        }
    }

    /**
     * Retorna uma representação em texto do navio (categoria, orientação e posição).
     * 
     * @return string formatada com os dados do navio
     */
    @Override
    public String toString() {
        return "[" + category + " " + bearing + " " + pos + "]";
    }

}

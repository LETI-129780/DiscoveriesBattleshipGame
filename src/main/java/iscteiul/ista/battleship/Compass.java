/**
 * Enumeração que representa os pontos cardeais (orientações) possíveis 
 * para os navios no jogo Batalha Naval (Norte, Sul, Este, Oeste e Desconhecido).
 * 
 * @author LETI-129793
 * @version 1.0
 */
package iscteiul.ista.battleship;

public enum Compass {
    /** Orientação Norte ('n'). */
    NORTH('n'), 
    /** Orientação Sul ('s'). */
    SOUTH('s'), 
    /** Orientação Este ('e'). */
    EAST('e'), 
    /** Orientação Oeste ('o'). */
    WEST('o'), 
    /** Orientação Desconhecida ou inválida ('u'). */
    UNKNOWN('u');

    private final char c;

    /**
     * Constrói uma direção do compasso associada a um caractere.
     * 
     * @param c o caractere representativo da direção
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Retorna o caractere correspondente à direção.
     * 
     * @return o caractere da direção
     */
    public char getDirection() {
        return c;
    }

    /**
     * Retorna a representação em texto da direção em formato de caractere.
     * 
     * @return string com o caractere da direção
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converte um caractere num respetivo objeto Compass.
     * 
     * @param ch o caractere a converter ('n', 's', 'e', 'o')
     * @return a direção correspondente do Compass, ou UNKNOWN se o caractere for inválido
     */
    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}

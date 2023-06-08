import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card {
    private String suit;
    private String color;
    private String value;

    public Card(String suit, String color, String value) {
        this.suit = suit;
        this.color = color;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return  "suit:" + suit +
                ", color=" + color +
                ", value=" + value ;
    }
}

class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        configureDeck();
    }

    private void configureDeck() {
        String[] suits = {"Corazones", "Diamantes", "Treboles", "Picas"};
        String[] colors = {"Rojo", "Rojo", "Negro", "Negro"};
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (int i = 0; i < suits.length; i++) {
            String suit = suits[i];
            String color = colors[i];
            for (String value : values) {
                Card card = new Card(suit, color, value);
                cards.add(card);
            }
        }
    }



    public void shuffle() {
        Random aleatorio = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = aleatorio.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (cards.isEmpty()) {
            System.out.println("Ya no hay cartas disponibles");
        } else {
            Card firstCard = cards.remove(0);
            System.out.println("La primera carta es: " + firstCard);
            System.out.println("Quedan: " + cards.size() + " cartas en deck");
        }
    }

    public Card pick() {
        if (cards.isEmpty()) {
            System.out.println("Ya no hay cartas disponibles");
            return null;
        } else {
            Random aleatorio = new Random();
            int randomIndex = aleatorio.nextInt(cards.size());
            Card randomCard = cards.get(randomIndex);
            cards.remove(randomIndex);
            System.out.println("La carta al azar elegida es: " + randomCard);
            System.out.println("Quedan: " + cards.size() + " cartas en deck");
            return randomCard;
        }
    }

    public void hand(int numCards) {
        if (numCards > cards.size()) {
            System.out.println("Ya no hay cartas disponibles");
            return;
        }

        Random aleatorio = new Random();
        System.out.println("Se seleccionaron: " + numCards + " cartas");
        for (int i = 0; i < numCards; i++) {
            int randomIndex = aleatorio.nextInt(cards.size());
            Card randomCard = cards.get(randomIndex);
            cards.remove(randomIndex);
            System.out.println("Card " + (i + 1) + ": " + randomCard);
        }
        System.out.println("Quedan: " + cards.size() + " cartas en deck");
    }
}

public class PokerHandSimulator {
    public static void main(String[] args) {
        Deck baraja = new Deck();

        // Actividad 1: Mezclar la baraja
        baraja.shuffle();

        // Actividad 2: Mostrar la primera carta del deck
        baraja.head();

        // Actividad 3: Seleccionar una carta al azar
        baraja.pick();

        // Activity 4: Seleccionar una mano de poker (5 cartas)
        baraja.hand(5);
    }
}
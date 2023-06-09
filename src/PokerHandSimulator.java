import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//La clase Card contiene 3 atributos suit para trebol, color para rojo, value para 3
class Card {
    private String suit;
    private String color;
    private String value;

    // Este es un constructor para referenciar las 3 variables o atributos
    public Card(String suit, String color, String value) {
        this.suit = suit;
        this.color = color;
        this.value = value;
    }

   //toString nos ayuda a que se cree una carta con las 3 variables
    public String toString() {
        return  "suit=" + suit +
                ", color=" + color +
                ", value=" + value ;
    }
}
// en la clase Deck se crea un Arraylist para crear las 52 cartas
class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        configureDeck();
    }

    /* en configureDeck se crean 3 strings arrays en los que se le explica cuales son los strings para cada una
    de las variables suits, colors y values
     */
    private void configureDeck() {
        String[] suits = {"Corazones", "Diamantes", "Treboles", "Picas"};
        String[] colors = {"Rojo", "Rojo", "Negro", "Negro"};
        String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        /* en este ciclo for se configura para que se genere un color y un suit para todos los valores en value
        y se crea una carta con ellos
         */
        for (int i = 0; i < suits.length; i++) {
            String suit = suits[i];
            String color = colors[i];
            for (String value : values) {
                Card carta = new Card(suit, color, value);
                cards.add(carta);
            }
        }
    }

    /* En el metodo shuffle se crea un objeto random
    aleatorion.nextInt genera un indice integer random
    Card temp nos sirve para almacenar la carta obtenida
    */
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

    /* la clase head con el if-else nos ayuda a generar la primera carta del deck
    la parte del if, está configurada por si ya no hay cartas disponibles arroje un mensaje
    firstCard obtiene la carta en el index 0, que es la primera
    cards.remove la remueve del deck
     */
    public void head() {
        if (cards.isEmpty()) {
            System.out.println("Ya no hay cartas disponibles");
        } else {
            Card firstCard = cards.remove(0);
            System.out.println("La primera carta es: " + firstCard);
            System.out.println("Quedan: " + cards.size() + " cartas en deck");
        }
    }

    /*
    la clase pick selecciona una carta al azar
    la parte del if, está configurada por si ya no hay cartas disponibles arroje un mensaje
    la parte else con aleatorio genera un objeto random
    randomCard obtiene la carta que corresponde al index obtenido de manera random
    cards.remove elimina esa carta del deck
     */
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

    /*
    la clase hand selecciona el numero de cartas en "numCards" que se configuro en 5
    la parte del if, está configurada por si ya no hay cartas disponibles arroje un mensaje
    */
    public void hand(int numCards) {
        if (numCards > cards.size()) {
            System.out.println("Ya no hay cartas disponibles");
            return;
        }

        Random aleatorio = new Random();
        System.out.println("Se seleccionaron: " + numCards + " cartas");
        for (int i = 0; i < numCards; i++) {
            //genera un index aleatorio a partir del cual se van a seleccionar las cartas
            int randomIndex = aleatorio.nextInt(cards.size());
            Card randomCard = cards.get(randomIndex);
            //// elimina las cartas seleccionadas del deck
            cards.remove(randomIndex);
            System.out.println("Card " + (i + 1) + ": " + randomCard);
        }
        System.out.println("Quedan: " + cards.size() + " cartas en deck");
    }
}

// al usar public static void main este es el entry point del programa
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
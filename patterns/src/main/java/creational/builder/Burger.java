package creational.builder;

public class Burger {

    private int size;

    private boolean cheese;
    private boolean pepperoni;
    private boolean lettuce;
    private boolean tomato;

    Burger () {
    }

    public static BurgerBuilder createBurgerBuilder(){
        return new BurgerBuilder ();
    }

    @Override
    public String toString () {
        return "Burger{" +
                "size=" + size +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", lettuce=" + lettuce +
                ", tomato=" + tomato +
                '}';
    }

    public static class BurgerBuilder{

        private final Burger burger;

        BurgerBuilder () {
            this.burger = new Burger ();
        }

        public BurgerBuilder withSize(int size){
            burger.size = size;
            return this;
        }

        public BurgerBuilder withCheese(boolean cheese){
            burger.cheese = cheese;
            return this;
        }


        public BurgerBuilder withPepperoni(boolean pepperoni){
            burger.pepperoni = pepperoni;
            return this;
        }

        public BurgerBuilder withLettuce(boolean lettuce){
            burger.lettuce = lettuce;
            return this;
        }


        public BurgerBuilder withTomato(boolean tomato){
            burger.tomato = tomato;
            return this;
        }

        public Burger build(){
            return this.burger;
        }

    }
}

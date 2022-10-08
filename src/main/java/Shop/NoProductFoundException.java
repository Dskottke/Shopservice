package Shop;

public class NoProductFoundException extends RuntimeException{

    public NoProductFoundException() {

        super("found no product with this id ");
    }

}

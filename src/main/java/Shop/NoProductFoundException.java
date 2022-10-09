package Shop;

public class NoProductFoundException extends RuntimeException{

    //Exception for no match with id
    public NoProductFoundException() {

        super("found no product with this id ");
    }

}

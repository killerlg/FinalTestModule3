package Function;

public class NotFoundProductException extends Throwable {
    public NotFoundProductException() {
        System.out.println("Khong tim thay ID!");
    }
}

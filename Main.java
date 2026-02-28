public class Main {
    public static void main(String[] args) {
        ErrorLogBuffer buf = new ErrorLogBuffer();
        buf.addError("First error");
        buf.addError("Second error");
        buf.addError("Third error");
        System.out.println(buf.getSequentialLog());
    }
}
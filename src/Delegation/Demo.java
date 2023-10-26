package Delegation;

public class Demo {
    public static void main(String[] args)  {
        String MESSAGE_TO_PRINT = "hello world";

        PrinterController hpPrinterController = new PrinterController(new HpPrinter());
        PrinterController canonPrinterController = new PrinterController(new CanonPrinter());

        hpPrinterController.print(MESSAGE_TO_PRINT);
        canonPrinterController.print(MESSAGE_TO_PRINT);
    }
}

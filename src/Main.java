public class Main {

    public static void main(String[] args) {
        System.out.println("Kontroler kodu kreskowego EAN-8 / EAN-13");
        BarcodeController barcode;
        barcode = new BarcodeController(new UserBarcodeInput(), new BarcodeChecker());
        if (barcode.analyzeBarcode(new UserBarcodeInput())) {
            System.out.print(barcode.returnCorrectBarcode(barcode.barcode, barcode.barcodeType));
            System.out.print(" - Poprawny kod kreskowy bez addon.");
        } else {
            System.out.println("Zły kod kreskowy lub typ !");
        }
    }
}
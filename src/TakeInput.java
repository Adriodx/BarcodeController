import java.util.Scanner;

public class TakeInput implements BarcodeScannerInput {
    private String barcode;
    private int barcodeType;

    public String getBarcode() {
        System.out.println(" Podaj kod kreskowy: ");
        Scanner code = new Scanner(System.in);
        barcode = code.nextLine();
        return barcode;
    }

    public int getBarcodeType() {
        System.out.println(" Podaj typ kodu kreskowego (1)- Ean8 lub (2) - EAN13: ");
        Scanner type = new Scanner(System.in);
        barcodeType = type.nextInt();
        return barcodeType;
    }
}
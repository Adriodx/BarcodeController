

public class TakeInputTest implements BarcodeScannerInput {
    private final String barcode;
    private final int barcodeType;

    public TakeInputTest(String givenBarcode, int givenBarcodeType) {
        barcode = givenBarcode;
        barcodeType = givenBarcodeType;
    }

    public String getBarcode() {
        return barcode;
    }


    public int getBarcodeType() {
        return barcodeType;
    }
}
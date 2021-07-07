

public class TestBarcodeInput implements BarcodeInputInterface {
    private String barcode;
    private int barcodeType;

    public TestBarcodeInput(String givenBarcode, int givenBarcodeType) {
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

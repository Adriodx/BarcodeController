
public class BarcodeController {
    protected BarcodeInputInterface input;
    protected String barcode;
    protected int barcodeType;
    private final BarcodeChecker checker;


    public BarcodeController(BarcodeInputInterface input, BarcodeChecker checker) {
        this.checker = checker;
        this.input = input;
    }

    public boolean analyzeBarcode(BarcodeInputInterface input) {
        barcode = this.input.getBarcode();
        barcodeType = this.input.getBarcodeType();
        try{
            this.checker.isNumeric(barcode);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return false;
        }

        try {
            this.checker.checkZeroTruncation(barcode);
        } catch (ZeroException e) {
            barcode = '0' + barcode;
        }
        try {
            if (this.checker.checkBarcodeLength(barcode, barcodeType))
                return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String returnCorrectBarcode(String givenBarcode, int givenBarcodeType) {
        char[] barcodeToAnalyze = givenBarcode.toCharArray();
        int givenBarcodeLength = givenBarcode.length();
        char[] entireBarcode = new char[givenBarcodeLength];
        StringBuilder correctBarcode = new StringBuilder();
        if (givenBarcodeType == BarcodeChecker.EAN8_TYPE)
            for (int i = 0; i < BarcodeChecker.EAN8_LENGTH; i++) {
                entireBarcode[i] = barcodeToAnalyze[i];
                correctBarcode.append(entireBarcode[i]);
            }
        else if (givenBarcodeType == BarcodeChecker.EAN13_TYPE)
            for (int i = 0; i < BarcodeChecker.EAN13_LENGTH; i++) {
                entireBarcode[i] = barcodeToAnalyze[i];
                correctBarcode.append(entireBarcode[i]);
            }
        return correctBarcode.toString();
    }
}

public class BarcodeChecker {
    public static final int EAN8_TYPE = 1;
    public static final int EAN13_TYPE = 2;
    public static final int EAN8_LENGTH = 8;
    public static final int EAN13_LENGTH = 13;
    private final int EAN8_ADDON2_LENGTH = 10;
    private final int EAN8_ADDON5_LENGTH = 13;
    private final int EAN13_ADDON2_LENGTH = 15;
    private final int EAN13_ADDON5_LENGTH = 18;
    private int barcodeLength;

    public void isNumeric(String barcode)throws NumberFormatException
    {
        for (int i = 0; i < barcode.length(); i++) {
            if (!Character.isDigit(barcode.charAt(i))) {
                throw new NumberFormatException(" Kod kreskowy może być tylko jako ciąg liczb! ");
            }
        }
    }

    public boolean checkBarcodeLength(String givenBarcode, int givenBarcodeType) throws IllegalArgumentException {
        barcodeLength = givenBarcode.length();

        if ((givenBarcodeType != EAN8_TYPE) && (givenBarcodeType != EAN13_TYPE))
            throw new IllegalArgumentException("Niepoprawny typ kodu kreskowego! Wybierz typ kodu EAN8 (1) lub EAN 13 (2)!");
        else if ((givenBarcodeType == EAN8_TYPE) && (barcodeLength < EAN8_LENGTH))
            throw new IllegalArgumentException(" Niepoprawna długość kodu kreskowego dla typu EAN-8! ");
        else if ((givenBarcodeType == EAN13_TYPE) && (barcodeLength < EAN13_LENGTH))
            throw new IllegalArgumentException(" Niepoprawna długość kodu kreskowego dla typu EAN-13! ");
        else if ((givenBarcodeType == EAN8_TYPE) && ((barcodeLength != EAN8_LENGTH) && (barcodeLength != EAN8_ADDON2_LENGTH) && (barcodeLength != EAN8_ADDON5_LENGTH)))
            throw new IllegalArgumentException(" Niepoprawna długość kodu kreskowego dla typu EAN-8! ");
        else if ((givenBarcodeType == EAN13_TYPE)
                && ((barcodeLength != EAN13_LENGTH) && (barcodeLength != EAN13_ADDON2_LENGTH) && (barcodeLength != EAN13_ADDON5_LENGTH)))
            throw new IllegalArgumentException(" Niepoprawna długość kodu kreskowego dla typu EAN-13! ");
        else
            return true;
    }

    public void checkZeroTruncation(String givenBarcode) throws ZeroException {
        final int CHECKED_LENGTHS = 5;
        barcodeLength = givenBarcode.length();
        char firstCharacter = givenBarcode.charAt(0);
        int[] truncationLengths = {7, 9, 12, 14, 17};
        for (int i = 0; i < CHECKED_LENGTHS; i++) {
            if ((firstCharacter == '0') && (barcodeLength == truncationLengths[i])) {
                throw new ZeroException(" Program odciął wiodące zero w kodzie kreskowym.");
            }
        }
    }
}

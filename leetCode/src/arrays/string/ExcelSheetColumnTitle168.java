package arrays.string;

public class ExcelSheetColumnTitle168 {


    public String convertToTitle(int columnNumber) {
        StringBuilder columTitle = new StringBuilder();
        int base = 26;
        while (columnNumber > 0){
            columnNumber--;
            columTitle.append((char) ((columnNumber) % base + 'A'));
            columnNumber /= base;
        }
        return columTitle.reverse().toString();
    }
}

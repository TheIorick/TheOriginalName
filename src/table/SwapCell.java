package table;

public class SwapCell {
    public void swapRow(int rowNumber1, int rowNumber2, Sheet sheet){
        if (rowNumber2 == rowNumber1){
            return;
        }
        int lowerRowNumber = Math.min(rowNumber1, rowNumber2);
        int topRowNumber = Math.max(rowNumber1, rowNumber2);
        Sheet.TableCell cell;
        for (int i = 1; i <= sheet.getLengthRow(); i++){
            cell = sheet.searchCell(lowerRowNumber, i);
            sheet.updateCell(lowerRowNumber, i, sheet.searchCell(topRowNumber, i));
            sheet.updateCell(topRowNumber, i, cell);
        }
    }
    public void swapColumn(int columnNumber1, int columnNumber2, Sheet sheet){
        if (columnNumber2 == columnNumber1){
            return;
        }
        int lowerColumnNumber = Math.min(columnNumber1, columnNumber2);
        int topColumnNumber = Math.max(columnNumber1, columnNumber2);
        Sheet.TableCell cell;
        for (int i = 1; i <= sheet.getDepthColumn(); i++){
            cell = sheet.searchCell(i, lowerColumnNumber);
            sheet.updateCell(i, lowerColumnNumber, sheet.searchCell(topColumnNumber, i));
            sheet.updateCell(i, topColumnNumber, cell);
        }
    }
}

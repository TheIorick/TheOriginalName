import table.Sheet;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Sheet.TableCell>> rows = new ArrayList<>();
        ArrayList<Sheet.TableCell> columns1 = new ArrayList<>();
        Sheet.TableCell cell = new Sheet.TableCell("dasfda");
        columns1.add(cell);
        columns1.add(cell);
        columns1.add(cell);
        ArrayList<Sheet.TableCell> columns2 = new ArrayList<>();
        columns2.add(cell);
        columns2.add(cell);
        columns2.add(cell);
        rows.add(columns1);
        rows.add(columns2);
        int lengthRow = 3;
        int depthColumn = 2;

        Sheet sheet = new Sheet(rows, lengthRow, depthColumn);
        sheet.addColumn(rows);
        sheet.addRow(rows);
        sheet.addRowOnNumber(rows,  6);
        sheet.getRows().set(4, columns2);
        sheet.searchCell(rows, 3, 4);
        LocalDate date = LocalDate.of(2021, 5, 12);
        sheet.setValueInCell(rows, 3, 4, date);
        System.out.println(sheet.getValueFromCell(rows, 3, 4));
    }
}
package table;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class OutputConsole {
    private Sheet sheet;


    public List<Integer> searchMaxLengthInColumn(Sheet sheet) {
        int length;
        List<Integer> maxLengthsColumns = new ArrayList<>();
        for(int numberColumn = 0; numberColumn < sheet.getRows().get(0).size(); numberColumn++) {
            length = 0;
            for (ArrayList<Sheet.TableCell> columns : sheet.getRows()) {
                if (columns.get(numberColumn).getValue() != null && columns.get(numberColumn).getValue().toString().length() > length) {
                    length = columns.get(numberColumn).getValue().toString().length();
                } else length = Math.max(4, length);
            }
            maxLengthsColumns.add(length);
        }
        return maxLengthsColumns;
    }

    public void printSheet (Sheet sheet){
        List<Integer> maxLenInColumn = searchMaxLengthInColumn(sheet);
        for (int i = 0; i < sheet.getRows().size(); i++){
            printOneRows(sheet, i, maxLenInColumn);
        }
    }
    public void printOneRows(Sheet sheet, int numberRow, List<Integer> maxLengthColumn) {
        int lengthColumn;
        ArrayList<Sheet.TableCell> row = sheet.getRows().get(numberRow);
        StringBuilder sb = new StringBuilder("| ");
        for (int i = 0; i < row.size(); i++) {
            Sheet.TableCell cell = row.get(i);
            lengthColumn = maxLengthColumn.get(i);
            if (cell.getValue() != null) {
                sb.append(cell.getValue());
                addSpace(sb, abs(lengthColumn  - cell.getValue().toString().length()) + 1);
                sb.append("| ");
                continue;
            }
            addSpace(sb, lengthColumn + 1);
            sb.append("| ");
        }
        System.out.println(sb);
    }

    private void addSpace(StringBuilder sb, int numberSpace){
        for (int i = 0; i < numberSpace; i++){
            sb.append(' ');
        }
    }

}

package printTable;

import table.Filter;
import table.Group;
import table.Sheet;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class OutputConsole {
    private List<Integer> searchMaxLengthInColumns(Sheet sheet) {
        int length;
        List<Integer> maxLengthsColumns = new ArrayList<>();
        for (int numberColumn = 0; numberColumn < sheet.getRows().get(0).size(); numberColumn++) {
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

    private int searchMaxLengthInOneColumn(Sheet sheet, int numberColumn) {
        int length = 0;
        for (ArrayList<Sheet.TableCell> columns : sheet.getRows()) {
            if (columns.get(numberColumn).getValue() != null && columns.get(numberColumn).getValue().toString().length() > length) {
                length = columns.get(numberColumn).getValue().toString().length();
            } else length = Math.max(4, length);
        }
        return length;
    }

    public void printSheet(Sheet sheet, Filter filter, Group group) {
        List<Integer> maxLenInColumn = searchMaxLengthInColumns(sheet);
        printNumberColumn(sheet, maxLenInColumn, group);
        printDashBetterRows(sheet, maxLenInColumn, group);
        for (int i = 0; i < sheet.getRows().size(); i++) {
            if (filter.isStatus() && !filter.getNumberRowsVisible().contains(i+1)){
                continue;
            }
            if (group.isColumnGroupStatus() && group.isRowGroupStatus()){
                if(group.getTopRowNumber() <= i + 1 && i + 1 <= group.getLowerRowNumber()){
                    continue;
                } else {
                    printOneRowWithGroup(sheet, i, maxLenInColumn, group);
                    printDashBetterRows(sheet, maxLenInColumn, group);
                }
                continue;
            } else if (group.isColumnGroupStatus()){
                printOneRowWithGroup(sheet, i, maxLenInColumn, group);
                printDashBetterRows(sheet, maxLenInColumn, group);
                continue;
            } else if (group.isRowGroupStatus() && group.getTopRowNumber() <= i + 1 && i + 1 <= group.getLowerRowNumber()){
                continue;
            }
            printOneRow(sheet, i, maxLenInColumn);
            printDashBetterRows(sheet, maxLenInColumn, group);
        }
    }

    private void printOneRow(Sheet sheet, int numberRow, List<Integer> maxLengthColumn) {
        int lengthColumn;
        ArrayList<Sheet.TableCell> row = sheet.getRows().get(numberRow);
        StringBuilder sb = new StringBuilder(numberRow + 1 + " | ");
        for (int i = 0; i < row.size(); i++) {
            Sheet.TableCell cell = row.get(i);
            lengthColumn = maxLengthColumn.get(i);
            if (cell.getValue() != null) {
                sb.append(cell.getValue());
                addSpace(sb, abs(lengthColumn - cell.getValue().toString().length()) + 1);
                sb.append("| ");
                continue;
            }
            addSpace(sb, lengthColumn + 1);
            sb.append("| ");
        }
        System.out.println(sb);
    }

    private void printOneRowWithGroup(Sheet sheet, int numberRow, List<Integer> maxLengthColumn, Group group) {
        int lengthColumn;
        ArrayList<Sheet.TableCell> row = sheet.getRows().get(numberRow);
        StringBuilder sb = new StringBuilder(numberRow + 1 + " | ");
        for (int i = 0; i < row.size(); i++) {
            if (group.getLeftColumnNumber() <= i + 1 && i + 1 <= group.getRightColumnNumber()){
                continue;
            }
            Sheet.TableCell cell = row.get(i);
            lengthColumn = maxLengthColumn.get(i);
            if (cell.getValue() != null) {
                sb.append(cell.getValue());
                addSpace(sb, abs(lengthColumn - cell.getValue().toString().length()) + 1);
                sb.append("| ");
                continue;
            }
            addSpace(sb, lengthColumn + 1);
            sb.append("| ");
        }
        System.out.println(sb);
    }
    private void printDashBetterRows(Sheet sheet, List<Integer> maxLengthColumn, Group group) {
        int lengthColumn;
        StringBuilder sb = new StringBuilder();
        ArrayList<Sheet.TableCell> row = sheet.getRows().get(0);
        sb.append("- * ");
        for (int i = 0; i < row.size(); i++) {
            if (group.isColumnGroupStatus() && group.getLeftColumnNumber() <= i + 1 && i + 1 <= group.getRightColumnNumber()){
                continue;
            }
            lengthColumn = maxLengthColumn.get(i);
            addDash(sb, lengthColumn);
            sb.append(" * ");
        }
        System.out.println(sb);
    }

    private void printNumberColumn(Sheet sheet, List<Integer> maxLengthColumn, Group group) {
        int lengthColumn;
        ArrayList<Sheet.TableCell> row = sheet.getRows().get(0);
        StringBuilder sb = new StringBuilder("  | ");
        for (int i = 0; i < row.size(); i++) {
            if (group.isColumnGroupStatus() && group.getLeftColumnNumber() <= i + 1 && i + 1 <= group.getRightColumnNumber()){
                continue;
            }
            sb.append(i + 1);
            lengthColumn = maxLengthColumn.get(i);
            addSpace(sb, lengthColumn);
            sb.append("| ");
        }
        System.out.println(sb);
    }



    public void printAllCellsFromFilter(Sheet sheet, Filter filter) {
        int maxLengthInColumn = searchMaxLengthInOneColumn(sheet, filter.getNumberColumn());
        StringBuilder sbNumber = new StringBuilder("row : ");
        StringBuilder sbCells = new StringBuilder("    | ");
        for (int i = 0; i < filter.getAllCellsFromColumn().size(); i++) {
            Sheet.TableCell cell = filter.getAllCellsFromColumn().get(i);
            sbNumber.append(i + 1);
            addSpace(sbNumber, maxLengthInColumn);
            sbNumber.append("| ");
            sbCells.append(cell.getValue());
            if (cell.getValue() != null){
                addSpace(sbCells, Math.abs(maxLengthInColumn - cell.getValue().toString().length()) + 1);
                sbCells.append("| ");
                continue;
            }
            addSpace(sbCells, maxLengthInColumn - 3);
            sbCells.append("| ");
        }
        System.out.println(sbNumber);
        System.out.println(sbCells);
    }


    private void addSpace(StringBuilder sb, int numberSpace) {
        sb.append(" ".repeat(Math.max(0, numberSpace)));
    }

    private void addDash(StringBuilder sb, int numberDash) {
        sb.append("-".repeat(Math.max(0, numberDash)));
    }

}

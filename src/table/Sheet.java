package table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

//лист таблицы (по факту сама таблица)
public class Sheet {
    private ArrayList<ArrayList<TableCell>> rows;

    public static class TableCell<T> {
        private T value;

        public TableCell(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

    }

    private int lengthRow;
    private int depthColumn;

    public ArrayList<ArrayList<TableCell>> getRows() {
        return rows;
    }

    public void setRows(ArrayList<ArrayList<TableCell>> rows) {
        this.rows = rows;
    }

    public int getLengthRow() {
        return lengthRow;
    }

    public void setLengthRow(int lengthRow) {
        this.lengthRow = lengthRow;
    }

    public int getDepthColumn() {
        return depthColumn;
    }

    public void setDepthColumn(int depthColumn) {
        this.depthColumn = depthColumn;
    }

    public Sheet(ArrayList<ArrayList<TableCell>> row, int lengthRow, int depthColumn) {
        this.rows = row;
        this.lengthRow = lengthRow;
        this.depthColumn = depthColumn;
    }

    public Sheet() {
        this.rows = new ArrayList<>();
        this.lengthRow = 0;
        this.depthColumn = 0;
    }

    public void addRow() {
        ArrayList<TableCell> newColumns = new ArrayList<TableCell>();
        alignmentOneRow(newColumns);
        rows.add(newColumns);
        depthColumn++;
    }

//    public void addRowOnNumber(int number) {
//        if (number >= depthColumn) {
//            for (int i = depthColumn; i < number; i++) {
//                ArrayList<TableCell> newColumn = new ArrayList<>();
//                alignmentOneRow(newColumn);
//                rows.add(newColumn);
//                depthColumn++;
//            }
//        } else {
//            ArrayList<TableCell> newColumn = new ArrayList<>();
//            rows.add(number, newColumn);
//            depthColumn++;
//        }
//    }

    public void addColumn() {
        if (rows == null) {
            ArrayList<TableCell> newColumns = new ArrayList<>();
            TableCell cell = new TableCell(null);
            newColumns.add(cell);
            rows.add(newColumns);
            depthColumn++;
            lengthRow++;
        } else {
            lengthRow++;
            alignmentAllRows();
        }
    }

    //выравнивание всех строк в таблице, приводим их к прямоугольному виду...
    private void alignmentAllRows() {
        TableCell cell = new TableCell(null);
        for (var i : rows) {
            alignmentOneRow(i);
        }
    }

    //Выравнивание одной строки
    private void alignmentOneRow(ArrayList<TableCell> columns) {
        TableCell cell = new TableCell(null);
        while (columns.size() < lengthRow | columns.size() == 0) {
            columns.add(cell);
        }
    }

    //Поиск ячейки
    public TableCell searchCell(int numberRow, int numberColumn) {
//        if (numberRow < depthColumn) {
//            while (lengthRow < numberColumn) {
//                addColumn();
//            }
//          return rows.get(numberRow-1).get(numberColumn-1);
//        } else{
            while(depthColumn < numberRow){
                addRow();
            }
            while (lengthRow < numberColumn) {
                addColumn();
            }
//        }
        return rows.get(numberRow-1).get(numberColumn - 1);
    }

    public void setValueInCell(int numberRow, int numberColumn, int value) {
        TableCell cell = searchCell(numberRow, numberColumn);
        cell.setValue(value);
    }

    public void setValueInCell(int numberRow, int numberColumn, String value) {
        TableCell cell = searchCell(numberRow, numberColumn);
        cell.setValue(value);
    }

    public void setValueInCell(int numberRow, int numberColumn, LocalDate value) {
        TableCell cell = searchCell(numberRow, numberColumn);
        cell.setValue(value);
    }

    public Object getValueFromCell(int numberRow, int numberColumn) {
        TableCell cell = searchCell(numberRow, numberColumn);
        return cell.getValue();
    }
//    private ArrayList<ArrayList<TableCell>> searchRows( int numberRow){
//
//    }
}

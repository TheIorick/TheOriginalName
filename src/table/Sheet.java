package table;

import java.time.LocalDate;
import java.util.ArrayList;

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
        addColumn();
    }

    public void addRow() {
        ArrayList<TableCell> newColumns = new ArrayList<TableCell>();
        alignmentOneRow(newColumns);
        rows.add(newColumns);
        depthColumn++;
    }


    public void addColumn() {
        if (rows.size() == 0) {
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
        TableCell cell;
        while (columns.size() < lengthRow | columns.size() == 0) {
            cell = new TableCell(null);
            columns.add(cell);
        }
    }

    //Поиск ячейки
    public TableCell searchCell(int numberRow, int numberColumn) {
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
    public void setValueInCell(int numberRow, int numberColumn, double value) {
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
}

package table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

//лист таблицы (по факту сама таблица)
public class Sheet {
    private ArrayList<ArrayList<TableCell>> rows;

    public static class TableCell<T> {
        private T value;

        public TableCell(T value) {
            this.value = value;
        }

        public Object getValue() {
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
        addColumn();
    }

    public void addRow() {
        ArrayList<TableCell> newColumns = new ArrayList<>();
        alignmentOneRow(newColumns);
        rows.add(newColumns);
        depthColumn++;
    }


    public void addColumn() {
        if (rows.isEmpty()) {
            ArrayList<TableCell> newColumns = new ArrayList<>();
            TableCell<String> cell = new TableCell<>(null);
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
        TableCell<String> cell = new TableCell<String>(null);
        for (var i : rows) {
            alignmentOneRow(i);
        }
    }

    //Выравнивание одной строки
    private void alignmentOneRow(ArrayList<TableCell> columns) {
        TableCell<String> cell;
        while (columns.size() < lengthRow | columns.isEmpty()) {
            cell = new TableCell<String>(null);
            columns.add(cell);
        }
    }

    //Поиск ячейки
    public TableCell searchCell(int numberRow, int numberColumn) {
        while (depthColumn < numberRow) {
            addRow();
        }
        while (lengthRow < numberColumn) {
            addColumn();
        }
//        }
        return rows.get(numberRow - 1).get(numberColumn - 1);
    }

    public void updateCell(int numberRow, int numberColumn, TableCell tableCell) {
        while (depthColumn < numberRow) {
            addRow();
        }
        while (lengthRow < numberColumn) {
            addColumn();
        }
//        }
        rows.get(numberRow - 1).set(numberColumn - 1, tableCell);
    }

    public void setValueInCell(int numberRow, int numberColumn, int value) {
        TableCell<Integer> cell = new TableCell<>(value);
        updateCell(numberRow, numberColumn, cell);
    }

    public void setValueInCell(int numberRow, int numberColumn, double value) {
        TableCell<Double> cell = new TableCell<>(value);
        updateCell(numberRow, numberColumn, cell);
    }

    public void setValueInCell(int numberRow, int numberColumn, String value) {
        TableCell<String> cell = new TableCell<>(value);
        updateCell(numberRow, numberColumn, cell);
    }

    public void setValueInCell(int numberRow, int numberColumn, LocalDateTime value) {
        TableCell<LocalDateTime> cell = new TableCell<>(value);
        updateCell(numberRow, numberColumn, cell);
    }

    public Object getValueFromCell(int numberRow, int numberColumn) {
        TableCell cell = searchCell(numberRow, numberColumn);
        return cell.getValue();
    }
}

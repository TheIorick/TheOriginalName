package table;

import java.time.LocalDateTime;
import java.util.ArrayList;

//лист таблицы (по факту сама таблица)
public class Sheet {
    public enum TableCellType {
        STRING,
        INT,
        DOUBLE,
        DATE,
        NULL
    }
    private ArrayList<ArrayList<TableCell>> rows;

    public static class TableCell {
        private int intValue;
        private String stringValue;
        private double doubleValue;
        private LocalDateTime dateValue;
        private TableCellType cellType;

        public TableCell() {
            this.stringValue = null;
            cellType = TableCellType.NULL;
        }
        public TableCell(int intValue) {
            this.intValue = intValue;
            cellType = TableCellType.INT;
        }

        public TableCell(String stringValue) {
            this.stringValue = stringValue;
            cellType = TableCellType.STRING;
        }

        public TableCell(double doubleValue) {
            this.doubleValue = doubleValue;
            cellType = TableCellType.DOUBLE;
        }

        public TableCell(LocalDateTime dateValue) {
            this.dateValue = dateValue;
            cellType = TableCellType.DATE;
        }

        public Object getValue() {
            switch (cellType){
                case INT -> {
                    return intValue;
                }
                case STRING -> {
                    return stringValue;
                }
                case DOUBLE -> {
                    return doubleValue;
                }
                case DATE -> {
                    return dateValue;
                }
                case NULL -> {
                    return null;
                }
            }
            return null;
        }

        public void setValue(int intValue) {
            this.intValue = intValue;
            switch (cellType){
                case STRING -> stringValue = null;
                case DOUBLE -> doubleValue = 0;
                case DATE -> dateValue = null;
            }
            cellType = TableCellType.INT;
        }

        public void setValue(String stringValue) {
            this.stringValue = stringValue;
            switch (cellType){
                case INT -> intValue = 0;
                case DOUBLE -> doubleValue = 0;
                case DATE -> dateValue = null;
            }
            cellType = TableCellType.STRING;
        }
        public void setValue(Double doubleValue) {
            this.doubleValue = doubleValue;
            switch (cellType){
                case INT -> intValue = 0;
                case STRING -> stringValue = null;
                case DATE -> dateValue = null;
            }
            cellType = TableCellType.DOUBLE;
        }
        public void setValue(LocalDateTime dateValue) {
            this.dateValue = dateValue;
            switch (cellType){
                case INT -> intValue = 0;
                case STRING -> stringValue = null;
                case DOUBLE -> doubleValue = 0;
            }
            cellType = TableCellType.DATE;
        }
        public void setValue() {
            this.dateValue = dateValue;
            switch (cellType){
                case INT -> intValue = 0;
                case STRING -> stringValue = null;
                case DOUBLE -> doubleValue = 0;
                case DATE -> dateValue = null;

            }
            cellType = TableCellType.NULL;
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
            TableCell cell = new TableCell();
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
        for (var i : rows) {
            alignmentOneRow(i);
        }
    }

    //Выравнивание одной строки
    private void alignmentOneRow(ArrayList<TableCell> columns) {
        TableCell cell;
        while (columns.size() < lengthRow | columns.isEmpty()) {
            cell = new TableCell();
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
        TableCell cell = new TableCell(value);
        updateCell(numberRow, numberColumn, cell);
    }

    public void setValueInCell(int numberRow, int numberColumn, double value) {
        TableCell cell = new TableCell(value);
        updateCell(numberRow, numberColumn, cell);
    }

    public void setValueInCell(int numberRow, int numberColumn, String value) {
        TableCell cell = new TableCell(value);
        updateCell(numberRow, numberColumn, cell);
    }

    public void setValueInCell(int numberRow, int numberColumn, LocalDateTime value) {
        TableCell cell = new TableCell(value);
        updateCell(numberRow, numberColumn, cell);
    }

    public Object getValueFromCell(int numberRow, int numberColumn) {
        TableCell cell = searchCell(numberRow, numberColumn);
        return cell.getValue();
    }
}

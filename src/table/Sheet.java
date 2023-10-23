package table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
//лист таблицы (по факту сама таблица)
public class Sheet {
    private ArrayList<ArrayList<TableCell>> rows;
    private ArrayList<TableCell> columns;
    public static class TableCell {

        // приватные поля для хранения значения ячейки
        private String stringValue;
        private int intValue;
        private LocalDate dateValue;
        private boolean isEmpty;

        public TableCell(boolean isEmpty) {
            this.isEmpty = isEmpty;
        }

        public TableCell(LocalDate dateValue) {
            this.dateValue = dateValue;
        }

        public TableCell(int intValue) {
            this.intValue = intValue;
        }

        public TableCell(String stringValue) {
            this.stringValue = stringValue;
        }

        public String getStringValue() {
            return stringValue;
        }

        public void setStringValue(String stringValue) {
            this.stringValue = stringValue;
        }

        public int getIntValue() {
            return intValue;
        }

        public void setIntValue(int intValue) {
            this.intValue = intValue;
        }

        public LocalDate getDateValue() {
            return dateValue;
        }

        public void setDateValue(LocalDate dateValue) {
            this.dateValue = dateValue;
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

    public ArrayList<TableCell> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<TableCell> column) {
        this.columns = column;
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

    public void addRow(ArrayList<ArrayList<TableCell>> rows){
        ArrayList<TableCell> newColumns = new ArrayList<TableCell>();
        alignmentOneRow(newColumns);
        rows.add(newColumns);
        depthColumn++;
    }

    public void addRowOnNumber(ArrayList<ArrayList<TableCell>> rows, int number){
        if(number >= depthColumn) {
            for (int i = depthColumn; i < number; i++){
                ArrayList<TableCell> newColumn = new ArrayList<>();
                alignmentOneRow(newColumn);
                rows.add(newColumn);
                depthColumn++;
            }
        } else{
            ArrayList<TableCell> newColumn = new ArrayList<>();
            rows.add(number, newColumn);
            depthColumn++;
        }
    }

    public void addColumn(ArrayList<ArrayList<TableCell>> rows){
        if (rows == null){
            ArrayList<TableCell> newColumns = new ArrayList<>();
            TableCell cell = new TableCell(true);
            newColumns.add(cell);
            rows.add(newColumns);
            depthColumn++;
            lengthRow++;
        } else {
            lengthRow++;
            alignmentAllRows(rows);
        }
    }

    //выравнивание всех строк в таблице, приводим их к прямоугольному виду...
    private void alignmentAllRows(ArrayList<ArrayList<TableCell>> rows){
        TableCell cell = new TableCell(true);
        for (var i : rows){
            alignmentOneRow(i);
        }
    }
    //Выравнивание одной строки
    private void alignmentOneRow(ArrayList<TableCell> row){
        TableCell cell = new TableCell(true);
        while(row.size() < lengthRow){
            row.add(cell);
        }
    }

    public TableCell searchCell(ArrayList<ArrayList<TableCell>> rows, int numberRow, int numberColumn){
        if (numberRow < depthColumn){
            while(lengthRow < numberColumn){
                addColumn(rows);
            }
            return rows.get(numberRow-1).get(numberColumn-1);
        } else{
            while(depthColumn < numberRow){
                addRow(rows);
            }
        }
        return rows.get(numberRow).get(numberColumn);
    }

    public void setValueInCell(ArrayList<ArrayList<TableCell>> rows, int numberRow, int numberColumn, int value){
        TableCell cell = searchCell(rows, numberRow, numberColumn);
        cell.intValue = value;
        cell.stringValue = null;
        cell.dateValue = null;
        cell.isEmpty = false;
    }
    public void setValueInCell(ArrayList<ArrayList<TableCell>> rows, int numberRow, int numberColumn, String value){
        TableCell cell = searchCell(rows, numberRow, numberColumn);
        cell.stringValue = value;
        cell.dateValue = null;
        cell.intValue = 0;
        cell.isEmpty = false;
    }
    public void setValueInCell(ArrayList<ArrayList<TableCell>> rows, int numberRow, int numberColumn, LocalDate value){
        TableCell cell = searchCell(rows, numberRow, numberColumn);
        cell.dateValue = value;
        cell.stringValue = null;
        cell.intValue = 0;
        cell.isEmpty = false;
    }

    public Object getValueFromCell(ArrayList<ArrayList<TableCell>> rows, int numberRow, int numberColumn){
        TableCell cell = searchCell(rows, numberRow, numberColumn);
        if(!cell.isEmpty){
            if (cell.stringValue != null){
                return cell.stringValue;
            } else if (cell.dateValue != null) {
                return cell.dateValue;
            }
            return cell.intValue;
        }
        return null;
    }
}

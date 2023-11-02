package table;

import java.util.ArrayList;

import static table.Sheet.*;

public class Filter {
    private final boolean status;

    private int numberColumn;
    private ArrayList<TableCell> allCellsFromColumn;

    private ArrayList<Integer> numberRowsVisible;

    public boolean isStatus() {
        return status;
    }

    public int getNumberColumn() {
        return numberColumn;
    }

    public ArrayList<TableCell> getAllCellsFromColumn() {
        return allCellsFromColumn;
    }

    public ArrayList<Integer> getNumberRowsVisible() {
        return numberRowsVisible;
    }

    public Filter(Sheet sheet, int numberColumn) {
        this.status = true;
        this.numberColumn = numberColumn - 1;
        this.allCellsFromColumn = getAllCellsFromColumn(sheet, numberColumn - 1);
        this.numberRowsVisible = getNumbersRowsForVisible(this.allCellsFromColumn);
    }

    public Filter() {
        this.status = false;
    }

    private ArrayList<TableCell> getAllCellsFromColumn(Sheet sheet, int numberColumn){
        ArrayList<TableCell> allCellsFromColumn = new ArrayList<>();
        for (ArrayList<TableCell> row : sheet.getRows()){
            allCellsFromColumn.add(row.get(numberColumn));
        }
        return allCellsFromColumn;
    }
    public void removeFromVisibleRows(int numberRow){
        numberRowsVisible.remove(numberRow - 1);
        numberRowsVisible.add(numberRow - 1, null);
    }
    public void addVisibleRows(int numberRow){
        numberRowsVisible.add(numberRow - 1, numberRow);
    }

    private ArrayList<Integer> getNumbersRowsForVisible(ArrayList<TableCell> allCellsFromColumn){
        ArrayList <Integer> numbersRows = new ArrayList<>();
        for(int i = 0; i < allCellsFromColumn.size(); i++){
            //+1 нужен т.к. в таблице индексация с 1;
            numbersRows.add(i + 1);
        }
        return numbersRows;
    }
}

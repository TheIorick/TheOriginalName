package table;

import java.util.ArrayList;

public class Filter {
    private boolean status;
    private Sheet sheet;

    private int numberColumn;
    private ArrayList<Sheet.TableCell> allCellsFromColumn;

    private ArrayList<Integer> numberRowsVisible;

    public boolean isStatus() {
        return status;
    }

    public Sheet getSheet() {
        return sheet;
    }

    public int getNumberColumn() {
        return numberColumn;
    }

    public ArrayList<Sheet.TableCell> getAllCellsFromColumn() {
        return allCellsFromColumn;
    }

    public ArrayList<Integer> getNumberRowsVisible() {
        return numberRowsVisible;
    }

    public Filter(Sheet sheet, int numberColumn) {
        this.status = true;
        this.sheet = sheet;
        this.numberColumn = numberColumn - 1;
        this.allCellsFromColumn = getAllCellsFromColumn(sheet, numberColumn - 1);
        this.numberRowsVisible = getNumbersRowsForVisible(this.allCellsFromColumn);
    }

    public Filter() {
        this.status = false;
    }

    private ArrayList<Sheet.TableCell> getAllCellsFromColumn(Sheet sheet, int numberColumn){
        ArrayList<Sheet.TableCell> allCellsFromColumn = new ArrayList<>();
        for (ArrayList<Sheet.TableCell> row : sheet.getRows()){
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

    private ArrayList<Integer> getNumbersRowsForVisible(ArrayList<Sheet.TableCell> allCellsFromColumn){
        ArrayList <Integer> numbersRows = new ArrayList<>();
        for(int i = 0; i < allCellsFromColumn.size(); i++){
            //+1 нужен т.к. в таблице индексация с 1;
            numbersRows.add(i + 1);
        }
        return numbersRows;
    }
//аналогичная история как и с offGroup
//    public void offFilter (Filter filter){
//        filter.status = false;
//        filter.allCellsFromColumn = null;
//        filter.numberRowsVisible = null;
//        filter.numberColumn = 0;
//    }

}

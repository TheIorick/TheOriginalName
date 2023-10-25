package table;

import java.util.ArrayList;

public class Filter {
    private boolean onState;
    private Sheet sheet;

    private int numberColumn;
    private ArrayList<Sheet.TableCell> allCellsFromColumn;

    private ArrayList<Sheet.TableCell> cellsVisible;

    public Filter(Sheet sheet, int numberColumn) {
        this.onState = true;
        this.sheet = sheet;
        this.numberColumn = numberColumn;
        this.allCellsFromColumn = allCellsFromColumn;
        this.cellsVisible = allCellsFromColumn;
    }

    private ArrayList<Sheet.TableCell> getAllCellsFromColumn(Sheet sheet, int numberColumn){
        ArrayList<Sheet.TableCell> allCellsFromColumn = new ArrayList<>();
        for (ArrayList<Sheet.TableCell> row : sheet.getRows()){
            allCellsFromColumn.add(row.get(numberColumn));
        }
    }
}

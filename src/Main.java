import printTable.UserInteraction;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UserInteraction userInteraction = new UserInteraction();
        userInteraction.startUsing();

//        OutputConsole outputConsole = new OutputConsole();
//
//        Sheet sheet = new Sheet();
//        sheet.searchCell(9, 9);
//        System.out.println();
//        LocalDate date = LocalDate.of(2021, 5, 12);
//        sheet.setValueInCell( 3, 7, date);
//        sheet.setValueInCell( 6, 1, 120123);
//        sheet.setValueInCell( 5, 3, "Hek");
//
//        sheet.setValueInCell( 6, 2, "Hek");
//        outputConsole.printSheet(sheet, new Filter(), new Group());
//        System.out.println();
//
//        Filter filter = new Filter(sheet, 1);
//        System.out.println();
//        outputConsole.printSheet(sheet, filter);
//        System.out.println();
//        filter.removeFromVisibleRows( 3);
//        filter.removeFromVisibleRows( 5);
//        outputConsole.printSheet(sheet, filter, new Group());
//        System.out.println();
//        outputConsole.printAllCellsFromFilter(sheet, filter);
//        System.out.println();
//        filter.addVisibleRows(sheet, 5);
//        filter = new Filter();
//        Group group = new Group();
//        group.setLeftColumnNumber(2);
//        group.setRightColumnNumber(7);
//        group.setLowerRowNumber(5);
//        group.setTopRowNumber(4);
//        System.out.println();
//        outputConsole.printSheet(sheet, new Filter(), group);

//
//        WorkWithFile work = new WorkWithFile();
//        work.saveInFile("test", sheet);
//        Sheet sheet1 = work.LoadFromFile("test");
//        outputConsole.printSheet(sheet1, new Filter(), new Group());
//
    }
}
import printTable.OutputConsole;
import printTable.UserInteraction;
import table.Filter;
import table.Group;
import table.Sheet;
import table.SwapCell;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {
    public static void main(String[] args) throws IOException {
        UserInteraction userInteraction = new UserInteraction();
        userInteraction.startUsing();

//        System.out.println("Parsed Date and Time: " + parsedDateTime);
//        OutputConsole outputConsole = new OutputConsole();
//        SwapCell swapCell = new SwapCell();
//        Sheet sheet = new Sheet();
//        sheet.searchCell(9, 9);
//        System.out.println();
//        LocalDateTime date = LocalDateTime.of(2012, 10, 5, 23, 52);
//        sheet.setValueInCell( 3, 7, date);
//        sheet.setValueInCell( 6, 1, 120123);
//        sheet.setValueInCell( 5, 3, "Hek");
//
//        sheet.setValueInCell( 6, 2, "Hek");
//        outputConsole.printSheet(sheet, new Filter(), new Group());
//        swapCell.swapColumn(1, 7, sheet);
//        System.out.println();
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
//        OutputConsole outputConsole = new OutputConsole();
//        outputConsole.printSheet(sheet, new Filter(), new Group());
//        LocalDateTime date = LocalDateTime.of(1, 1, 1, 0, 0);
//        String dateString = "2021-10-25";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate dateTime = LocalDate.parse(dateString, formatter);

//        String dateString = "31/12/2021 23:59";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
//        System.out.println(dateTime);
    }
}
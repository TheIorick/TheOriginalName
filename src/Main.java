import printTable.OutputConsole;
import table.Sheet;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        OutputConsole outputConsole = new OutputConsole();

        Sheet sheet = new Sheet();
        sheet.searchCell(3, 4);
        LocalDate date = LocalDate.of(2021, 5, 12);
        sheet.setValueInCell( 3, 4, date);
        sheet.setValueInCell( 4, 5, 120123);
        sheet.setValueInCell( 5, 6, "Hek");
//        System.out.println(sheet.getValueFromCell( 3, 4));
//        System.out.println(sheet.getValueFromCell( 4, 5));
//        System.out.println(sheet.getValueFromCell(5, 6));
        sheet.setValueInCell( 6, 9, "Hek");
        System.out.println(outputConsole.searchMaxLengthInColumn(sheet));
        System.out.println();
        sheet.setValueInCell( 1, 6, "Hek");
//        sheet.setValueInCell( 2, 2, "Hek");
//        sheet.setValueInCell( 1, 2, "Hek");
//        sheet.setValueInCell( 1, 1, "Hek");

        outputConsole.printSheet(sheet);
    }
}
package printTable;

import org.w3c.dom.ls.LSOutput;
import table.Filter;
import table.Group;
import table.Sheet;
import table.WorkWithFile;

import java.io.IOException;
import java.util.Scanner;

public class UserInteraction {
    final String PRESS_0 = "Чтобы увидеть таблицу целиком введите                   0";
    final String PRESS_1 = "Чтобы установить значение в ячейке введите              1";
    final String PRESS_2 = "Чтобы запустить фильтр введите                          2";
    final String PRESS_3 = "Чтобы убрать строку с помощью фильтра введите           3";
    final String PRESS_4 = "Чтобы вернуть строку с помощью фильтра введите          4";
    final String PRESS_5 = "Чтобы отключить фильтр введите                          5";
    final String PRESS_6 = "Чтобы сгруппировать по строкам и по столбцам введите    6";
    final String PRESS_7 = "Чтобы сгруппировать по строкам  введите                 7";
    final String PRESS_8 = "Чтобы сгруппировать по столбцам введите                 8";
    final String PRESS_9 = "Чтобы отключить группировку введите                     9";
    final String PRESS_10 = "Чтобы сохранить таблицу в файл введите                 10";
    final String PRESS_11 = "Чтобы загрузить таблицу из файла введите               11";
    final String PRESS_12 = "Чтобы выйти введите                                    12";
    final String ENTER_NUMBER_ROW = "Введите номер строки";
    final String ENTER_NUMBER_COLUMN = "Введите имя файла";
    final String ENTER_NAME_FILE = "Введите ";
    final String START_GROUP = " c какого начнется группировка";
    final String END_GROUP = " по какой будет группировка";
    final String GROUP_TABLE = "Сгруппированная таблица";
    final String ALL_VALUES_FROM_COLUMN_FOR_WORK_FILTER = "Все значения столбца и его номер для которого работает фильтр";
    public void startUsing() throws IOException {
        Scanner scanner = new Scanner(System.in);
        OutputConsole console = new OutputConsole();
        WorkWithFile work = new WorkWithFile();
        System.out.println("Создана начальная таблица");
        System.out.println();
        Sheet sheet = new Sheet();
        Filter filter = new Filter();
        Group group = new Group();
        console.printSheet(sheet, new Filter(), new Group());
        String usersText;
        int numberRow;
        int numberColumn;
        String value;
        while(true){
            System.out.println();
            System.out.println(PRESS_0);
            System.out.println(PRESS_1);
            System.out.println(PRESS_2);
            System.out.println(PRESS_3);
            System.out.println(PRESS_4);
            System.out.println(PRESS_5);
            System.out.println(PRESS_6);
            System.out.println(PRESS_7);
            System.out.println(PRESS_8);
            System.out.println(PRESS_9);
            System.out.println(PRESS_10);
            System.out.println(PRESS_11);
            System.out.println(PRESS_12);
            usersText = scanner.nextLine();
            if(usersText.equals("12")){
                break;
            }
            switch (usersText){
                case "0":
                    System.out.println();
                    console.printSheet(sheet, new Filter(), new Group());
                    break;
                case "1":
                    System.out.println(ENTER_NUMBER_ROW);
                    numberRow = scanner.nextInt();
                    System.out.println();
                    numberColumn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(ENTER_NUMBER_COLUMN);
                    value = scanner.nextLine();
                    sheet.setValueInCell(numberRow, numberColumn, value);
                    System.out.println();
                    console.printSheet(sheet, new Filter(), new Group());
                    break;
                case "2":
                    System.out.println(ENTER_NUMBER_COLUMN);
                    numberColumn = scanner.nextInt();
                    filter = new Filter(sheet, numberColumn);
                    System.out.println();
                    System.out.println(ALL_VALUES_FROM_COLUMN_FOR_WORK_FILTER);
                    System.out.println();
                    console.printAllCellsFromFilter(sheet, filter);
                    break;
                case "3":
                    System.out.println();
                    System.out.println(ALL_VALUES_FROM_COLUMN_FOR_WORK_FILTER);
                    System.out.println();
                    console.printAllCellsFromFilter(sheet, filter);
                    System.out.println();
                    System.out.println(ENTER_NUMBER_ROW + " из фильтра, которую хотите скрыть");
                    numberRow = scanner.nextInt();
                    filter.removeFromVisibleRows(numberRow);
                    console.printSheet(sheet, filter, new Group());
                    break;
                case "4":
                    System.out.println();
                    System.out.println("Все значения столбца и номера строк для которого работает фильтр");
                    System.out.println();
                    console.printAllCellsFromFilter(sheet, filter);
                    System.out.println();
                    System.out.println(ENTER_NUMBER_ROW +" из фильтра, которую хотите вернуть");
                    numberRow = scanner.nextInt();
                    filter.addVisibleRows(numberRow);
                    console.printSheet(sheet, filter, new Group());
                    break;
                case "5":
                    filter = new Filter();
                    System.out.println("Фильтр выключен");
                    break;
                case "6":
                    System.out.println(ENTER_NUMBER_ROW + START_GROUP);
                    group.setLowerRowNumber(scanner.nextInt());
                    System.out.println(ENTER_NUMBER_ROW + END_GROUP);
                    group.setLowerRowNumber(scanner.nextInt());
                    System.out.println(ENTER_NUMBER_COLUMN + START_GROUP);
                    group.setLeftColumnNumber(scanner.nextInt());
                    System.out.println(ENTER_NUMBER_COLUMN + END_GROUP);
                    group.setRightColumnNumber(scanner.nextInt());
                    System.out.println();
                    System.out.println(GROUP_TABLE);
                    console.printSheet(sheet, new Filter(), group);
                    break;
                case "7":
                    System.out.println(ENTER_NUMBER_ROW + START_GROUP);
                    group.setTopRowNumber(scanner.nextInt());
                    System.out.println(ENTER_NUMBER_ROW + END_GROUP);
                    group.setLowerRowNumber(scanner.nextInt());
                    System.out.println();
                    System.out.println(GROUP_TABLE);
                    console.printSheet(sheet, new Filter(), group);
                    break;
                case "8":
                    System.out.println(ENTER_NUMBER_COLUMN + START_GROUP);
                    group.setLeftColumnNumber(scanner.nextInt());
                    System.out.println(ENTER_NUMBER_COLUMN + END_GROUP);
                    group.setRightColumnNumber(scanner.nextInt());
                    System.out.println();
                    System.out.println("Сгруппированная таблица");
                    console.printSheet(sheet, new Filter(), group);
                    break;
                case "9":
                    group = new Group();
                    System.out.println("Группировка выключена");
                    break;
                case "10":
                    System.out.println(ENTER_NAME_FILE);
                    work.saveInFile(scanner.nextLine(), sheet);
                    System.out.println();
                    System.out.println("Файл сохранен");
                    break;
                case "11":
                    System.out.println(ENTER_NAME_FILE);
                    sheet = work.LoadFromFile(scanner.nextLine());
                    System.out.println();
                    console.printSheet(sheet, new Filter(), new Group());
                    break;
            }
        }
    }
}

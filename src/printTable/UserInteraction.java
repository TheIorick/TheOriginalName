package printTable;

import org.w3c.dom.ls.LSOutput;
import table.Filter;
import table.Group;
import table.Sheet;
import table.WorkWithFile;

import java.io.IOException;
import java.util.Scanner;

public class UserInteraction {
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
            System.out.println("Чтобы увидеть таблицу целиком введите 0");
            System.out.println("Чтобы установить значение в ячейке введите 1");
            System.out.println("Чтобы запустить фильтр введите 2");
            System.out.println("Чтобы убрать строку с помощью фильтра введите 3");
            System.out.println("Чтобы вернуть строку с помощью фильтра введите 4");
            System.out.println("Чтобы отключить фильтр введите 5");
            System.out.println("Чтобы сгруппировать по строкам и по столбцам введите 6");
            System.out.println("Чтобы сгруппировать по строкам  введите 7");
            System.out.println("Чтобы сгруппировать по столбцам введите 8");
            System.out.println("Чтобы отключить группировку введите 9");
            System.out.println("Чтобы сохранить таблицу в файл введите 10");
            System.out.println("Чтобы загрузить таблицу из файла введите 11");
            System.out.println("Чтобы выйти введите 12");
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
                    System.out.println("Введите номер строки");
                    numberRow = scanner.nextInt();
                    System.out.println("Введите номер столбца");
                    numberColumn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите значение для ячейки");
                    value = scanner.nextLine();
                    sheet.setValueInCell(numberRow, numberColumn, value);
                    System.out.println();
                    console.printSheet(sheet, new Filter(), new Group());
                    break;
                case "2":
                    System.out.println("Введите номер столбца");
                    numberColumn = scanner.nextInt();
                    filter = new Filter(sheet, numberColumn);
                    System.out.println();
                    System.out.println("Все значения столбца и его номер для которого работает фильтр");
                    System.out.println();
                    console.printAllCellsFromFilter(sheet, filter);
                    break;
                case "3":
                    System.out.println();
                    System.out.println("Все значения столбца и номера строк для которого работает фильтр");
                    System.out.println();
                    console.printAllCellsFromFilter(sheet, filter);
                    System.out.println();
                    System.out.println("Введите номер строки из фильтра, которую хотите скрыть");
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
                    System.out.println("Введите номер строки из фильтра, которую хотите вернуть");
                    numberRow = scanner.nextInt();
                    filter.addVisibleRows(numberRow);
                    console.printSheet(sheet, filter, new Group());
                    break;
                case "5":
                    filter = new Filter();
                    System.out.println("Фильтр выключен");
                    break;
                case "6":
                    System.out.println("Введите номер строки c какого начнется группировка");
                    group.setLowerRowNumber(scanner.nextInt());
                    System.out.println("Введите номер строки по какой будет группировка");
                    group.setLowerRowNumber(scanner.nextInt());
                    System.out.println("Введите номер столбца c какого начнется группировка");
                    group.setLeftColumnNumber(scanner.nextInt());
                    System.out.println("Введите номер столбца по какой будет группировка");
                    group.setRightColumnNumber(scanner.nextInt());
                    System.out.println();
                    System.out.println("Сгруппированная таблица");
                    console.printSheet(sheet, new Filter(), group);
                    break;
                case "7":
                    System.out.println("Введите номер строки c какого начнется группировка");
                    group.setTopRowNumber(scanner.nextInt());
                    System.out.println("Введите номер строки по какой будет группировка");
                    group.setLowerRowNumber(scanner.nextInt());
                    System.out.println();
                    System.out.println("Сгруппированная таблица");
                    console.printSheet(sheet, new Filter(), group);
                    break;
                case "8":
                    System.out.println("Введите номер столбца c какого начнется группировка");
                    group.setLeftColumnNumber(scanner.nextInt());
                    System.out.println("Введите номер столбца по какой будет группировка");
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
                    System.out.println("Введите имя файла");
                    work.saveInFile(scanner.nextLine(), sheet);
                    System.out.println();
                    System.out.println("Файл сохранен");
                    break;
                case "11":
                    System.out.println("Введите имя файла");
                    sheet = work.LoadFromFile(scanner.nextLine());
                    System.out.println();
                    console.printSheet(sheet, new Filter(), new Group());
                    break;
            }
        }
    }
}

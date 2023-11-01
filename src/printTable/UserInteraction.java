package printTable;

import table.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInteraction extends Constants {
    final private UpdateDataFormat update = new UpdateDataFormat();
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
            System.out.println(PRESS_13);
            usersText = scanner.nextLine();
            if(usersText.equals("13")){
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
                    System.out.println(ENTER_NUMBER_COLUMN);
                    numberColumn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите значение");
                    value = scanner.nextLine();
                    sheet.setValueInCell(numberRow, numberColumn, value);
                    System.out.println();
                    console.printSheet(sheet, new Filter(), new Group());
                    break;
                case "2":
                    System.out.println(ENTER_NUMBER_ROW);
                    numberRow = scanner.nextInt();
                    System.out.println(ENTER_NUMBER_COLUMN);
                    numberColumn = scanner.nextInt();
                    scanner.nextLine();
                    printFormat(scanner);
                    scanner.nextLine();
                    String dateString = enterDate(scanner);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(update.getFormatInMoment());
                    LocalDateTime date = LocalDateTime.parse(dateString, formatter);
                    sheet.setValueInCell(numberRow, numberColumn, date);
                    System.out.println();
                    console.printSheet(sheet, new Filter(), new Group());
                    break;
                case "3":
                    System.out.println(ENTER_NUMBER_COLUMN);
                    numberColumn = scanner.nextInt();
                    filter = new Filter(sheet, numberColumn);
                    System.out.println();
                    System.out.println(ALL_VALUES_FROM_COLUMN_FOR_WORK_FILTER);
                    System.out.println();
                    console.printAllCellsFromFilter(sheet, filter);
                    break;
                case "4":
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
                case "5":
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
                case "6":
                    filter = new Filter();
                    System.out.println("Фильтр выключен");
                    break;
                case "7":
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
                case "8":
                    System.out.println(ENTER_NUMBER_ROW + START_GROUP);
                    group.setTopRowNumber(scanner.nextInt());
                    System.out.println(ENTER_NUMBER_ROW + END_GROUP);
                    group.setLowerRowNumber(scanner.nextInt());
                    System.out.println();
                    System.out.println(GROUP_TABLE);
                    console.printSheet(sheet, new Filter(), group);
                    break;
                case "9":
                    System.out.println(ENTER_NUMBER_COLUMN + START_GROUP);
                    group.setLeftColumnNumber(scanner.nextInt());
                    System.out.println(ENTER_NUMBER_COLUMN + END_GROUP);
                    group.setRightColumnNumber(scanner.nextInt());
                    System.out.println();
                    System.out.println("Сгруппированная таблица");
                    console.printSheet(sheet, new Filter(), group);
                    break;
                case "10":
                    group = new Group();
                    System.out.println("Группировка выключена");
                    break;
                case "11":
                    System.out.println(ENTER_NAME_FILE);
                    work.saveInFile(scanner.nextLine(), sheet);
                    System.out.println();
                    System.out.println("Файл сохранен");
                    break;
                case "12":
                    System.out.println(ENTER_NAME_FILE);
                    sheet = work.LoadFromFile(scanner.nextLine());
                    System.out.println();
                    console.printSheet(sheet, new Filter(), new Group());
                    break;
            }
        }
    }

    private void printFormat(Scanner scanner){
        System.out.println("Выберите один формат даты для записи из уже существующих ");
        System.out.println("Или создайте новый ");
        System.out.println("(Введите номер)");
        for (int i = 0; i  < update.getDateFormats().size(); i++){
            System.out.println("#" + " " + (i + 1) + "  " + update.getDateFormats().get(i));
        }
        System.out.println("#" + " "+ (update.getDateFormats().size() + 1) + "  " + "Создать новый формат");
        int number = scanner.nextInt();
        if(number >= update.getDateFormats().size() + 1){
            System.out.println("Введите новый формат, где");
            System.out.println("yyyy - год");
            System.out.println("MM - месяц");
            System.out.println("dd - день");
            System.out.println("HH - часы");
            System.out.println("mm - минуты");
            System.out.println("ss - секунды");
            scanner.nextLine();
            update.addNewFormat(scanner.nextLine());
        } else {
            update.setFormatInMoment(number);
        }
    }

    private String enterDate(Scanner scanner){
        System.out.println("Введите значение даты в соответствии с заданным форматом: ");
        System.out.println("yyyy - год");
        System.out.println("MM - месяц");
        System.out.println("dd - день");
        System.out.println("HH - часы");
        System.out.println("mm - минуты");
        System.out.println("ss - секунды");
        System.out.println(update.getFormatInMoment());
        String date = scanner.nextLine();
        return date;
    }
}

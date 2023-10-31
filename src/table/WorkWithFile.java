package table;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkWithFile {
    public void saveInFile(String nameFile, Sheet sheet) throws IOException {
        FileWriter writer = new FileWriter(nameFile + ".csv");
        BufferedWriter bw = new BufferedWriter(writer);
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Sheet.TableCell> row : sheet.getRows()){
            sb.setLength(0);
            for(Sheet.TableCell cell : row){
                sb.append(cell.getValue() + ",");
            }
            // удаляем лишнюю запятую
            sb.deleteCharAt(sb.length() - 1);
            bw.write(String.valueOf(sb) + "\n");
        }
        bw.close();
    }

    public Sheet LoadFromFile(String nameFile) throws IOException {
        Sheet sheet = new Sheet();
        FileReader reader = new FileReader(nameFile + ".csv");
        BufferedReader br = new BufferedReader(reader);
        String line;
        String regexInt = "\\d+";
        String regexDouble = "\\d+(\\.\\d+)?";
        Pattern patternInt = Pattern.compile(regexInt);
        Pattern patternDouble = Pattern.compile(regexDouble);
        int cntRow = 0;
        while ((line = br.readLine()) != null){
            String[] values = line.split(",");
            for (int i = 0; i < values.length; i++){
                //на третьей минуте пояснение
                try {
                    Matcher matcherInt = patternInt.matcher(values[i]);
                    Matcher matcherDouble = patternDouble.matcher(values[i]);
                    if (matcherInt.find()){
                        int num = Integer.parseInt(values[i]);
                        sheet.setValueInCell(cntRow+1, i+1, num);
                        continue;
                    } else if (matcherDouble.find()){
                        double num = Double.parseDouble(values[i]);
                        sheet.setValueInCell(cntRow+1, i+1, num);
                        continue;
                    }
                } catch (Exception e) {
                }
                if (values[i].equals("null")){
                    sheet.setValueInCell(cntRow+1, i+1, (String) null);
                    continue;
                }
                sheet.setValueInCell(cntRow+1, i+1, values[i]);

            }
            cntRow++;
        }
        br.close();
        return sheet;
    }
}

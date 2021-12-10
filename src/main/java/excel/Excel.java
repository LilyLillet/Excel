package excel;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Excel {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();
        List <FinOperation> finOperations = fileReader.getFinOperations();
        FileWriter fileWriter = new FileWriter();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write file name with calculations");
        String fileWithCalculations = reader.readLine();
        System.out.println("Write file name with incoming payments from Insurance companies");
        String fileWithIncomingPayments = reader.readLine();
        FileOutputStream file2;
        try (FileOutputStream file = new FileOutputStream("C:\\java\\" + fileWithCalculations + ".xlsx")) {
            file2 = new FileOutputStream("C:\\java\\" + fileWithIncomingPayments + ".xlsx");
            fileWriter.writeToFile(finOperations, file);
        }
        fileWriter.writePaymentsFromIC(finOperations, file2);
    }
}

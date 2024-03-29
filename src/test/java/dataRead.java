import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class dataRead {
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    @ExtendWith(testResultLogger.class)
    public void readFromCSVFileTest_1(String column_1 ) throws InterruptedException {
        String question = column_1;
        System.out.println(question);


        app app = new app();
        app.runChatBot(question);

    }
}

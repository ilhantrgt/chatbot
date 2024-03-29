import logger.log;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class testResultLogger implements TestWatcher {

    log log = new log();

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        String result = context.toString();
        log.info(testName + " PASSED");
        log.info(result + "Test Result Message");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String testFailCause = cause.getMessage() ;
        log.error(testName + " FAILED with cause : " + testFailCause);
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {

    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {

    }
}

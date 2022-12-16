import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public final class Main {

    private Main() {

    }

    /***/
    public static void main(final String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        InputData inputData = objectMapper.readValue(new File(args[0]), InputData.class);
        AppManager manager = new AppManager(inputData);

        manager.computeActions();

        ArrayList<ActionOutput> res = manager.getRes();


        ObjectWriter objectWriter = objectMapper.writer();
        objectWriter = objectWriter.withDefaultPrettyPrinter();
        objectWriter.writeValue(new File(args[1]), res);
    }
}

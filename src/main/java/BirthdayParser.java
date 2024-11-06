import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BirthdayParser {
    // Define the formatter with the specific pattern
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    public static final int CSV_INDEX_LAST_NAME = 0;
    public static final int CSV_INDEX_FIRST_NAME = 1;
    public static final int CSV_INDEX_BIRTHDAY = 2;
    public static final int CSV_INDEX_EMAIL = 3;
    public static final String LINE_BREAK = "\n";

    public List<BirthdayDto> parse(String content) {
        if (content.isBlank())
            return Collections.emptyList();

        List<String> linesWithoutHeader = getLinesWithoutHeader(content);
        return linesWithoutHeader.stream()
                .map(this::parseLineToBirthday)
                .toList();
    }

    @NotNull
    private static List<String> getLinesWithoutHeader(String fileContent) {
        return Arrays.stream(fileContent.split(LINE_BREAK))
                .skip(1)
                .toList();
    }

    private BirthdayDto parseLineToBirthday(String line) {
        List<String> properties = Arrays.stream(line.split(","))
                .map(String::trim)
                .toList();
        return new BirthdayDto(
                properties.get(CSV_INDEX_LAST_NAME), 
                properties.get(CSV_INDEX_FIRST_NAME), 
                getLocalDateFromString(properties.get(CSV_INDEX_BIRTHDAY)), 
                properties.get(CSV_INDEX_EMAIL)
        );
    }

    private static LocalDate getLocalDateFromString(String localDateAsString) {
        return LocalDate.parse(localDateAsString, formatter);
    }
}

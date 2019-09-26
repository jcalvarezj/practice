import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimePractice{

	public static void main(String args[]) {
		ZonedDateTime expected = ZonedDateTime.of(1969, 7, 16, 9, 32, 0, 0, ZoneId.of("America/Bogota"));
	//	LocalDateTime localDateTime = expected.toLocalDateTime();
		ZonedDateTime actual = expected.withZoneSameInstant(ZoneId.of("UTC"));
		System.out.println("Expected: "+expected+" actual: "+actual);
	}

}

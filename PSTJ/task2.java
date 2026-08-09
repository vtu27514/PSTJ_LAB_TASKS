import java.util.*;
import java.util.stream.Collectors;

class SensorReading {
    String sensorId;
    double temperature;

    SensorReading(String sensorId, double temperature) {
        this.sensorId = sensorId;
        this.temperature = temperature;
    }
}

public class StreamAnalytics {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of sensor readings
        int n = sc.nextInt();

        List<SensorReading> readings = new ArrayList<>();

        // Read sensor ID and temperature
        for (int i = 0; i < n; i++) {
            String sensorId = sc.next();
            double temperature = sc.nextDouble();

            readings.add(new SensorReading(sensorId, temperature));
        }

        // Stream processing
        Map<String, Double> result = readings.stream()

                // 1. Filter temperatures greater than 50
                .filter(r -> r.temperature > 50)

                // 2. Group by sensor ID
                .collect(Collectors.groupingBy(
                        r -> r.sensorId,

                        // 3. Calculate average temperature
                        Collectors.averagingDouble(r -> r.temperature)
                ));

        // 4. Sort by average temperature in descending order
        result.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry ->
                        System.out.printf("%s %.2f%n",
                                entry.getKey(),
                                entry.getValue()));
    }
}
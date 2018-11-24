namespace * com.kaoru.finagleservices

/**
 * temperature in celisus and timestamp in UTC milliseconds
 */
struct TemperatureDatum {
  1: i32 celsius,
  2: i64 timestamp
}

service TemperatureService {
   /** store a datum */
   void add(1: TemperatureDatum datum);

   /** return the mean temperature */
   double mean();
}
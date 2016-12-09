public class Exercise10_1 {
  public static void main(String[] args) {
    Time time = new Time(555550000);
    System.out.println("Hour: " + time.getHour() + " Minute: " +
                       time.getMinute() + " Second: " + time.getSecond());
  }
}

class Time {
  private int hour;
  private int minute;
  private int second;

  public Time() {
    this(System.currentTimeMillis());
  }

  public Time(long elapseTime) {
    // Obtain the total seconds since the midnight, Jan 1, 1970
    long totalSeconds = elapseTime / 1000;

    // Compute the current second in the minute in the hour
    second = (int)(totalSeconds % 60);

    // Obtain the total minutes
    long totalMinutes = totalSeconds / 60;

    // Compute the current minute in the hour
    minute = (int)(totalMinutes % 60);

    // Obtain the total hours
    int totalHours = (int)(totalMinutes / 60);

    // Compute the current hour
    hour = (int)(totalHours % 24);
  }

  public String toString() {
    return hour + ":" + minute + ":" + second + " GMT";
  }

  public int getHour() {
    return hour;
  }

  public int getMinute() {
    return minute;
  }

  public int getSecond() {
    return second;
  }
}

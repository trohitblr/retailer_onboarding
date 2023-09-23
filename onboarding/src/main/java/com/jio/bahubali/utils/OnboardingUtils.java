package com.jio.bahubali.utils;

import com.jio.bahubali.enums.ChannelType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OnboardingUtils {

  private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String NUMBERS = "0123456789";
  private static final String ALPHANUMERIC = ALPHABET + NUMBERS;
  private static final SecureRandom RANDOM = new SecureRandom();
  private static final int ID_LENGTH = 20;

  public static String generateUniqueId() {
    StringBuilder sb = new StringBuilder(ID_LENGTH);

    // Add the first two characters (letters)
    for (int i = 0; i < 2; i++) {
      sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
    }

    // Add the next two characters (digits)
    for (int i = 0; i < 2; i++) {
      sb.append(NUMBERS.charAt(RANDOM.nextInt(NUMBERS.length())));
    }

    // Add the remaining characters (alphanumeric)
    for (int i = 0; i < ID_LENGTH - 4; i++) {
      sb.append(ALPHANUMERIC.charAt(RANDOM.nextInt(ALPHANUMERIC.length())));
    }

    return sb.toString();
  }

  /**
   * Calls a method of the given object dynamically using reflection.
   *
   * @param object the object to call the method on
   * @param methodName the name of the method to call
   * @param parameterTypes the types of the method parameters
   * @param args the arguments to pass to the method
   * @return the result of the method call, or null if the method returns void
   * @throws NoSuchMethodException if the method does not exist
   * @throws IllegalAccessException if the method cannot be accessed
   * @throws InvocationTargetException if the method invocation fails
   */
  public static Object callMethod(
      Object object, String methodName, Class<?>[] parameterTypes, Object... args)
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
    Method method = object.getClass().getMethod(methodName, parameterTypes);
    return method.invoke(object, args);
  }

  public static ChannelType getChannelFromOrderId(String orderId) {
    if (orderId.toUpperCase().startsWith(ChannelType.ASP.getPrefix())) {
      return ChannelType.RCPL;
    } else if (orderId.toUpperCase().startsWith(ChannelType.B2B.getPrefix())) {
      return ChannelType.RCPL;
    }
    return ChannelType.RCPL;
  }

  public static LocalDateTime dateConverter(String parseDate) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return LocalDateTime.parse(parseDate, formatter);
  }

  public static Float formatFloatTwoDecimalValues(Float value) {
    if (value == null) {
      return value;
    }
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    String formattedGrossTotal = decimalFormat.format(value);

    // Convert the formattedGrossTotal back to a float
    return Float.parseFloat(formattedGrossTotal);
  }

  public static Double formatDoubleTwoDecimalValues(Double value) {
    if (value == null) {
      return value;
    }
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    String formattedGrossTotal = decimalFormat.format(value);

    // Convert the formattedGrossTotal back to a float
    return Double.parseDouble(formattedGrossTotal);
  }

  /**
   * @param date String Date
   * @param dateformat format pattern of date is coming
   * @param format format in you want to convert
   * @return
   */
  public static String dateConvertToString(String date, String dateformat, String format) {
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(dateformat);
    LocalDateTime dateTime = LocalDateTime.parse(date, inputFormatter);

    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(format);
    return dateTime.format(outputFormatter);
  }

  public static LocalDateTime dateConvertToLocalDateTime(String date, String dateformat) {
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(dateformat);
    return LocalDateTime.parse(date, inputFormatter);
  }

  public static String invoiceDateConverter(String invoiceTime) {
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime dateTime = LocalDateTime.parse(invoiceTime, inputFormatter);

    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy h a");
    String formattedDateTime = dateTime.format(outputFormatter);
    return formattedDateTime;
  }

  public static LocalDateTime dateConverterToLocalDateTime(String parseDate) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return parseDate != null ? LocalDateTime.parse(parseDate, formatter) : null;
  }
}

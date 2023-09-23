package com.jio.bahubali.utils;

public class BlogConstant {
  public static final String AWS_NAMESPACE = "products-item-image";
  public static final String EXTENSION_SLUG = "retailer-onboarding";
  public static final String ERROR_IN_SERVICE = "Something went wrong";
  public static final String COOKIE_STRING = "token=Bearer ";
  public static final String COOKIE_STRING_TTL_SECURE = "; Max-Age=36000; Path=/; Secure; HttpOnly";
  public static final String COOKIE_STRING_LOGOUT = "token=; Max-Age=0; Path=/; Secure; HttpOnly";
  public static final String REDIS_SSL = "REDIS_SSL";
  public static final String REDIS_PORT = "REDIS_PORT";
  public static final String REDIS_HOST = "REDIS_HOST";
  public static final String REDIS_DB = "REDIS_DB";
  public static final String CREDENTIAL_ID = "credentialId";
  public static final String BASE_64_PATTERN =
      "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$";
  public static final String SECRET_KEY = "secretKey";
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  public static final String SYSTEM_UPDATED = "SYSTEM_UPDATED";
  public static final String SUPER_ADMIN = "SUPER_ADMIN";
  public static final String ADMIN = "ADMIN";
  public static final String USER = "USER";
  public static String EMAIL_REGEX = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

  public static String MOBILE_REGEX = "^$|[0-9]{10}";
  public static final String ERROR_CODE = "errorCode";
  public static final String X_USER_DATA = "x-user-data";
  public static final String COOKIE = "cookie";
}

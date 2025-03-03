package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {

    public static UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());
    public static ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
}
package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class TestConfig {

    private static final String DEFAULT_BASE_URL = "https://serverest.dev";

    private TestConfig() {
    }

    public static String getBaseUrl() {
        String fromSystemProperty = System.getProperty("base.url");
        if (fromSystemProperty != null && !fromSystemProperty.trim().isEmpty()) {
            return fromSystemProperty.trim();
        }

        Properties props = new Properties();
        try (InputStream input = TestConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                props.load(input);
                String configValue = props.getProperty("base.url");
                if (configValue != null && !configValue.trim().isEmpty()) {
                    return configValue.trim();
                }
            }
        } catch (IOException e) {
            // fallback para URL padrão em caso de falha de leitura
        }

        return DEFAULT_BASE_URL;
    }
}
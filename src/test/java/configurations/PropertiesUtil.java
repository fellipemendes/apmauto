package configurations;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PropertiesUtil {

    private PropertiesUtil(){
    }
    private static final String APPLICATION_PROPERTIES = "application";

    public static final String getProperty(final String key){
        String value = null;

        try {
            ResourceBundle bundle = null;
            bundle = ResourceBundle.getBundle(APPLICATION_PROPERTIES);
            value = resolveValueWithEnvVars(bundle.getString(key));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return value;
    }

    private static String resolveValueWithEnvVars(String value) {
        if (null == value) {
            return null;
        }

        Pattern p = Pattern.compile("\\$\\{(\\w+)\\}|\\$(\\w+)");
        Matcher m = p.matcher(value);
        String envVarValue = value;
        while (m.find()) {
            String envVarName = null == m.group(1) ? m.group(2) : m.group(1);
            envVarValue = System.getenv(envVarName);
            if (envVarValue == null || envVarValue.isEmpty()) {
                envVarValue = System.getProperty(envVarName);
            }
        }
        return envVarValue;
    }
}

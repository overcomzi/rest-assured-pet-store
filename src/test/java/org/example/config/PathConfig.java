package org.example.config;

public class PathConfig {
    private static String schemasPath = "org/example/validations/schemas/";

    public static String getSchemaPath(String schemaPath) {
        return schemasPath + schemaPath;
    }
}

package com.fabian_velasquez.satyro_backend.shared.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

@Component
public class SqlQueryUtils {

    private static final Logger LOG = LoggerFactory.getLogger(SqlQueryUtils.class);

    private static SqlQueryUtils instance;
    private JSONObject query;

    public static SqlQueryUtils getInstance() {
        if (instance == null) {
            instance = new SqlQueryUtils();
            try {
                instance.load();
            } catch (RuntimeException e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return instance;
    }

    public void load() {
        try {
            InputStream insfile = new ClassPathResource("sql-queries.json").getInputStream();
            query = readFileJSONObject(insfile);
        } catch (IOException pe) {
            LOG.error(pe.getMessage(), pe);
            throw new RuntimeException("Error al cargar archivo sql-queries.json", pe);
        }
    }

    private JSONObject readFileJSONObject(InputStream inputStream) {
        JSONParser parser = new JSONParser();
        JSONObject jsnobj = null;
        try {
            Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            Object obj = parser.parse(reader);
            jsnobj = (JSONObject) obj;
        } catch (IOException ioerr) {
            LOG.error(String.format("ReadFileJSONObject IOException -> %s", ioerr.getMessage()));
        } catch (ParseException err) {
            LOG.error(String.format("ReadFileJSONObject ParseException -> %s", err.getMessage()));
        }
        return jsnobj;
    }

    public String getQuery(String keyQuery) {
        return (String) query.get(keyQuery);
    }
}

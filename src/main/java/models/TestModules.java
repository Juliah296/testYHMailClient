package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestModules {

    public static List<Map<Column, String>> getInboxMessagesRows(String expectedSender, String expectedSubject) {
        List<Map<Column, String>> rows = new ArrayList<>();
        Map<Column, String> cellWithSender = new HashMap<>();
        cellWithSender.put(Column.SENDER, expectedSender);
        rows.add(cellWithSender);
        Map<Column, String> cellWithSubject = new HashMap<>();
        cellWithSubject.put(Column.SUBJECT, expectedSubject);
        rows.add(cellWithSubject);
        return rows;
    }

    public enum Column {
        SENDER,
        SUBJECT
    }
}
package edu.ale.rentofbilds.service.record.intefaces;

import edu.ale.rentofbilds.model.Record;

import java.util.List;

public interface ICrudRecord {
    Record create(Record record);
    Record get(String id);
    Record update(Record record);
    Record delete(String id);
    List<Record> getAll();

}


package edu.ale.rentofbilds.service.record.impls;

import edu.ale.rentofbilds.Repository.RecordRepository;
import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Record;
import edu.ale.rentofbilds.service.record.intefaces.ICrudRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ServiceRecordMongoImpl implements ICrudRecord {

    @Autowired
    RecordRepository repository;

    @Override
    public Record create(Record record) {
        record.setCreated_at(LocalDateTime.now());
        record.setModified_at(LocalDateTime.now());
        return repository.save(record);
    }

    @Override
    public Record get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Record update(Record record) {
        record.setModified_at(LocalDateTime.now());
        return repository.save(record);
    }

    @Override
    public Record delete(String id) {
        Record record = this.get(id);
        repository.deleteById(id);
        return record;
    }

    @Override
    public List<Record> getAll() {
        return repository.findAll();
    }

    public void renew() {

    }
}

package edu.ale.rentofbilds.data;

import edu.ale.rentofbilds.Repository.RecordRepository;
import edu.ale.rentofbilds.model.Build;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class FakeData {

    @Autowired
    RecordRepository recordRepository;

    private List<Client> clients = Stream.of(
            new Client("1", "Bomj Viktoriya", "", "Chernivtsi pod mostom", "nema",
                    LocalDate.of(2012, Month.APRIL, 2), "EWE TOT BOMJ"
            ),
            new Client("2", "Bomj ILUSha", "", "Chernivtsi ", "nema",
                    LocalDate.of(2000, Month.SEPTEMBER, 5), "EWE TOT BOMJ"
            ),
            new Client("3", "Bomj EdaaaaGAR", "", "Chernivtsi pod mostom", "2034982039",
                    LocalDate.of(2002, Month.APRIL, 5), "EWE TOT BOMJ"
            ),
            new Client("4", "Bomj VGOSDS", "", "Chernivtsi pod mostom", "00012312",
                    LocalDate.of(1987, Month.MARCH, 2), "EWE TOT BOMJ"
            )
    ).collect(Collectors.toList());
    private List<Build> builds = Stream.of(
            new Build("1", "buld1", "center", LocalDateTime.now(), LocalDateTime.now()),
            new Build("2", "buld2", "center2", LocalDateTime.now(), LocalDateTime.now()),
            new Build("3", "buld3", "center3", LocalDateTime.now(), LocalDateTime.now()),
            new Build("4", "buld4", "center4", LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());
    private List<Record> records = Stream.of(
            new Record("1", "record1", "desk1", LocalDateTime.now()
                    , LocalDateTime.now(), clients.get(0), builds.get(0), LocalDateTime.now(), LocalDateTime.now()),
            new Record("2", "record2", "desk1", LocalDateTime.now()
                    , LocalDateTime.now(), clients.get(2), builds.get(3), LocalDateTime.now(), LocalDateTime.now()),
            new Record("3", "record3", "desk1", LocalDateTime.now()
                    , LocalDateTime.now(), clients.get(1), builds.get(2), LocalDateTime.now(), LocalDateTime.now()),
            new Record("4", "record4", "desk1", LocalDateTime.now()
                    , LocalDateTime.now(), clients.get(3), builds.get(1), LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());
    private List<Item> items = Stream.of(
            new Item(null, "Coca-Cola", "Drink",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item(null, "Pepsi", "Drink",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item(null, "Sprite", "Drink",
                    LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());

    //   @PostConstruct
    void init() {
        recordRepository.deleteAll();
        recordRepository.saveAll(records);
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public List<Record> renewRecords() {
        recordRepository.deleteAll();
        return recordRepository.saveAll(records);
    }
}

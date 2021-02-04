package edu.ale.rentofbilds.service.item.impls;

import edu.ale.rentofbilds.Repository.ItemRepository;
import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.item.interfaces.ICrudItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrudItemMongoImpl implements ICrudItem {

//    @Autowired
//    FakeData trash;

    @Autowired
    ItemRepository repository;

    private List<Item> list = new ArrayList<>();

    //   @PostConstruct  // не будет добавлять больше чем нужно..
//    void init() {
//        repository.deleteAll();
//        list = trash.getItems();
//        list.size();
//        repository.saveAll(list);
//    }

    @Override
    public Item create(Item item) {
        item.setId(item.getId());
        item.setCreated_at(LocalDateTime.now());
        item.setModified_at(LocalDateTime.now());
        return repository.save(item);
    }

    @Override
    public Item get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Item update(Item item) {
        item.setModified_at(LocalDateTime.now());
        return repository.save(item);
    }

    @Override
    public Item delete(String id) {
        Item item = this.get(id);
        repository.deleteById(id);
        return item;
    }


    @Override
    public List<Item> getAll() {
        return repository.findAll();
    }


    public List<Item> getAllSortedByName() {
        List<Item> list = repository.findAll();
        List<Item> sortedByName = list.stream()
                .sorted(Comparator.comparing(Item::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());

        return sortedByName;
    }

    public Object getAllSortedByModified() {
        List<Item> list = repository.findAll();
        List<Item> sortedByModified = list.stream()
                .sorted(Comparator.comparing(Item::getModified_at))
                .collect(Collectors.toList());

        return sortedByModified;
    }

    public Object getAllSortedById() {
        List<Item> list = repository.findAll();
        List<Item> sortedById = list.stream()
                .sorted(Comparator.comparing(Item::getId))
                .collect(Collectors.toList());

        return sortedById;
    }

    public List<Item> getByName(String name) {
        if (name.equals("")) return this.getAll();
//        return this.getAll().stream().filter(item -> item.getName().contains(name))
//                .collect(Collectors.toList());
        return repository.findByNameContaining(name);
    }

    public List<Item> getByNameAndDesc(String name, String description) {
  //  самый тупой метод !!!!
//        return this.getAll().stream()
//                .filter(item -> item.getName().equals(name))
//                .filter(item -> item.getDescription().equals(description))
//                .collect(Collectors.toList());

// менее тупее и легче проходит ну вы поняли! в памяти !
        return this.getAll().stream()
                .filter(item -> (item.getName().equals(name)
                        &&
                        item.getDescription().equals(description)))
                .collect(Collectors.toList());
//        return repository.findByNameAndDescription(name, description);
    }


}



/*
mongodb+srv://alexrith:<password>@cluster0.6sjdx.mongodb.net/test*/


//    MongoClientURI uri = new MongoClientURI(
//            "mongodb+srv://alexrith:<password>@cluster0.6sjdx.mongodb.net/<dbname>?retryWrites=true&w=majority");
//
//    MongoClient mongoClient = new MongoClient(uri);
//    MongoDatabase database = mongoClient.getDatabase("test");

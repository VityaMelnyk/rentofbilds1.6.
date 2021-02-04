package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.form.ClientForm;
import edu.ale.rentofbilds.form.RecordForm;
import edu.ale.rentofbilds.form.SearchForm;
import edu.ale.rentofbilds.model.Build;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Gender;
import edu.ale.rentofbilds.model.Record;
import edu.ale.rentofbilds.service.client.impls.CrudClientServiceMongoImpl;
import edu.ale.rentofbilds.service.record.impls.ServiceRecordMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web/record")
public class RecordWebController {

    @Autowired
    ServiceRecordMongoImpl servise;

    @Autowired
    FakeData fakeData;

    @Autowired
    CrudClientServiceMongoImpl clientService;

    Build standart = new Build("1", "build1", LocalDateTime.now(), LocalDateTime.now());

    @RequestMapping("/all")
    String getAll(Model model) {
        model.addAttribute("records", servise.getAll());
//        SearchForm search = new SearchForm();
//        model.addAttribute("search", search);
        return "recordTable";
    }

    @RequestMapping("/renew")
    String renew(Model model) {
        model.addAttribute("records", fakeData.renewRecords());
//        SearchForm search = new SearchForm();
//        model.addAttribute("search", search);
        return "recordTable";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        List<String> clients = clientService.getAll()
                .stream().map(client -> client.getName() + " " + client.getPhone())
                .collect(Collectors.toList());
        Map<String, String> clientMap = new HashMap<>();

        for (Client client : clientService.getAll()) {
            clientMap.put(client.getId(), client.getName() + " " + client.getPhone());
        }
        RecordForm recordForm = new RecordForm();
        model.addAttribute("form", recordForm);
        model.addAttribute("clients", clientMap);
        return "recordAddForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") RecordForm recordForm, Model model) {
        Record record = new Record();
        record.setName(recordForm.getName());
        record.setDescription(recordForm.getDescription());

//        String startAsString = recordForm.getStart();
//        LocalDate startAsDate = LocalDate.parse(startAsString);
//        LocalDateTime startAsDateTime = startAsDate.atTime(0, 0, 0);
//        record.setStart(startAsDateTime);
        record.setStart(LocalDate.parse(recordForm.getStart()).atTime(0, 0, 0));
        record.setFinish(LocalDate.parse(recordForm.getFinish()).atTime(0, 0, 0));

        String clientId = recordForm.getClient();
        Client client = clientService.get(clientId);
        record.setClient(client);
        record.setBuild(standart);
//        record.setClient(record.getClient());
//        record.setBuild(record.getBuild());
        servise.create(record);
        return "redirect:/web/record/all";
    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        servise.delete(id);
        return "redirect:/web/record/all";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") String id) {
        Record record = servise.get(id);
        RecordForm recordForm = new RecordForm();
        recordForm.setName(record.getName());
        recordForm.setDescription(record.getDescription());
        recordForm.setStart(record.getStart().toLocalDate().toString());
        recordForm.setFinish(record.getFinish().toLocalDate().toString());
        List<String> clients = clientService.getAll()
                .stream().map(client -> client.getName())
                .collect(Collectors.toList());
        System.out.println(clients);
        String clientName = recordForm.getClient();
        Client client = clientService.getByName(clientName).get(0);
        clients.remove(clientName);
//        clients.add(0,clientName);
        System.out.println(clients);
        record.setClient(client);
//        recordForm.setBuild(record.getBuild().toString());
        model.addAttribute("form", recordForm);
        model.addAttribute("clients", clients);
        System.out.println(recordForm);
        return "updateRecord";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @PathVariable("id") String id, @ModelAttribute("form") RecordForm form) {
        Record record = servise.get(id);
        record.setName(form.getName());
        record.setDescription(form.getDescription());
        record.setStart(LocalDate.parse(form.getStart()).atTime(0, 0, 0));
        record.setFinish(LocalDate.parse(form.getFinish()).atTime(0, 0, 0));
        String clientName = form.getClient();
        Client client = clientService.getByName(clientName).get(0);
        record.setClient(client);
        servise.update(record);
        return "redirect:/web/record/all";
    }


}

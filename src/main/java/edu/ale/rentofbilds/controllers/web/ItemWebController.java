package edu.ale.rentofbilds.controllers.web;

import edu.ale.rentofbilds.form.SearchForm;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.item.impls.CrudItemMongoImpl;
import edu.project.rent.forms.ItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web/item")
public class ItemWebController {

    @Autowired
    CrudItemMongoImpl service;

    // rest возращает JASON
    @RequestMapping("/all")
    String getAll(Model model) {
        model.addAttribute("spisok", service.getAll());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }

    @RequestMapping(value ="/all",method = RequestMethod.POST)
    String getAll(@ModelAttribute("search")SearchForm form, Model model) {
        String name = form.getName();
        model.addAttribute("spisok", service.getByName(name));
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        service.delete(id);
     /*
//        System.out.println(" вы нажали Delete ");
//
//        Item item = service.getAll().stream().filter(element -> element.getId().equals(id))
//                .findFirst().orElse(null);
//        service.getAll().remove(item);*/
        return "redirect:/web/item/all";
        //crud CRUD -> create read update delete
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        ItemForm itemForm = new ItemForm();
        model.addAttribute("form", itemForm);
        return "itemAddForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") ItemForm form, Model model) {
        System.out.println(form);
        Item item = new Item();
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        service.create(item);
        return "redirect:/web/item/all";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") String id) {
        Item item = service.get(id);
        ItemForm itemForm = new ItemForm();
        itemForm.setId(item.getId());
        itemForm.setName(item.getName());
        itemForm.setDescription(item.getDescription());
//        itemForm.setCreated_at(item.getCreated_at().toString());
//        itemForm.setModified_at(item.getModified_at().toString());

        model.addAttribute("form", itemForm);

        return "updateItem";

    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @PathVariable("id") String id, @ModelAttribute("form") ItemForm form) {
        Item item = service.get(id);
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        service.update(item);
        return "redirect:/web/item/all";
    }
    @RequestMapping(value = "/all/sort/name",method = RequestMethod.GET)
    public String sortedByName(Model model){
        model.addAttribute("spisok", service.getAllSortedByName());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }
    @RequestMapping(value = "/all/sort/modified",method = RequestMethod.GET)
    public String sortedByModified(Model model){
        model.addAttribute("spisok", service.getAllSortedByModified());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }
    @RequestMapping(value = "/all/sort/id",method = RequestMethod.GET)
    public String sortedById(Model model){
        model.addAttribute("spisok", service.getAllSortedById());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }


}


package com.service.FoodAndTravel.Controller;

import com.service.FoodAndTravel.Model.Base;
import com.service.FoodAndTravel.Service.BaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class BaseController<Service extends BaseService, Obj extends Base> {
    private final Service service;

    public BaseController(Service service) {
        this.service = service;
    }

    @GetMapping("/get-all")
    public List<Obj> getAll(){
        return this.service.getAll();
    }

    @GetMapping("/find-by-id/{id}")
    public Object getById(@PathVariable("id") long id) {
        return this.service.getById(id);
    }

    @PostMapping("/create")
    public Object create(@RequestBody Obj obj){
        return service.create(obj);
    }

}

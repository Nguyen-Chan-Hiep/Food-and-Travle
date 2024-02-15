package com.service.FoodAndTravel.Service;

import com.service.FoodAndTravel.Config.PersonalException;
import com.service.FoodAndTravel.Constants.Constants;
import com.service.FoodAndTravel.Model.Base;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public abstract class BaseService<Repo extends JpaRepository<Obj, Long>, Obj extends Base> {

    private final Repo repo;

    public BaseService(Repo repo) {
        this.repo = repo;
    }

    public List<Obj> getAll() {
        try {
            return this.repo.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Object getById(long id) {
        try {
            Obj o = this.repo.findById(id).orElse(null);
            if (o == null){
                return new PersonalException("error", "Object not found");
            }
            return o;
        } catch (Exception e) {
            return new PersonalException("error", e.getMessage());
        }
    }

    public Object create(Obj o) {
        try {
            o.setCreateDate(new Date());
            o.setCreateBy("system");
            o.setStatus(1);
            o = repo.save(o);
            return o;
        } catch (Exception e) {
            return new PersonalException("error", e.getMessage());
        }
    }

    public Object update(Obj o) {
        try {
            Obj obj = repo.findById(o.getId()).orElse(null);
            if (obj == null){
                return new PersonalException("error", "Object not found");
            }
            o.setModifyDate(new Date());
            o.setUpdateBy("updater");
            o = repo.save(o);
            return o;
        } catch (Exception e) {
            return new PersonalException("error", e.getMessage());
        }
    }

    public Object delete(Obj o) {
        try {
            Obj obj = repo.findById(o.getId()).orElse(null);
            if (obj == null){
                return new PersonalException("error", "Object not found");
            }
            obj.setUpdateBy("updater");
            obj.setModifyDate(new Date());
            obj.setStatus(Constants.INACTIVE_STATUS);
            repo.save(obj);
            return new PersonalException("Ok", "Object deleted");
        } catch (Exception e) {
            return new PersonalException("error", e.getMessage());
        }
    }
}

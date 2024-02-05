package com.service.FoodAndTravel.Service;

import com.service.FoodAndTravel.Config.PersonalException;
import com.service.FoodAndTravel.Constants.Constants;
import com.service.FoodAndTravel.DTO.AddressDetailDTO;
import com.service.FoodAndTravel.DTO.AddressTravelDTO;
import com.service.FoodAndTravel.Model.Travel.AddressDetail;
import com.service.FoodAndTravel.Model.Travel.AddressTravel;
import com.service.FoodAndTravel.Reponsitory.TravelReponsitory.AddressDetailRepo;
import com.service.FoodAndTravel.Reponsitory.TravelReponsitory.AddressTravelRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class AddressTravelService extends BaseService<AddressTravelRepo, AddressTravel> {

    @Autowired
    private AddressTravelRepo repo;
    @Autowired
    private AddressDetailRepo addressDetailRepo;

    public AddressTravelService(AddressTravelRepo addressTravelRepo) {
        super(addressTravelRepo);
    }

    @Override
    public Object create(AddressTravel o) {
        try {
            AddressTravel addressTravel = repo.checkExist(o.getName(), o.getAddress(), Constants.ACTIVE_STATUS, Constants.Category.TRAVEL.toString());
            if (addressTravel != null) {
                return new PersonalException("error", "Address travel is already exists");
            }
            o.setCreateDate(new Date());
            o.setCreateBy("system");
            o.setStatus(1);
            o = repo.save(o);
            return o;
        } catch (Exception e) {
            return new PersonalException("error", e.getMessage());
        }
    }

    public Object getDetail(long id){
        AddressTravel addressTravel = repo.findByIdAndStatus(id, Constants.ACTIVE_STATUS).orElse(null);
        if (addressTravel == null){
            return new PersonalException("error", "Address not found");
        }
        AddressTravel travel = new AddressTravel();
        AddressDetail detail = new AddressDetail();
        AddressTravelDTO result = travel.toDTO(addressTravel);
        AddressDetail addressDetail = addressDetailRepo.findByAddressIdAndStatus(addressTravel.getId(), Constants.ACTIVE_STATUS).orElse(null);
        if (addressDetail != null){
            AddressDetailDTO addressDetailDTO = detail.toDTO(addressDetail);
            result.setDetail(addressDetailDTO);
        } else {
            result.setDetail(null);
        }
        return getChild(result);
    }

    public List<AddressTravelDTO> getChild(AddressTravelDTO addressTravel){
        AddressTravel travel = new AddressTravel();
        AddressDetail detail = new AddressDetail();
        List<AddressTravel> listChild = repo.findByParentIdAndStatus(addressTravel.getId(), Constants.ACTIVE_STATUS);
        List<AddressTravelDTO> addressTravelDTOS = new ArrayList<>();
        if (!listChild.isEmpty()){
            listChild.forEach(child -> {
                AddressTravelDTO addressTravelDTO = travel.toDTO(child);
                List<AddressTravelDTO> children = getChild(addressTravelDTO);
                AddressDetail addressDetail = addressDetailRepo.findByAddressIdAndStatus(addressTravel.getId(), Constants.ACTIVE_STATUS).orElse(null);
                if (addressDetail != null){
                    AddressDetailDTO addressDetailDTO = detail.toDTO(addressDetail);
                    addressTravelDTO.setDetail(addressDetailDTO);
                } else {
                    addressTravelDTO.setDetail(null);
                }
                addressTravelDTO.setChildren(children);
                addressTravelDTOS.add(addressTravelDTO);
            });
        }
        return addressTravelDTOS;
    }
}

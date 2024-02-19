package com.service.FoodAndTravel.Service.TravelService;

import com.service.FoodAndTravel.Config.PersonalException;
import com.service.FoodAndTravel.Constants.Constants;
import com.service.FoodAndTravel.DTO.AddressDetailDTO;
import com.service.FoodAndTravel.DTO.AddressTravelDTO;
import com.service.FoodAndTravel.Model.Travel.AddressDetail;
import com.service.FoodAndTravel.Model.Travel.AddressTravel;
import com.service.FoodAndTravel.Reponsitory.LikeNumberRepo;
import com.service.FoodAndTravel.Reponsitory.TravelReponsitory.AddressDetailRepo;
import com.service.FoodAndTravel.Reponsitory.TravelReponsitory.AddressTravelRepo;
import com.service.FoodAndTravel.Service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class AddressTravelService extends BaseService<AddressTravelRepo, AddressTravel> {

    private final AddressTravelRepo repo;
    private final AddressDetailRepo addressDetailRepo;
    private final LikeNumberRepo likeNumberRepo;

    public AddressTravelService(AddressTravelRepo addressTravelRepo, AddressTravelRepo repo, AddressDetailRepo addressDetailRepo, LikeNumberRepo likeNumberRepo) {
        super(addressTravelRepo);
        this.repo = repo;
        this.addressDetailRepo = addressDetailRepo;
        this.likeNumberRepo = likeNumberRepo;
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
        result.setChildren(getChild(result));
        long likeNumber = likeNumberRepo.getLikeNumberByEntityAndCategory(result.getId(), Constants.Category.FOOD.toString());
        result.setLikeNumber(likeNumber);
        return result;
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
                long likeNumber = likeNumberRepo.getLikeNumberByEntityAndCategory(addressTravelDTO.getId(), Constants.Category.FOOD.toString());
                addressTravelDTO.setLikeNumber(likeNumber);
                addressTravelDTOS.add(addressTravelDTO);
            });
        }
        return addressTravelDTOS;
    }
}

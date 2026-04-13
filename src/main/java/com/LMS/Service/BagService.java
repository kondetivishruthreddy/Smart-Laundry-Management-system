package com.LMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.model.Bag;
import com.LMS.repo.BagRepo;

@Service
public class BagService {

    @Autowired
    private BagRepo repo;

    public Bag createBag(Bag incomingBag) {
        Bag bag = repo.findBagByBagId(incomingBag.getBagId());
        if (bag != null) {
            return bag;
        }

        if (incomingBag.getStatus() == null || incomingBag.getStatus().isEmpty()) {
            incomingBag.setStatus("Pending");
        }
        return repo.save(incomingBag);
    }

    public Bag startWashing(String bagId, int washTime) {
        Bag bag = repo.findBagByBagId(bagId);
        if (bag == null) {
            return null;
        }
        Long now = System.currentTimeMillis();
        bag.setStatus("Washing");
        bag.setStartTime(now);
        bag.setEndTime(now + washTime * 60 * 1000);
        return repo.save(bag);
    }

    public Bag updateStatus(String bagId, String status) {
        Bag bag = repo.findBagByBagId(bagId);
        if (bag == null) {
            return null;
        }
        bag.setStatus(status);
        return repo.save(bag);
    }

    public List<Bag> findAllBags() {
        return repo.findAll();
    }

}

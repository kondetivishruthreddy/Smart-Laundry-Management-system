package com.LMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.Service.BagService;
import com.LMS.model.Bag;

@RestController
@RequestMapping("/api/bags")
@CrossOrigin("*")
public class BagController {

    @Autowired
    private BagService service;

    @PostMapping
    public Bag create(@RequestBody Bag bag) {
        return service.createBag(bag);
    }

    @PutMapping("/start")
    public Bag start(@RequestParam String bagId, @RequestParam int washTime) {
        return service.startWashing(bagId, washTime);
    }

    @PutMapping("/status")
    public Bag setStatus(@RequestParam String bagId, @RequestParam String status) {
        return service.updateStatus(bagId, status);
    }

    @GetMapping
    public List<Bag> getBags() {
        return service.findAllBags();
    }
}

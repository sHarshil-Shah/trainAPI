package com.train.demo;

import com.train.demo.Service.ITrainService;
import com.train.demo.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TrainController {
    @Autowired
    public ITrainService service;

    @RequestMapping("/api/getTrains")
    public List<Train> GetTrains (Model model)
    {
        try {
            List<Train> trains = (List<Train>) service.findAll();
            System.out.println(trains);
            return trains;
        } catch (Exception ex) {
            System.out.println(ex);
            List<Train> trains = new ArrayList<>();
            return trains;
        }
    }
}

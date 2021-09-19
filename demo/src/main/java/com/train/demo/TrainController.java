package com.train.demo;

import com.train.demo.Repository.TrainRepository;
import com.train.demo.Service.ITrainService;
import com.train.demo.model.Train;
import com.train.demo.payload.response.MessageResponse;
import com.train.demo.payload.response.TrainsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TrainController {
    @Autowired
    public ITrainService service;
    @Autowired
    public TrainRepository trainRepository;

    private Sort.Direction getSortDirection(String direction)
    {
        if (direction.equals("asc"))
        {
            return Sort.Direction.ASC;
        }
        else if (direction.equals("desc"))
        {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.ASC;
    }

    @GetMapping("/trains")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getTrains (@RequestParam(defaultValue = "id, desc") String[] sort,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "3") int size
                                                  )
    {
        try {
            ///TODO: Custom error message when invalid parameter
            ///TODO: What if parameter name is invalid other then these three
            if (sort[0].contains(",")) {
                for (String sortColumns : sort) {
                    String[] _sortCheck = sortColumns.split(",");
                    if (!Train.hasMapColumn.containsKey(_sortCheck[0])) {
                        return ResponseEntity
                                .badRequest()
                                .body(new MessageResponse("Invalid Parameter"));
                    }
                }
            }
            else
            {
                if (!Train.hasMapColumn.containsKey(sort[0])) {
                    return ResponseEntity
                            .badRequest()
                            .body(new MessageResponse("Invalid Parameter"));
                }
            }
            List<Sort.Order> orders = new ArrayList<Sort.Order>();
            if (sort[0].contains(",")) {
                for (String sortOrder : sort) {
                    String[] _sort = sortOrder.split(",");
                    if (Train.hasMapColumn.containsKey(_sort[0])) {
                        _sort[0] = Train.hasMapColumn.get(_sort[0]);
                    }
                    orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
                }
            }
            else
            {
                if (Train.hasMapColumn.containsKey(sort[0])) {
                    sort[0] = Train.hasMapColumn.get(sort[0]);
                }
                orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
            }
            System.out.println(orders);
            Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
            Page<Train> pageTrain = trainRepository.findAll(pagingSort);

            List<Train> trains = pageTrain.getContent();
            double trainCount = trainRepository.count();
            return ResponseEntity.ok(new TrainsResponse(trains, size, page, trainCount));
        } catch (Exception ex) {
            System.out.println(ex);
            List<Train> trains = new ArrayList<>();
            return
                    ResponseEntity
                            .badRequest()
                            .body(new MessageResponse("Invalid Parameter"));}
    }
}

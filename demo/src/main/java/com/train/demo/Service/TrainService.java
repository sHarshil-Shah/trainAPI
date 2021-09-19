package com.train.demo.Service;

import com.train.demo.Repository.TrainRepository;
import com.train.demo.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService implements ITrainService {
    @Autowired
    private TrainRepository trainRepository;

    @Override
    public List<Train> findAll()
    {
        List<Train> trains = (List<Train>) trainRepository.findAll();
        return trains;
    }
}

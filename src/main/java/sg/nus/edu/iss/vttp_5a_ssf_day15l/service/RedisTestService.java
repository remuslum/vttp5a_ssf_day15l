package sg.nus.edu.iss.vttp_5a_ssf_day15l.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.vttp_5a_ssf_day15l.repo.ListRepo;
import sg.nus.edu.iss.vttp_5a_ssf_day15l.repo.ValueRepo;

@Service
public class RedisTestService {
    
    @Autowired
    ListRepo listRepo;

    @Autowired
    ValueRepo vRepo;
}

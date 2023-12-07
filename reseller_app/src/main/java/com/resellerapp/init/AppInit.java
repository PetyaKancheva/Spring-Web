package com.resellerapp.init;

import com.resellerapp.model.ConditionEnum;
import com.resellerapp.model.entity.ConditionEntity;
import com.resellerapp.repository.ConditionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AppInit implements CommandLineRunner {
    private final ConditionRepository conditionRepository;

    public AppInit(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        boolean hasConditions= conditionRepository.count()>0;
        if (!hasConditions){
            List<ConditionEntity> conditions = new ArrayList<>();
            Arrays.stream(ConditionEnum.values()).forEach(
                    conditionEnum -> {
                        ConditionEntity condition = new ConditionEntity();
                        condition.setName(conditionEnum);
                        conditions.add(condition);
                    }
            );


            conditionRepository.saveAll(conditions);
        }

    }
}

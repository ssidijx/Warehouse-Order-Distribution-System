package com.rustam.warehouse.service;

import com.rustam.warehouse.dto.WarehouseResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class WarehouseOrchestratorImplTest {
    @Autowired
    WarehouseOrchestrator orchestrator;

    @Test
    void fullTest(){
        WarehouseResult result = orchestrator.startProcess();
        assertThat(result).isNotNull();
    }
}

package com.rustam.warehouse.dto;

import java.util.List;

public record WarehouseResult(
        int totalTrucks,
        List<TruckPlan> trucks
) {}

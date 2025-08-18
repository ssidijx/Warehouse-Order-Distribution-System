package com.rustam.warehouse.dto;

import java.util.List;

public record TruckPlan(
   Long truckId,
   List<RouteStop> route,
   double totalWeightKg,
   double totalVolumeM3
) {}

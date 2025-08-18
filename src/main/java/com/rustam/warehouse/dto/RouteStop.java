package com.rustam.warehouse.dto;

import java.util.List;

public record RouteStop(
        Long storeId,
        List<Long> productsId
) {}
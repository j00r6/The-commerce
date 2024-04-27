package com.toyproject.thecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PageInfo {
    private long page;
    private long size;
    private long totalElements;
    private long totalPages;
}

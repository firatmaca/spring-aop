package com.teamfighttactics.teamfighttactics.dto;

import lombok.Data;

import java.util.List;

@Data
public class HeroPageResponse {
    private List<HeroDTO> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}

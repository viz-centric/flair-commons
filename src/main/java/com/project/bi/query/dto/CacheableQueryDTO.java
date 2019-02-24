package com.project.bi.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CacheableQueryDTO {

    private QueryDTO queryDTO;

    private String fbiEngineIpAddress;

    private Integer fbiEnginePort;

    private String fbiEngineEndpoint;

    private Boolean fbiEngineSecure;


}

package com.project.bi.query.dto.transform;

import com.project.bi.query.dto.FieldDTO;
import com.project.bi.query.dto.TransformationDTO;
import lombok.Data;

@Data
public class GroupingTransformationDTO implements TransformationDTO {
    private FieldDTO groupingField;
}

package com.example.kafka.test.mapping;

import com.example.kafka.test.dto.TestDto;
import com.example.kafka.test.model.Test;
import org.mapstruct.Mapper;

@Mapper
public interface TestMapper {
    Test fromDto(TestDto dto);
    TestDto toDto(Test test);
}

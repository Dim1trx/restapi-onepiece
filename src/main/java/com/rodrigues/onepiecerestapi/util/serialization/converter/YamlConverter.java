package com.rodrigues.onepiecerestapi.util.serialization.converter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.rodrigues.onepiecerestapi.util.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

public class YamlConverter extends AbstractJackson2HttpMessageConverter {
    public YamlConverter() {
        super(
                new YAMLMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL),
                MediaType.parseMediaType(MediaTypes.APPLICATION_YAML)
        );
    }
}

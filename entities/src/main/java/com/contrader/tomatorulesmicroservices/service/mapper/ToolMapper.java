package com.contrader.tomatorulesmicroservices.service.mapper;

import com.contrader.tomatorulesmicroservices.domain.*;
import com.contrader.tomatorulesmicroservices.service.dto.ToolDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Tool and its DTO ToolDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ToolMapper extends EntityMapper<ToolDTO, Tool> {



    default Tool fromId(Long id) {
        if (id == null) {
            return null;
        }
        Tool tool = new Tool();
        tool.setId(id);
        return tool;
    }
}

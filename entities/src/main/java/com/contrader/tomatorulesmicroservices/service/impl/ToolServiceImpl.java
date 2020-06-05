package com.contrader.tomatorulesmicroservices.service.impl;

import com.contrader.tomatorulesmicroservices.service.ToolService;
import com.contrader.tomatorulesmicroservices.domain.Tool;
import com.contrader.tomatorulesmicroservices.repository.ToolRepository;
import com.contrader.tomatorulesmicroservices.service.dto.ToolDTO;
import com.contrader.tomatorulesmicroservices.service.mapper.ToolMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Tool.
 */
@Service
@Transactional
public class ToolServiceImpl implements ToolService {

    private final Logger log = LoggerFactory.getLogger(ToolServiceImpl.class);

    private final ToolRepository toolRepository;

    private final ToolMapper toolMapper;

    public ToolServiceImpl(ToolRepository toolRepository, ToolMapper toolMapper) {
        this.toolRepository = toolRepository;
        this.toolMapper = toolMapper;
    }

    /**
     * Save a tool.
     *
     * @param toolDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ToolDTO save(ToolDTO toolDTO) {
        log.debug("Request to save Tool : {}", toolDTO);
        Tool tool = toolMapper.toEntity(toolDTO);
        tool = toolRepository.save(tool);
        return toolMapper.toDto(tool);
    }

    /**
     * Get all the tools.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ToolDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Tools");
        return toolRepository.findAll(pageable)
            .map(toolMapper::toDto);
    }


    /**
     * Get one tool by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ToolDTO> findOne(Long id) {
        log.debug("Request to get Tool : {}", id);
        return toolRepository.findById(id)
            .map(toolMapper::toDto);
    }

    /**
     * Delete the tool by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Tool : {}", id);
        toolRepository.deleteById(id);
    }
}

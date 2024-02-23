package com.generation.javdventures.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.generation.jadventures.entities.Adventurer;
import com.generation.jadventures.model.dto.adventurer.AdventurerDtoR;
import com.generation.jadventures.model.dto.adventurer.AdventurerDtoWParty;
import com.generation.jadventures.model.dto.adventurer.AdventurerDtoWnoParty;
import com.generation.jadventures.model.repositories.AdventurerRepository;
import com.generation.jadventures.model.service.AdventurerConverter;

public class AdventurerController 
{
    @Autowired
    AdventurerRepository repo;
    @Autowired
    AdventurerConverter conv;

    @GetMapping("/adventurers")
    public List<AdventurerDtoWnoParty> getAll()
    {
        return repo.findAll().stream().map(a -> conv.adventurertoDtoWnoParty(a)).toList();
    }

    @GetMapping("/adventurers/{id}")
    public AdventurerDtoWnoParty getOne(@PathVariable Integer id)
    {
        return conv.adventurertoDtoWnoParty(repo.findById(id).get());
    }

    @GetMapping("/adventurers/{id}/party")
    public AdventurerDtoWParty getOneWithParty(@PathVariable Integer id)
    {
        return conv.adventurertoDtoWParty(repo.findById(id).get());
    }

    @PutMapping("/adventurers")
    public AdventurerDtoWParty updateAdventurer(@RequestBody AdventurerDtoR dto)
    {
        Adventurer a = conv.DtoRToAdventurer(dto);
        return conv.adventurertoDtoWParty(repo.save(a));
    }

    @PutMapping("/adventurers/{id}")
    public AdventurerDtoWParty updateWithId(@RequestBody AdventurerDtoR dto,@PathVariable Integer id)
    {
        
        Adventurer a = conv.DtoRToAdventurer(dto);
        a.setId(id);
        return conv.adventurertoDtoWParty(repo.save(a));
    }

    @PostMapping("/adventurers")
    public AdventurerDtoWParty insert(@RequestBody AdventurerDtoR dto)
    {
        Adventurer a = conv.DtoRToAdventurer(dto);
        return conv.adventurertoDtoWParty(repo.save(a));
    }

    @DeleteMapping("/adventurers/{id}")
    public void deleteAdventurers(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }

}





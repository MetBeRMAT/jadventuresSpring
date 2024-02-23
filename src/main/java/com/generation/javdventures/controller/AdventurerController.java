package com.generation.javdventures.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.generation.jadventures.entities.Adventurer;
import com.generation.jadventures.model.dto.adventurer.AdventurerDtoBase;
import com.generation.jadventures.model.dto.adventurer.AdventurerDtoR;
import com.generation.jadventures.model.repositories.AdventurerRepository;
import com.generation.jadventures.model.service.AdventurerConverter;

public class AdventurerController 
{
    @Autowired
    AdventurerRepository repo;
    @Autowired
    AdventurerConverter conv;

    @GetMapping("/adventurers")
    public List<Adventurer> getAll()
    {
        return repo.findAll();
    }

   @GetMapping("/adventurers/{id}")
    public AdventurerDtoBase getOne(@PathVariable Integer id)
    {
        Optional<Adventurer> op = repo.findById(id);

        if(op.isEmpty())
            return null;

        return conv.AdventurerToDtoR(op.get());
    }

    @PutMapping("/adventurers")
    public AdventurerDtoR updateAdventurer(@RequestBody AdventurerDtoR dto)
    {
        Adventurer a = conv.dtoRputToAdventurer(dto);
        return conv.adventurerToDtoR(repo.save(a));
    }

    @PutMapping("/parties/{id}")
    public AdventurerDtoR updateWithId(@RequestBody AdventurerDtoR dto,@PathVariable Integer id)
    {
        
        Adventurer a = conv.dtoRputToAdventurer(dto);
        a.setId(id);
        
        return conv.adventurerToDtoR(repo.save(a));
    }

    @DeleteMapping("/adventurers/{id}")
    public void deleteAdventurers(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }

}





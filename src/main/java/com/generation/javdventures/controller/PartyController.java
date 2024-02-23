package com.generation.javdventures.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jadventures.entities.Guild;
import com.generation.jadventures.entities.Party;
import com.generation.jadventures.entities.Quest;
import com.generation.jadventures.model.dto.guild.GuildDtoBase;
import com.generation.jadventures.model.dto.party.PartyDtoBase;
import com.generation.jadventures.model.dto.party.PartyDtoR;
import com.generation.jadventures.model.dto.party.PartyDtoWAdventurer;
import com.generation.jadventures.model.dto.quest.QuestDtoBase;
import com.generation.jadventures.model.dto.quest.QuestDtoR;
import com.generation.jadventures.model.repositories.PartyRepository;
import com.generation.jadventures.model.service.PartyConverter;

@RestController
@CrossOrigin

public class PartyController 
{
    @Autowired
    PartyRepository repo;
    @Autowired
    PartyConverter conv;

    @GetMapping("/parties")
    public List<Party> getAll()
    {
        return repo.findAll();
    }

   @GetMapping("/parties/{id}")
    public PartyDtoBase getOne(@PathVariable Integer id)
    {
        Optional<Party> op = repo.findById(id);

        if(op.isEmpty())
            return null;

        return conv.partyToDtoR(op.get());
    }

    @GetMapping("/parties/{id}")
    public PartyDtoWAdventurer getOneWithParty(@PathVariable Integer id)
    {
        Optional<Party> op = repo.findById(id);

        if(op.isEmpty())
            return null;

        return conv.partyToDtoWAdventurer(op.get());
    }

    @PutMapping("/parties")
    public PartyDtoR updateParty(@RequestBody PartyDtoR dto)
    {
        Party p = conv.dtoRputToParty(dto);
        return conv.partyToDtoR(repo.save(p));
    }

    @PutMapping("/parties/{id}")
    public PartyDtoR updateWithId(@RequestBody PartyDtoR dto,@PathVariable Integer id)
    {
        
        Party p = conv.dtoRputToParty(dto);
        p.setId(id);
        
        return conv.partyToDtoR(repo.save(p));
    }

    @DeleteMapping("/parties/{id}")
    public void deleteParty(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }

}



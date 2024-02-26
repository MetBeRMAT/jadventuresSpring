package com.generation.jadventures.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jadventures.entities.Party;
import com.generation.jadventures.model.dto.party.PartyDtoR;
import com.generation.jadventures.model.dto.party.PartyDtoWAdventurer;
import com.generation.jadventures.model.dto.party.PartyDtoWQuest;
import com.generation.jadventures.model.dto.party.PartyDtoWWithPartyLeaderAndNoAdventures;
import com.generation.jadventures.model.dto.party.PartyDtoWnoQuest;
import com.generation.jadventures.model.repositories.PartyRepository;
import com.generation.jadventures.model.service.PartyConverter;

@RestController
public class PartyController 
{
    @Autowired
    PartyRepository repo;
    @Autowired
    PartyConverter conv;

    @GetMapping("/parties")
    public List<PartyDtoWnoQuest> getAll()
    {
        return repo.findAll().stream().map(p -> conv.partyToDtoWnoQuest(p)).toList();
    }

   @GetMapping("/parties/{id}")
    public PartyDtoWnoQuest getOne(@PathVariable Integer id)
    {
        return conv.partyToDtoWnoQuest(repo.findById(id).get());
    }

    @GetMapping("/parties/{id}/adventurer")
    public PartyDtoWAdventurer getOneWithAdventure(@PathVariable Integer id)
    {
        return conv.partyToDtoWAdventurer(repo.findById(id).get());
    }

    @GetMapping("/parties/{id}/quest")
    public PartyDtoWQuest getOneWithQuest(@PathVariable Integer id)
    {
        return conv.partyToDtoWQuest(repo.findById(id).get());
    }

    @GetMapping("/parties/{id}/party_leader")
    public PartyDtoWWithPartyLeaderAndNoAdventures getOneWithPartyLeader(@PathVariable Integer id)
    {
        return conv.partyDtoWWithPartyLeaderAndNoAdventures(repo.findById(id).get());
    }

    @PostMapping("/parties")
    public PartyDtoWAdventurer insert (@RequestBody PartyDtoR dto)
    {
        Party q = conv.DtoRToParty(dto);
        return conv.partyToDtoWAdventurer(repo.save(q));
    }


    @PutMapping("/parties")
    public PartyDtoWAdventurer updateParty(@RequestBody PartyDtoR dto)
    {
        Party p = conv.DtoRToParty(dto);
        return conv.partyToDtoWAdventurer(repo.save(p));
    }

    @PutMapping("/parties/{id}")
    public PartyDtoWAdventurer updateWithId(@RequestBody PartyDtoR dto,@PathVariable Integer id)
    {
        
        Party p = conv.DtoRToParty(dto);
        p.setId(id);
        
        return conv.partyToDtoWAdventurer(repo.save(p));
    }

    @DeleteMapping("/parties/{id}")
    public void deleteParty(@PathVariable Integer id)
    {
        repo.deleteById(id);
    }

}



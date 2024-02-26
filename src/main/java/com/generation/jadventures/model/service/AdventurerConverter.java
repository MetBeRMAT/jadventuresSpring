package com.generation.jadventures.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.jadventures.entities.Adventurer;
import com.generation.jadventures.model.dto.adventurer.AdventurerDtoR;
import com.generation.jadventures.model.dto.adventurer.AdventurerDtoWParty;
import com.generation.jadventures.model.dto.adventurer.AdventurerDtoWnoParty;
import com.generation.jadventures.model.repositories.AdventurerRepository;

@Service
public class AdventurerConverter 
{
    @Autowired
    AdventurerRepository aRepo;
    
    public Adventurer DtoRToAdventurer (AdventurerDtoR a)
    {
        return  Adventurer
                .builder()
                .id(a.getId())
                .name(a.getName())
                .surname(a.getSurname())
                .dob(a.getDob())
                .rank(a.getRank())
                .role(a.getRole())
                .build();
    }

    public AdventurerDtoWParty adventurertoDtoWParty (Adventurer a)
    {
        return  AdventurerDtoWParty
                .builder()
                .id(a.getId())
                .name(a.getName())
                .surname(a.getSurname())
                .dob(a.getDob())
                .rank(a.getRank())
                .role(a.getRole())
                .party(a.getParty())
                .build();
    }

    public AdventurerDtoWnoParty adventurertoDtoWnoParty (Adventurer a)
    {
        return  AdventurerDtoWnoParty
                .builder()
                .id(a.getId())
                .name(a.getName())
                .surname(a.getSurname())
                .dob(a.getDob())
                .rank(a.getRank())
                .role(a.getRole())
                .build();
    }
}
   


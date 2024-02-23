package com.generation.jadventures.model.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.generation.jadventures.entities.Party;
import com.generation.jadventures.model.dto.party.PartyDtoR;
import com.generation.jadventures.model.dto.party.PartyDtoWAdventurer;
import com.generation.jadventures.model.dto.party.PartyDtoWQuest;
import com.generation.jadventures.model.dto.party.PartyDtoWWithPartyLeaderAndNoAdventures;
import com.generation.jadventures.model.dto.party.PartyDtoWnoQuest;
import com.generation.jadventures.model.repositories.PartyRepository;

public class PartyConverter 
{
    @Autowired
    PartyRepository pRepo;

    public Party DtoRToParty (PartyDtoR p)
    {
        return  Party
                .builder()
                .id(p.getId())
                .name(p.getName())
                .authentication_seal(p.getAuthentication_seal())
                .motto(p.getMotto())
                .build();
    }

    public PartyDtoWAdventurer partyToDtoWAdventurer (Party p)
    {
        return  PartyDtoWAdventurer
                .builder()
                .id(p.getId())
                .name(p.getName())
                .authentication_seal(p.getAuthentication_seal())
                .motto(p.getMotto())
                .adventurers(p.getAdventurers())
                .party_leader(p.getParty_leader())
                .build();
    }

    public PartyDtoWQuest partyToDtoWQuest (Party p)
    {
        return  PartyDtoWQuest
                .builder()
                .id(p.getId())
                .name(p.getName())
                .authentication_seal(p.getAuthentication_seal())
                .motto(p.getMotto())
                .quests(p.getQuests())
                .build();
    }

    public PartyDtoWWithPartyLeaderAndNoAdventures partyDtoWWithPartyLeaderAndNoAdventures (Party p)
    {
        return  PartyDtoWWithPartyLeaderAndNoAdventures
                .builder()
                .id(p.getId())
                .name(p.getName())
                .authentication_seal(p.getAuthentication_seal())
                .motto(p.getMotto())
                .party_leader(p.getParty_leader())
                .build();
                
    }
    
    public PartyDtoWnoQuest partyToDtoWnoQuest (Party p)
    {
        return  PartyDtoWnoQuest
                .builder()
                .id(p.getId())
                .name(p.getName())
                .authentication_seal(p.getAuthentication_seal())
                .motto(p.getMotto())
                .build();
    }

}

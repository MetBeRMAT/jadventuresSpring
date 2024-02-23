package com.generation.jadventures.model.dto.party;

import java.util.List;

import com.generation.jadventures.entities.Adventurer;
import com.generation.jadventures.model.dto.guild.GuildDtoWQuest;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data

public class PartyDtoWAdventurer extends PartyDtoBase
{
    public PartyDtoWAdventurer(){}
    private Integer id;
    private List<Adventurer> adventurers;
    private Adventurer party_leader;
}

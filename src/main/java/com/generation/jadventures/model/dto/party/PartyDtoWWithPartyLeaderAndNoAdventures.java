package com.generation.jadventures.model.dto.party;

import com.generation.jadventures.entities.Adventurer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor

public class PartyDtoWWithPartyLeaderAndNoAdventures extends PartyDtoBase
{
    private Integer id;
    private Adventurer party_leader;
}

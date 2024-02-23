package com.generation.jadventures.model.dto.party;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor

public class PartyDtoWnoQuest   extends PartyDtoBase
{
    private Integer id;
}

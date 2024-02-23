package com.generation.jadventures.model.dto.party;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor

public class PartyDtoR extends PartyDtoBase
{
    public PartyDtoR(){}
    private Integer id;
}

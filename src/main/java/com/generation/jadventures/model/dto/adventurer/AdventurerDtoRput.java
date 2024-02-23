package com.generation.jadventures.model.dto.adventurer;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data

public class AdventurerDtoRput extends AdventurerDtoBase
{
    private Integer party_id;
    private Integer id;
    public AdventurerDtoRput(){}
}

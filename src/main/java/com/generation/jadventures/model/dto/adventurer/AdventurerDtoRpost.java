package com.generation.jadventures.model.dto.adventurer;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data

public class AdventurerDtoRpost extends AdventurerDtoBase
{
    public AdventurerDtoRpost(){}
    private Integer id;
    private Integer party_id;
}

package com.generation.jadventures.model.dto.adventurer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor

public class AdventurerDtoWParty    extends AdventurerDtoBase    
{
    private Integer id;
}

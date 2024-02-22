package com.generation.jadventures.model.dto.guild;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor


public class GuildDtoR extends GuildDtoBase
{
    public GuildDtoR(){}
    private Integer id;
}

package com.generation.jadventures.model.dto.guild;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data

public class GuildDtoR extends GuildDtoBase
{
    public GuildDtoR(){}
    private Integer id;
    private Integer guild_id;

}

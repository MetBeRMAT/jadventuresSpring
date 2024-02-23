package com.generation.jadventures.model.dto.guild;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class GuildDtoWNoQuest extends GuildDtoBase
{
    private Integer id;
    private String authentication_seal;
    private String seal_img_url;
}

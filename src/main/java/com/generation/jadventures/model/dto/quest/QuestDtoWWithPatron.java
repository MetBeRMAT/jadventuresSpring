package com.generation.jadventures.model.dto.quest;

import com.generation.jadventures.entities.Guild;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class QuestDtoWWithPatron extends QuestDtoBase
{
    private Integer id;
    private Guild patron;
}

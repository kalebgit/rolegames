package kal.com.rolegames.mappers.characters;

import kal.com.rolegames.dto.PlayerCharacterDTO;
import kal.com.rolegames.models.characters.PlayerCharacter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PlayerCharacterMapper {

    PlayerCharacter toEntity(PlayerCharacterDTO dto);

    void updatePlayerCharacterFromDto(PlayerCharacterDTO source, @MappingTarget PlayerCharacter target);
}

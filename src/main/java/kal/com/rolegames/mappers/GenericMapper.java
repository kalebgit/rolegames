package kal.com.rolegames.mappers;

import kal.com.rolegames.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface GenericMapper<E, D> {
   D toDTO(E data);
   E toEntity(D data);
}


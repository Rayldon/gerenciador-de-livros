package br.jus.tjrj.gerenciadorlivro.adapters.mapper;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.AssuntoDTO;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Assunto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AssuntoMapper {

    AssuntoMapper INSTANCE = Mappers.getMapper(AssuntoMapper.class);

    Assunto toEntity(AssuntoDTO assuntoDTO);

    AssuntoDTO toDTO(Assunto assunto);
}

package br.jus.tjrj.gerenciadorlivro.adapters.mapper;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.AutorDTO;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutorMapper {

    AutorMapper INSTANCE = Mappers.getMapper(AutorMapper.class);

    Autor toEntity(AutorDTO autorDTO);

    AutorDTO toDTO(Autor autor);
}

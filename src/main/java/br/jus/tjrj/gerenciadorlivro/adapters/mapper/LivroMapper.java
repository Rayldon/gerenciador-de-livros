package br.jus.tjrj.gerenciadorlivro.adapters.mapper;

import br.jus.tjrj.gerenciadorlivro.adapters.dto.LivroDTO;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Autor;
import br.jus.tjrj.gerenciadorlivro.domain.entidade.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface LivroMapper {

    LivroMapper INSTANCE = Mappers.getMapper(LivroMapper.class);

    @Mapping(target = "autoresIds", expression = "java(livro.getAutores().stream().map(autor -> autor.getId()).collect(Collectors.toSet()))")
    LivroDTO toDTO(Livro livro);

    @Mapping(target = "autores", source = "autoresIds", qualifiedByName = "mapAutoresIdsToAutores")
    Livro toEntity(LivroDTO livroDTO);

    @Named("mapAutoresIdsToAutores")
    default Set<Autor> mapAutoresIdsToAutores(Set<Long> autoresIds) {
        return autoresIds.stream()
                .map(id -> {
                    Autor autor = new Autor();
                    autor.setId(id);
                    return autor;
                }).collect(Collectors.toSet());
    }
}


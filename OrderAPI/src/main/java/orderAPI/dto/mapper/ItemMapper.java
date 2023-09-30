package orderAPI.dto.mapper;

import orderAPI.dto.ItemDto;
import orderAPI.models.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);
    ItemDto itemToItemDTO (Item item);

}


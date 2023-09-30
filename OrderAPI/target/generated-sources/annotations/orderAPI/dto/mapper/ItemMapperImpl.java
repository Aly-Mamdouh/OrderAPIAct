package orderAPI.dto.mapper;

import javax.annotation.processing.Generated;
import orderAPI.dto.ItemDto;
import orderAPI.models.Item;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-30T12:48:25+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ItemMapperImpl implements ItemMapper {

    @Override
    public ItemDto itemToItemDTO(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        itemDto.setProductId( item.getProductId() );
        itemDto.setQuantity( item.getQuantity() );

        return itemDto;
    }
}

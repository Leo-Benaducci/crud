package br.com.soften.crud.models.dtos;

import br.com.soften.crud.models.entities.ItemSale;
import br.com.soften.crud.models.entities.Sale;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {
	private Sale sale;
	private List<ItemSale> items;
}

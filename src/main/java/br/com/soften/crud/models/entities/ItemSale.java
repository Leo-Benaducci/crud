package br.com.soften.crud.models.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemSale {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn
	private Product product;
	@ManyToOne
	@JoinColumn
	private Sale sale;
	private double qty;
}

package br.com.soften.crud.models.entities;

import lombok.*;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn
	private Client client;
	private LocalDate date;
	private double price;
}

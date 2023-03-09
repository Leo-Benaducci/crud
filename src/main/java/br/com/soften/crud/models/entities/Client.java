package br.com.soften.crud.models.entities;

import br.com.soften.crud.models.enums.State;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String cnpj;
	private String ie;
	private int cep;
	private String address;
	private int number;
	private String district;
	private String complement;
	private String city;
	@Enumerated(EnumType.ORDINAL)
	private State state;
}

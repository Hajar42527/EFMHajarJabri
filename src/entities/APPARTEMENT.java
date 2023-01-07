package entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class APPARTEMENT {

	@Id
	@Column
	@ToString.Include
	private String lettre_appartement;
	
	@Column
	@ToString.Include
	private int nb_pieces_total;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "num_etage")
	private ETAGE etage;
	
}

package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class ETAGE {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@ToString.Include
	private int num_etage;
	
	@Column
	@ToString.Include
	private int nb_appartements_tot;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "num_immeuble")
	private IMMEUBLE immeuble;
	
	@OneToMany(mappedBy = "ETAGE",fetch = FetchType.LAZY)
	private List<APPARTEMENT> appartements;
}

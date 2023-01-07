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
public class IMMEUBLE {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@ToString.Include
	private int num_immeuble;
	
	@Column
	@ToString.Include
	private int nb_etages_total;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "code_rue")
	private RUE rue;
	
	@OneToMany(mappedBy = "IMMEUBLE",fetch = FetchType.LAZY)
	private List<ETAGE> etages;
}







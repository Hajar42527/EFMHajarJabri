package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class RUE {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@ToString.Include
	private int code_rue;
	
	@Column
	@ToString.Include
	private String NOM_rue;
	
	@OneToMany(mappedBy = "RUE",fetch = FetchType.LAZY)
	private List<IMMEUBLE> immeubles;
	
}

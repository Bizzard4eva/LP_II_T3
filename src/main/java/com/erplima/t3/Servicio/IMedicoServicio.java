package com.erplima.t3.Servicio;

import java.util.List;

import com.erplima.t3.Modelo.Medico;

public interface IMedicoServicio {

	List<Medico> listMedico();
	void createMedico(Medico medico);
	Medico getMedico(Integer idMedico);
	void deleteMedico(Medico medico);
}

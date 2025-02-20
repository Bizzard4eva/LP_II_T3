package com.erplima.t3.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erplima.t3.Modelo.Medico;
import com.erplima.t3.Repositorio.IMedicoRepositorio;

@Service
public class MedicoServicioImpl implements IMedicoServicio {
	
	@Autowired
	private IMedicoRepositorio iMedicoRepositorio;

	@Override
	public List<Medico> listMedico() {
		return (List<Medico>) iMedicoRepositorio.findAll();
	}

	@Override
	public void createMedico(Medico medico) {
		iMedicoRepositorio.save(medico);
	}

	@Override
	public Medico getMedico(Integer idMedico) {
		return iMedicoRepositorio.findById(idMedico).orElse(null);
	}

	@Override
	public void deleteMedico(Medico medico) {
		iMedicoRepositorio.deleteById(medico.getIdMedico());
	}

}

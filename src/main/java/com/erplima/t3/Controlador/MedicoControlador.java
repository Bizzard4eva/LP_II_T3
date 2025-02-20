package com.erplima.t3.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erplima.t3.Modelo.Medico;
import com.erplima.t3.Servicio.IMedicoServicio;

@Controller
@RequestMapping("/Vistas")
public class MedicoControlador {

	@Autowired
	private IMedicoServicio iMedicoServicio;
	
	@GetMapping("ListaMedicos")
	public String listMedico(Model model) {
		List<Medico> medicos = iMedicoServicio.listMedico();
		model.addAttribute("listMedico", medicos);
		return "/Vistas/ListaMedicos";
	}
	
	@GetMapping("/RegistrarMedico")
	public String createMedico(Model model) {
		Medico medico = new Medico();
		model.addAttribute("createMedico", medico);
		return "/Vistas/FrmRegistrarMedico";
	}
	
	@PostMapping("/GuardarMedico")
	public String saveMedico(@ModelAttribute Medico medico, Model model) {
		iMedicoServicio.createMedico(medico);
		System.out.println("InfoMedico registrado en la BD!");
		return "redirect:/Vistas/ListaMedicos";
	}
	
	@GetMapping("/EditarMedico/{id}")
	public String updateMedico(@PathVariable("id") Integer idMedico, Model model) {
		Medico medico = iMedicoServicio.getMedico(idMedico);
		model.addAttribute("updateMedico", medico);
		return "/Vistas/FrmRegistrarMedico";
	}
	
	@GetMapping("/EliminarMedico/{id}")
	public String deleteMedico(@PathVariable("id") Integer idMedico, Model model) {
		Medico medico = new Medico();
		medico.setIdMedico(idMedico);
		iMedicoServicio.deleteMedico(medico);
		List<Medico> listMedicos = iMedicoServicio.listMedico();
		model.addAttribute("listMedico", listMedicos);
		return "redirect:/Vistas/ListaMedicos";
	}
	
}

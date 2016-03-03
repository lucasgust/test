package com.fiveware.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fiveware.test.dao.CadastroDAO;
import com.fiveware.test.model.Pessoa;

@Controller
public class CadastroController {

	@Autowired
	private CadastroDAO cadastroDAO;

	@RequestMapping(value = "/")
	public ModelAndView listPessoa(ModelAndView model) {
		List<Pessoa> listPessoa = cadastroDAO.list();
		model.addObject("listPessoa", listPessoa);
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/cadastro")
	public ModelAndView cadastro(ModelAndView model) {
		Pessoa pessoa = new Pessoa();
		model.addObject("pessoa", pessoa);
		model.setViewName("cadastro");
		return model;
	}

	@RequestMapping(value = "/insertPessoa", method = RequestMethod.POST)
	public ModelAndView insertPessoa(@ModelAttribute Pessoa pessoa) {
		cadastroDAO.insert(pessoa);
		return new ModelAndView("redirect:/");
	}
}

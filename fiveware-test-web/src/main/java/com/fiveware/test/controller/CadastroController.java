package com.fiveware.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fiveware.test.dao.CadastroDAO;
import com.fiveware.test.model.Pessoa;

@Controller
public class CadastroController {

	@Autowired
	private CadastroDAO cadastroDAO;

	@RequestMapping(value = "/")
	public ModelAndView cadastro(ModelAndView model) {
		model.addObject("listPessoa", cadastroDAO.list());
		model.setViewName("cadastro");
		return model;
	}
	
	@RequestMapping(value = "/inserir", method = RequestMethod.POST)
	public @ResponseBody
	String inserir(ModelAndView model, @ModelAttribute Pessoa pessoa) {
		cadastroDAO.insert(pessoa);
		List<Pessoa> listPessoa = cadastroDAO.list();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<table border=\"1\">");
		sb.append("<th>ID</th>");
		sb.append("<th>Nome</th>");
		sb.append("<th>Sexo</th>");
		sb.append("<th>Estado Civil</th>");
		sb.append("<th>Empregado</th>");
		for (Pessoa p : listPessoa) {
			sb.append("<tr>");
			sb.append("<td>" + p.getId() + "</td>");
			sb.append("<td>" + p.getNome() + "</td>");
			sb.append("<td>" + p.getSexo() + "</td>");
			sb.append("<td>" + p.getEstadoCivil() + "</td>");
			sb.append("<td>" + p.getEmpregado() + "</td>");
			sb.append("</tr>");
		}
		sb.append("</table>");
		
        return sb.toString();
	}
	
}

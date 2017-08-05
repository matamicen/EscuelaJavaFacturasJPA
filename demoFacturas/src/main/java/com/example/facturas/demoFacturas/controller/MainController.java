package com.example.facturas.demoFacturas.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.facturas.demoFacturas.model.Cliente;
import com.example.facturas.demoFacturas.model.DaoCliente;
import com.example.facturas.demoFacturas.model.DaoFactura;
import com.example.facturas.demoFacturas.model.DaoItems;
import com.example.facturas.demoFacturas.model.DaoProducto;
import com.example.facturas.demoFacturas.model.DaoUsuario;
import com.example.facturas.demoFacturas.model.Factura;
import com.example.facturas.demoFacturas.model.Items;
import com.example.facturas.demoFacturas.model.Usuario;



@Controller
@SessionAttributes("usuariologueado")
public class MainController {
	
	@Autowired
	DaoCliente daocliente;
	@Autowired
	DaoFactura daofactura;
	@Autowired 
	DaoItems daoitems;
	@Autowired 
	DaoProducto daoproducto;
	@Autowired 
	DaoUsuario daousuario;

	
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login (Model model)
	{
		
		
		return "login";
	}
	
	@RequestMapping(value="/chequealogin", method = RequestMethod.POST)
	public String chequealogin (Model model, @RequestParam String nombre, @RequestParam String password)
	{
		String pagina = "login";
		
		if (daousuario.findBynombre(nombre).size() > 0)
		{	
		
		 Factura factura = new Factura();
		 model.addAttribute("fac",factura); 
		 model.addAttribute("usuariologueado",daousuario.findBynombre(nombre).get(0));
		 pagina = "homepage";
		}
	
		
		return pagina;
	}
	
	@RequestMapping(value="/crearfactura", method = RequestMethod.POST)
	public String crearFactura (Model model,@ModelAttribute Factura factura ,
			@ModelAttribute("usuariologueado") Usuario usuario,
			@RequestParam long clienteid)
	{
		
		Cliente cli = daocliente.findOne(clienteid);
		factura.setCliente(cli);
		System.out.println(" imprimo usuario que viene de SessionAttributes id:"+usuario.getIduser() + "nombre:" + usuario.getNombre() + usuario.getPassword());
		factura.setUsuario(usuario);
		
		factura.setFecha(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		daofactura.save(factura);
		
		 model.addAttribute("fac",factura); 
		 model.addAttribute("listafacturas",daofactura.findAll());
		
		
		return "listafacturas";
	}

	@RequestMapping(value="/agregaritems", method = RequestMethod.GET)
	public String agrearItems (Model model, @RequestParam long idfac)
	{
		
		Factura factura = daofactura.findOne(idfac);
		System.out.println("idFac:" + factura.getIdfac());
				
		 model.addAttribute("fac",factura); 
		 model.addAttribute("listaproductos",daoproducto.findAll());
		
		
		
		return "agregandoproductos";
	}

	@RequestMapping(value="/agregaprodfactura", method = RequestMethod.POST)
	public String agregaProddFactura (Model model, @ModelAttribute Factura factura,
			@RequestParam long idprod, @RequestParam int qty )
	{
		Factura factaux = daofactura.findOne(factura.getIdfac());
		Items item = new Items(factaux, daoproducto.findOne(idprod), qty);
		
		daoitems.save(item);
		
		
		 model.addAttribute("fac",factaux); 
		 model.addAttribute("listaproductos",daoproducto.findAll());
		 model.addAttribute("listaitems",daoitems.findByfactura(factaux));
		
			
	
        
		
		return "agregandoproductos";
	}
	
	@RequestMapping(value="/imprimirfactura", method = RequestMethod.GET)
	public String imprimirfactura (Model model, @RequestParam long idfac)
	{
		float total = 0;
		Factura factaux = daofactura.findOne(idfac);
		System.out.println("idFac:" + factaux.getIdfac());
				
		 model.addAttribute("fac",factaux); 
		 model.addAttribute("listaitems",daoitems.findByfactura(factaux));
		 
		 for(Items it: daoitems.findByfactura(factaux))
		 {
			 total = total + ( it.getQty() * it.getProducto().getPrecio() );
		 }
		 
		 model.addAttribute("totalfactura",total); 
		 	
		
		return "impresionfactura";
	}
}

package com.sop.smart_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class SmartShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartShopApplication.class, args);
	}

	@RequestMapping("/")
	String Home(){
		return "Hey, Welcome to SOP Daisy Ice-cream shop!!! \n";
	}

	@RequestMapping("/menuuuuu")
	String menu() {
		String menulist = "";
		IceCream[] menu = IceCreamOrder.getMenu();
		for (IceCream f: menu) {
            menulist += (f.getId()) + ") " + f.getFlavor() + " Price: "+f.getPrice()+"\n==================== ";
            System.out.println((f.getId()) + ") " + f.getFlavor() + " Price: "+f.getPrice()+"\n==================== ");
		}
		return menulist;
	}

	@RequestMapping("/myorder")
    String myorder() {
	    String orderlist = "";
	    List<IceCream> order = IceCreamOrder.myOrder();
	    for (IceCream m: order) {
	        orderlist += "-"+m.getFlavor()+" Ice cream, Price: "+m.getPrice()+" Baht.\n";
        }
        return orderlist;
    }

    @RequestMapping(value = "/addorder{id}", method = RequestMethod.GET)
    List<IceCream> addorder(@PathVariable int id) {
	    System.out.println("added");
	    return IceCreamOrder.orderIceCream(id);
    }

    @RequestMapping(value = "/delorder", method = RequestMethod.GET)
    public List<IceCream> deleatorder(){
        System.out.println("deleted order");
        return Cart.clearIceCream();
    }
}

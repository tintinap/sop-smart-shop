package com.sop.smart_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class SmartShopApplication {

	private IceCreamOrder ico = IceCreamOrder.getInstance();

	public static void main(String[] args) {
		SpringApplication.run(SmartShopApplication.class, args);
	}

	@RequestMapping("/")
	String Home(){
		return "Hey, Welcome to SOP Daisy Ice-cream shop!!! \n";
	}

//	@RequestMapping("/menu")
//	String menu() {
//		String menulist = "";
//		IceCream[] menu = ico.getMenu();
//		for (IceCream f: menu) {
//            menulist += (f.getId()) + ") " + f.getFlavor() + " Price: "+f.getPrice()+" CAD<br> ID to order: " +f.getId()+" <br>==================== <br>";
//            System.out.println((f.getId()) + ") " + f.getFlavor() + " Price: "+f.getPrice()+"\n==================== ");
//		}
//		return menulist;
//	}

//	@RequestMapping("/myorder")
//    String myorder() {
//	    String orderlist = "";
//	    List<IceCream> order = ico.myOrder();
//	    if (order.size() != 0 ) {
//			for (IceCream m: order) {
//				orderlist += "ID: "+m.getId()+" - "+m.getFlavor()+" Ice cream, Price: "+m.getPrice()+" CAD.<br>";
//			}
//			return orderlist;
//		}
//		return "No Order";
//    }
//
//    @RequestMapping(value = "/addorder{id}", method = RequestMethod.GET)
//    List<IceCream> addorder(@PathVariable int id) {
//	    System.out.println("added");
//	    return ico.orderIceCream(id);
//    }
//
//    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
//    public String checkout(){
//		List<IceCream> order = ico.myOrder();
//		double total_price = 0;
//        for (IceCream i : order) {
//			total_price += i.getPrice();
//		}
//		System.out.println("You have to pay "+total_price+" CAD.");
//		Cart.clearIceCream();
//        return "You have to pay "+total_price+" CAD";
//    }
    //============================= Assign 2 ============================
	@RequestMapping("/menu")
	public ResponseEntity<IceCream[]> menu() {
		String menulist = "";
		IceCream[] menu = ico.getMenu();
		for (IceCream f: menu) {
			menulist += (f.getId()) + ") " + f.getFlavor() + " Price: "+f.getPrice()+" CAD<br> ID to order: " +f.getId()+" <br>==================== <br>";
			System.out.println((f.getId()) + ") " + f.getFlavor() + " Price: "+f.getPrice()+"\n==================== ");
		}
		return new ResponseEntity<IceCream[]>(ico.getMenu(), HttpStatus.OK);
	}

	@RequestMapping("/myorder")
	public ResponseEntity<List<IceCream>> myorder() {
		String orderlist = "";
		List<IceCream> order = ico.myOrder();
		if (order.size() != 0 ) {
			for (IceCream m: order) {
				orderlist += "ID: "+m.getId()+" - "+m.getFlavor()+" Ice cream, Price: "+m.getPrice()+" CAD.<br>";
			}
			return new ResponseEntity<List<IceCream>>(ico.myOrder(), HttpStatus.OK);
		}
		return new ResponseEntity<List<IceCream>>(new ArrayList<IceCream>(), HttpStatus.OK);
	}

	@RequestMapping(value = "/addorder{id}", method = RequestMethod.GET)
	ResponseEntity<List<IceCream>> addorder(@PathVariable int id) {
		System.out.println("added");
		return new ResponseEntity<List<IceCream>>(ico.orderIceCream(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ResponseEntity<List<IceCream>> checkout(){
		List<IceCream> order = ico.myOrder();
		double total_price = 0;
		for (IceCream i : order) {
			total_price += i.getPrice();
		}
		System.out.println("You have to pay "+total_price+" CAD.");
		Cart.clearIceCream();
		return new ResponseEntity<List<IceCream>>(ico.myOrder(), HttpStatus.OK);
	}
}

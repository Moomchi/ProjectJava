package com.mimi.FoodDelivery.controllers;


import com.mimi.FoodDelivery.entities.*;
import com.mimi.FoodDelivery.repositories.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/menu")
public class MenuController {

    private final BurgerRepository burgerRepository;
    private CityRepository cityRepository;
    private final DealsRepository dealsRepository;
    private final DessertRepository dessertRepository;
    private final DrinkRepository drinkRepository;
    private final PizzaRepository pizzaRepository;
    private final SaladRepository saladRepository;
    private final SauceRepository sauceRepository;
    private DistrictRepository districtRepository;
    private final OrdersRepository ordersRepository;

    MenuController(PizzaRepository pizzaRepository,
                   DessertRepository dessertRepository,
                   BurgerRepository burgerRepository,
                   DrinkRepository drinkRepository,
                   SaladRepository saladRepository,
                   SauceRepository sauceRepository,
                   OrdersRepository ordersRepository,
                   DealsRepository dealsRepository) {
        this.burgerRepository= burgerRepository;
        this.pizzaRepository = pizzaRepository;
        this.dessertRepository = dessertRepository;
        this.drinkRepository = drinkRepository;
        this.saladRepository = saladRepository;
        this.sauceRepository = sauceRepository;
        this.ordersRepository = ordersRepository;
        this.dealsRepository = dealsRepository;
    }

    @GetMapping("/all/deals")
    public List<Deals> getAllDeals() {
        return new ArrayList<>(dealsRepository.findAll());
    }

    @GetMapping("/all")
     public List<Object> getAll() {
        List<Object> foodList = new ArrayList<>();
        foodList.addAll(pizzaRepository.findAll());
        foodList.addAll(burgerRepository.findAll());
        foodList.addAll(dessertRepository.findAll());
        foodList.addAll(drinkRepository.findAll());
        foodList.addAll(saladRepository.findAll());
        foodList.addAll(sauceRepository.findAll());
        return foodList;
    }

    @GetMapping("/product")
    public ResponseEntity<?> getProductByName(@RequestParam(required = false) String name,
                                              @RequestParam Integer num){
        if (name==null || name.isBlank()) return ResponseEntity.ok().body("Не сте задали име");
        Optional<?> result=null;
        switch (num){
            case 0: result=burgerRepository.findByName(name.toLowerCase()); break;
            case 1: result=pizzaRepository.findByName(name.toLowerCase()); break;
            case 2: result=saladRepository.findByName(name.toLowerCase()); break;
            case 3: result=dessertRepository.findByName(name.toLowerCase()); break;
            case 4: result=drinkRepository.findByName(name.toLowerCase()); break;
            case 5: result=sauceRepository.findByName(name.toLowerCase()); break;
        }
        return result.isPresent()? ResponseEntity.ok(result) : ResponseEntity.ok("Не е открит запис");
    }

    @GetMapping("product/search/id")
    public Optional<?> getProductById(@RequestParam Integer num,
                                      @RequestParam Long id){
        Optional<?>result=null;
        switch (num){
            case 0: result = burgerRepository.findById(id); break;
            case 1: result = pizzaRepository.findById(id); break;
            case 2: result = saladRepository.findById(id); break;
            case 3: result = dessertRepository.findById(id); break;
            case 4: result = drinkRepository.findById(id); break;
            case 5: result = sauceRepository.findById(id); break;
        }
        return result;
    }

    @GetMapping("/product/search/page")
    public  ResponseEntity<?> paginateProducts(@RequestParam(value ="currentPage", defaultValue = "1") int currentPage,
                                               @RequestParam(value="perPage", defaultValue = "5") int perPage,
                                               @RequestParam(required = false) String name,
                                               @RequestParam Integer num) {
        Pageable pageable = PageRequest.of(currentPage-1,perPage);

        Page<?> products =null;
        switch (num){
            case 0: products = burgerRepository.findPageBurger(pageable,name.toLowerCase()); break;
            case 1: products = pizzaRepository.findPagePizza(pageable,name.toLowerCase()); break;
            case 2: products = saladRepository.findPageSalad(pageable,name.toLowerCase()); break;
            case 3: products = dessertRepository.findPageDessert(pageable,name.toLowerCase()); break;
            case 4: products = drinkRepository.findPageDrink(pageable,name.toLowerCase()); break;
            case 5: products = sauceRepository.findPageSauce(pageable,name.toLowerCase()); break;
        }

        Map<String, Object> response = new HashMap<>();
        response.put("products",products.getContent());
        response.put("currentPage", products.getNumber()+1);
        response.put("totalItems",products.getTotalElements());
        response.put("totalPages",products.getTotalPages());

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/product/search/all")
    public ResponseEntity<?> getProductAll(@RequestParam Integer num){
        List<?> products=null;
        switch (num){
            case 0: products = burgerRepository.findAll(); break;
            case 1: products = pizzaRepository.findAll(); break;
            case 2: products = saladRepository.findAll(); break;
            case 3: products = dessertRepository.findAll(); break;
            case 4: products = drinkRepository.findAll(); break;
            case 5: products = sauceRepository.findAll(); break;
        }

        Map<String, Object> response = new HashMap<>();
        response.put("products",products);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/orders/save")
    public ResponseEntity<?> saveOrder(@RequestParam(required = false) Long id,
                                       @RequestParam(required = false) String customerName,
                                       @RequestParam(required = false) String orderList) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String currentDate=formatter.format(date);

        Boolean received = false;

        Orders currentOrder = new Orders(id,received,orderList,customerName,currentDate);
        currentOrder = ordersRepository.save(currentOrder);

        Map<String,Object> response = new HashMap<>();
        response.put("Order", currentOrder);
        response.put("messаge","Успешно записан");
        return new ResponseEntity<>(response,HttpStatus.OK);
        }

}

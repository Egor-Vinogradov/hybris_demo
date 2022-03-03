package mobilephone.controller;

import de.hybris.platform.catalog.CatalogVersionService;
import mobilephone.data.OrderPhoneData;
import mobilephone.facades.OrderPhoneFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RestOrderPhoneController {

    private final OrderPhoneFacade orderPhoneFacade;

    // не работает без этого поиск
    private static final String CATALOG_ID = "mobilephoneProductCatalog";
    private static final String CATALOG_VERSION_NAME = "Online";

    private final CatalogVersionService catalogVersionService;

    public RestOrderPhoneController(OrderPhoneFacade orderPhoneFacade,
                                    CatalogVersionService catalogVersionService) {
        this.orderPhoneFacade = orderPhoneFacade;
        this.catalogVersionService = catalogVersionService;
    }

    @GetMapping(value = "/orders_phone")
    @ResponseBody
    public ResponseEntity<?> getAllOrders() {

        this.catalogVersionService.setSessionCatalogVersion(CATALOG_ID, CATALOG_VERSION_NAME);

        List<OrderPhoneData> list = this.orderPhoneFacade.getAllOrderPhone();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/orders_phone/{code}")
    @ResponseBody
    public ResponseEntity<?> getOrderByCode(@PathVariable String code) {
        this.catalogVersionService.setSessionCatalogVersion(CATALOG_ID, CATALOG_VERSION_NAME);
        OrderPhoneData orderPhoneData = this.orderPhoneFacade.getOrderPhoneByCode(code);
        return new ResponseEntity<>(orderPhoneData, HttpStatus.OK);
    }

    @PostMapping(value = "/orders_phone")
    public ResponseEntity<?> createOrder(@RequestBody OrderPhoneData order) {
        this.catalogVersionService.setSessionCatalogVersion(CATALOG_ID, CATALOG_VERSION_NAME);
        this.orderPhoneFacade.createOrder(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

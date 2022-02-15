package mobilephone.controller;

import de.hybris.platform.catalog.CatalogVersionService;
import mobilephone.data.PhoneData;
import mobilephone.data.PhoneSummaryData;
import mobilephone.facades.PhoneDetailsFacade;
import mobilephone.facades.PhoneFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestModelPhone {

    private final PhoneFacade phoneFacade;
    private final PhoneDetailsFacade phoneDetailsFacade;

    // не работает без этого поиск
    private static final String CATALOG_ID = "mobilephoneProductCatalog";
    private static final String CATALOG_VERSION_NAME = "Online";

    private final CatalogVersionService catalogVersionService;

    public RestModelPhone(PhoneFacade phoneFacade, PhoneDetailsFacade phoneDetailsFacade, CatalogVersionService catalogVersionService) {
        this.phoneFacade = phoneFacade;
        this.phoneDetailsFacade = phoneDetailsFacade;
        this.catalogVersionService = catalogVersionService;
    }

    @GetMapping(value = "/phone")
    @ResponseBody
    public ResponseEntity<?> getPhone(@RequestParam("phone") String phoneId) {

        this.catalogVersionService.setSessionCatalogVersion(CATALOG_ID, CATALOG_VERSION_NAME);

        PhoneData phoneData = this.phoneFacade.getPhone(phoneId);
        return new ResponseEntity<>(phoneData, HttpStatus.OK);
    }

    @GetMapping(value = "/phone/{code}")
    @ResponseBody
    public ResponseEntity<?> getPhoneDetails(@PathVariable("code") String phoneId) {

        this.catalogVersionService.setSessionCatalogVersion(CATALOG_ID, CATALOG_VERSION_NAME);

        PhoneSummaryData phoneData = this.phoneDetailsFacade.getPhone(phoneId);
        return new ResponseEntity<>(phoneData, HttpStatus.OK);
    }
}

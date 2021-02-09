package com.aleksandar.location.controllers;

import com.aleksandar.location.entities.Location;
import com.aleksandar.location.repositories.LocationRepository;
import com.aleksandar.location.services.LocationService;
import com.aleksandar.location.util.EmailUtil;
import com.aleksandar.location.util.ReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class LocationController {

    @Autowired
    LocationService service;

    @Autowired
    LocationRepository repository;

    @Autowired
    EmailUtil emailUtil;

    @Autowired
    ServletContext servletContext;

   @Autowired
    ReportUtil reportUtil;




    @RequestMapping("/showCreate")
    public String showCreate(){
        return "createLocation";
    }

    @RequestMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("locaion")Location location, ModelMap modelMap){
        Location locationSaved = service.saveLocation(location);
        String msg = "Location saved with id: "+ locationSaved.getId();
        modelMap.addAttribute("msg",msg);
        emailUtil.sendEmail("aleksandarunchev@gmail.com","Location Saved","Location Saved Successfully " +
                "and about to return a response");
        return "createLocation";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap){
        List<Location> locations = service.getAllLocations();
        modelMap.addAttribute("locations",locations);
        return "displayLocations";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap){
        Location location = service.getLocationById(id);
        service.deleteLocation(location);
        List<Location> allLocations = service.getAllLocations();
        modelMap.addAttribute("locations",allLocations);
        return "displayLocations";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap){
        Location location = service.getLocationById(id);
        modelMap.addAttribute("location",location);

        return "updateLocation";
    }

    @RequestMapping("/updateLoc")
    public String updateLocation(@ModelAttribute("location") Location location,ModelMap modelMap){

        Location location1= service.updateLocation(location);

        List<Location> locations = service.getAllLocations();
        modelMap.addAttribute("locations",locations);
        return "displayLocations";
    }

    @RequestMapping("/generateReport")
    public String generateReport(){

        String path = servletContext.getRealPath("/");

        List<Object[]> data = repository.findTypeAndTypeCount();

        reportUtil.generatePieChart(path,data);
        return "report";
    }
}

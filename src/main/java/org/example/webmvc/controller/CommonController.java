package org.example.webmvc.controller;

import org.example.webmvc.entity.RecordStatus;
import org.example.webmvc.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {
    private final RecordService recordService;

    @Autowired
    public CommonController(RecordService recordService) {
        this.recordService = recordService;
    }

    @RequestMapping("/")
    public String redirectToHomePage() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public ModelAndView getMainPage(@RequestParam(name = "filter", required = false) String filterMode) {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("main-page");
        var records = recordService.findAllRecords(filterMode);
        modelAndView.getModelMap().addAttribute("countActive", records.getCountActiveRecords());
        modelAndView.getModelMap().addAttribute("countNotActive", records.getCountNotActiveRecords());
        modelAndView.getModelMap().addAttribute("records", records.getRecords());
        return modelAndView;
    }

    @RequestMapping(value = "/add-record", method = RequestMethod.POST)
    public String addRecord(@RequestParam String title) {
        recordService.saveRecord(title);
        return "redirect:/home";
    }

    @RequestMapping(value = "/make-record-done", method = RequestMethod.POST)
    public String makeRecordDone(@RequestParam int id,
                                 @RequestParam(name = "filter", required = false) String filterMode) {
        recordService.updateRecordStatus(id, RecordStatus.DONE);
        return "redirect:/home" + ((filterMode != null && filterMode.isBlank()) ? "?filter=" + filterMode : "");
    }

    @RequestMapping(value = "/delete-record", method = RequestMethod.POST)
    public String deleteRecord(QueryParameters parameters) {
        recordService.deleteRecord(parameters.getId());
        return "redirect:/home" + ((parameters.getFilter() != null && parameters.getFilter().isBlank()) ? "?filter=" + parameters.getFilter() : "");
    }
}

class QueryParameters {
    private int id;
    private String filter;

    public QueryParameters(String filter, int id) {
        this.filter = filter;
        this.id = id;
    }

    public String getFilter() {
        return filter;
    }

    public int getId() {
        return id;
    }
}

package de.schulz.exercise.timeformatter.controller;

import de.schulz.exercise.timeformatter.model.Time;
import de.schulz.exercise.timeformatter.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TimeController {

    private final TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/")
    public String testForm(Model model) {
        model.addAttribute("time", new Time());
        return "time";
    }

    @PostMapping("/")
    public String testSubmit(@ModelAttribute Time time, Model model) {
        String convertedTime = timeService.convertTimeIntoLanguage(time);
        time.setTime(convertedTime);
        model.addAttribute("time", time);
        return "result";
    }
}

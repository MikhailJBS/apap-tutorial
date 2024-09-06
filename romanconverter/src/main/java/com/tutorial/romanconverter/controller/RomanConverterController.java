package com.tutorial.romanconverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tutorial.romanconverter.dto.RequestDTO;
import com.tutorial.romanconverter.model.RomanConverter;

@Controller
public class RomanConverterController {

    @GetMapping(value = "/")
    public String home(Model model) {
        return "view-home.html";
    }

    @GetMapping(value = "/about-me")
    public String aboutMe(Model model) {
        String name = "Mikhail Haritz";
        String npm = "2206082764";
        model.addAttribute("name", name);
        model.addAttribute("npm", npm);
        return "about-me.html";
    }

    private String getRomanConverterPage(String roman, Model model) {
        try {
            final RomanConverter romanConverter = new RomanConverter(roman);
            if (!romanConverter.isValidRoman()) {
                throw new IllegalArgumentException("Invalid Roman numeral");
            }
            model.addAttribute("romanConverter", romanConverter);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", "Terdapat Kesalahan Pada Input");
        }
        return "view-conversion-result.html";
    }

    @GetMapping(value = "/roman-converter/{roman}")
    public String romanConverterWithPathVariable(@PathVariable(value = "roman") String roman, Model model) {
        return getRomanConverterPage(roman, model);
    }

    @GetMapping(value = "/roman-converter")
    public String romanConverterWithReqParam(@RequestParam(value = "roman") String roman, Model model) {
        return getRomanConverterPage(roman, model);
    }

    @GetMapping(value = "/convert")
    public String getRomanCoverterWithView(Model model) {
        var requestDTO = new RequestDTO();
        model.addAttribute("requestDTO", requestDTO);
        return "form.html";
    }


    @PostMapping(value = "/convert")
    public String postRomanConverterWithView(
        @ModelAttribute RequestDTO requestDTO, Model model
    ) {
        String romanFromView = requestDTO.getRoman();
        return getRomanConverterPage(romanFromView, model);
    }


}

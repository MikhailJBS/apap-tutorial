package com.tutorial.romanconverter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tutorial.romanconverter.dto.IntegerRequestDTO;
import com.tutorial.romanconverter.model.IntegerConverter;

@Controller
public class IntegerConverterController {

    @GetMapping(value = "/convert-integer")
    public String getIntegerConverterWithView(Model model) {
        var integerRequestDTO = new IntegerRequestDTO();
        model.addAttribute("IntegerRequestDTO", integerRequestDTO);
        return "form-integer-converter.html";
    }

    @PostMapping(value = "/convert-integer")
    public String postIntegerConverterWithView(@ModelAttribute IntegerRequestDTO integerRequestDTO, Model model) {
        return getIntegerConverterPage(integerRequestDTO.getInteger(), model);
    }

    private String getIntegerConverterPage(String integer, Model model) {
        try {
            int integerInt = Integer.parseInt(integer);
            final IntegerConverter integerConverter = new IntegerConverter(integerInt);
            model.addAttribute("integerConverter", integerConverter);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", "Terdapat Kesalahan Pada Input");
        }
        return "view-conversion-result-integer.html";
    }
}

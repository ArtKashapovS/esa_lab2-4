package ru.ssau.esa_lab24.controllers.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.ssau.esa_lab24.models.Category;
import ru.ssau.esa_lab24.services.CategoryService;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoriesRESTController {

    private final CategoryService categoryService;

    @Autowired
    public CategoriesRESTController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping(value = "/categories", produces = MediaType.APPLICATION_XML_VALUE)
    public ModelAndView getCategoriesXml() throws JsonProcessingException {
        List<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("categories");
        Source source = new StreamSource(new ByteArrayInputStream(new XmlMapper().writeValueAsBytes(categories)));
        modelAndView.addObject(source);
        return modelAndView;
    }
}

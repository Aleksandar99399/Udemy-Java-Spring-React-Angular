package com.aleksandar.documentweb.controllers;

import com.aleksandar.documentweb.entities.Document;
import com.aleksandar.documentweb.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class DocumentController {

    @Autowired
    private DocumentRepository repository;

    @RequestMapping(value = "/displayUpload",method = RequestMethod.GET)
    public String displayUpload(ModelMap modelMap){
        List<Document> documents = repository.findAll();
        System.out.println(documents.size());
        modelMap.addAttribute("documents",documents);

        return "displayUpload";
    }

    @RequestMapping(value = "/displayUpload",method = RequestMethod.POST)
    public String upload(@RequestParam("document") MultipartFile multipartFile,
                         @RequestParam("id") Long id,
                         ModelMap modelMap){

        Document document=new Document();
        document.setId(id);
        document.setName(multipartFile.getOriginalFilename());
        try {
            document.setData(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        repository.save(document);

        List<Document> documents = repository.findAll();
        System.out.println(documents.size());
        modelMap.addAttribute("documents",documents);

        return "displayUpload";
    }

    @RequestMapping("download")
    public StreamingResponseBody download(@RequestParam("id") long id, HttpServletResponse response){
        Document document = repository.findById(id).get();
        byte[] data = document.getData();

        response.setHeader("Content-Disposition","attachment;filename=download.jpeg");

        return outputStream -> {
            outputStream.write(data);
        };
    }

}

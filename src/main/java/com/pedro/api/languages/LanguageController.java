package com.pedro.api.languages;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LanguageController {

  @Autowired
  private LanguageRepository repository;

  @GetMapping(value="/languages")
  public List<Language> getLanguages(@RequestParam  Optional<String> sortBy, Optional<String> sortOrder) {
    if (sortBy.isPresent()) {
      String sortField = sortBy.get();
      
      if (sortField.equalsIgnoreCase("ranking") || sortField.equalsIgnoreCase("stars")) {
        if (sortOrder.isPresent() && sortOrder.get().equalsIgnoreCase("desc")) {
          return repository.findAll(Sort.by(sortField).descending());
        } else {
          return repository.findAll(Sort.by(sortField));
        }
      }
    }

    return repository.findAll();
  }

  @PostMapping(value = "/languages")
  public ResponseEntity<Language> createLanguage(@RequestBody Language language) {
    Language createdLanguage = repository.save(language);
    return new ResponseEntity<>(createdLanguage, HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/languages/{id}")
  public ResponseEntity <?> deleteLanguage(@PathVariable String id) {
    Optional<Language> language = repository.findById(id);
    
    if (language.isEmpty()) {
      return ResponseEntity.notFound().build();
    } 
    
    repository.deleteById(id);
    return ResponseEntity.ok().build();
  }

  @PatchMapping(value = "/languages/{id}")
  public ResponseEntity<Language> updateLanguageName(@PathVariable String id, @RequestBody Language newInformation) {
    Optional<Language> language = repository.findById(id);
    
    if (language.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    String newName = language.get().getName();
    String newImage = language.get().getImage();

    if (!(newInformation.getName() == null)) {
      newName = newInformation.getName();
    }
    if (!(newInformation.getImage() == null)) {
      newImage = newInformation.getImage();
    }

    language.get().setName(newName);
    language.get().setImage(newImage);

    Language updatedLanguage = repository.save(language.get());

    return new ResponseEntity<>(updatedLanguage, HttpStatus.OK);
  }

  @PatchMapping(value = "/languages/add-star/{id}")
  public ResponseEntity<Language> addStarToLanguage(@PathVariable String id) {
    Optional<Language> language = repository.findById(id);
    
    if (language.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    language.get().addStar();
    Language updatedLanguage = repository.save(language.get());

    return new ResponseEntity<>(updatedLanguage, HttpStatus.OK);
  }
}

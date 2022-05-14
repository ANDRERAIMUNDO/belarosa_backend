package me.andreraimundo.belarosa_backend.resources;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import me.andreraimundo.belarosa_backend.services.FirebaseImageService;

@RestController
@RequestMapping("/firebase/storage")
public class FirebaseResource {
    
    @Autowired
    FirebaseImageService firebaseImageService;
    
    @RequestMapping(value="/profiles//{id}", method=RequestMethod.POST)
	  public ResponseEntity<?>uploadProfilePicture(@RequestParam(name="file") MultipartFile file) throws IOException{
		String obj = firebaseImageService.saveProfiles(file);
		return ResponseEntity.ok(obj);
	}
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/products/{id}", method=RequestMethod.POST)
	  public ResponseEntity<?>uploadProdutcsPicture(@RequestParam(name="file") MultipartFile file, @PathVariable Integer id) throws IOException{
		String obj = firebaseImageService.saveProduts(file, id);
		return ResponseEntity.ok(obj);
	}
}

package apap.tutorial.manpromanpro.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import apap.tutorial.manpromanpro.restservice.PekerjaRestService;
import apap.tutorial.manpromanpro.restservice.*;
import apap.tutorial.manpromanpro.restdto.response.*;
import apap.tutorial.manpromanpro.restdto.request.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.hibernate.exception.ConstraintViolationException;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/developer")
public class DeveloperRestController {
    
    @Autowired
    private DeveloperRestService developerRestService;

    @GetMapping("/viewall")
    public ResponseEntity<?> listDeveloper() {
        var baseResponseDTO = new BaseResponseDTO<List<DeveloperOptionResponseDTO>>();
        List<DeveloperOptionResponseDTO> listDeveloper = developerRestService.getAllDevelopers();

        baseResponseDTO.setStatus(HttpStatus.OK.value());
        baseResponseDTO.setData(listDeveloper);
        baseResponseDTO.setMessage(String.format("List developer berhasil ditemukan"));
        baseResponseDTO.setTimestamp(new Date());
        return new ResponseEntity<>(baseResponseDTO, HttpStatus.OK);
    }

}

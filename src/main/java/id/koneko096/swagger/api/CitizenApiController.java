package id.koneko096.swagger.api;

import id.koneko096.swagger.data.model.Citizen;
import id.koneko096.swagger.data.repositories.CitizenRepository;
import id.koneko096.swagger.utils.NullAwareBeanUtilsBean;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-20T18:37:09.423+07:00")

@Controller
public class CitizenApiController implements CitizenApi {

    @Autowired
    private CitizenRepository employeeRepository;

    public ResponseEntity<Citizen> createCitizen(@RequestBody Citizen citizen) {
        Optional<Citizen> newEmployee = Optional.ofNullable(employeeRepository.save(citizen));
        if (newEmployee.isPresent())
            return new ResponseEntity<Citizen>(newEmployee.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> deleteCitizen(@ApiParam(value = "ID of Citizen to delete",required=true ) @PathVariable("citizenId") Long citizenId) {

        Optional<Citizen> oldEmployee = Optional.ofNullable(employeeRepository.findOne(citizenId));
        if (!oldEmployee.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        try {
            employeeRepository.delete(citizenId);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<Citizen>> getAllCitizens() {
        return new ResponseEntity<List<Citizen>>(employeeRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Citizen> getCitizenDetails(@ApiParam(value = "ID of Citizen to return",required=true ) @PathVariable("citizenId") Long citizenId) {
        Optional<Citizen> employee = Optional.ofNullable(employeeRepository.findOne(citizenId));
        if (employee.isPresent())
            return new ResponseEntity<Citizen>(employee.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Citizen> updateCitizen(@ApiParam(value = "ID of Citizen to update",required=true ) @PathVariable("citizenId") Long citizenId, @RequestBody Citizen citizen) {
        Optional<Citizen> oldEmployee = Optional.ofNullable(employeeRepository.findOne(citizenId));
        if (!oldEmployee.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        NullAwareBeanUtilsBean.copyNonNullProperties(citizen, oldEmployee.get());
        Optional<Citizen> newEmployee = Optional.ofNullable(employeeRepository.save(oldEmployee.get()));
        if (newEmployee.isPresent())
            return new ResponseEntity<Citizen>(newEmployee.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}

package com.friendsapplication.gurukulam.controller;

import com.friendsapplication.gurukulam.model.*;
import com.friendsapplication.gurukulam.repository.GurukulamJDBCRepo;
import com.friendsapplication.gurukulam.repository.GurukulamRepo;
import com.friendsapplication.gurukulam.service.GurukulamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/gurukulam")
@RestController
@CrossOrigin(origins="*")
public class GurukulamController {

    @Autowired
    public GurukulamRepo gurukulamRepo;

    @Autowired
    public GurukulamService gurukulamService;

    @Autowired
    public GurukulamJDBCRepo gurukulamJDBCRepo;

    @PostMapping(value="/getuserinfo")
    public ResponseEntity<Optional> getUserInfo(@RequestBody LoginReq req) {
        Optional<Users> userInfo = gurukulamRepo.findByUserid(req.getUsername());
        /*if(userInfo != null && userInfo.get().mypassword.equalsIgnoreCase(req.getPassword())){
            return new ResponseEntity<String>("Valid User", HttpStatus.OK);
        }else {*/
        if(userInfo.isPresent()) {
            System.out.println("User not available");
        }
        return new ResponseEntity<Optional>(userInfo, HttpStatus.OK);
       // }
    }

    @GetMapping(value="/getAllUsersInfo")
    public ResponseEntity<Iterable> getAllUsers() {
        Iterable<Users> usersList = gurukulamRepo.findAll();
        return new ResponseEntity<Iterable>(usersList, HttpStatus.OK);
    }


    @GetMapping("/getSubjectsInfo")
    public ResponseEntity<?> getSubjectsInfo() {
        Iterable<SubjectMaster> info = gurukulamService.getSubjectsInfo();
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @GetMapping("/getSyllabusInfo")
    public ResponseEntity<?> getSyllabusInfo() {
        Iterable<SyllabusMaster> info = gurukulamService.getSyllabusInfo();
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @GetMapping("/getSyllabusInfo/{subjectCode}")
    public ResponseEntity<?> getSyllabus(@PathVariable String subjectCode) {
        List<SyllabusMaster> info = gurukulamService.getSyllabus(subjectCode);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @GetMapping("/getSubject_SyllabusInfo")
    public ResponseEntity<?> getSubject_SyllabusInfo() {
        List<SubjectWithSyllabus> info = gurukulamService.getSubject_SyllabusInfo();
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @GetMapping("/getSyllabus_ConceptsInfo")
    public ResponseEntity<?> getSyllabus_ConceptsInfo() {
        List<TeluguConcepts> info = gurukulamService.getSyllabus_ConceptsInfo();
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @GetMapping("/getSyllabus_ConceptsInfo/{syllabusId}")
    public ResponseEntity<?> getSyllabusPerConceptsInfo(@PathVariable int syllabusId) {
        List<TeluguConcepts> info = gurukulamService.getSyllabusPerConceptsInfo(syllabusId);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @GetMapping("/getSyllabus_Concepts_Random/{syllabusId}")
    public ResponseEntity<?> getSyllabus_Concepts_Random(@PathVariable int syllabusId) {
        List<TeluguConcepts> info = gurukulamService.getSyllabus_Concepts_Random(syllabusId);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }
}

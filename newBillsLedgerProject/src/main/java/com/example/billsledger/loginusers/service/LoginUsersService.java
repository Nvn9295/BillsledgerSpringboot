package com.example.billsledger.loginusers.service;

import com.example.billsledger.loginusers.model.dto.LoginUsersDto;
import com.example.billsledger.loginusers.model.entity.LoginUsers;
import com.example.billsledger.loginusers.repository.LoginUsersRepository;
import com.example.billsledger.loginusers.transformer.LoginUsersDtoToEntityConverter;
import com.example.billsledger.loginusers.transformer.LoginUsersEntityToDtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LoginUsersService {
    private final LoginUsersRepository repository;
    private final LoginUsersDtoToEntityConverter loginUsersDtoToEntityConverter;
    private final LoginUsersEntityToDtoConverter loginUsersEntityToDtoConverter;

    public LoginUsersDto login(LoginUsersDto loginUsersDto) {
        LoginUsers loginUser = repository.findByUserName(loginUsersDto.getUserName());
        LoginUsersDto loginUsersDtoForResponse = new LoginUsersDto();
        if (loginUser != null) {
            if (loginUsersDto.getPassword().equals(loginUser.getPassword())) {
                loginUsersDtoForResponse = loginUsersEntityToDtoConverter.entityToDto(loginUser);
                loginUsersDtoForResponse.setMessage("Login Successful");
            } else {
                loginUsersDtoForResponse.setMessage("Invalid Password");
            }
        } else {
            loginUsersDtoForResponse.setMessage("Invalid Credentials");
        }
        return loginUsersDtoForResponse;
    }

    public ResponseEntity<LoginUsersDto> addUser(LoginUsersDto loginUserDto) {
        LoginUsers loginUsers = new LoginUsers();
        String email = loginUserDto.getEmail();
        loginUsers = repository.findByEmail(email);
        if (loginUsers != null) {
            loginUserDto.setMessage(email + " is already exist");
            return ResponseEntity.ok(loginUserDto);
        } else {
            loginUsers = loginUsersDtoToEntityConverter.dtoToEntity(loginUserDto);
            loginUserDto = loginUsersEntityToDtoConverter.entityToDto(repository.save(loginUsers));
            loginUserDto.setMessage("Success");
            return ResponseEntity.ok(loginUserDto);
        }
    }


    public List<LoginUsersDto> getUsers() {
        List<LoginUsers> loginUsers = repository.findAll();
        return loginUsersEntityToDtoConverter.entityToDto(loginUsers);
    }

    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }
}




//    @GetMapping("/data/check/{candidateId}")
//    public ResponseEntity<?> checkDataPresence(@PathVariable String candidateId) {
//        try {
//            Optional<Interviewer> interviewerOptional = interviewerRepo.findByCandidateId(candidateId);
//
//            if (interviewerOptional.isPresent()) {
//                Interviewer interviewer = interviewerOptional.get();
//                if (interviewer.getRoundOneStatus() != null && interviewer.getRoundoneRemarks() != null) {
//                    return ResponseEntity.ok().body("{\"dataPresent\": true}");
//                } else {
//                    return ResponseEntity.ok().body("{\"dataPresent\": false}");
//                }
//            } else {
//                return ResponseEntity.ok().body("{\"dataPresent\": false}");
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"An error occurred\"}");
//        }
//    }



//
//    public ResponseEntity<Map<String,String>> loginBusiness(@RequestBody Map<String, String> loginData) {
//
//
//        String businessId = loginData.get("businessId");
//        String password = loginData.get("password");
//
//        Business business = businessService.findBusinessById(businessId);
//
//        if (business != null && password.equals(business.getPassword())) {
//            Map<String, String> response = new HashMap<>();
//            response.put("message", "Login successful");
//            return ResponseEntity.ok(response);
//        }
//        Map<String, String> errorResponse = new HashMap<>();
//        errorResponse.put("message", "Invalid business ID or password");
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
//
//
//    }

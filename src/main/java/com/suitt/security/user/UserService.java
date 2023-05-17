package com.suitt.security.user;

import com.suitt.tables.client.ClientDto;
import com.suitt.tables.client.ClientRepository;
import com.suitt.tables.client.ClientService;
import com.suitt.tables.employee.EmployeeDto;
import com.suitt.tables.employee.EmployeeRepository;
import com.suitt.tables.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    protected final ClientRepository clientRepository;
    protected final EmployeeRepository employeeRepository;

    public UserDto getUser(String email){
        return employeeRepository.findById(email)
                .map(EmployeeService::toDto)
                .orElse(
                        clientRepository.findById(email)
                                .map(ClientService::toDto)
                                .orElse(null)
                );
    }



    public List<UserDto> getEmployees(){
        return employeeRepository.findAll().stream()
                .map(EmployeeService::toDto)
                .collect(Collectors.toList());
    }

    public List<UserDto> getClients(){
        return clientRepository.findAll().stream()
                .map(ClientService::toDto)
                .collect(Collectors.toList());
    }




    public EmployeeDto getEmployee(String email){
        return (EmployeeDto) employeeRepository.findById(email)
                .map(EmployeeService::toDto)
                .orElse(null);
    }
    public ClientDto getClient(String email){
        return (ClientDto) clientRepository.findById(email)
                .map(ClientService::toDto)
                .orElse(null);
    }

}

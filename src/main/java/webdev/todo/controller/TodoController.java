package webdev.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webdev.todo.dto.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {
    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testTodo() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseEntity. And you got OK!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok().body(response);
    }
}

package com.example.learn.spring.controller;

import com.example.learn.spring.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/v1/api")
public class WebController {
    // Chỉ dùng cách này khi DEMO ^^
    List<Todo> todoList = new CopyOnWriteArrayList<>();

    /*
        @RequestParam dùng để đánh dấu một biến là request param trong request gửi lên server.
        Nó sẽ gán dữ liệu của param-name tương ứng vào biến
     */
    @GetMapping("/listTodo")
    public String index(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
        // Trả về đối tượng todoList.

        // Nếu người dùng gửi lên param limit thì trả về sublist của todoList
        model.addAttribute("todoList", limit != null ? todoList.subList(0, limit) : todoList);

        // Trả về template "listTodo.html"
        return "listTodo";
    }

    @GetMapping("/addTodo")
    public String getTodo(Model model) {
        // Thêm mới một đối tượng Todo vào model
        model.addAttribute("todo", new Todo());
        // Trả về template addTodo.html
        return "getTodo";
    }

    @PostMapping("/addTodo")
    public String addTodo(Model model) {
        return "success";
    }
}

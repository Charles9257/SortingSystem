package com.example.sorting.controller;

import com.example.sorting.service.SortingService;
import jakarta.servlet.http.HttpSession;

// Removed invalid import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sorting.model.SortHistory;
import com.example.sorting.model.UserSort;
import com.example.sorting.repository.SortHistoryRepository;
import com.example.sorting.service.UserService;
import com.example.sorting.util.LoggerManager;
import com.example.sorting.exception.UserAlreadyExistsException;
import com.example.sorting.exception.UnsupportedAlgorithmException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SortController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SortHistoryRepository sortHistoryRepository;

    @Autowired
    private SortingService sortingService;
    @Autowired
    private UserService userService; // Assuming you have a UserService to handle user-related operations

    // home page
    @GetMapping("/")
    public String showHomePage() {
        
        return "index"; // Displays the input page initially
    }

    // Show Register Page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";  // Register form
    }

    // Handle Registration (POST)
    @PostMapping("/register")
    public String register(@ModelAttribute UserSort user,
                           @RequestParam String password,
                           @RequestParam String username,
                            @RequestParam String email,
                           Model model) {
        if (!user.getPassword().equals(password)) {
            model.addAttribute("error", "Passwords do not match!");
            return "register";
        }
        
        try {
            userService.registerUser(user.getUsername(), user.getPassword(), user.getEmail());
            model.addAttribute("success", "Registration successful! Please log in.");
            return "redirect:/login";
        } catch (UserAlreadyExistsException e) {
            model.addAttribute("error", "Username already exists. Try another.");
            return "register";
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            return "register";
        }
                            
    }

    // Show Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Custom login page
    }

    // Handle Login (POST)
    @PostMapping("/login")
    public String login(@RequestParam String username, 
                        @RequestParam String password, 
                        HttpSession session, 
                        Model model) {
        
        UserSort user = userService.getUserByUsername(username);
        
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            session.setAttribute("loggedInUser", user);
            LoggerManager.getInstance().log("User " + username + " logged in successfully.");
            return "redirect:/sorting";  // Redirect after successful login
        } else {
            model.addAttribute("error", "Invalid credentials.");
            return "login";  // Back to login page with error
        }
    }
    
   /* @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if (userService.authenticateUser(username, password)) {
            return "redirect:/sorting";
        } else {
            model.addAttribute("error", "Invalid credentials.");
            return "login";
        }
    }*/
    // Show Sorting Page
    @GetMapping("/sorting")
    public String showSortingPage(Model model) {
        // Add default values to the model
        model.addAttribute("numberList", "");
        model.addAttribute("algorithm", "BubbleSort");
        return "sorting";  // Sorting page
    }

    // Handle Sorting (POST)

    @PostMapping("/sort")
    public String sortNumbers(@RequestParam String numberList,
                            @RequestParam String algorithm,
                            Model model) {
        LoggerManager.getInstance().log("Received sort request using " + algorithm);
        try {
            // Convert input string to int[] (input format: comma-separated numbers)
            int[] items = Arrays.stream(numberList.split(","))
                                .map(String::trim)
                                .mapToInt(Integer::parseInt)
                                .toArray();

            long start = System.currentTimeMillis();

            // Call sorting service (sorts the numbers)
            int[] sortedArray = sortingService.sort(items, algorithm);

            long duration = System.currentTimeMillis() - start;

            // Convert sorted int[] back to List<Integer> and add to model
            List<Integer> sortedList = Arrays.stream(sortedArray)
                                            .boxed()
                                            .collect(Collectors.toList());

            // Save sort history to database
            SortHistory sortHistory = new SortHistory(
                numberList, 
                sortedList.toString(),  // Store the sorted numbers as string
                algorithm,
                LocalDateTime.now()
            );

            sortHistoryRepository.save(sortHistory);  // Save to PostgreSQL

            model.addAttribute("numberList", numberList);
            model.addAttribute("algorithm", algorithm);
            model.addAttribute("sortedNumbers", sortedList);
            model.addAttribute("duration", duration);
            model.addAttribute("timestamp", sortHistory.getTimestamp());  // Display timestamp

        } catch (UnsupportedAlgorithmException e) {
            model.addAttribute("error", "Unsupported sorting algorithm: " + algorithm);
        } catch (NumberFormatException e) {
            LoggerManager.getInstance().log("Invalid number format: " + e.getMessage());
            model.addAttribute("error", "Invalid input format. Please enter numbers separated by commas.");
        } catch (Exception e) {
            LoggerManager.getInstance().log("An error occurred: " + e.getMessage());
            model.addAttribute("error", "An unexpected error occurred. Please try again.");
        }

        return "sorting";
    }

    // Handle Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // Invalidate the session to log out
        LoggerManager.getInstance().log("User logged out successfully.");
        return "redirect:/";  // Redirect to home page after logout
        
    }
}

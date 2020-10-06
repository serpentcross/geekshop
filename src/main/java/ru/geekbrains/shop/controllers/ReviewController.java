package ru.geekbrains.shop.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.geekbrains.shop.services.ReviewService;
import ru.geekbrains.shop.services.feign.clients.ShopFeignClient;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ShopFeignClient shopFeignClient;

//    @GetMapping("/dosomething")
//    public ResponseEntity<byte[]> getFlyer() {
//        return shopFeignClient.getFlyer();
//    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String moderateReview(@PathVariable UUID id, @RequestParam String option) {
        return "redirect:/products/" + reviewService.moderate(id, option);
    }

}
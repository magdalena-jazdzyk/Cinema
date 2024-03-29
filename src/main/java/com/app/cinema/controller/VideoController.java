package com.app.cinema.controller;

import com.app.cinema.dto.VideoDto;
import com.app.cinema.model.Video;
import com.app.cinema.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;

    @GetMapping("/{movieId}")
    public List<VideoDto> findVideoByMovie(@PathVariable Long movieId) {
        return videoService.findVideoByMovieId(movieId);
    }

    @GetMapping("/all/{page}/{size}")
    public Page<VideoDto> findAllVideo(@PathVariable Integer page, @PathVariable Integer size) {
        return videoService.findAll(PageRequest.of(page, size));
    }
}

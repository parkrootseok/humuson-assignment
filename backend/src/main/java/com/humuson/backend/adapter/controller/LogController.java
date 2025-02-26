package com.humuson.backend.adapter.controller;

import com.humuson.backend.application.log.usecase.LogUseCase;
import com.humuson.backend.domain.log.model.dto.response.GetCountLogResponse;
import com.humuson.backend.domain.log.model.dto.response.GetFilteredLogResponse;
import com.humuson.backend.domain.log.model.dto.response.UploadLogResponse;
import com.humuson.backend.global.model.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogController {

    private final LogUseCase logUseCase;

    @GetMapping("/analyze")
    public Result<GetCountLogResponse> analyzeLogLevels(
            @RequestParam(defaultValue = "app.log") String fileName,
            @RequestParam(required = false) String levels
    ) throws IOException {
        return Result.of(logUseCase.analyzeLogLevels(fileName, levels));
    }

    @GetMapping("/errors")
    public Result<GetFilteredLogResponse> filterLogsByLevel(
            @RequestParam(defaultValue = "app.log") String fileName,
            @RequestParam(required = false) String levels
    ) throws IOException {
        return Result.of(logUseCase.filterLogsByLevel(fileName, levels));
    }

    @PostMapping("/upload")
    public Result<UploadLogResponse> saveUploadedLog(@RequestParam("file") MultipartFile file) {
        return Result.of(logUseCase.saveUploadedLog(file));
    }

}

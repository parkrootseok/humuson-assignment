package com.humuson.backend.adapter.controller;

import com.humuson.backend.application.log.usecase.LogUseCase;
import com.humuson.backend.domain.log.model.dto.response.LogAnalysisResponse;
import com.humuson.backend.domain.log.model.dto.response.ErrorLogResponse;
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
    public Result<LogAnalysisResponse> getLogsCountByLevel(
            @RequestParam(defaultValue = "app.log") String fileName,
            @RequestParam(required = false) String levels
    ) throws IOException {
        return Result.of(logUseCase.getLogsCountByLevel(fileName, levels));
    }

    @GetMapping("/errors")
    public Result<ErrorLogResponse> getLogsByLevel(
            @RequestParam(defaultValue = "app.log") String fileName,
            @RequestParam(required = false) String levels
    ) throws IOException {
        return Result.of(logUseCase.getLogsByLevel(fileName, levels));
    }

    @PostMapping("/upload")
    public Result<String> uploadLog(@RequestParam("file") MultipartFile file) {
        return Result.of(logUseCase.uploadLog(file));
    }

}

package com.humuson.backend.infrastructure.log.repository;

import static com.humuson.backend.global.constant.Format.TIMESTAMP_FORMAT;

import com.humuson.backend.domain.log.model.entity.LogEntity;
import com.humuson.backend.global.util.LogParseUtil;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Repository
public class FileLogRepository implements LogRepository {

    private static final Path DEFAULT_LOG_PATH = Path.of("logs/app.log");
    private static final Path LOG_DIRECTORY = Path.of("logs/");

    @Override
    public List<LogEntity> readLogs(String fileName) throws IOException {

        Path logFilePath = validateAndGetLogFilePath(fileName);
        try (Stream<String> lines = Files.lines(logFilePath)) {
            return lines
                    .map(LogParseUtil::parseLog)
                    .filter(Objects::nonNull)
                    .map(LogEntity::new)
                    .toList();
        }
    }

    @Override
    public List<LogEntity> readLastNLogs(String fileName, int limit) throws IOException {
        Path logFilePath = validateAndGetLogFilePath(fileName);
        try (Stream<String> lines = Files.lines(logFilePath)) {
            long totalLines = Files.lines(logFilePath).count();
            return lines
                    .skip(Math.max(0, totalLines - limit))
                    .map(LogParseUtil::parseLog)
                    .filter(Objects::nonNull)
                    .map(LogEntity::new)
                    .toList();
        }
    }

    private Path validateAndGetLogFilePath(String fileName) throws IOException {

        Path logFilePath = (fileName != null && !fileName.isEmpty()) ? Path.of("logs", fileName) : DEFAULT_LOG_PATH;

        if (!Files.exists(logFilePath)) {
            throw new IOException("로그 파일을 찾을 수 없습니다: " + logFilePath);
        }

        return logFilePath;

    }

    @Override
    public String saveLog(MultipartFile file) throws IOException {

        if (!Files.exists(LOG_DIRECTORY)) {
            Files.createDirectories(LOG_DIRECTORY);
        }

        String newFileName = UUID.randomUUID() + ".log";
        Path destination = LOG_DIRECTORY.resolve(newFileName);
        Files.copy(file.getInputStream(), destination);

        log.info("파일 저장 완료: {}", newFileName);
        return newFileName;

    }

}

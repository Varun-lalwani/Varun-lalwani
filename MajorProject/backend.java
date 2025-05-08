package com.example.malwaredetector;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
class MalwareDetectorController {
    @PostMapping("/scan")
    public Map<String, String> scan(@RequestParam("files") MultipartFile[] files) throws IOException {
        Map<String, String> result = new HashMap<>();
        for (MultipartFile file : files) {
            byte[] fileBytes = IOUtils.toByteArray(file.getInputStream());
            boolean isMalware = dummyMalwareCheck(fileBytes);
            result.put(file.getOriginalFilename(), isMalware ? "Malware detected" : "No malware detected");
        }
        return result;
    }

    private boolean dummyMalwareCheck(byte[] fileBytes) {
        return fileBytes.length % 2 == 0; // Example condition
    }
}
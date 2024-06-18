package com.example.springBootLab.service.Implementation;


import com.example.springBootLab.model.ImageData;
import com.example.springBootLab.repository.ImageStorageRepository;
import com.example.springBootLab.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
@Service
public class ImageServiceImpl implements ImageService {


    @Autowired
    private ImageStorageRepository repository;

    public final String Folder_Path="/Users/harshilvaria/Downloads/CSCI3130/ResumeMedia/";
    public String uploadImage(MultipartFile file) throws IOException {
        String file_path=Folder_Path+file.getOriginalFilename();
        ImageData imageData = repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(file_path).build());

        file.transferTo(new File(file_path));

        if (imageData != null) {
            return ""+file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName) throws IOException {
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        String filePath= dbImageData.get().getFilePath();
        byte[] images= Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}

package com.eventostac.api.service;
import com.amazonaws.services.s3.AmazonS3;
import com.eventostac.api.domain.event.Event;
import com.eventostac.api.domain.event.EventRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    private AmazonS3 s3client;

    @Value("${aws.bucket.name}")
    private String bucketName;

    public Event createEvent(EventRequestDTO data){
        String imageUrl = null;
        if(data.image() != null){
            imageUrl = this.uploadImg(data.image());

        }

        Event newEvent = new Event();
        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setEventUrl(data.eventUrl());
        newEvent.setDate(new Date(data.date()));
        newEvent.setRemote(data.remote());
        newEvent.setImgUrl(imageUrl);

        return newEvent;
    }


    private String uploadImg(MultipartFile multipartFile){
        String filename = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

        try{
            File file = this.convertMultipartFile(multipartFile);
            s3client.putObject(bucketName, filename, file);
            file.delete();
            return s3client.getUrl(bucketName, filename).toString();

        }catch (Exception e){
            throw new RuntimeException("Erro ao salvar imagem no bucket aws s3");
        }
    }

    private File convertMultipartFile(MultipartFile multipartFile) throws IOException {
        File convFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipartFile.getBytes());
        fos.close();
        return convFile;
    }
}

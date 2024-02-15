package backend.CC.service;

import backend.CC.domain.Image;
import backend.CC.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    @Transactional
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    public Image createfile(MultipartFile image) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        int millis = now.get(ChronoField.MILLI_OF_SECOND);

        String absolutePath = new File("ImageDataBase").getAbsolutePath() + "/"; // Desktop 폴더에 저장될 절대 경로
        String newFileName = "image" + hour + minute + second + millis; // 새로 부여한 이미지명
        String fileExtension = '.' + image.getOriginalFilename().replaceAll("^.*\\.(.*)$", "$1"); // 정규식 이용하여 확장자만 추출
        String path = "images/" + year + "/" + month + "/" + day; // 저장될 폴더 경로

        if (!image.isEmpty()) {
            File file = new File(absolutePath + path);
            if (!file.exists()) {
                file.mkdirs(); // mkdir()과 다르게 상위 폴더가 없을 때 상위폴더까지 생성
            }

            file = new File(absolutePath + path + "/" + newFileName + fileExtension);
            image.transferTo(file);
        }

        return Image.builder()
                .originImageName(image.getOriginalFilename())
                .imagePath(path)
                .imageName(newFileName + fileExtension)
                .build();
    }
}

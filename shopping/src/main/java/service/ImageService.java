package service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import domain.ImageVO;

public interface ImageService {
    
    void insertImage(ImageVO image);
    
    List<ImageVO> findByJoinId(Long joinid);

    ImageVO findImageById(Long id); // 새로운 메서드 추가

    void saveImage(MultipartFile file, Long joinid) throws Exception;

    void deleteImage(Long id); // 이미지 삭제 메서드 추가
    
}

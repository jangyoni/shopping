package mapper;

import java.util.List;

import domain.ImageVO;

public interface ImageMapper {

    void insertImage(ImageVO image);

    List<ImageVO> findByJoinId(Long joinid);

    ImageVO findImageById(Long id); // 새로운 메서드 추가

    void deleteImage(Long id); // 이미지 삭제 메서드 추가
}

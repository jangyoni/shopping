package service;

import java.io.File;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import domain.ImageVO;
import mapper.ImageMapper;

@Service
public class ImageServiceImp implements ImageService {

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public void insertImage(ImageVO image) {
        imageMapper.insertImage(image);
    }

    @Override
    public List<ImageVO> findByJoinId(Long joinid) {
        return imageMapper.findByJoinId(joinid);
    }

    @Override
    public void saveImage(MultipartFile file, Long joinid) throws Exception {
        String uploadFolder = "c:/upload";
        String datePath = new java.text.SimpleDateFormat("yyyy/MM/dd").format(new Date());
        String uploadPath = uploadFolder + File.separator + datePath;

        // 디렉토리 존재 확인 및 생성
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        File saveFile = new File(uploadPath, file.getOriginalFilename());
        file.transferTo(saveFile);

        ImageVO imageVO = new ImageVO();
        imageVO.setImgname(datePath + "/" + file.getOriginalFilename());
        imageVO.setNowtime(new java.sql.Date(Instant.now().toEpochMilli())); // java.util.Date를 java.sql.Date로 변환
        imageVO.setJoinid(joinid);

        insertImage(imageVO);
    }

	@Override
	public ImageVO findImageById(Long id) {
		
		return imageMapper.findImageById(id);
	}

	@Override
	public void deleteImage(Long id) {
		imageMapper.deleteImage(id);
		
	}
}

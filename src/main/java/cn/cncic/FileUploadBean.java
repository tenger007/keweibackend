package cn.cncic;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author chb
 *
 */
public class FileUploadBean {

    private MultipartFile file;

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }
}
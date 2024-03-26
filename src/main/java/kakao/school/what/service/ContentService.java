package kakao.school.what.service;

import kakao.school.what.domain.Content;
import kakao.school.what.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public Content getContentById(Long contentId) {
        return contentRepository.findById(contentId)
                .orElseThrow(() -> new NoSuchElementException("해당하는 Content가 존재하지 않습니다."));
    }

}

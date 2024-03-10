package kakao.school.what.service;

import kakao.school.what.domain.Content;
import kakao.school.what.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    // contentId와 title을 기반으로 Content 객체를 찾아 반환
    public Content getContentByIdAndTitle(Long contentId, String title) {
        // Optional을 사용하여 Content 객체를 안전하게 다룸.
        return contentRepository.findByContentIdAndTitle(contentId, title)
                .orElseThrow(() -> new NoSuchElementException("해당하는 Content가 존재하지 않습니다."));
    }
}

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

    public Content saveContent(Content content) {
        // 제목으로 존재하는 Content 검색
        Optional<Content> existingContent = contentRepository.findByTitle(content.getTitle());

        // 만약 같은 제목의 Content가 이미 존재한다면, 저장하지 않고 해당 Content를 반환
        if(existingContent.isPresent()) {
            throw new IllegalStateException("이미 존재하는 제목입니다.");
        } else {
            // 존재하지 않는다면 새로운 Content 저장
            return contentRepository.save(content);
        }
    }

}

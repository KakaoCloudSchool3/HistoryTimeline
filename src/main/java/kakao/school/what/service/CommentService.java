package kakao.school.what.service;

import kakao.school.what.domain.Comment;
import kakao.school.what.repository.CommentRepository;
import kakao.school.what.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ContentRepository contentRepository;

    public List<Comment> getCommentsByTitle(String title) {
        return contentRepository.findByTitle(title)
                .map(content -> commentRepository.findByContent_ContentId(content.getContentId()))
                .orElse(Collections.emptyList());
    }
}

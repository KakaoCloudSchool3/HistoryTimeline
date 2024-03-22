package kakao.school.what.service;

import kakao.school.what.domain.Comment;
import kakao.school.what.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentsByContentId(Long contentId) {
        return commentRepository.findByContentId(contentId);
    }
}

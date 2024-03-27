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

    public Comment saveComment(Long contentId, String note, Long userId) {
        Comment newComment = new Comment();
        newComment.setContentId(contentId); // content 객체 대신 contentId 직접 설정
        newComment.setNote(note); // 댓글 내용 설정
        newComment.setUserId(userId); // 유저 ID 설정
        return commentRepository.save(newComment); // Comment 저장
    }

    public List<Comment> findCommentsByContentId(Long contentId) {
        return commentRepository.findByContentId(contentId);
    }
}

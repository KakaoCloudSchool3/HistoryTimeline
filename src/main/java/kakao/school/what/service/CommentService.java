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

    // 유저 ID를 포함한 새 댓글 저장 메소드
    public Comment saveComment(String title, String note, Long userId) {
        return contentRepository.findByTitle(title)
                .map(content -> {
                    Comment newComment = new Comment();
                    newComment.setContent(content); // 찾은 Content 객체를 설정
                    newComment.setNote(note); // 댓글 내용 설정
                    newComment.setUserId(userId); // 유저 ID 설정
                    return commentRepository.save(newComment); // Comment 저장
                }).orElse(null); // 해당 제목의 Content가 없을 경우 null 반환
    }
}

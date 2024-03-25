package kakao.school.what.web;

import kakao.school.what.domain.Comment;
import kakao.school.what.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments/by-title")
    public List<Comment> getCommentsByTitle(@RequestParam(value = "title") String title) {
        return commentService.getCommentsByTitle(title);
    }

    // 유저 ID를 포함하여 댓글 저장하는 API
    @PostMapping("/comments/save")
    public Comment saveComment(@RequestParam(value = "title") String title,
                               @RequestParam(value = "note") String note,
                               @RequestParam(value = "userId") Long userId) {
        return commentService.saveComment(title, note, userId);
    }
}

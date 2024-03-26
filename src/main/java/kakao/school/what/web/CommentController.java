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

    @PostMapping("/comments/save")
    public Comment saveComment(@RequestParam(value = "contentId") Long contentId,
                               @RequestParam(value = "note") String note,
                               @RequestParam(value = "userId") Long userId) {
        return commentService.saveComment(contentId, note, userId);
    }

    @GetMapping("/comments")
    public List<Comment> getCommentsByContentId(@RequestParam(value = "contentId") Long contentId) {
        return commentService.findCommentsByContentId(contentId);
    }
}

package codeit.controller;

import codeit.Service.PostService;

import codeit.Service.PostUpdateRequest;
import codeit.dto.PostCreateRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostCreateRequest request, HttpServletRequest httpRequest) {
        // 인터셉터에서 설정한 사용자 ID 가져오기
        String userId = (String) httpRequest.getAttribute("userId");

        // 서비스 호출하여 게시물 생성
        String postId = postService.createPost(request, userId);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("postId", postId);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getPosts(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(postService.getPost(page, size));
    }

    // 게시물 상세 조회
    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostDetail(@PathVariable UUID postId) {
        return ResponseEntity.ok(postService.getPosts(postId));
    }

    // 게시물 수정
    @PutMapping("/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable UUID postId, @RequestBody PostUpdateRequest updatePostDto, HttpServletRequest httpRequest) {
        String userId = (String) httpRequest.getAttribute("userId");
        postService.updatePost(updatePostDto, userId);
        // postId와 userId를 통해 게시물 수정
        return null;
    }

    // 게시물 삭제
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable UUID postId, HttpServletRequest httpRequest) {
        String userId = (String) httpRequest.getAttribute("userId");
        postService.deletePost(postId, userId);
        return ResponseEntity.noContent().build();
    }
}


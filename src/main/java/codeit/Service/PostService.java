package codeit.Service;

import codeit.dto.PostCreateRequest;

import java.util.UUID;

public interface PostService {
    String createPost(PostCreateRequest request, String userId);

    void updatePost(codeit.Service.PostUpdateRequest postUpdateRequest, String userId);

    void deletePost(UUID postId, String userId);


    Object getPost(int page, int size);

    Object getPosts(UUID postId);
}

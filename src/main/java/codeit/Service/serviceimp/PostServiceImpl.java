package codeit.Service.serviceimp;

import codeit.Service.PostService;
import codeit.Service.PostUpdateRequest;
import codeit.dto.PostCreateRequest;
import codeit.entity.Post;
import codeit.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
   private final PostRepository postRepository;
    //이미지 서비스 호출
    @Override
    public String createPost(PostCreateRequest request, String userId) {
        Pattern pattern = Pattern.compile("\\{\\{([^|]+)\\|([^}]+)\\}\\}");
        Matcher matcher = pattern.matcher(request.getContent());
        while (matcher.find()) {
            String imageIdStr = matcher.group(1);
            String imagePath = matcher.group(2);
            try {
                UUID imageId = UUID.fromString(imageIdStr); // 유효한 UUID인지 확인

            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("콘텐츠 내 이미지 ID가 올바르지 않습니다: ");
            }
        }
        //1. 사용자가 이미지를 업로드하면 Image 엔티티 생성 및 저장
        //2. 사용자가 게시물 작성 시 이미지 참조 형식(`{{image key|image path}}`)으로 내용에 포함
        //3. 게시물 저장 시 내용에서 이미지 참조를 추출하여 PostImage 엔티티 생성
        Post post = new Post(
                request.getTitle(),
                request.getContent(),
                userId,
                request.getTags()
        );
        return userId;
    }

    @Override
    public void updatePost(PostUpdateRequest postUpdateRequest, String userId) {
        //레포 업데이트
        //업데이트 한 것 중 이미지를 더한다면
       //포스트이미지 객체 생성해서 관계 정의
        //만약 제거였다면 postimage 객체 삭제
    }

    @Override
    public void deletePost(UUID pstId, String userId) {
        //레포.delete
        //postImage 서비스로 삭제 호출


    }

    @Override
    public Object getPost(int page, int size) {
        return null;
    }

    @Override
    public Object getPosts(UUID postId) {
        return null;
    }

}

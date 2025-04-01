package codeit.dto;

//게시물
public record ImageSummary(
         String id,
         String originalName,
         String extension,
         String path,
         Long size,
         Long uploadedAt
) {
}

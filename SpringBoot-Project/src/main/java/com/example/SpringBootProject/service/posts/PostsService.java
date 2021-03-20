package com.example.SpringBootProject.service.posts;

import com.example.SpringBootProject.domain.posts.PostsRepository;
import com.example.SpringBootProject.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor            // final이 선언된 모든 인자값의 생성자를 자동 생성
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}

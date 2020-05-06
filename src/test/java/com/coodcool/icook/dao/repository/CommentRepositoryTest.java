package com.coodcool.icook.dao.repository;

import com.coodcool.icook.model.Comment;
import com.coodcool.icook.mother.CommentMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static  org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void saveOneSimple() {
        Comment comment = CommentMother.completeWithoutId().build();
        commentRepository.save(comment);
        List<Comment> comments = commentRepository.findAll();
        assertThat(comments).hasSize(1);
    }

}
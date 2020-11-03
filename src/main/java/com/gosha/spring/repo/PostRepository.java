package com.gosha.spring.repo;

import com.gosha.spring.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}

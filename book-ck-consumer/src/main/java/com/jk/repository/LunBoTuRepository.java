package com.jk.repository;

import com.jk.model.LunBo;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface LunBoTuRepository extends ElasticsearchCrudRepository<LunBo,String> {
}

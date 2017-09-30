package cn.cncic.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

import cn.cncic.models.FieldSource;
import cn.cncic.models.JishudianArticle;
import scala.collection.immutable.Page;


interface FieldSourceRepository extends CrudRepository<FieldSource, Long>{

}

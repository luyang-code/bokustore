package com.tsc.graduateproj.bokubookstore.infrastructure;

import com.tsc.graduateproj.bokubookstore.domain.model.PictureDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPictureRepository extends JpaRepository<PictureDO,Integer> {

    //根据bookId搜图片
    @Query("select p from PictureDO p where p.bookId=?1 and p.isdelete=false ")
    List<PictureDO> findPictureByBookId(String bookId);

    //根据bookId删除图片
    @Modifying
    @Query("update PictureDO p set p.isdelete=true where p.bookId=?1")
    void deletePicByBookId(String bookId);
}

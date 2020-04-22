package com.tsc.graduateproj.bokubookstore.infrastructure;

import com.tsc.graduateproj.bokubookstore.domain.model.UserDO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<UserDO,Integer>, JpaSpecificationExecutor<UserDO> {

    @Query("select u from UserDO u where u.userName=?1 and u.userPassword=?2 and u.isdelete=false ")
    UserDO findByUserNameAndPassword(String userName,String password);

    @Query("select u from UserDO u where u.userName=?1 and u.isdelete=false ")
    UserDO findByUserName(String userName);

    @Query("select u from UserDO u where u.userId=?1 and u.isdelete=false ")
    UserDO findByUserId(String userId);

    @Query("select u from UserDO u where u.isdelete=false order by u.userId desc ")
    UserDO findLastUser(PageRequest page);

    @Query("select count(u) from UserDO u where u.isdelete=false ")
    Integer queryNum();

}

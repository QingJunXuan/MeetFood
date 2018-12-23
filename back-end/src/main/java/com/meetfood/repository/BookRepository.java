package com.meetfood.repository;

import com.meetfood.entity.Book;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface BookRepository extends CrudRepository<Book,Integer> {
    List<Book> findByStateAndGuest_id(@Param("state") Integer state,
                           @Param("guest_id") Integer guest_id);
    List<Book> findByStateAndDining_id(@Param("state") Integer state,
                                      @Param("dining_id") Integer dining_id);
    List<Book> findByGuest_id(@Param("guest_id") Integer guest_id);

    //@Query(value = "select dining_id from Book where timestampdiff(week,order_time,now())<1",nativeQuery = true);

    List<Book> findByTimestampAfter(@Param("timestamp") Date start,
                                    @Param("guest_id") Integer guest_id);

    //Book findOrderById(@Param("id") Integer id);
}

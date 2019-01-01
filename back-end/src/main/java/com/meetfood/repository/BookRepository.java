package com.meetfood.repository;

import com.meetfood.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface BookRepository extends CrudRepository<Book,Integer> {
    @Query(value = "from Book b where b.state=:state and b.guest_id=:guest_id")
    List<Book> findByStateAndGuest_id(@Param("state") Integer state,
                                     @Param("guest_id") Integer guest_id);

   @Query(value = "from Book b where  b.guest_id=:guest_id")
    List<Book> findByGuest_id(@Param("guest_id") Integer guest_id);

    @Query(value = "from Book b where b.state=:state and b.dining_id=:dining_id")
    List<Book> findByStateAndDining_id(@Param("state") Integer state,@Param("dining_id") Integer dining_id);

    @Query(value = "from Book b where  b.dining_id=:dining_id")
    List<Book> findByDining_id(@Param("dining_id") Integer dining_id);

    @Query(value = "from Book b where b.guest_id =:guest_id and b.order_time >:time")
    List<Book> findByGuest_idAndOrder_time(@Param("guest_id") Integer guest_id,
                                           @Param("time") Date time);

    @Query(value = "from Book b where b.dining_id =:dining_id and b.order_time >:time")
    List<Book> findByDining_idAndOrder_time(@Param("dining_id") Integer dining_id,
                                           @Param("time") Date time);
    //Book findOrderById(@Param("id") Integer id);
}

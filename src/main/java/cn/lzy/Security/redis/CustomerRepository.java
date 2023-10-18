package cn.lzy.Security.redis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByUsername(String username);
    Customer findByPassword(String password);
    // 根据id修改信息

    @Transactional
    @Query("SELECT c.id FROM t_customer c WHERE c.username = ?1")
    Integer findByUsername1(String username);
    @Transactional
    @Modifying
    @Query("UPDATE t_customer c SET c.username= ?1 WHERE  c.id = ?2")
    int updateCache(String username, Integer id);

}

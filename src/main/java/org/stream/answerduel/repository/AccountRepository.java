package org.stream.answerduel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stream.answerduel.entity.sys.Account;

/**
 * 功能描述：
 *
 * @Auther: 梁展鹏
 * @Date: 2018/7/17 17:16
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * 功能描述：
     *
     * @param username
     * @return
     */
    Account findByUsername(String username);

}

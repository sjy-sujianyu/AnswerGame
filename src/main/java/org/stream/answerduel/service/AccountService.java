package org.stream.answerduel.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.stream.answerduel.dto.PageResult;
import org.stream.answerduel.entity.sys.Account;
import org.stream.answerduel.repository.AccountRepository;
import org.stream.answerduel.util.SnowflakeIdWorker;
import org.stream.answerduel.vo.sys.AccountVo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    /**
     * 功能描述：
     *
     * @param accountVo
     */
    public void add(AccountVo accountVo) {
        Account account = new Account();
        BeanUtils.copyProperties(accountVo, account);
        account.setId(snowflakeIdWorker.nextId());
        account.setCreateBy(1L);
        account.setCreateAt(new Date());
        account.setUpdateBy(1L);
        account.setUpdateAt(new Date());
        accountRepository.save(account);
    }

    /**
     * 功能描述：
     *
     * @param id
     */
    public void del(Long id) {
        accountRepository.deleteById(id);
    }

    /**
     * 功能描述：
     *
     * @param pageSize
     * @param pageNumber
     */
    public PageResult<AccountVo> select(Integer pageNumber, Integer pageSize) {

        Page<Account> page = accountRepository.findAll(PageRequest.of(pageNumber, pageSize));

        List<AccountVo> list = new ArrayList<>();
        for (Account account : page.getContent()) {
            AccountVo accountVo = new AccountVo();
            BeanUtils.copyProperties(account, accountVo);
            list.add(accountVo);
        }

        return new PageResult<AccountVo>(pageNumber, pageSize, page.getTotalPages(), list);
    }

    /**
     * 功能描述：
     *
     * @param accountVo
     */
    public void update(AccountVo accountVo) {
        Account account = accountRepository.findById(accountVo.getId()).get();
        BeanUtils.copyProperties(accountVo, account);
        account.setUpdateBy(1L);
        account.setUpdateAt(new Date());
        accountRepository.save(account);
    }

}

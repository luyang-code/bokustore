package com.tsc.graduateproj.bokubookstore.bokubookstore;

import com.alibaba.fastjson.JSON;
import com.github.wenhao.jpa.Specifications;
import com.tsc.graduateproj.bokubookstore.BokubookstoreApplication;
import com.tsc.graduateproj.bokubookstore.command.BookIdAndSellNum;
import com.tsc.graduateproj.bokubookstore.command.dto.BookParamDTO;
import com.tsc.graduateproj.bokubookstore.domain.model.BookDO;
import com.tsc.graduateproj.bokubookstore.infrastructure.*;
import com.tsc.graduateproj.bokubookstore.util.ListUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BokubookstoreApplication.class)
public class TestBoKuStore {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IAdminRepository adminRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private DealQueryDAO dealQueryDAO;
    @Autowired
    private DealInfoDAO dealInfoDAO;
    @Autowired
    private GreceivableDAO greceivableDAO;

    @Test
    public void testUser() {
        List<BookDO> allBooks = bookRepository.findAllBooks();
        BookParamDTO bookParamDTO = new BookParamDTO("",new ArrayList<>(Arrays.asList("2018-05","2020-10")),new ArrayList<>(Arrays.asList(0,96)));
        Specification<BookDO> spec = Specifications.<BookDO>and()
//                .like(!StringUtils.isEmpty(dto.getKeyWord()), "bookName", "%" + dto.getKeyWord() + "%")
                .eq("isdelete", false)
                .eq("putState", true)
                .between(!ListUtils.isEmpty(bookParamDTO.getPublisTimes()), "bookPublishTime", "2018-05", "2020-10")
                .between(!ListUtils.isEmpty(bookParamDTO.getPrices()), "bookNewPrice",new BigDecimal(96), new BigDecimal(300))
                .build();
        List<BookDO> all = bookRepository.findAll(spec);

    }

    @Test
    public void testTopTenBooks() {
        List<Map<String, Integer>> topTenBooks = orderRepository.findTopTenBooks();
        List<BookIdAndSellNum> bookIdAndSellNums = JSON.parseArray(JSON.toJSON(topTenBooks).toString(), BookIdAndSellNum.class);
    }

//    private static final Integer UN_REIMBURSEMENT = 2;
//    @Test
//    public void test1() {
//
//        List<DealQueryDO> allCompleteInfo = dealQueryDAO.findAllCompleteInfo();
//        List<String> queryCompleteCodes = allCompleteInfo.stream().map(DealQueryDO::getCompleteCode).collect(Collectors.toList());
//
//        List<GreceivableDO> allReceiveInfo = greceivableDAO.findInfoByQueryComplete(queryCompleteCodes);
//
//        List<String> receiveCompleteCodes = allReceiveInfo.stream().map(GreceivableDO::getCompleteCode).collect(Collectors.toList());
//
//        List<DealQueryDO> dealQueryDOS = dealQueryDAO.findByReceiveCompleteCodes(receiveCompleteCodes);
//
//        //未报账成交编号
//        List<String> unReceiveCompletes = dealQueryDOS.stream().filter
//                (d -> UN_REIMBURSEMENT.equals(d.getReceivablesState())).map(DealQueryDO::getCompleteCode).collect(Collectors.toList());
//
//        //其它成交编号
//        List<String> receiveCompletes = dealQueryDOS.stream().filter
//                (d -> !(UN_REIMBURSEMENT.equals(d.getReceivablesState()))).map(DealQueryDO::getCompleteCode).collect(Collectors.toList());
//    }

}

package com.tsc.graduateproj.bokubookstore.domain.service.impl;

import com.tsc.graduateproj.bokubookstore.command.dto.CartDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.CartVO;
import com.tsc.graduateproj.bokubookstore.command.vo.CartWithCountVO;
import com.tsc.graduateproj.bokubookstore.domain.model.CartDO;
import com.tsc.graduateproj.bokubookstore.domain.model.PictureDO;
import com.tsc.graduateproj.bokubookstore.domain.service.ICartService;
import com.tsc.graduateproj.bokubookstore.infrastructure.IBookRepository;
import com.tsc.graduateproj.bokubookstore.infrastructure.ICartRepository;
import com.tsc.graduateproj.bokubookstore.infrastructure.IPictureRepository;
import com.tsc.graduateproj.bokubookstore.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IPictureRepository pictureRepository;

    @Override
    public CartWithCountVO queryAllShopCartByCustomId(Integer page,Integer size,String customId) {
        List<CartVO> cartVOS = cartRepository.queryAllShopCartByCustomId(customId).stream().map(cart -> {
            List<String> mainPic = pictureRepository.findPictureByBookId(cart.getBookId()).stream().
                    filter(p -> p.getMainPic() == true).map(PictureDO::getBookPicture).collect(Collectors.toList());
            //主图为空，则返回图片路径为""
            if (ListUtils.isEmpty(mainPic))
                return new CartVO(cart, bookRepository.findByBookId(cart.getBookId()), "");
            return new CartVO(cart, bookRepository.findByBookId(cart.getBookId()), mainPic.get(0));
        }).collect(Collectors.toList());
        return new CartWithCountVO(cartVOS.size(),ListUtils.page(cartVOS, page, size));
    }

    @Override
    public Boolean addToShopCart(CartDTO cartDTO) {
        CartDO cartDO = cartRepository.queryByCustomIdAndBookId(cartDTO.getCustomId(), cartDTO.getBookId());
        if(!StringUtils.isEmpty(cartDO)){
            cartDO.setBookCount(cartDO.getBookCount()+cartDTO.getBookCount());
            cartDO.setAddTime(new Date());
            cartRepository.save(cartDO);
        }else {
            cartRepository.save(new CartDO(cartDTO));
        }
        return true;
    }

    @Transactional
    @Override
    public Boolean deleteShopCartBook(String customId,String bookId) {
        cartRepository.deleteCartBook(customId,bookId);
        return true;
    }

    @Override
    public Boolean modifyShopCartBook(CartDTO cartDTO) {
        CartDO cartDO = cartRepository.queryByCustomIdAndBookId(cartDTO.getCustomId(), cartDTO.getBookId());
        cartDO.setBookCount(cartDTO.getBookCount());
        cartRepository.save(cartDO);
        return true;
    }
}

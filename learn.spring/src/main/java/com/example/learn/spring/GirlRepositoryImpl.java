package com.example.learn.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class GirlRepositoryImpl implements GirlRepository {

    @Autowired
    private ApplicationContext applicationContext;
    @Override
    public Girl getGirlByName(String name) {
        // Ở đây tôi ví dụ là database đã trả về
        // một cô gái với tên đúng như tham số

        // Còn thực tế phải query trong csđl nhé.
        Girl g = applicationContext.getBean(Girl.class);
        g.setName(name);
        return g;
    }
}

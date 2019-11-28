package demo.demo;

import demo.redisutil.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HeJun
 * @version 1.0
 * @description
 * @Date $time$ $date$
 */
@RequestMapping("demo")
@RestController
public class RedisDemo {

    @Autowired
    private RedisUtil redisUtil;


    /**
     * @return
     * @throws Exception
     * @Author HeJun
     * @Description 将数据存到redis
     * @Date 15:47 2019/11/27
     * @Param
     **/
    public void setData() {


        //redisUtil.set("demoOne", "测试将数据存到redis");
    }

//    public Object get(String key) {
//        return key == null ? null : redisTemplate.opsForValue().get(key);
//
//    }

//    public boolean set(String key, Object value) {
//        try {
//            redisTemplate.opsForValue().set(key, value);
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//
//        }
//    }

    public String getData() {
        String data = (String) redisUtil.get("demoOne111");
        System.out.println(data);
        return data;
    }

    @RequestMapping("getData")
    public String demo() {
        System.out.println(redisUtil.set("demoOne1111", "测试将数据存到redis1111"));
        String data = (String) redisUtil.get("demoOne1111");
        System.out.println(data);
        return data;
    }


    public static void main(String[] args) {
        RedisDemo demo = new RedisDemo();
        demo.setData();
        demo.getData();
    }
}

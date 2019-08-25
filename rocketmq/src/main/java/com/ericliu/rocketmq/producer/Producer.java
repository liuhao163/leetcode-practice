package com.ericliu.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import static com.ericliu.rocketmq.consant.Constant.NAME_ADDR;
import static com.ericliu.rocketmq.consant.Constant.topicName2;

/**
 * @Author: liuhaoeric
 * Create time: 2019/08/21
 * Description:
 */
public class Producer {

    private static DefaultMQProducer producer;
    private static int initialState = 0;

    private Producer() {

    }

    public static DefaultMQProducer getDefaultMQProducer() {
        if (producer == null) {
            producer = new DefaultMQProducer("ProducerGroupName");
        }

        if (initialState == 0) {
            producer.setNamesrvAddr(NAME_ADDR);
            try {
                producer.start();
            } catch (MQClientException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }

            initialState = 1;
        }

        return producer;
    }


    public static void main(String[] args) {
        producer=getDefaultMQProducer();
        for (int i = 0; i < 100; i++) {
            int tagIdx = i % 3;
            sendMsg(producer,"tag" + tagIdx, "orider_" + i, "this is order id is " + i);
        }
        while(true){}
//        producer.shutdown();
    }


    public static void sendMsg(DefaultMQProducer producer,String tag, String key, String body) {

        try {
            Message msg = new Message(
                    topicName2,
                    tag,
                    key,
                    body.getBytes());
//            SendResult sendResult = producer.send(msg);
//            producer.sendOneway(msg);
            producer.send(msg,new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("producer sendResult="+sendResult);
                }
                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", -1, e);
                    e.printStackTrace();
                }
            });
//            System.out.println(sendResult);
        } catch (MQClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemotingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        catch (MQBrokerException e) {
//            e.printStackTrace();
//        }
    }

}

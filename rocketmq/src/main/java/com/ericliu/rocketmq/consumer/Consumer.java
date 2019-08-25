package com.ericliu.rocketmq.consumer;


import org.apache.log4j.BasicConfigurator;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.ericliu.rocketmq.consant.Constant.NAME_ADDR;
import static com.ericliu.rocketmq.consant.Constant.topicName;
import static com.ericliu.rocketmq.consant.Constant.topicName2;

/**
 * @Author: liuhaoeric
 * Create time: 2019/08/21
 * Description:
 */
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
    /*
     * Constructs a client instance with your account for accessing DefaultMQConsumer
     */
    private static int initialState = 0;

    private DefaultMQPushConsumer consumer;

    static {
        BasicConfigurator.configure();
    }

    public Consumer(String consumerGruop) {
        consumer = new DefaultMQPushConsumer(consumerGruop);
        consumer.setNamesrvAddr(NAME_ADDR);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
    }


    public static void main(String[] args) {
        Consumer c=new Consumer("liuhao-g");
        c.receiveMsg(topicName2, "tag0||tag1");
    }

    public void receiveMsg(final String topicName, String tagExp) {
        //        // 订阅主体
        try {
            consumer.subscribe(topicName, tagExp);

            //todo MessageListenerConcurrently
            consumer.registerMessageListener(new MessageListenerConcurrently() {

                /**
                 * * 默认msgs里唯独一条消息，能够通过设置consumeMessageBatchMaxSize參数来批量接收消息
                 */
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(
                        List<MessageExt> msgs, ConsumeConcurrentlyContext context) {

                    System.out.println("currentThreadName:" + Thread.currentThread().getName() + " and Receive New Messages:" + msgs);

                    MessageExt msg = msgs.get(0);

                    if (msg.getTopic().equals(topicName)) {
                        // 运行TopicTest1的消费逻辑
                        if (msg.getTags() != null && msg.getTags().equals("tag0")) {
                            // 运行TagA的消费
                            System.out.println("====>Tag:" + msg.getTags() + " ,Key:" + msg.getKeys() + "  Body:" + new String(msg.getBody()));
                        } else if (msg.getTags() != null
                                && msg.getTags().equals("tag1")) {
                            // 运行TagC的消费
                            System.out.println("---->Tag:" + msg.getTags() + " ,Key:" + msg.getKeys() + "  Body:" + new String(msg.getBody()));
                        } else if (msg.getTags() != null
                                && msg.getTags().equals("tag2")) {
                            // 运行TagD的消费
                            System.out.println("+++++>Tag:" + msg.getTags() + " ,Key:" + msg.getKeys() + "  Body:" + new String(msg.getBody()));
                        }
                    } else {
                        // 运行TopicTest2的消费逻辑
                        System.out.println("Other topic Tag:" + msg.getTags() + " ,Key:" + msg.getKeys() + "  Body:" + new String(msg.getBody()));
                    }

                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });

            /**
             * Consumer对象在使用之前必须要调用start初始化。初始化一次就可以<br>
             */
            consumer.start();

            logger.info("Consumer Started.");
        } catch (MQClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}

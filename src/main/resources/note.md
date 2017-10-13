####取消CentOS 的图形界面直接进入命令行模式
开机后进入图形化界面还是进入命令行取决于inittab文件中的配置。该文件位于etc目录下。
```
　# vi /etc/inittab
　　找到下面的语句：
　　# Default runlevel. The runlevels used by RHS are:
　　# 1 – Single user mode–单用户模式
　　# 2 – Multiuser, without NFS （The same as 3, if you do not havenetworking）–多用户模式，不支持NFS
　　# 3 – Full multiuser mode–多用户模式
　　# 4 – unused–没有使用
　　# 5 – X11–图形界面方式
　　# 6 – reboot （Do NOT set initdefault to this） –重新启动
　　#
　　id:5:initdefault:–默认运行等级是5，只要将此处改成 id:3:initdefault:即可
　　另外在文本模式如果想启动图形界面，可以使用下面的方法：
　　# startx
```


http://kelgon.iteye.com/blog/2287558

http://www.osyunwei.com/archives/7174.html

http://blog.csdn.net/bslzl/article/details/7937899

kafka
http://www.orchome.com/kafka/index

http://blog.csdn.net/lnho2015/article/details/51353936

http://blog.csdn.net/suifeng3051/article/details/38321043

http://www.jianshu.com/p/9d48a5bd1669

http://kelgon.iteye.com/blog/2287558

http://www.jianshu.com/p/2027add8747c

http://zqhxuyuan.github.io/2016/02/20/Kafka-Consumer-New/


http://blog.csdn.net/u010003835/article/details/52235572

JMX_PORT=2898 bin/kafka-server-start.sh -daemon config/server1.properties


flume
http://www.51studyit.com/html/notes/20140506/128.html
https://birdben.github.io/2016/08/24/Flume/Flume%E5%AD%A6%E4%B9%A0%EF%BC%88%E4%B8%89%EF%BC%89Flume%E5%A4%9A%E4%B8%AAAgent%E6%9E%B6%E6%9E%84/

agent:
agent.sources = s1
agent.channels = c1
agent.sinks = k1

agent.sources.s1.type=exec
agent.sources.s1.command=tail -F /usr/soft/log/abc.log
agent.sources.s1.channels=c1
agent.channels.c1.type=memory
agent.channels.c1.capacity=10000
agent.channels.c1.transactionCapacity=100

#设置接收器
agent.sinks.k1.channel=c1
agent.sinks.k1.type= avro
agent.sinks.k1.hostname=10.33.4.231
agent.sinks.k1.port=40040
collect:
agent.sources = s1
agent.channels = c1
agent.sinks = k1

agent.sources.s1.channels = c1
agent.sources.s1.type = avro
agent.sources.s1.bind = 10.33.4.231
agent.sources.s1.port = 40040
agent.sources.s1.threads = 2

agent.channels.c1.type=memory
agent.channels.c1.capacity=10000
agent.channels.c1.transactionCapacity=100

#设置kafka接收器
agent.sinks.k1.type= org.apache.flume.sink.kafka.KafkaSink
#设置Kafka的broker地址和端口号
agent.sinks.k1.brokerList=10.33.4.231:9091
#设置Kafka的Topic
agent.sinks.k1.topic=testFromFlume
#设置序列化方式
agent.sinks.k1.serializer.class=kafka.serializer.StringEncoder

agent.sinks.k1.channel=c1



mananger

conf/application.conf
play.http.context修改为"/kafka"
kafka-manager.zkhosts修改为"zk的ip:2181/kafka"
basicAuthentication.password修改为"elog"
运行
nohup bin/kafka-manager -Dconfig.file=conf/application.conf -Dhttp.port=8080 &


supervisor 启动


https://tech.youzan.com/you-zan-tong-ri-zhi-ping-tai-chu-tan/

kafka
http://www.cnblogs.com/fxjwind/p/4972244.html


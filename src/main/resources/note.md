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
http://www.voidcn.com/search/sqrrau/list-15.html
http://flychao88.iteye.com/blog/2288037
http://www.bkjia.com/jzjy/1116911.html

https://sdk.cn/news/3225


http://blog.csdn.net/sdksdk0/article/details/73176639

flume 官方插件，常用两种方式采集增量日志 
1 exec 插件可以执行 Shell tail -f 文件 命令。优点，实时采集，缺点。如果flume进程重启。将无法找到当时的checkpoint。特别是主文件已经被log4j切走，或者被Shell脚本切走 

2 spool 插件可以检测目录下新增的文件，处理过的文件用.COMPLETE文件名称结束。优点，Flume内部实现了checkpoint断点续传。(如何实现的?)缺点是不够实时。除非日志不按小时或者天级别切分，按分钟级别切分。这样产生的临时文件很多。不容易实现秒级别的采集 

3 每隔几秒钟读一下文件。甚至可以while true不休息。这种方式可以记录文件的总体字节偏移的checkpoint。百度内部的rtlc也是这么实现的。这种方式目前来看比较好 

4 tail -n +1 从第一行开始读文件，读出所有的增量。优点是即保证了tail-f。又保证了获取了最后一行的行号。如果文件内容过大，flume内存会OOM。当然可以通过程序控制，丢弃无用的数据 

mananger

conf/
application.conf
play.http.context修改为"/kafka"
kafka-manager.zkhosts修改为"zk的ip:2181/kafka"
basicAuthentication.password修改为"elog"
运行
nohup bin/kafka-manager -Dconfig.file=conf/application.conf -Dhttp.port=8080 &


supervisor 启动


https://tech.youzan.com/you-zan-tong-ri-zhi-ping-tai-chu-tan/

kafka
http://www.cnblogs.com/fxjwind/p/4972244.html


metric
http://wuchong.me/blog/2015/08/01/getting-started-with-metrics/




https://tech.meituan.com/disruptor.html

http://brokendreams.iteye.com/blog/2255720

https://tech.meituan.com/java-memory-reordering.html

http://ifeve.com/memory-barriers-or-fences/

https://mechanical-sympathy.blogspot.hk/2011/07/memory-barriersfences.html

http://in355hz.iteye.com/blog/1797829
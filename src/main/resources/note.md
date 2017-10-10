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
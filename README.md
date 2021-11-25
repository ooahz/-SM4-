**国密 SM2 SM3 SM4 算法, 使用的是bouncycastle包**<br/>
注意需要引入bcprov-jdk15XXX的包，JDK16没有SM4的包；<br/>
原项目引入的是commons-codec中的Hex工具类，但是该工具类限制了传入数据必须为16位倍数长度，<br/>
所以在SM4中使用的是cn.hutool中的Hex工具类，<br/>
为什么只在SM4中使用呢，因为我只用到了SM4<br/>

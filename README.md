# *xyk-app* started

## Guides

* [xyk-app](http://git.qimoukj.com/backend/xyk-boot-app)  xyk-app
* [xyk-dao](http://git.qimoukj.com/backend/xyk-boot-dao)  公共基础dao层;
* [xyk-common](http://git.qimoukj.com/backend/xyk-boot-common) 公共基础工具层,涵盖基本utils,aop,weblog等;

> **xyk-app是xyk项目的app服务工程,提供app需要的各种api接口,工程依赖于xyk-common(依赖于xyk-dao),下载项目后需先下载xyk-dao及xyk-common并本地打jar包后方可使用.**
> <font color=#FF0000 size=4 >特别提醒:上线打包前必须更新xyk-dao,xyk-common代码后重新打包.</font>



### 项目进度:

* 基础框架搭建完成(待优化)
* api接口暂未开始
* 测试类请执行：test.service.TestCommonService
* 测试结果：
* 16:28:22.018 [main] INFO test.service.TestCommonService - 数据生产开始==1601108902015
16:28:22.298 [main] INFO test.service.TestCommonService - 数据生产共用时间283毫秒！
16:28:22.433 [main] INFO test.service.TestCommonService - 数据生产成功[{"money":0,"moneyType":0,"count":0,"name":"测试0","id":"DCDE527E04D54AEDBB5C7CA662CCA45A","type":"测试"},{"money":1,"moneyType":2,"count":1,"name":"演示1","id":"1717EB0F844942559F753B6EE03601A6","type":"演示"},{"money":2,"moneyType":3,"count":2,"name":"演示2","id":"337B4F5F172A47CB93E1CC6F025B0824","type":"演示"},{"money":3,"moneyType":1,"count":3,"name":"演示3","id":"6A0BD751019849A6BCB99EC22E4BBB9C","type":"演示"},{"money":4,"moneyType":1,"count":4,"name":"演示4","id":"64D7B1D82F9246B6971170545F342225","type":"演示"},{"money":5,"moneyType":4,"count":5,"name":"测试5","id":"AA56A573AC5D490EB91A16132F39740C","type":"测试"},{"money":6,"moneyType":3,"count":6,"name":"测试6","id":"256AB156019F4CB69F1F4A420D8C4F49","type":"测试"},{"money":7,"moneyType":4,"count":7,"name":"测试7","id":"7B7A786F4DBC4617AFB00D630EB17405","type":"测试"},{"money":8,"moneyType":4,"count":8,"name":"测试8","id":"0BED682F16A14E3588E0E1A3E8039D18","type":"测试"},{"money":9,"moneyType":3,"count":9,"name":"演示9","id":"E51351ED28524C3196DA19A49C86383E","type":"演示"}]
16:28:22.433 [main] INFO test.service.TestCommonService - Where Or-->数据查询开始==1601108902433
16:28:22.447 [main] INFO test.service.TestCommonService - Where Or-->数据查询共用时间14毫秒！
16:28:22.448 [main] INFO test.service.TestCommonService - Where Or-->数据查询成功[{"money":4,"moneyType":1,"count":4,"name":"演示4","id":"64D7B1D82F9246B6971170545F342225","type":"演示"},{"money":5,"moneyType":4,"count":5,"name":"测试5","id":"AA56A573AC5D490EB91A16132F39740C","type":"测试"},{"money":6,"moneyType":3,"count":6,"name":"测试6","id":"256AB156019F4CB69F1F4A420D8C4F49","type":"测试"},{"money":7,"moneyType":4,"count":7,"name":"测试7","id":"7B7A786F4DBC4617AFB00D630EB17405","type":"测试"},{"money":8,"moneyType":4,"count":8,"name":"测试8","id":"0BED682F16A14E3588E0E1A3E8039D18","type":"测试"},{"money":9,"moneyType":3,"count":9,"name":"演示9","id":"E51351ED28524C3196DA19A49C86383E","type":"演示"}]
16:28:22.450 [main] INFO test.service.TestCommonService - 数据生产开始==1601108902450
16:28:22.451 [main] INFO test.service.TestCommonService - 数据生产共用时间1毫秒！
16:28:22.452 [main] INFO test.service.TestCommonService - 数据生产成功[{"money":0,"moneyType":3,"count":0,"name":"演示0","id":"86C5ECC0C6534226BE1336876E57C335","type":"演示"},{"money":1,"moneyType":2,"count":1,"name":"正式1","id":"5E17508A88C8406AB6F2C76C687F3DEF","type":"正式"},{"money":2,"moneyType":1,"count":2,"name":"演示2","id":"B05BE693077D40E490DF55688D7597D7","type":"演示"},{"money":3,"moneyType":0,"count":3,"name":"演示3","id":"0A229DBB220D462989279881D2B7526A","type":"演示"},{"money":4,"moneyType":0,"count":4,"name":"测试4","id":"326056C92E9B4DDBBE8309D80C7AF14C","type":"测试"},{"money":5,"moneyType":0,"count":5,"name":"测试5","id":"1755F3FF76BC4375BDEA505CD0739753","type":"测试"},{"money":6,"moneyType":4,"count":6,"name":"演示6","id":"CC03D8F820F64951A821AB8CD6816D84","type":"演示"},{"money":7,"moneyType":3,"count":7,"name":"测试7","id":"FC8099BC340F4E418AA405C2A81A1D3C","type":"测试"},{"money":8,"moneyType":1,"count":8,"name":"正式8","id":"06FA353FF0D34278B4254B1DB28C3110","type":"正式"},{"money":9,"moneyType":2,"count":9,"name":"测试9","id":"3D2B3B0AD5624432B1CC05BBD9A3EE3B","type":"测试"}]
16:28:22.452 [main] INFO test.service.TestCommonService - Limit-->数据查询开始==1601108902452
16:28:22.454 [main] INFO test.service.TestCommonService - Limit-->数据查询共用时间2毫秒！
16:28:22.455 [main] INFO test.service.TestCommonService - Limit-->数据查询成功[[{"money":5,"moneyType":0,"count":5,"name":"测试5","id":"1755F3FF76BC4375BDEA505CD0739753","type":"测试"},{"money":6,"moneyType":4,"count":6,"name":"演示6","id":"CC03D8F820F64951A821AB8CD6816D84","type":"演示"},{"money":7,"moneyType":3,"count":7,"name":"测试7","id":"FC8099BC340F4E418AA405C2A81A1D3C","type":"测试"},{"money":8,"moneyType":1,"count":8,"name":"正式8","id":"06FA353FF0D34278B4254B1DB28C3110","type":"正式"},{"money":9,"moneyType":2,"count":9,"name":"测试9","id":"3D2B3B0AD5624432B1CC05BBD9A3EE3B","type":"测试"}]]
16:28:22.455 [main] INFO test.service.TestCommonService - 数据生产开始==1601108902455
16:28:22.456 [main] INFO test.service.TestCommonService - 数据生产共用时间1毫秒！
16:28:22.458 [main] INFO test.service.TestCommonService - 数据生产成功[{"money":0,"moneyType":1,"count":0,"name":"演示0","id":"609DD7FFFAFB48918A2496E352FB8151","type":"演示"},{"money":1,"moneyType":1,"count":1,"name":"正式1","id":"8EFA717B73E8443D88A5D4DEBC81FC3D","type":"正式"},{"money":2,"moneyType":1,"count":2,"name":"正式2","id":"2B46FDF4D3FC4EA49DD6709216EAFFA2","type":"正式"},{"money":3,"moneyType":3,"count":3,"name":"正式3","id":"54354CADE51040E2B8EB2D50B2EAA29D","type":"正式"},{"money":4,"moneyType":0,"count":4,"name":"测试4","id":"F35BE8A2146C43F7A08DBA146328BAF1","type":"测试"},{"money":5,"moneyType":2,"count":5,"name":"演示5","id":"F1BF6CA003904C70864148D399BFBC99","type":"演示"},{"money":6,"moneyType":0,"count":6,"name":"正式6","id":"E59AE120775C4578968DFC7A96CE1481","type":"正式"},{"money":7,"moneyType":3,"count":7,"name":"测试7","id":"52F795531136489A91B9AEACBC5BAE5E","type":"测试"},{"money":8,"moneyType":1,"count":8,"name":"测试8","id":"C495FEAE415C4CBFB5A42B1EB9953660","type":"测试"},{"money":9,"moneyType":3,"count":9,"name":"演示9","id":"40A8CE1F39794DFD9D51C9EC31930963","type":"演示"}]
16:28:22.458 [main] INFO test.service.TestCommonService - Where-->数据查询开始==1601108902458
16:28:22.458 [main] INFO test.service.TestCommonService - Where-->数据查询共用时间0毫秒！
16:28:22.458 [main] INFO test.service.TestCommonService - Where-->数据查询成功[{"money":6,"moneyType":0,"count":6,"name":"正式6","id":"E59AE120775C4578968DFC7A96CE1481","type":"正式"}]
16:28:22.459 [main] INFO test.service.TestCommonService - 数据生产开始==1601108902459
16:28:22.460 [main] INFO test.service.TestCommonService - 数据生产共用时间1毫秒！
16:28:22.461 [main] INFO test.service.TestCommonService - 数据生产成功[{"money":0,"moneyType":1,"count":0,"name":"测试0","id":"08CA4842B8124FEAAF8CDE10E9ACE4BE","type":"测试"},{"money":1,"moneyType":3,"count":1,"name":"正式1","id":"990CA6EC97D9401190D0B5CEACF107A3","type":"正式"},{"money":2,"moneyType":1,"count":2,"name":"演示2","id":"D1C97B5DC43F44D79E509062289B8CB2","type":"演示"},{"money":3,"moneyType":0,"count":3,"name":"测试3","id":"755212D8EAF041D0B620C9CADCE35E3E","type":"测试"},{"money":4,"moneyType":1,"count":4,"name":"演示4","id":"B840BF930ECF49C9B0405B28C70E315E","type":"演示"},{"money":5,"moneyType":4,"count":5,"name":"正式5","id":"4480DC8024BF4232983F2BDA7CEF9782","type":"正式"},{"money":6,"moneyType":1,"count":6,"name":"演示6","id":"13AAD6DED34949F5A9C5299708E7CF62","type":"演示"},{"money":7,"moneyType":3,"count":7,"name":"正式7","id":"34CDEF1F24894D929793408EC9F902D0","type":"正式"},{"money":8,"moneyType":1,"count":8,"name":"正式8","id":"930A112D00C34A5384FED04BC991DB87","type":"正式"},{"money":9,"moneyType":2,"count":9,"name":"演示9","id":"4F660A6BA5974E43B1722D56B6DC6FB8","type":"演示"}]
16:28:22.461 [main] INFO test.service.TestCommonService - OrderBy-->数据查询开始==1601108902461
16:28:22.463 [main] INFO test.service.TestCommonService - OrderBy-->数据查询共用时间2毫秒！
16:28:22.464 [main] INFO test.service.TestCommonService - OrderBy-->数据查询成功[{"money":10,"count":9,"name":"正式9","type":"正式"},{"money":10,"count":8,"name":"正式8","type":"正式"},{"money":8,"moneyType":1,"count":8,"name":"正式8","id":"930A112D00C34A5384FED04BC991DB87","type":"正式"},{"money":10,"count":7,"name":"正式7","type":"正式"},{"money":7,"moneyType":3,"count":7,"name":"正式7","id":"34CDEF1F24894D929793408EC9F902D0","type":"正式"},{"money":10,"count":6,"name":"正式6","type":"正式"},{"money":10,"count":5,"name":"正式5","type":"正式"},{"money":5,"moneyType":4,"count":5,"name":"正式5","id":"4480DC8024BF4232983F2BDA7CEF9782","type":"正式"},{"money":10,"count":4,"name":"正式4","type":"正式"},{"money":10,"count":3,"name":"正式3","type":"正式"},{"money":10,"count":2,"name":"正式2","type":"正式"},{"money":1,"moneyType":3,"count":1,"name":"正式1","id":"990CA6EC97D9401190D0B5CEACF107A3","type":"正式"},{"money":10,"count":1,"name":"正式1","type":"正式"},{"money":10,"count":0,"name":"正式0","type":"正式"}]
16:28:22.465 [main] INFO test.service.TestCommonService - 数据生产开始==1601108902465
16:28:22.466 [main] INFO test.service.TestCommonService - 数据生产共用时间1毫秒！
16:28:22.466 [main] INFO test.service.TestCommonService - 数据生产成功[{"money":0,"moneyType":1,"count":0,"name":"演示0","id":"A0F2C3684E7F45D09B65B5577408FFD9","type":"演示"},{"money":1,"moneyType":2,"count":1,"name":"测试1","id":"80103421D1D7486D90B682696BA9A56A","type":"测试"},{"money":2,"moneyType":1,"count":2,"name":"正式2","id":"2D0212D7458D4B5DA0C01D7170ED7309","type":"正式"},{"money":3,"moneyType":2,"count":3,"name":"正式3","id":"FC07128CE24B44FFBF0EC2F03B0DADC3","type":"正式"},{"money":4,"moneyType":3,"count":4,"name":"正式4","id":"927BD8F9FA4446DCA4234E5B61B3447E","type":"正式"},{"money":5,"moneyType":4,"count":5,"name":"测试5","id":"C0C054CB50504904B8EC8239C5DC0CFC","type":"测试"},{"money":6,"moneyType":3,"count":6,"name":"正式6","id":"FE162265202F4D3B83BDD49A933EEC8B","type":"正式"},{"money":7,"moneyType":0,"count":7,"name":"演示7","id":"0FA2EA7EA30F4555A26CAFFC2481EBE7","type":"演示"},{"money":8,"moneyType":0,"count":8,"name":"测试8","id":"A4B13431A4244DCDA82ECC4764D1F61E","type":"测试"},{"money":9,"moneyType":0,"count":9,"name":"正式9","id":"22039D2278444D038220CFB38276A629","type":"正式"}]
16:28:22.466 [main] INFO test.service.TestCommonService - GroupBy-->数据查询开始==1601108902466
16:28:22.546 [main] INFO test.service.TestCommonService - GroupBy-->数据查询共用时间80毫秒！
16:28:22.549 [main] INFO test.service.TestCommonService - GroupBy-->数据查询成功[{"moneyType":"4","type":"测试"},{"moneyType":"2","type":"测试"},{"moneyType":"1","type":"演示"},{"moneyType":"0","type":"演示"},{"moneyType":"2","type":"正式"},{"moneyType":"3","type":"正式"},{"moneyType":"0","type":"正式"},{"moneyType":"1","type":"正式"},{"moneyType":"0","type":"测试"}]

性能测试：

功能	1万数据量耗时（毫秒）	10万数据量耗时（毫秒）	100万数据量耗时（毫秒）	200万数据耗时（毫秒）
ALL（全条件查询）	266	561	3323	4736
Limit（截取数量）	0	0	0	0
Where（条件过滤）	41	151	2056	3804
OrderBy（排序）	87	380	4522	8806
GroupBy（分组）	76	133	1407	3708


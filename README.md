# 使用 AccountManager 实现系统内共享账号

在开发过程中我们可能遇到自家应用间共享账号的场景。例如 APP1 登录成功后，启动 APP2 时自动完成登录并与 APP1 共享账号信息。

Android 为我们提供了AccountManager 来管理账号信息。



## 共享前提

1. 两个 app 在一个用户组内
2. 使用相同的签名（使用 debug 默认签名也可以共享）
3. accountType 相同

## 原理

> AccountManager是一个面向应用程序开发的组件，它提供了一套对应于 IAccountManager 协议的应用程序接口；这组接口通过Binder机制与系统服务AccountManagerService进行通信，协作完成帐号相关的操作。同时，AccountManager接收authenticators 提供的回调，以便在帐号操作完成之后向*调用此帐号服务的业务*返回对应的接口，同时触发这个业务对结果的处理。
> \- authenticators 即注册帐号服务的app；
> \- 业务调用方 即使用authenticators提供的帐号服务的第三方，也可以是authenticator自己
>
> 摘自：[Android AccountManager帐号管理（一）](https://blog.csdn.net/dzkdxyx/article/details/78569867)



## 使用

该项目中有两个 module ，app 对应注册账号服务的app，app1 对应使用账号服务的第三方应用

- 在两个应用的 manifest 中加入 `<uses-permission android:name="android.permission.GET_ACCOUNTS" />` 权限

- 在 app 中创建 `authenticator.xml` 文件，注意 accountType 的配置，这里的应用名及 icon 会在设备的 设置 -> 账号 中显示

  ![](https://gitee.com/flywith24/Album/raw/master/img/20200904152225.png)

- 在 app 中注册一个 action 为“android.accounts.AccountAuthenticator”的 authenticator service，引入上一步创建的 xml 文件

  ![](https://gitee.com/flywith24/Album/raw/master/img/20200904152006.png)

  ![](https://gitee.com/flywith24/Album/raw/master/img/20200904152029.png)

  

- 在 app 中创建  authenticator

  ![](https://gitee.com/flywith24/Album/raw/master/img/20200904151929.png)



## 创建账号

![](https://gitee.com/flywith24/Album/raw/master/img/20200904153019.png)

## 删除账号

![](https://gitee.com/flywith24/Album/raw/master/img/20200904153112.png)

## 第三方 app 获取 用户，token 等信息

![](https://gitee.com/flywith24/Album/raw/master/img/20200904154855.png)




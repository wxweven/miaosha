# Java秒杀系统

一个简单的，可水平扩展的Java秒杀系统。

## 页面优化

**应用程序的瓶颈一般都出现在数据库上**

为了减少数据库的影响，我们可以使用缓存， **从头到尾的缓存：**

浏览器缓存(页面静态化) -> CDN缓存 -> Nginx 缓存 -> 应用程序的页面缓存 -> 对象缓存 -> 数据库

用了缓存，就可能出现数据的不一致，所以我们需要做一个权衡。

## 接口优化

思路：减少数据库的访问

1. 系统初始化，把商品库存数量加载到Redis
2. 收到请求，Redis预减库存，库存不足，直接返回，否则进入3
3. 请求入队（这里使用RabbitMQ消息队列），立即返回排队中
4. 请求出队，生成订单，减少库存
5. 客户端轮询，是否秒杀成功

## 接口安全

1. 秒杀接口地址隐藏
2. 数学公式验证
3. 接口限流

## 项目亮点

1. 自定义JSR303参数校验
2. 自定义全局异常处理器
3. 自定义SpringMVC参数解析
4. 自定义访问拦截器


### 完成度：
* 没有获取分组接口

__Details:__



### 测试：
* 有Controller层测试，但只有一个测试

__Details:__



### 知识点：
* 需要了解下三层架构
* 了解下lombok的使用
* 需要了解Java8 Stream的使用

__Details:__

- \- @CrossOrigin可以放在类上
- \- 没有使用泛型
- \- 违反Restful实践, Post请求成功后应该返回201
- \- 应该使用Repository层保存数据
- \- 可以使用Java8 Stream简化代码
- \- ResponseEntity不应该侵入到Service层
- \- 分组算法略显复杂，可以想想有没有更简单的方法

### 工程实践：
* 注意单一职责，group和student应该有单独的Controller和Service

__Details:__

- \- 违反了封装性，字段应该使用private
- \- 为啥要使用三个List保存学生？
- \- 变量名不符合命名规范，首字母应该小写
- \- 应该使用常量
- \- 变量命名不表意
- \- 长方法，建议抽子方法来提高可读性
- \- Magic Number
- \- 注意代码风格，需要适当的添加空格
- \- 未使用的import语句
- \- 类名应该使用单数

### 综合：


__Details:__




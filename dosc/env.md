# 打包命令

```shell
# 清理并打包命令
mvn clean package -DskipTests

# 环境注入命令
java -jar AppQuakeTestUtils.jar --spring.profiles.active=ukdev

nohup java -jar AppQuakeTestUtils.jar --spring.profiles.active=ukdev &
```
``
### 本地发布远程
```shell
# 发布test_group
scp -P 7859  -r target/AppQuakeTestUtils.jar root@18.134.140.209:/workspace/quake

# 发布巴西测试
scp -P 7859  -r target/AppQuakeTestUtils.jar root@18.230.52.95:/workspace/quake
```

### 启动命令
```shell
# 英国测试启动
nohup java -jar AppQuakeTestUtils.jar --spring.profiles.active=ukdev &

# 巴西测试
nohup java -jar AppQuakeTestUtils.jar --spring.profiles.active=brdev &

# ac 测试
nohup java -jar AppQuakeTestUtils.jar --spring.profiles.active=brdev &
```
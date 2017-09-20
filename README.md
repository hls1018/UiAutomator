# UiAutomator

一、环境搭建

环境搭建：

1、JDK

2、SDK(API高于15)

3、Eclipse(安装ADT插件)

4、ANT(用于编译生成的jar)

二、详细操作

（1），用Eclipse新建Java Project（File->New->Java Project，输入工程名称点击"Finish"）

（2），添加JUnit库（在工程名称上点击右键，Bulid Path->Configure Bulid Path，在里面找到Java Build path -->add library -->jUnit-->JUnit 4 点击Finish）

（3），添加Android类库 找到路径sdk\platforms\android-18下面的android.jar和uiautomator.jar添加进来(android-17以上)在Eclipse 中Java Build path的页面点击Add external jars 将android.jar与uiautomator.jar添加进去。

（4），在src中添加包，然后添加class文件在新建的工程下的src上点击右键，New->Class。输入包名和类名，包名的命名规则：首字母为小写，类名：首字母英文大写，后面字母均为小写，多个单词组成，每个单词的首字母大写，

（5），在class文件中extend UiAutomatorTestCase

（6），cmd进入sdk\tools\ 目录下，运行命令：android list，查看API 大于15的SDK的ID值

（7），仍然在\sdk\tools\目录下，运行命令：android create uitest-project -n <name> -t <android-sdk-ID> -p <path>。其中name为将来生成的jar包的名字，可以自己定义，android-sdk-ID为上一步骤看到的2，path是新建工程的路径名称。运行命令后，将会在工程的根目录下生成build.xml文件
        
        例如：android create uitest-project -n AutoRunner -t 2 -p D:\adt-bundle-windows-x86_64-20140702\eclipse\workspace\ChpJavaTwo
  
（8），cmd进入项目的工程目录，然后运行ant build，使用ant编译生成jar，在bin目录下生成jar文件。

（9），adb push <jar文件路径> data/local/tmp

（10），adb shell uiautomator runtest <jar文件名> -c <包名.类名>


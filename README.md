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

三、代码详解：

exec()这个函数的意思，相当于你在输入adb shell 命令后，在Android手机系统的命令行下运行。所以上面这句话的意思和我们打开cmd框输入" adb shell am start *** " 是一样的的效果。

UiDevice：UiDevice用与访问关设备状态的信息，也可以使用这个类来模拟用户在设备上的操作。
        

UiDevice：UiDevice用与访问关设备状态的信息，也可以使用这个类来模拟用户在设备上的操作。
        
        实例操作方法：
        
        UiDevice mdevice = getUiDevice();
        
        函数体：
        
        click(int x, int y)：模拟用户在指定位置点击。
        
        getCurrentActivityName()：获得的是应用程序在桌面上显示的名字。
        
        getCurrentPackageName()：获得当前显示的应用程序的包名。
        
        getDisplayHeight()：获得当前设备的屏幕分辨率的高。
        
        getDisplayWighth()：获得当前设备的屏幕分辨率的宽。
        
         isScreenOn()：判断手机当前是否灭屏。
         
         wakeUp()：点亮当前屏幕。
         
         pressBack()：点击back键。
         
         pressHome()：点击home键。
         
         pressMenu()：点击menu键。
         
         pressKeyCode(int keyCode)：利用keycode值模拟一次按下事件
         
         swipe(int startX, int startY, int endX, int endY, int steps)：用指定的步长，从A点滑动B点。
         
         takeScreenshot(File storePath)： 截取当前屏幕，保存到文件。
         
UiSelector：按照一定的条件（例如控件的text值，资源id），定位界面上的元素。UiSelector对象的最终目的是去构造一个UiObject对象。。
        
        函数体：
        
        text(String text)：根据“控件text属性的内容”构造出UiSelector对象。
        
        textContains(String text)：根据“控件text属性包含的内容”构造出UiSelector对象。
        
        textMatches(String regex) ：根据“控件text属性正则表达式的内容”构造出UiSelector对象。
        
        textStartsWith(String text)：根据“控件text属性开始的内容”构造出UiSelector对象。
        
        description(String desc)：根据“控件content-desc属性的内容”构造出UiSelector对象。
        
        descriptionContains(String desc)：包含**
        
        descriptionMatches(String regex)：正则
        
        descriptionStartsWith(String desc)：以**开始
        
        resourceId(String id)：根据资源id获取对象，例如：UiSelector s = new UiSelector().resourceId("com.tencent.mm:id/b8m")。
        
        resourceIdMatches(String regex)：根据资源id的正则表达式获取对象。
        
        UiSelector className(String  className)：根据控件的类名来找到UiSelector对象。
        
UiCollection: http://android.toolib.net/tools/help/uiautomator/UiCollection.html

UiScrollable:http://android.toolib.net/tools/help/uiautomator/UiScrollable.html

UiObject:

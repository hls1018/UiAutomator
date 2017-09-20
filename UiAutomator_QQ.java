package QQ;

import java.io.IOException;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Test_qq extends UiAutomatorTestCase
{
    public void testDemo() throws IOException, UiObjectNotFoundException {
            
        // 启应用
        Runtime.getRuntime().exec("am start com.tencent.mobileqq/com.tencent.mobileqq.activity.SplashActivity");
        sleep(3000);
        
        // 点击 "动态" tab
        UiDevice device = getUiDevice();
        int height = device.getDisplayHeight();
        int width = device.getDisplayWidth();
        device.click(width -50, height-50);
        sleep(1000);
        
        // 点击 "好友动态" 按钮
        UiObject obj_1 = new UiObject(new UiSelector().description("点击进入好友动态"));
        obj_1.click();
        sleep(2000);
        
        // 点击 左上角返回 "动态"按钮
        UiObject obj_2 = new UiObject(new UiSelector().resourceId("com.tencent.mobileqq:id/ivTitleBtnLeft"));
        obj_2.click();
        sleep(1000);
        
        // 点击菜单键
        device.pressMenu();
        sleep(1000);
        
        // 点击退出qq        
        UiObject obj_3 = new UiObject(new UiSelector().text("退出QQ"));
        obj_3.click();
        sleep(1000);
        
        // 点击确定
        UiObject obj_4 = new UiObject(new UiSelector().text("确定"));
        obj_4.click();
    }
}

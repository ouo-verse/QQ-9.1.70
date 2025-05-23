package sx;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.webview.swift.cookie.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a implements t43.a {
    @Override // t43.a
    public List<String> a(String str) {
        String gdtDeviceInfoBase64;
        if ("https://weather.mp.qq.com/".equals(str) && (gdtDeviceInfoBase64 = ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).getGdtDeviceInfoBase64()) != null) {
            if (QLog.isColorLevel()) {
                QLog.d("WeatherBrowserCookieInjector", 2, "cookie gdt_device_info for weather 2.0 was added");
            }
            String b16 = b.b("gdt_device_info", gdtDeviceInfoBase64, "weather.mp.qq.com", false);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(b16);
            return arrayList;
        }
        return null;
    }
}

package x1;

import android.hardware.Camera;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.ar.y;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Method f446852a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f446853b;

    static {
        c();
    }

    public static int a(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == 17) {
                return 17;
            }
        }
        return -1;
    }

    public static Camera.Size b(List<Camera.Size> list, int i3, int i16) {
        double d16;
        int i17;
        Camera.Size size = null;
        if (list == null) {
            return null;
        }
        for (Camera.Size size2 : list) {
            if (size2.width == i3 && size2.height == i16) {
                return size2;
            }
        }
        double d17 = i3 / i16;
        double d18 = Double.MAX_VALUE;
        double d19 = Double.MAX_VALUE;
        for (Camera.Size size3 : list) {
            if ((i3 > i16 && size3.width > size3.height) || (i3 < i16 && size3.width < size3.height)) {
                d16 = size3.width;
                i17 = size3.height;
            } else {
                d16 = size3.height;
                i17 = size3.width;
            }
            if (Math.abs((d16 / i17) - d17) <= 0.05d && Math.abs(size3.height - i16) < d19) {
                d19 = Math.abs(size3.height - i16);
                size = size3;
            }
        }
        if (size == null) {
            for (Camera.Size size4 : list) {
                if (Math.abs(size4.height - i16) < d18) {
                    d18 = Math.abs(size4.height - i16);
                    size = size4;
                }
            }
        }
        return size;
    }

    private static void c() {
        try {
            f446853b = Camera.Parameters.class.getMethod("getSupportedPreviewSizes", null);
        } catch (NoSuchMethodException unused) {
        }
        try {
            f446852a = Camera.Parameters.class.getMethod("getSupportedPreviewFormats", null);
        } catch (NoSuchMethodException unused2) {
        }
    }

    public static void d(Camera camera2, int i3, int i16) {
        e(camera2, i3, i16, 2);
    }

    public static void e(Camera camera2, int i3, int i16, int i17) {
        Camera.Size b16;
        int i18;
        int a16;
        Camera.Parameters parameters = camera2.getParameters();
        Method method = f446853b;
        if (method != null) {
            try {
                Object invoke = method.invoke(parameters, null);
                if (invoke instanceof List) {
                    List<Camera.Size> list = (List) invoke;
                    ArrayList arrayList = new ArrayList();
                    for (Camera.Size size : list) {
                        if (size.width != 980 || size.height != 800 || !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(Build.MANUFACTURER) || (!"GT-I9220".equalsIgnoreCase(DeviceInfoMonitor.getModel()) && !"GT-N7000".equalsIgnoreCase(DeviceInfoMonitor.getModel()))) {
                            int i19 = size.width;
                            if (((i19 != 1184 || size.height != 666) && (i19 != 704 || size.height != 576)) || !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(Build.MANUFACTURER) || !"GT-I9300".equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
                                if (size.width != 800 || size.height != 450 || !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(Build.MANUFACTURER) || !"GT-I9100".equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
                                    arrayList.add(size);
                                }
                            }
                        }
                    }
                    Camera.Size previewSize = parameters.getPreviewSize();
                    if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(Build.MANUFACTURER) && "GT-I9008L".equalsIgnoreCase(DeviceInfoMonitor.getModel())) {
                        b16 = previewSize;
                    } else if (i3 != 0 && i16 != 0) {
                        b16 = b(list, i3, i16);
                        if (b16 == null) {
                            b16 = b(list, 640, 480);
                        }
                    } else {
                        b16 = b(arrayList, 1280, 720);
                    }
                    if (b16 != null && ((i18 = b16.height) != previewSize.height || b16.width != previewSize.width)) {
                        parameters.setPreviewSize(b16.width, i18);
                    }
                }
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (IllegalArgumentException e17) {
                e17.printStackTrace();
            } catch (InvocationTargetException e18) {
                e18.printStackTrace();
            }
        }
        Method method2 = f446852a;
        if (method2 != null) {
            try {
                List list2 = (List) method2.invoke(parameters, null);
                if (list2 != null && (a16 = a(list2)) != -1) {
                    parameters.setPreviewFormat(a16);
                }
            } catch (IllegalAccessException e19) {
                e19.printStackTrace();
            } catch (IllegalArgumentException e26) {
                e26.printStackTrace();
            } catch (InvocationTargetException e27) {
                e27.printStackTrace();
            }
        } else if (parameters.getPreviewFormat() != 17) {
            parameters.setPreviewFormat(17);
        }
        try {
            g(parameters, i17);
            f(parameters);
            camera2.setParameters(parameters);
        } catch (RuntimeException e28) {
            e28.printStackTrace();
        }
    }

    public static void f(Camera.Parameters parameters) {
        String str = "auto";
        try {
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes.contains("continuous-video") && y.a().f198844d) {
                str = "continuous-video";
            } else if (!supportedFocusModes.contains("auto")) {
                str = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("CameraParameters", 2, String.format("setDefaultFocusMode focusMode=%s", str));
            }
            if (!TextUtils.isEmpty(str)) {
                parameters.setFocusMode(str);
            }
        } catch (RuntimeException e16) {
            e16.printStackTrace();
        }
    }

    private static void g(Camera.Parameters parameters, int i3) {
        try {
            int max = Math.max(i3, 0);
            if (parameters.isZoomSupported()) {
                parameters.setZoom(Math.min(max, parameters.getMaxZoom()));
            }
        } catch (Exception unused) {
        }
    }
}

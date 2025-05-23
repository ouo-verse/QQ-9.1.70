package ut0;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u001a\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\u0011\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\b\u0010\t\u001a\b\u0010\n\u001a\u00020\u0002H\u0002\u001a\b\u0010\u000b\u001a\u00020\u0002H\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u00a8\u0006\u0011"}, d2 = {"Landroid/content/Context;", "context", "", h.F, "g", "d", "isCheckConfig", "e", "f", "()Ljava/lang/Boolean;", "a", "c", "", "target", "Lorg/json/JSONArray;", "arr", "b", "ic-game-common-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {
    private static final boolean a() {
        try {
            Object obj = new JSONObject("").get("black_list");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
            String MODEL = DeviceInfoMonitor.getModel();
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            if (b(MODEL, (JSONArray) obj)) {
                return true;
            }
            return false;
        } catch (JSONException unused) {
            QLog.w("ICGameScreenSupportUtil", 1, "isInBlack json parse error,content:");
            return false;
        }
    }

    private static final boolean b(String str, JSONArray jSONArray) {
        Object obj;
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            try {
                obj = jSONArray.get(i3);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            } catch (ClassCastException unused) {
                QLog.w("ICGameScreenSupportUtil", 1, "json parse error,str:" + jSONArray.get(i3));
            }
            if (TextUtils.equals((String) obj, str)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean c() {
        try {
            Object obj = new JSONObject("").get(MobileQQ.PREF_WHITE_LIST_KEY);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONArray");
            String MODEL = DeviceInfoMonitor.getModel();
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            if (b(MODEL, (JSONArray) obj)) {
                return true;
            }
            return false;
        } catch (JSONException unused) {
            QLog.w("ICGameScreenSupportUtil", 1, "isInWhite json parse error,content:");
            return false;
        }
    }

    public static final boolean d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return e(context, true);
    }

    private static final boolean e(Context context, boolean z16) {
        int i3;
        int i16;
        Boolean f16;
        if (z16 && (f16 = f()) != null) {
            return f16.booleanValue();
        }
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        windowManager.getDefaultDisplay().getRealSize(new Point());
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class<?> cls = Class.forName("android.view.Display");
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<android.view.Display>");
            Field declaredField = cls.getDeclaredField("mDisplayInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(windowManager.getDefaultDisplay());
            Field declaredField2 = obj.getClass().getDeclaredField("logicalWidth");
            Field declaredField3 = obj.getClass().getDeclaredField("logicalHeight");
            Object obj2 = declaredField2.get(obj);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
            i3 = ((Integer) obj2).intValue();
            Object obj3 = declaredField3.get(obj);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            i16 = ((Integer) obj3).intValue();
        } catch (Exception unused) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            i3 = displayMetrics.widthPixels;
            i16 = displayMetrics.heightPixels;
        }
        QLog.w("ICGameScreenSupportUtil", 1, "real w:" + i3 + " h:" + i16);
        defaultDisplay.getMetrics(displayMetrics);
        if (Math.sqrt(Math.pow(i3 / displayMetrics.xdpi, 2.0d) + Math.pow(i16 / displayMetrics.ydpi, 2.0d)) >= 8.5d) {
            return true;
        }
        return false;
    }

    private static final Boolean f() {
        if (a()) {
            return Boolean.FALSE;
        }
        if (c()) {
            return Boolean.TRUE;
        }
        return null;
    }

    public static final boolean g(@NotNull Context context) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        if (a()) {
            return false;
        }
        DisplayMetrics displayMetrics = GlobalDisplayMetricsManager.sOriginDisplayMetrics;
        if (displayMetrics == null) {
            displayMetrics = context.getResources().getDisplayMetrics();
        }
        if (displayMetrics == null) {
            return false;
        }
        if (b.b() / displayMetrics.density >= 840.0f && d(context)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (b.b() <= b.a() || !c()) {
            return false;
        }
        return true;
    }

    public static final boolean h(@NotNull Context context) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        if (a()) {
            return false;
        }
        DisplayMetrics displayMetrics = GlobalDisplayMetricsManager.sOriginDisplayMetrics;
        if (displayMetrics == null) {
            displayMetrics = context.getResources().getDisplayMetrics();
        }
        if (displayMetrics == null) {
            return false;
        }
        if (b.a() / displayMetrics.density >= 900.0f && d(context)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (b.b() >= b.a() || !c()) {
            return false;
        }
        return true;
    }
}

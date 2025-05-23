package qb0;

import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.app.FontSettingManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f428778a;

    static {
        int i3;
        if (DisplayUtil.getDensity() > 1.5f && FontSettingManager.getFontLevel() <= 16.0f) {
            i3 = 5;
        } else {
            i3 = 4;
        }
        f428778a = i3;
    }
}

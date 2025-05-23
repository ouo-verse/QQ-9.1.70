package q50;

import android.text.TextUtils;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableCreateOption;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {
    public static void a(int i3, AnimationDrawableCreateOption animationDrawableCreateOption, AnimationDrawableFactory.CreateResultListener createResultListener) {
        AnimationDrawableFactory.getInstance().createFromUrl(i3, animationDrawableCreateOption, createResultListener);
    }

    public static String[] b(String str, String str2) {
        String[] listFilePath = AnimationDrawableFactory.getListFilePath(str2);
        if (listFilePath != null && listFilePath.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str3 : listFilePath) {
                if (c(str3)) {
                    arrayList.add(str3);
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return new String[0];
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.endsWith(".png") && !str.endsWith(".jpg") && !str.endsWith(".jpeg")) {
            return false;
        }
        return true;
    }
}

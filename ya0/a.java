package ya0;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.factory.IQFSViewAttrParse;
import cooperation.qqcircle.factory.OnHookCreateViewCallback;
import cooperation.qqcircle.factory.ParseViewAttrEntry;
import cooperation.qqcircle.helpers.QFSDynamicResourceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import za0.b;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements OnHookCreateViewCallback {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f449925a;

    /* renamed from: b, reason: collision with root package name */
    private static final Set<IQFSViewAttrParse> f449926b;

    /* renamed from: c, reason: collision with root package name */
    private static final Set<String> f449927c;

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        f449926b = copyOnWriteArraySet;
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        f449927c = copyOnWriteArraySet2;
        copyOnWriteArraySet.add(new b());
        copyOnWriteArraySet.add(new za0.a());
        copyOnWriteArraySet2.add("TextView");
        copyOnWriteArraySet2.add("com.tencent.biz.qqcircle.widgets.QFSFormSimpleItem");
        copyOnWriteArraySet2.add("com.tencent.biz.qqcircle.widgets.person.QFSSettingSwitchView");
    }

    public static a a() {
        if (f449925a == null) {
            synchronized (a.class) {
                if (f449925a == null) {
                    f449925a = new a();
                }
            }
        }
        return f449925a;
    }

    private static int b(String str) {
        try {
            return Integer.parseInt(str.substring(1));
        } catch (Throwable unused) {
            return -1;
        }
    }

    private boolean c(String str) {
        return f449927c.contains(str);
    }

    @Override // cooperation.qqcircle.factory.OnHookCreateViewCallback
    public List<ParseViewAttrEntry> parseViewAttrResId(Context context, String str, AttributeSet attributeSet) {
        int b16;
        if (context == null || attributeSet == null || !c(str)) {
            return null;
        }
        int attributeCount = attributeSet.getAttributeCount();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeValue = attributeSet.getAttributeValue(i3);
            if (attributeValue.startsWith("@") && (b16 = b(attributeValue)) != -1 && QFSDynamicResourceManager.g().isUpdateViewToWhiteList(b16)) {
                String attributeName = attributeSet.getAttributeName(i3);
                for (IQFSViewAttrParse iQFSViewAttrParse : f449926b) {
                    if (iQFSViewAttrParse.isNeedParse(attributeName)) {
                        arrayList.add(ParseViewAttrEntry.generate(attributeName, attributeValue, iQFSViewAttrParse));
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // cooperation.qqcircle.factory.OnHookCreateViewCallback
    public void updateViewAttrValue(Context context, View view, String str, String str2, IQFSViewAttrParse iQFSViewAttrParse) {
        int b16;
        if (TextUtils.isEmpty(str) || !str.startsWith("@") || (b16 = b(str)) == -1) {
            return;
        }
        String resourceEntryName = context.getResources().getResourceEntryName(b16);
        if (!QFSDynamicResourceManager.g().isUpdateViewToWhiteList(b16)) {
            return;
        }
        String a16 = h.a(b16);
        iQFSViewAttrParse.updateViewValue(view, str2, a16);
        QLog.d("DTR-QFSDynamicResAttrIntercept", 1, "[updateViewAttrValue] entryName: " + resourceEntryName + " | entryValue: " + a16 + " | view: " + view);
    }
}

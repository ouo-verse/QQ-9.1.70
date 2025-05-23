package qq2;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0005H\u0016J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u000e\u001a\u00020\rJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a8\u0006\u0016"}, d2 = {"Lqq2/f;", "Ljq2/c;", "", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "title", "Landroid/content/Context;", "context", "id", "", "f", "", "j", "switchItemName", "i", "(Ljava/lang/String;)Ljava/lang/Boolean;", "Lcom/tencent/mobileqq/app/QQAppInterface;", tl.h.F, "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f extends jq2.c {
    @Override // jq2.c
    public ArrayList<jq2.c> c() {
        ArrayList<jq2.c> arrayList = new ArrayList<>();
        arrayList.add(new y());
        if (j()) {
            arrayList.add(new r());
        }
        return arrayList;
    }

    @Override // jq2.c
    /* renamed from: e */
    public String getDetailTitle() {
        return "\u4e3b\u9875\u5e95\u90e8\u5bfc\u822a\u680f\u8bbe\u7f6e";
    }

    @Override // jq2.c
    public void f(String title, Context context, String id5) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("setting_search_title", title);
        ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startBottomTabSettingFragmentPage(context, intent, 2004);
        QLog.d("CustomBottomBarNode", 2, "startRouteToPage ");
    }

    public final QQAppInterface h() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        if (waitAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) waitAppRuntime;
        }
        return null;
    }

    protected final Boolean i(String switchItemName) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(switchItemName, "switchItemName");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) waitAppRuntime;
        String tabRuleList = TabDataHelper.getTabRuleList(qQAppInterface.getApplicationContext(), qQAppInterface.getCurrentUin(), TabDataHelper.getModelType());
        Intrinsics.checkNotNull(tabRuleList, "null cannot be cast to non-null type kotlin.String");
        Map<String, Integer> tabSwitch = TabDataHelper.getTabSwitch(qQAppInterface.getApplicationContext(), qQAppInterface.getCurrentUin(), TabDataHelper.SCENE_BOTTOM_TAB_SETTING);
        Intrinsics.checkNotNull(tabSwitch, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, java.lang.Integer>");
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<String, Integer>> it = tabSwitch.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Integer> next = it.next();
            String key = next.getKey();
            Integer value = next.getValue();
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.CharSequence");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) tabRuleList, (CharSequence) key, false, 2, (Object) null);
            if (contains$default && value != null && (value.intValue() == 2 || value.intValue() == 3)) {
                hashMap.put(key, Integer.valueOf(value.intValue()));
            }
        }
        Integer num = (Integer) hashMap.get(switchItemName);
        if (num == null || !(num.intValue() == 3 || num.intValue() == 2)) {
            return null;
        }
        return Boolean.valueOf(num.intValue() == 2);
    }

    public final boolean j() {
        int modelType;
        QQAppInterface h16 = h();
        return (TabDataHelper.isTabShield(null, h16 != null ? h16.getCurrentUin() : null, TabDataHelper.TAB_META_DREAM) || (modelType = TabDataHelper.getModelType()) == 3 || modelType == 4 || i(TabDataHelper.TAB_META_DREAM) == null) ? false : true;
    }
}

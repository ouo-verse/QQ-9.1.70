package qq2;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0005H\u0016J\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\n\u001a\u0004\u0018\u00010\tJ\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"Lqq2/e;", "Ljq2/c;", "", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "", "i", "Lcom/tencent/mobileqq/app/QQAppInterface;", tl.h.F, "title", "Landroid/content/Context;", "context", "id", "", "f", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e extends jq2.c {
    @Override // jq2.c
    public ArrayList<jq2.c> c() {
        ArrayList<jq2.c> arrayList = new ArrayList<>();
        arrayList.add(new ak());
        arrayList.add(new j());
        arrayList.add(new i());
        if (i()) {
            arrayList.add(new ac());
        }
        arrayList.add(new l());
        if (q.a()) {
            arrayList.add(new a());
        }
        return arrayList;
    }

    @Override // jq2.c
    /* renamed from: e */
    public String getDetailTitle() {
        return "\u804a\u5929";
    }

    @Override // jq2.c
    public void f(String title, Context context, String id5) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("setting_search_title", title);
        ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startGeneralSettingChatActivityPage(context, intent, 2004);
        QLog.d("ChatNode", 2, "startRouteToPage ");
    }

    public final QQAppInterface h() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        if (waitAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) waitAppRuntime;
        }
        return null;
    }

    public final boolean i() {
        return com.tencent.mobileqq.flashchat.e.d(h()).n(h()) && !SimpleUIUtil.getSimpleUISwitch();
    }
}

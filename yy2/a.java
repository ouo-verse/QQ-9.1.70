package yy2;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.e;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.b;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.business.api.ISettingSearchHightApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.util.HashMap;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements e {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadLocal<StringBuilder> f451551a = new C11640a();

    /* compiled from: P */
    /* renamed from: yy2.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C11640a extends ThreadLocal<StringBuilder> {
        C11640a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    }

    private void g(Intent intent) {
        intent.setFlags(268435456);
        intent.putExtra("KEY_ENTRANCE", "VALUE_QQ_SETTING_OHTER");
        ((ISettingSearchHightApi) QRoute.api(ISettingSearchHightApi.class)).startQUIBottomTabSettingPage(BaseApplication.getContext(), intent);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.controllerinject.e
    public boolean a() {
        boolean isInQCircle = ((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).isInQCircle();
        QLog.i("TabDataUtil", 1, "isQQCircleActive" + isInQCircle);
        return isInQCircle;
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.controllerinject.e
    public void b(int i3) {
        Intent intent = new Intent();
        intent.putExtra("KEY_ENABLE_TAB_ID", i3);
        g(intent);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.controllerinject.e
    public String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return b.f183049l + "_num";
        }
        HashMap hashMap = new HashMap();
        String name = Conversation.class.getName();
        StringBuilder sb5 = new StringBuilder();
        String str2 = b.f183049l;
        sb5.append(str2);
        sb5.append("_num");
        hashMap.put(name, sb5.toString());
        hashMap.put(Contacts.class.getName(), b.f183050m + "_num");
        hashMap.put(QzoneFrame.class.getName(), b.f183051n + "_num");
        hashMap.put(((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).getLebaFrameClass().getName(), b.f183052o + "_num");
        hashMap.put(((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass().getName(), b.f183056s + "_num");
        hashMap.put(QCircleFrame.class.getName(), b.f183055r + "_num");
        hashMap.put(((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).getMetaDreamFrameClass().getName(), b.f183057t + "_num");
        if (!hashMap.keySet().contains(str)) {
            return str2 + "_num";
        }
        return (String) hashMap.get(str);
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.controllerinject.e
    public void d() {
        g(new Intent());
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.controllerinject.e
    public String e() {
        return QUA.getQUA3();
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.controllerinject.e
    public int f(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Conversation.class.getName(), 1);
        hashMap.put(Contacts.class.getName(), 2);
        hashMap.put(QzoneFrame.class.getName(), 3);
        hashMap.put(((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).getLebaFrameClass().getName(), 3);
        hashMap.put(((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass().getName(), 4);
        hashMap.put(QCircleFrame.class.getName(), 5);
        hashMap.put(((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).getMetaDreamFrameClass().getName(), 7);
        if (!hashMap.keySet().contains(str)) {
            return 0;
        }
        return ((Integer) hashMap.get(str)).intValue();
    }
}

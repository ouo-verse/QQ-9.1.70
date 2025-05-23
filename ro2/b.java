package ro2;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.CallSuper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.unite.unifysearch.head_template.HeadTemplatePB$SearchTemplateResp;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class b {

    /* renamed from: d, reason: collision with root package name */
    private View f431804d;

    /* renamed from: e, reason: collision with root package name */
    protected HeadTemplatePB$SearchTemplateResp f431805e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f431806f = false;

    /* renamed from: h, reason: collision with root package name */
    protected int f431807h = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, String str2) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.w(str, 1, "#doJump: app is " + peekAppRuntime);
            return;
        }
        SearchUtils.Q0((AppInterface) peekAppRuntime, this.f431804d.getContext(), str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(HeadTemplatePB$SearchTemplateResp headTemplatePB$SearchTemplateResp) {
        if (headTemplatePB$SearchTemplateResp.image.has() && !TextUtils.isEmpty(headTemplatePB$SearchTemplateResp.image.image.get())) {
            return false;
        }
        return true;
    }

    public boolean c() {
        return this.f431806f;
    }

    @CallSuper
    public void d(HeadTemplatePB$SearchTemplateResp headTemplatePB$SearchTemplateResp, int i3, int i16) {
        this.f431805e = headTemplatePB$SearchTemplateResp;
        this.f431807h = i16;
    }

    @CallSuper
    public void e(View view) {
        this.f431804d = view;
    }
}

package rh0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ecommerce.biz.customview.PTSCountAdjusterView;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends PTSNodeVirtual {

    /* renamed from: a, reason: collision with root package name */
    private int f431448a;

    /* renamed from: b, reason: collision with root package name */
    private int f431449b;

    /* renamed from: c, reason: collision with root package name */
    private int f431450c;

    /* compiled from: P */
    /* renamed from: rh0.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static class C11139a implements PTSNodeVirtual.a {
        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public View buildNativeView(Context context, PTSNodeVirtual pTSNodeVirtual) {
            return new PTSCountAdjusterView((a) pTSNodeVirtual);
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public PTSNodeVirtual buildNodeVirtual(PTSAppInstance pTSAppInstance) {
            return new a(pTSAppInstance);
        }
    }

    protected a(PTSAppInstance pTSAppInstance) {
        super(pTSAppInstance, "view", "qq-ec-count-adjuster");
        this.f431448a = 0;
        this.f431449b = Integer.MAX_VALUE;
        this.f431450c = 0;
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public void onParseValueFinished() {
        super.onParseValueFinished();
        ((PTSCountAdjusterView) getView()).e(this.f431448a, this.f431449b, this.f431450c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public boolean setAttribute(String str, Object obj) {
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (!TextUtils.isEmpty(str2)) {
                if ("data-count".equals(str)) {
                    this.f431448a = Integer.parseInt(str2);
                } else if ("data-max-count".equals(str)) {
                    this.f431449b = Integer.parseInt(str2);
                } else if ("data-min-count".equals(str)) {
                    this.f431450c = Integer.parseInt(str2);
                }
            }
        }
        return super.setAttribute(str, obj);
    }
}

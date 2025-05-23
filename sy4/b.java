package sy4;

import com.tencent.component.utils.LogUtil;
import com.tme.karaoke.lib_earback.e;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b implements e {

    /* renamed from: a, reason: collision with root package name */
    private a f434995a;

    /* renamed from: b, reason: collision with root package name */
    private int f434996b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f434997c = 8;

    /* renamed from: d, reason: collision with root package name */
    private float f434998d = (8 * 1.0f) / 15.0f;

    public b() {
        try {
            this.f434995a = a.b(com.tme.karaoke.lib_earback.base.b.a());
        } catch (Exception e16) {
            LogUtil.w("XiaoMiFeedback", e16.getMessage());
            LogUtil.i("XiaoMiFeedback", "XiaoMiFeedback: exception occur");
        }
    }

    public boolean a() {
        a aVar = this.f434995a;
        boolean z16 = false;
        if (aVar == null) {
            LogUtil.i("XiaoMiFeedback", "feedback not work");
            return false;
        }
        if (aVar.c() == 1) {
            z16 = true;
        }
        LogUtil.d("XiaoMiFeedback", "isFeedback: " + z16);
        return z16;
    }

    @Override // com.tme.karaoke.lib_earback.e
    public boolean turnFeedback(boolean z16) {
        LogUtil.d("XiaoMiFeedback", "turnFeedback: " + z16);
        if (this.f434995a == null) {
            LogUtil.i("XiaoMiFeedback", "feedback not work");
            return false;
        }
        if (z16) {
            LogUtil.d("XiaoMiFeedback", "turnFeedback -> openKTVDevice");
            this.f434995a.d();
            LogUtil.d("XiaoMiFeedback", "turnFeedback -> setPlayFeedbackParam:1");
            this.f434995a.f(1);
            this.f434995a.e(this.f434997c);
        } else {
            LogUtil.d("XiaoMiFeedback", "turnFeedback -> setPlayFeedbackParam:0");
            this.f434995a.f(0);
            LogUtil.d("XiaoMiFeedback", "turnFeedback -> closeKTVDevice");
            this.f434995a.a();
        }
        return a();
    }
}

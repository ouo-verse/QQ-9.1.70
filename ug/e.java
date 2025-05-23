package ug;

import android.app.Activity;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e implements a {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f438922a;

    public e(Activity activity) {
        this.f438922a = activity;
    }

    @Override // ug.a
    public void a(boolean z16, SuperLikeView superLikeView, BusinessFeedData businessFeedData) {
        Activity activity = this.f438922a;
        if (activity != null) {
            superLikeView.setImageDrawable(activity.getDrawable(R.drawable.f153142));
        }
    }

    @Override // ug.a
    public boolean b(boolean z16, BusinessFeedData businessFeedData) {
        return true;
    }

    @Override // ug.a
    public boolean c(BusinessFeedData businessFeedData) {
        return false;
    }

    @Override // ug.a
    public boolean d(SuperLikeView superLikeView, BusinessFeedData businessFeedData) {
        Activity activity = this.f438922a;
        if (activity == null) {
            return true;
        }
        superLikeView.setImageDrawable(activity.getDrawable(R.drawable.f153142));
        return true;
    }
}

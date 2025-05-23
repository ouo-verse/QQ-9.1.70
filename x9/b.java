package x9;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.qzone.reborn.albumx.common.bean.e;
import com.qzone.reborn.base.l;
import com.qzone.reborn.widget.QZoneSwipeMenuLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class b extends l<e> implements View.OnClickListener {

    /* renamed from: h, reason: collision with root package name */
    private static final int f447486h = cx.a(8.0f);

    /* renamed from: e, reason: collision with root package name */
    protected QZoneSwipeMenuLayout f447487e;

    /* renamed from: f, reason: collision with root package name */
    private View f447488f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public abstract String getTAG();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f447487e = (QZoneSwipeMenuLayout) this.mRootView.findViewById(R.id.nga);
        View findViewById = this.mRootView.findViewById(R.id.mgv);
        this.f447488f = findViewById;
        findViewById.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(int i3, int i16) {
        View view = this.f447488f;
        if (view != null && view.getResources() != null) {
            if (QLog.isColorLevel()) {
                QLog.d(getTAG(), 2, "[updateMenuDelBgDrawable] pos = " + i3 + ", dataSize = " + i16);
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(this.f447488f.getResources().getColor(R.color.qui_common_feedback_error));
            float[] u16 = u(i3, i16);
            if (u16.length == 4) {
                float f16 = u16[1];
                float f17 = u16[2];
                float f18 = u16[3];
                gradientDrawable.setCornerRadii(new float[]{u16[0], u16[0], f16, f16, f17, f17, f18, f18});
            }
            this.f447488f.setBackground(gradientDrawable);
            return;
        }
        QLog.e(getTAG(), 1, "[updateMenuDelBgDrawable] mMenuDel or resource is null");
    }

    private float[] u(int i3, int i16) {
        float[] fArr = new float[4];
        fArr[0] = 0.0f;
        fArr[3] = 0.0f;
        if (i3 == 0 && i16 == 1) {
            int i17 = f447486h;
            fArr[1] = i17;
            fArr[2] = i17;
        } else if (i3 == 0 && i16 > 1) {
            fArr[1] = f447486h;
            fArr[2] = 0.0f;
        } else if (i3 == i16 - 1 && i16 > 1) {
            fArr[1] = 0.0f;
            fArr[2] = f447486h;
        } else {
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
        }
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n5y};
    }
}

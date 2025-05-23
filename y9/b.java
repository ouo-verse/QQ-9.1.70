package y9;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.albumx.common.viewmodel.k;
import com.qzone.reborn.base.l;
import com.qzone.reborn.widget.QZoneSwipeMenuLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import l9.h;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends l<IQueueTask> implements View.OnClickListener {

    /* renamed from: i, reason: collision with root package name */
    private static final int f449574i = cx.a(8.0f);

    /* renamed from: e, reason: collision with root package name */
    private QZoneSwipeMenuLayout f449575e;

    /* renamed from: f, reason: collision with root package name */
    private View f449576f;

    /* renamed from: h, reason: collision with root package name */
    private k f449577h;

    private k v() {
        k kVar = this.f449577h;
        if (kVar != null) {
            return kVar;
        }
        h hVar = (h) q(h.class);
        if (hVar == null || hVar.g5() == null) {
            return null;
        }
        k g56 = hVar.g5();
        this.f449577h = g56;
        return g56;
    }

    private void w(View view) {
        QLog.d(getTAG(), 1, "[handleDeleteClick]  | taskId=" + ((IQueueTask) this.mData).getTaskId() + " | clientKey=" + ((IQueueTask) this.mData).getClientKey() + " | caseId=" + ((IQueueTask) this.mData).getCaseId());
        k v3 = v();
        if (v3 != null) {
            v3.M1((IQueueTask) this.mData);
        }
    }

    private void y(int i3, int i16) {
        View view = this.f449576f;
        if (view != null && view.getResources() != null) {
            if (QLog.isColorLevel()) {
                QLog.d(getTAG(), 2, "[updateMenuDelBgDrawable] pos = " + i3 + ", dataSize = " + i16);
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(this.f449576f.getResources().getColor(R.color.qui_common_feedback_error));
            float[] u16 = u(i3, i16);
            if (u16.length == 4) {
                float f16 = u16[1];
                float f17 = u16[2];
                float f18 = u16[3];
                gradientDrawable.setCornerRadii(new float[]{u16[0], u16[0], f16, f16, f17, f17, f18, f18});
            }
            this.f449576f.setBackground(gradientDrawable);
            return;
        }
        QLog.e("QZPublishX_CommonPublishQueueDeleteSection", 1, "[updateMenuDelBgDrawable] mMenuDel or resource is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZPublishX_CommonPublishQueueDeleteSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.mgv) {
            this.f449575e.g();
            w(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f449575e = (QZoneSwipeMenuLayout) this.mRootView.findViewById(R.id.nga);
        View findViewById = this.mRootView.findViewById(R.id.mgv);
        this.f449576f = findViewById;
        findViewById.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindData(IQueueTask iQueueTask, int i3, List<Object> list) {
        k v3 = v();
        if (v3 == null) {
            return;
        }
        List<IQueueTask> value = v3.Q1().getValue();
        if (!RFSafeListUtils.isEmpty(value)) {
            y(i3, value.size());
        } else {
            QLog.e(getTAG(), 1, "[onBindData] data list is empty");
        }
    }

    private float[] u(int i3, int i16) {
        float[] fArr = new float[4];
        fArr[0] = 0.0f;
        fArr[3] = 0.0f;
        if (i3 == 0 && i16 == 1) {
            int i17 = f449574i;
            fArr[1] = i17;
            fArr[2] = i17;
        } else if (i3 == 0 && i16 > 1) {
            fArr[1] = f449574i;
            fArr[2] = 0.0f;
        } else if (i3 == i16 - 1 && i16 > 1) {
            fArr[1] = 0.0f;
            fArr[2] = f449574i;
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

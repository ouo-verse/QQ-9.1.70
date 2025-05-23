package ti;

import android.view.View;
import com.qzone.reborn.albumx.common.bean.e;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumTaskDetailInitBean;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends x9.a {
    private GroupAlbumTaskDetailInitBean D;

    /* JADX WARN: Multi-variable type inference failed */
    private void A(View view) {
        QLog.d(getTAG(), 1, "[handleOpeIconClick] ");
        T t16 = this.mData;
        if (t16 == 0) {
            return;
        }
        if (v((e) t16)) {
            zh.b.l().e(((e) this.mData).getStateData().getUrl());
        } else if (w((e) this.mData)) {
            zh.b.l().p(((e) this.mData).getStateData().getUrl());
        }
    }

    private void B() {
        if (p() == null || p().getIntent() == null) {
            return;
        }
        this.D = (GroupAlbumTaskDetailInitBean) p().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumDownloadQueueContentSection";
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean z16) {
        super.onAttachedChanged(z16);
        if (this.D != null) {
            if (z16) {
                zh.b.l().r(this.D.getGroupId(), this);
            } else {
                zh.b.l().s(this.D.getGroupId(), this);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.ngm) {
            A(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        if (this.D != null) {
            zh.b.l().s(this.D.getGroupId(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // x9.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        super.onInitView(view);
        B();
    }
}

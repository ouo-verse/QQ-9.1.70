package ti;

import android.view.View;
import com.qzone.reborn.albumx.common.bean.e;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumTaskDetailInitBean;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends x9.b {

    /* renamed from: i, reason: collision with root package name */
    private GroupAlbumTaskDetailInitBean f436376i;

    /* JADX WARN: Multi-variable type inference failed */
    private void w(View view) {
        QLog.d(getTAG(), 1, "[handleDeleteClick] ");
        zh.b.l().c(((e) this.mData).getStateData().getUrl());
    }

    private void x() {
        if (p() == null || p().getIntent() == null) {
            return;
        }
        this.f436376i = (GroupAlbumTaskDetailInitBean) p().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // x9.b, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumDownloadQueueDeleteSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.mgv) {
            this.f447487e.g();
            w(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // x9.b, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        super.onInitView(view);
        x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(e eVar, int i3, List<Object> list) {
        String str;
        zh.b l3 = zh.b.l();
        GroupAlbumTaskDetailInitBean groupAlbumTaskDetailInitBean = this.f436376i;
        if (groupAlbumTaskDetailInitBean != null) {
            str = groupAlbumTaskDetailInitBean.getGroupId();
        } else {
            str = "";
        }
        int g16 = l3.g(str);
        if (g16 > 0) {
            v(i3, g16);
        } else {
            QLog.e(getTAG(), 1, "[onBindData] data list is empty");
        }
    }
}

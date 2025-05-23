package sb;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.albumx.common.part.k;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxTaskDetailInitBean;
import com.tencent.biz.richframework.queue.RFWDownloadQueue;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends k {
    private QZAlbumxTaskDetailInitBean E;
    private String F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class a implements RFWDownloadQueue.QueryBizTaskStateCallback {
        a() {
        }

        @Override // com.tencent.biz.richframework.queue.RFWDownloadQueue.QueryBizTaskStateCallback
        public void onTaskListRsp(List<RFWDownloadTaskStateData> list) {
            b.this.G9(list);
        }
    }

    private void L9() {
        kc.b.INSTANCE.a().f(this.F);
    }

    private void M9() {
        kc.b.INSTANCE.a().p(this.F, new a());
    }

    @Override // com.qzone.reborn.albumx.common.part.k
    public List<RFWDownloadTaskStateData> E9(String str) {
        return kc.b.INSTANCE.a().h(str);
    }

    @Override // com.qzone.reborn.albumx.common.part.k
    protected String F9() {
        return this.F;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxDownloadQueuePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.n5_) {
            L9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.reborn.albumx.common.part.k, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        M9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        QZAlbumxTaskDetailInitBean qZAlbumxTaskDetailInitBean = (QZAlbumxTaskDetailInitBean) activity.getIntent().getSerializableExtra("key_bundle_common_init_bean");
        this.E = qZAlbumxTaskDetailInitBean;
        if (qZAlbumxTaskDetailInitBean != null) {
            this.F = qZAlbumxTaskDetailInitBean.getUin();
        }
        kc.b.INSTANCE.a().r(this.F, this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        kc.b.INSTANCE.a().s(this.F, this);
    }
}

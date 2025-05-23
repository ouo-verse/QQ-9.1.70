package t90;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.bizparts.c;
import com.tencent.biz.qqcircle.immersive.views.QFSKuiklyView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudRead$StSearchKuikly;
import java.util.HashMap;
import java.util.List;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends c {
    private QFSKuiklyView C;
    private String D;
    private FeedCloudRead$StSearchKuikly E;

    public a(Bundle bundle) {
        super(bundle);
        setBlockVisible(false);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSKuiklyView qFSKuiklyView = new QFSKuiklyView(viewGroup.getContext());
        this.C = qFSKuiklyView;
        qFSKuiklyView.setExtraTypeInfo(getExtraTypeInfo());
        this.C.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSSearchActivityBlock";
    }

    public void i0(String str) {
        RFWLog.d("QFSSearchActivityBlock", RFWLog.USR, "setKeyWords:" + str);
        this.D = str;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        boolean z16;
        List<E> list = this.mDataList;
        if (list != 0 && list.size() > i3) {
            Object obj = this.mDataList.get(i3);
            if ((obj instanceof FeedCloudRead$StSearchKuikly) && this.C != null) {
                FeedCloudRead$StSearchKuikly feedCloudRead$StSearchKuikly = (FeedCloudRead$StSearchKuikly) obj;
                if (this.E != feedCloudRead$StSearchKuikly) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean z17 = z16;
                HashMap hashMap = new HashMap();
                hashMap.put("qqcir_report_page_id", QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE);
                hashMap.put(QCircleSchemeAttr.WebView.KEY_BUSINESS_ID, feedCloudRead$StSearchKuikly.business_id.get());
                int i16 = feedCloudRead$StSearchKuikly.high.get();
                if (i16 <= 0) {
                    i16 = 357;
                }
                this.C.n0(feedCloudRead$StSearchKuikly.page_name.get(), feedCloudRead$StSearchKuikly.bundle_name.get(), feedCloudRead$StSearchKuikly.ext.get(), i16, z17, hashMap);
                this.E = feedCloudRead$StSearchKuikly;
                HashMap hashMap2 = new HashMap();
                hashMap2.put("xsj_task_id", feedCloudRead$StSearchKuikly.page_name.get());
                hashMap2.put(QCircleDaTongConstant.ElementParamKey.XSJ_CARD_TYPE, feedCloudRead$StSearchKuikly.bundle_name.get());
                hashMap2.put(QCircleDaTongConstant.ElementParamKey.XSJ_CUSTOMIZED_BUSINESS_TYPE, feedCloudRead$StSearchKuikly.business_id.get());
                if (!TextUtils.isEmpty(this.D)) {
                    hashMap2.put("xsj_query_text", this.D);
                }
                i.k(this.C, QCircleDaTongConstant.ElementId.EM_XSJ_KUIKLY_CARD, hashMap2, feedCloudRead$StSearchKuikly.hashCode());
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QFSKuiklyView qFSKuiklyView = this.C;
        if (qFSKuiklyView != null) {
            qFSKuiklyView.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QFSKuiklyView qFSKuiklyView = this.C;
        if (qFSKuiklyView != null) {
            qFSKuiklyView.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QFSKuiklyView qFSKuiklyView = this.C;
        if (qFSKuiklyView != null) {
            qFSKuiklyView.onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}

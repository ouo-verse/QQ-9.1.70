package w30;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationFeedItemView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends com.tencent.biz.qqcircle.bizparts.a<e30.b> {

    /* renamed from: m, reason: collision with root package name */
    private c f444496m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f444497d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e30.b f444498e;

        a(int i3, e30.b bVar) {
            this.f444497d = i3;
            this.f444498e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (b.this.f444496m != null) {
                b.this.f444496m.a(this.f444497d, this.f444498e, view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* renamed from: w30.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C11456b extends RecyclerView.ViewHolder {
        public QCircleBaseWidgetView E;

        public C11456b(@NonNull QCircleBaseWidgetView qCircleBaseWidgetView) {
            super(qCircleBaseWidgetView);
            this.E = qCircleBaseWidgetView;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface c {
        void a(int i3, e30.b bVar, View view);
    }

    public b(Bundle bundle) {
        super(bundle);
    }

    private void j0(View view, e30.b bVar) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_PRODUCT);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.putAll(ua0.c.d(bVar));
        VideoReport.setElementParams(view, buildElementParams);
    }

    private boolean l0(RecyclerView recyclerView, int i3, int i16) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager) || i3 % i16 != 0) {
            return false;
        }
        return true;
    }

    private boolean m0(RecyclerView recyclerView, int i3, int i16) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager) || (i3 + 1) % i16 != 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<E> list = this.mDataList;
        if (list == 0) {
            return 0;
        }
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i3;
        int i16;
        if (recyclerView != null && recyclerView.getAdapter() != null) {
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            boolean l06 = l0(recyclerView, childLayoutPosition, 3);
            boolean m06 = m0(recyclerView, childLayoutPosition, 3);
            int dip2px = ViewUtils.dip2px(0.5f);
            if (l06) {
                i3 = 0;
            } else if (m06) {
                i3 = dip2px * 2;
            } else {
                i3 = dip2px;
            }
            if (m06) {
                i16 = 0;
            } else if (l06) {
                i16 = dip2px * 2;
            } else {
                i16 = dip2px;
            }
            rect.set(i3, 0, i16, dip2px * 3);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "QFSAggregationBottomBlock";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 3;
    }

    public boolean k0() {
        if (getNUM_BACKGOURND_ICON() == 0) {
            return true;
        }
        return false;
    }

    public boolean n0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<e30.b> it = getDataList().iterator();
        int i3 = -1;
        while (it.hasNext()) {
            i3++;
            if (TextUtils.equals(str, it.next().g().f398449id.get())) {
                it.remove();
                notifyItemRemoved(i3);
                notifyItemRangeChanged(i3, getNUM_BACKGOURND_ICON() - i3);
                return true;
            }
        }
        return false;
    }

    public void o0(c cVar) {
        this.f444496m = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        List<E> list = this.mDataList;
        if (list != 0 && i3 < list.size()) {
            e30.b bVar = (e30.b) this.mDataList.get(i3);
            C11456b c11456b = (C11456b) viewHolder;
            c11456b.E.setData(bVar, i3);
            c11456b.E.setOnClickListener(new a(i3, bVar));
            j0(viewHolder.itemView, bVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new C11456b(new QFSAggregationFeedItemView(viewGroup.getContext()));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}

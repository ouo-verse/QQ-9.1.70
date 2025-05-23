package vd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.base.j;
import com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.viewmodel.f;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.qqlive.module.videoreport.VideoReport;
import hh.c;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class b<E> extends j<E> {
    private f C;

    /* renamed from: m, reason: collision with root package name */
    private c f441423m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traversePage(recyclerView);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: vd.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static class C11413b extends RecyclerView.ViewHolder {
        public C11413b(View view) {
            super(view);
        }

        public void l(CommonFeed commonFeed, int i3) {
            View view = this.itemView;
            if (view instanceof QzoneBaseFeedProItemView) {
                ((QzoneBaseFeedProItemView) view).setData(commonFeed, i3);
            }
        }
    }

    public b(Bundle bundle) {
        super(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j0(hh.b bVar) {
        c cVar = this.f441423m;
        if (cVar != null) {
            cVar.d(bVar);
        }
    }

    public LifecycleOwner k0() {
        if (getBlockMerger() == null || getBlockMerger().getBlockPart() == null || getBlockMerger().getBlockPart().getPartHost() == null) {
            return null;
        }
        return getBlockMerger().getBlockPart().getPartHost().getHostLifecycleOwner();
    }

    protected abstract List<hh.b> l0();

    protected void n0(final RecyclerView recyclerView) {
        f fVar = this.C;
        if (fVar != null) {
            fVar.M1().observe(getParentFragment(), new Observer() { // from class: vd.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    b.m0(RecyclerView.this, (Integer) obj);
                }
            });
        }
    }

    public void o0() {
        c cVar = this.f441423m;
        if (cVar != null) {
            cVar.k();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        p0(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        c cVar = this.f441423m;
        if (cVar != null) {
            cVar.bindViewHolder(viewHolder);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        c cVar = this.f441423m;
        if (cVar != null) {
            removeOnScrollListener(cVar);
            this.f441423m.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        c cVar = this.f441423m;
        if (cVar != null) {
            cVar.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        c cVar = this.f441423m;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        c cVar = this.f441423m;
        if (cVar != null) {
            cVar.onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        c cVar = this.f441423m;
        if (cVar != null) {
            cVar.onStop();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        c cVar = this.f441423m;
        if (cVar != null) {
            cVar.l(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        c cVar = this.f441423m;
        if (cVar != null) {
            cVar.m(viewHolder);
        }
    }

    protected void p0(RecyclerView recyclerView) {
        this.f441423m = new c(getContext(), recyclerView, this);
        this.C = (f) getViewModel(f.class);
        List<hh.b> l06 = l0();
        if (l06 != null && l06.size() > 0) {
            Iterator<hh.b> it = l06.iterator();
            while (it.hasNext()) {
                this.f441423m.d(it.next());
            }
        }
        addOnScrollListener(this.f441423m);
        this.f441423m.j(recyclerView);
        recyclerView.addOnScrollListener(new a());
        n0(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m0(RecyclerView recyclerView, Integer num) {
        for (int i3 = 0; i3 < recyclerView.getChildCount(); i3++) {
            try {
                View childAt = recyclerView.getChildAt(i3);
                if (childAt instanceof QZoneBaseFeedItemView) {
                    ((QZoneBaseFeedItemView) childAt).y0(num);
                }
            } catch (Exception e16) {
                RFWLog.fatal("QzoneBaseFeedProListAdapter", RFWLog.USR, e16);
                return;
            }
        }
    }
}

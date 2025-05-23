package q60;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.search.filter.QFSSearchFilterChoiceItemView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends com.tencent.biz.qqcircle.bizparts.a<String> {
    private int C;
    private p70.d D;
    private Fragment E;
    private String F;

    /* renamed from: m, reason: collision with root package name */
    private int f428449m;

    public c(Bundle bundle) {
        super(bundle);
        setHasStableIds(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        q0(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(List list) {
        int i3;
        if (list != null) {
            int size = list.size();
            int i16 = this.C;
            if (size > i16) {
                i3 = ((Integer) list.get(i16)).intValue();
                q0(i3);
            }
        }
        i3 = 0;
        q0(i3);
    }

    private void q0(int i3) {
        if (i3 != this.f428449m && i3 < getNUM_BACKGOURND_ICON()) {
            int i16 = this.f428449m;
            this.f428449m = i3;
            notifyItemChanged(i16);
            notifyItemChanged(this.f428449m);
            p70.d dVar = this.D;
            if (dVar != null) {
                dVar.e2(this.C, this.f428449m);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<E> list = this.mDataList;
        if (list != 0) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "QFSSearchFilterChoiceAdapter";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    public void m0(p70.d dVar) {
        this.D = dVar;
    }

    public void n0(Fragment fragment) {
        this.E = fragment;
    }

    public void o0(int i3) {
        this.C = i3;
        p70.d dVar = this.D;
        if (dVar != null && this.E != null) {
            dVar.S1().observe(this.E, new Observer() { // from class: q60.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    c.this.l0((List) obj);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i3) {
        boolean z16;
        if (!ab0.a.a(i3, getDataList())) {
            View view = viewHolder.itemView;
            if (view instanceof QFSSearchFilterChoiceItemView) {
                QFSSearchFilterChoiceItemView qFSSearchFilterChoiceItemView = (QFSSearchFilterChoiceItemView) view;
                qFSSearchFilterChoiceItemView.setTitle(this.F);
                if (i3 == this.f428449m) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                qFSSearchFilterChoiceItemView.setSelected(z16);
                qFSSearchFilterChoiceItemView.setData(getItem(i3), i3);
                qFSSearchFilterChoiceItemView.setOnClickListener(new View.OnClickListener() { // from class: q60.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        c.this.k0(i3, view2);
                    }
                });
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSSearchFilterChoiceItemView qFSSearchFilterChoiceItemView = new QFSSearchFilterChoiceItemView(viewGroup.getContext());
        qFSSearchFilterChoiceItemView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        qFSSearchFilterChoiceItemView.setReportBean(getReportBean());
        return new BaseListViewAdapter.BaseVH(qFSSearchFilterChoiceItemView);
    }

    public void p0(String str) {
        this.F = str;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}

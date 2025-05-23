package z30;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleAlbumDetailBean;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.utils.j;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends MultiViewBlock<b40.a> {

    /* renamed from: m, reason: collision with root package name */
    private Drawable f451842m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends RecyclerView.ViewHolder {
        public RoundCornerImageView E;
        public TextView F;
        public TextView G;

        public a(@NonNull View view) {
            super(view);
            this.E = (RoundCornerImageView) view.findViewById(R.id.f33600ww);
            this.F = (TextView) view.findViewById(R.id.f164289r3);
            this.G = (TextView) view.findViewById(R.id.f164286qy);
        }
    }

    public e(Bundle bundle) {
        super(bundle);
        this.f451842m = com.tencent.biz.qqcircle.immersive.manager.d.c().d(R.drawable.naw);
    }

    private void j0(View view, b40.a aVar) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM);
        HashMap hashMap = new HashMap();
        if (aVar.f() != null) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, Long.valueOf(aVar.f().album.f398441id.get()));
        }
        VideoReport.setElementParams(view, hashMap);
        VideoReport.setElementReuseIdentifier(view, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM + "_" + aVar.k());
    }

    private void k0(Context context, b40.a aVar) {
        QCircleAlbumDetailBean qCircleAlbumDetailBean = new QCircleAlbumDetailBean(aVar.k().longValue());
        qCircleAlbumDetailBean.setFeedAlbum(aVar.f().album.get());
        com.tencent.biz.qqcircle.launcher.c.Z(context, qCircleAlbumDetailBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(b40.a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        k0(getContext(), aVar);
        EventCollector.getInstance().onViewClicked(view);
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

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    public void m0(List<b40.a> list) {
        if (list == null) {
            return;
        }
        if (this.mDataList.size() >= list.size()) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            notifyDataSetChanged();
        } else {
            int size = this.mDataList.size();
            this.mDataList.clear();
            this.mDataList.addAll(list);
            notifyItemRangeInserted(size, this.mDataList.size() - size);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        a aVar = (a) viewHolder;
        final b40.a aVar2 = (b40.a) this.mDataList.get(i3);
        aVar.E.setCorner(ViewUtils.dpToPx(4.0f));
        j.b(aVar.E, aVar2.c(), aVar.E.getLayoutParams().width, aVar.E.getLayoutParams().height, this.f451842m);
        if (aVar2.m().isEmpty()) {
            aVar.F.setText("");
        } else {
            aVar.F.setText(aVar2.m());
        }
        if (aVar2.f() != null && aVar2.f().album != null) {
            if (aVar2.f().album.get().visitorInfo != null && aVar2.f().album.get().visitorInfo.get().viewDesc != null && !TextUtils.isEmpty(aVar2.f().album.get().visitorInfo.get().viewDesc.get())) {
                aVar.G.setText(aVar2.f().album.get().visitorInfo.get().viewDesc.get());
            } else if (aVar2.f().album.get().feed_count.get() > 0) {
                aVar.G.setText(aVar2.f().album.get().feed_count.get() + " \u4f5c\u54c1");
            }
        }
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: z30.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.l0(aVar2, view);
            }
        });
        j0(viewHolder.itemView, aVar2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(getContext()).inflate(R.layout.gko, viewGroup, false));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}

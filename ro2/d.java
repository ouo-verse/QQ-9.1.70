package ro2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.trpcprotocol.unite.unifysearch.head_template.HeadTemplatePB$SearchIconItem;
import com.tencent.trpcprotocol.unite.unifysearch.head_template.HeadTemplatePB$SearchTemplateResp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends ro2.b {
    private List<HeadTemplatePB$SearchIconItem> C;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f431810i;

    /* renamed from: m, reason: collision with root package name */
    private a f431811m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class a extends RecyclerView.Adapter<b> {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            if (d.this.C == null) {
                return 0;
            }
            return d.this.C.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull b bVar, int i3) {
            bVar.l((HeadTemplatePB$SearchIconItem) d.this.C.get(i3), i3, d.this.f431807h + i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            d dVar = d.this;
            return new b(LayoutInflater.from(dVar.f431810i.getContext()).inflate(R.layout.ful, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView E;
        private final TextView F;
        private HeadTemplatePB$SearchIconItem G;

        b(@NonNull View view) {
            super(view);
            this.E = (ImageView) view.findViewById(R.id.f53202bv);
            this.F = (TextView) view.findViewById(R.id.f53212bw);
            view.setOnClickListener(this);
        }

        public void l(HeadTemplatePB$SearchIconItem headTemplatePB$SearchIconItem, int i3, int i16) {
            this.G = headTemplatePB$SearchIconItem;
            ad.s(this.E, headTemplatePB$SearchIconItem.icon.get());
            this.F.setText(headTemplatePB$SearchIconItem.text.get());
            so2.a.a(this.itemView, headTemplatePB$SearchIconItem.report_info.get(), i16);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            d.this.a("QCircleSearchGameUnionIconPresenter", this.G.scheme.get());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Override // ro2.b
    public void d(HeadTemplatePB$SearchTemplateResp headTemplatePB$SearchTemplateResp, int i3, int i16) {
        super.d(headTemplatePB$SearchTemplateResp, i3, i16);
        this.f431810i.setVisibility(8);
        List<HeadTemplatePB$SearchIconItem> list = headTemplatePB$SearchTemplateResp.icons.get();
        if (list.isEmpty()) {
            this.f431806f = true;
            return;
        }
        if (list.get(0).icon.get().isEmpty()) {
            this.f431806f = true;
            return;
        }
        if (list.size() > 4) {
            list = list.subList(0, 4);
        }
        this.f431810i.setVisibility(0);
        this.f431806f = false;
        RecyclerView recyclerView = this.f431810i;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), list.size()));
        this.C = list;
        this.f431810i.setAdapter(this.f431811m);
    }

    @Override // ro2.b
    public void e(View view) {
        super.e(view);
        this.f431810i = (RecyclerView) view.findViewById(R.id.f53172bs);
        this.f431811m = new a();
    }
}

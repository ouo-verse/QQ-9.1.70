package sq;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorSelectionView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import javax.annotation.Nonnull;
import rq.c;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d extends RecyclerView.Adapter<b> {
    private static List<c.a> C;

    /* renamed from: d, reason: collision with root package name */
    private Context f434190d;

    /* renamed from: e, reason: collision with root package name */
    private int f434191e = 0;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView f434192f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f434193h;

    /* renamed from: i, reason: collision with root package name */
    private String f434194i;

    /* renamed from: m, reason: collision with root package name */
    private String f434195m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f434196d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f434197e;

        a(int i3, b bVar) {
            this.f434196d = i3;
            this.f434197e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f434196d != d.this.f434191e) {
                b bVar = (b) d.this.f434192f.findViewHolderForAdapterPosition(d.this.f434191e);
                if (bVar != null) {
                    bVar.c(false);
                } else {
                    d.this.notifyDataSetChanged();
                }
                this.f434197e.c(true);
                d.this.A(this.f434196d);
                if (d.this.f434193h != null) {
                    d.this.f434193h.setTextColor(Color.parseColor(d.this.f434194i));
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static class b extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        AEGIFTextColorSelectionView f434199d;

        public b(View view) {
            super(view);
            this.f434199d = (AEGIFTextColorSelectionView) view.findViewById(R.id.f163734rq1);
        }

        public void b(String str) {
            this.f434199d.setColor(str);
        }

        public void c(boolean z16) {
            this.f434199d.a(Boolean.valueOf(z16));
        }
    }

    public d(Context context, RecyclerView recyclerView) {
        this.f434190d = context;
        this.f434192f = recyclerView;
        x();
        this.f434194i = C.get(this.f434191e).f431901a;
        this.f434195m = C.get(this.f434191e).f431902b;
    }

    private void x() {
        C = rq.c.f431900b;
    }

    public void A(int i3) {
        this.f434191e = i3;
        this.f434194i = C.get(i3).f431901a;
        this.f434195m = C.get(i3).f431902b;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return C.size();
    }

    public void t(TextView textView) {
        this.f434193h = textView;
    }

    @Nonnull
    public String u() {
        return this.f434195m;
    }

    public int v() {
        return this.f434191e;
    }

    public String w() {
        return this.f434194i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i3) {
        bVar.b(C.get(i3).f431901a);
        if (i3 == this.f434191e) {
            bVar.c(true);
        } else {
            bVar.c(false);
        }
        bVar.itemView.setOnClickListener(new a(i3, bVar));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (this.f434190d == null) {
            this.f434190d = viewGroup.getContext();
        }
        return new b(LayoutInflater.from(this.f434190d).inflate(R.layout.do8, viewGroup, false));
    }
}

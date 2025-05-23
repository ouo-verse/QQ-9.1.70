package sq;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.util.i;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import rq.c;
import rq.e;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends RecyclerView.Adapter<C11247b> {

    /* renamed from: d, reason: collision with root package name */
    private Context f434167d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<rq.b> f434168e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView f434169f;

    /* renamed from: i, reason: collision with root package name */
    private e f434171i;

    /* renamed from: h, reason: collision with root package name */
    private int f434170h = -1;

    /* renamed from: m, reason: collision with root package name */
    private boolean f434172m = i.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ C11247b f434173d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f434174e;

        a(C11247b c11247b, String str) {
            this.f434173d = c11247b;
            this.f434174e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (b.this.f434170h != this.f434173d.getLayoutPosition()) {
                com.tencent.aelight.camera.ae.report.b.b().I1(this.f434174e);
            }
            if (b.this.f434170h == -1 && TextUtils.isEmpty(b.this.f434171i.n())) {
                e eVar = b.this.f434171i;
                String str = this.f434174e;
                List<c.a> list = rq.c.f431900b;
                eVar.s(str, list.get(0).f431901a, list.get(0).f431902b);
                b.this.f434171i.t(true, false);
            } else {
                b.this.f434171i.r(this.f434174e);
            }
            b.this.u();
            b.this.f434170h = this.f434173d.getLayoutPosition();
            ((rq.b) b.this.f434168e.get(b.this.f434170h - 1)).a(true);
            this.f434173d.b(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: sq.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static class C11247b extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        TextView f434176d;

        public C11247b(View view) {
            super(view);
            this.f434176d = (TextView) view.findViewById(R.id.rz6);
        }

        public void b(boolean z16) {
            this.itemView.setSelected(z16);
        }
    }

    public b(Context context, e eVar) {
        this.f434167d = context;
        this.f434171i = eVar;
        x(eVar.k());
        t(this.f434171i.l());
    }

    private void t(RecyclerView recyclerView) {
        this.f434169f = recyclerView;
    }

    private void x(ArrayList<rq.b> arrayList) {
        this.f434168e = arrayList;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f434168e.size() + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 != 0) {
            return 0;
        }
        return 1;
    }

    public void u() {
        C11247b c11247b = (C11247b) this.f434169f.findViewHolderForLayoutPosition(this.f434170h);
        if (c11247b != null) {
            c11247b.b(false);
        } else {
            int i3 = this.f434170h;
            if (i3 >= 0) {
                notifyItemChanged(i3);
            }
        }
        int i16 = this.f434170h;
        if (i16 >= 0) {
            this.f434168e.get(i16 - 1).a(false);
        }
        this.f434170h = -1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C11247b c11247b, int i3) {
        if (c11247b.getLayoutPosition() == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(x.c(this.f434167d, 33.0f), x.c(this.f434167d, 33.0f));
            layoutParams.setMargins(0, 0, x.c(this.f434167d, 51.0f), 0);
            c11247b.itemView.setLayoutParams(layoutParams);
        } else {
            String str = this.f434168e.get(c11247b.getLayoutPosition() - 1).f431897a;
            c11247b.f434176d.setText(str);
            if (this.f434170h == c11247b.getLayoutPosition()) {
                c11247b.b(true);
            } else {
                c11247b.b(false);
            }
            c11247b.itemView.setOnClickListener(new a(c11247b, str));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public C11247b onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (this.f434167d == null) {
            this.f434167d = viewGroup.getContext();
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.f434172m ? R.layout.do6 : R.layout.do5, viewGroup, false);
        if (i3 != 0) {
            inflate.setVisibility(4);
        }
        return new C11247b(inflate);
    }
}

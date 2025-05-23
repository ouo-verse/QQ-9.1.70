package sq;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.i;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends RecyclerView.Adapter<C11248c> {

    /* renamed from: d, reason: collision with root package name */
    private Context f434177d;

    /* renamed from: e, reason: collision with root package name */
    private List<AEMaterialWrapper> f434178e;

    /* renamed from: f, reason: collision with root package name */
    private int f434179f = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f434180h = 0;

    /* renamed from: i, reason: collision with root package name */
    private b f434181i;

    /* renamed from: m, reason: collision with root package name */
    private RecyclerView f434182m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f434183d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AEMaterialWrapper f434184e;

        a(int i3, AEMaterialWrapper aEMaterialWrapper) {
            this.f434183d = i3;
            this.f434184e = aEMaterialWrapper;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ms.a.a("AEGIFStickerAdapter", "[ItemView.onClick] position=" + this.f434183d + ", mClickedPos=" + c.this.f434179f + ", mActivatedPos=" + c.this.f434180h);
            c.this.f434179f = this.f434183d;
            AEMaterialWrapper aEMaterialWrapper = this.f434184e;
            int i3 = aEMaterialWrapper.f63558f;
            if (i3 == 2 || aEMaterialWrapper.f63559g == 1) {
                ms.a.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_DOWNLOADED");
                c.this.B(this.f434183d);
                if (this.f434183d != c.this.f434180h) {
                    ms.a.a("AEGIFStickerAdapter", "[ItemView.onClick] position != mActivatedPos");
                    int i16 = c.this.f434180h;
                    c.this.f434180h = this.f434183d;
                    c.this.notifyItemChanged(this.f434183d);
                    c.this.notifyItemChanged(i16);
                    if (c.this.f434181i != null) {
                        b bVar = c.this.f434181i;
                        AEMaterialWrapper aEMaterialWrapper2 = this.f434184e;
                        bVar.a(aEMaterialWrapper2.f63559g != 1 ? aEMaterialWrapper2 : null);
                    }
                    AEBaseReportParam.U().N0(this.f434184e.f63553a);
                    com.tencent.aelight.camera.ae.report.b.b().S0();
                    ms.a.f("AEGIFStickerAdapter", "[ItemView.onClick] gifMaterialClick, id=" + this.f434184e.f63553a);
                } else {
                    ms.a.a("AEGIFStickerAdapter", "[ItemView.onClick] position == mActivatedPos");
                }
            } else if (i3 == 0) {
                ms.a.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_NOT_DOWNLOAD");
                if (c.this.f434181i != null) {
                    b bVar2 = c.this.f434181i;
                    AEMaterialWrapper aEMaterialWrapper3 = this.f434184e;
                    bVar2.a(aEMaterialWrapper3.f63559g != 1 ? aEMaterialWrapper3 : null);
                }
            } else {
                ms.a.a("AEGIFStickerAdapter", "[ItemView.onClick] data.state == STATE_DOWNLOADING");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface b {
        void a(AEMaterialWrapper aEMaterialWrapper);
    }

    /* compiled from: P */
    /* renamed from: sq.c$c, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static class C11248c extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        ImageView f434186d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f434187e;

        /* renamed from: f, reason: collision with root package name */
        FrameLayout f434188f;

        /* renamed from: h, reason: collision with root package name */
        ProgressBar f434189h;

        public C11248c(View view) {
            super(view);
            this.f434186d = (ImageView) view.findViewById(R.id.rn9);
            this.f434188f = (FrameLayout) view.findViewById(R.id.f163718rn0);
            this.f434187e = (ImageView) view.findViewById(R.id.rna);
            this.f434189h = (ProgressBar) view.findViewById(R.id.rn_);
            if (i.b()) {
                this.f434187e.setImageResource(R.drawable.iu7);
                this.f434186d.setBackgroundResource(R.drawable.irw);
            }
        }
    }

    public c(Context context, List<AEMaterialWrapper> list) {
        this.f434177d = context;
        this.f434178e = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i3) {
        RecyclerView recyclerView = this.f434182m;
        if (recyclerView != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = findFirstVisibleItemPosition + (((linearLayoutManager.findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1) / 2);
            if (i3 > findLastVisibleItemPosition) {
                RecyclerView recyclerView2 = this.f434182m;
                recyclerView2.smoothScrollBy(zr.a.a(recyclerView2.getContext(), 70.0f), 0);
            } else if (i3 < findLastVisibleItemPosition) {
                RecyclerView recyclerView3 = this.f434182m;
                recyclerView3.smoothScrollBy(-zr.a.a(recyclerView3.getContext(), 70.0f), 0);
            }
        }
    }

    private void C(int i3) {
        RecyclerView recyclerView = this.f434182m;
        if (recyclerView != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = (((linearLayoutManager.findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1) / 2) + findFirstVisibleItemPosition;
            if (i3 < findFirstVisibleItemPosition || i3 > findLastVisibleItemPosition) {
                this.f434182m.scrollToPosition(i3);
                return;
            }
            if (i3 > findLastVisibleItemPosition) {
                RecyclerView recyclerView2 = this.f434182m;
                recyclerView2.smoothScrollBy(zr.a.a(recyclerView2.getContext(), 70.0f), 0);
            } else if (i3 < findLastVisibleItemPosition) {
                RecyclerView recyclerView3 = this.f434182m;
                recyclerView3.smoothScrollBy(-zr.a.a(recyclerView3.getContext(), 70.0f), 0);
            }
        }
    }

    public void D(b bVar) {
        this.f434181i = bVar;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f434178e.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f434182m = recyclerView;
    }

    public String v() {
        AEMaterialWrapper aEMaterialWrapper = this.f434178e.get(this.f434179f);
        if (aEMaterialWrapper == null || aEMaterialWrapper.f63559g == 1) {
            return null;
        }
        return aEMaterialWrapper.f63553a;
    }

    public void w(AEMaterialWrapper aEMaterialWrapper, boolean z16) {
        int indexOf = this.f434178e.indexOf(aEMaterialWrapper);
        if (z16) {
            this.f434179f = this.f434180h;
            notifyItemChanged(indexOf);
            return;
        }
        if (aEMaterialWrapper.f63558f == 2) {
            if (indexOf == this.f434179f) {
                C(indexOf);
                int i3 = this.f434180h;
                this.f434180h = indexOf;
                notifyItemChanged(indexOf);
                notifyItemChanged(i3);
                AEBaseReportParam.U().N0(aEMaterialWrapper.f63553a);
                com.tencent.aelight.camera.ae.report.b.b().S0();
                ms.a.f("AEGIFStickerAdapter", "[notifyDownloadStateChanged], gifMaterialDownloaded, id=" + aEMaterialWrapper.f63553a);
                return;
            }
            notifyItemChanged(indexOf);
            return;
        }
        notifyItemChanged(indexOf);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        if (r1 != 2) goto L13;
     */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(C11248c c11248c, int i3) {
        AEMaterialWrapper aEMaterialWrapper = this.f434178e.get(i3);
        if (aEMaterialWrapper.f63559g == 1) {
            c11248c.f434186d.setImageResource(R.drawable.ixp);
            c11248c.f434189h.setVisibility(8);
        } else {
            c11248c.f434186d.setImageDrawable(VasApngUtil.getApngURLDrawable(aEMaterialWrapper.f63554b.thumbUrl, new int[]{0}, this.f434177d.getResources().getDrawable(R.drawable.f159998iy2)));
            int i16 = aEMaterialWrapper.f63558f;
            if (i16 != 0) {
                if (i16 == 1) {
                    c11248c.f434189h.setVisibility(0);
                }
            }
            c11248c.f434189h.setVisibility(8);
        }
        c11248c.itemView.setOnClickListener(new a(i3, aEMaterialWrapper));
        if (i3 == this.f434180h) {
            AEBaseReportParam.U().N0(aEMaterialWrapper.f63553a);
            ViewGroup.LayoutParams layoutParams = c11248c.f434188f.getLayoutParams();
            layoutParams.width = zr.a.a(this.f434177d, 75.0f);
            layoutParams.height = zr.a.a(this.f434177d, 75.0f);
            c11248c.f434188f.setLayoutParams(layoutParams);
            c11248c.f434188f.setBackgroundResource(R.drawable.f159996iy0);
            c11248c.f434187e.setVisibility(0);
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = c11248c.f434188f.getLayoutParams();
        layoutParams2.width = zr.a.a(this.f434177d, 60.0f);
        layoutParams2.height = zr.a.a(this.f434177d, 60.0f);
        c11248c.f434188f.setLayoutParams(layoutParams2);
        c11248c.f434188f.setBackgroundResource(R.drawable.ixz);
        c11248c.f434187e.setVisibility(4);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public C11248c onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (this.f434177d == null) {
            this.f434177d = viewGroup.getContext();
        }
        return new C11248c(LayoutInflater.from(this.f434177d).inflate(R.layout.do7, viewGroup, false));
    }

    public void z(int i3) {
        ms.a.f("AEGIFStickerAdapter", "[onItemSelectedFromOutside], position=" + i3 + ", mClickedPos=" + this.f434179f + ", mActivatedPos=" + this.f434180h);
        AEMaterialWrapper aEMaterialWrapper = this.f434178e.get(i3);
        this.f434179f = i3;
        if (aEMaterialWrapper.f63558f != 2 && aEMaterialWrapper.f63559g != 1) {
            ms.a.f("AEGIFStickerAdapter", "[onItemSelectedFromOutside] materialWrapper.state != STATE_DOWNLOADED");
            return;
        }
        ms.a.f("AEGIFStickerAdapter", "[onItemSelectedFromOutside] materialWrapper.state == STATE_DOWNLOADED || materialWrapper.type == AEMaterialWrapper.TYPE_PLACEHOLDER");
        if (i3 != this.f434180h) {
            RecyclerView recyclerView = this.f434182m;
            if (recyclerView != null) {
                recyclerView.scrollToPosition(i3);
            }
            int i16 = this.f434180h;
            this.f434180h = i3;
            notifyItemChanged(i3);
            notifyItemChanged(i16);
        }
    }

    public void A() {
        this.f434179f = 0;
        this.f434180h = 0;
    }
}

package rq;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFOutlineTextView;
import com.tencent.aelight.camera.aebase.BaseVMPeakActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.util.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e {

    /* renamed from: o, reason: collision with root package name */
    public static final List<String> f431913o = Arrays.asList(HardCodeUtil.qqStr(R.string.j7g), HardCodeUtil.qqStr(R.string.j7r), HardCodeUtil.qqStr(R.string.j7p), HardCodeUtil.qqStr(R.string.j7w), HardCodeUtil.qqStr(R.string.f171563j80), HardCodeUtil.qqStr(R.string.j7x), "dbq", "886", HardCodeUtil.qqStr(R.string.j7u), HardCodeUtil.qqStr(R.string.j7t), HardCodeUtil.qqStr(R.string.j7k), FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, "666", HardCodeUtil.qqStr(R.string.j7m), HardCodeUtil.qqStr(R.string.f171565j83), HardCodeUtil.qqStr(R.string.j7v));

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, String> f431914a;

    /* renamed from: b, reason: collision with root package name */
    private BaseVMPeakActivity f431915b;

    /* renamed from: c, reason: collision with root package name */
    private RelativeLayout f431916c;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f431917d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f431918e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f431919f;

    /* renamed from: g, reason: collision with root package name */
    private ProgressBar f431920g;

    /* renamed from: h, reason: collision with root package name */
    private StaggeredGridLayoutManager f431921h;

    /* renamed from: i, reason: collision with root package name */
    private sq.b f431922i;

    /* renamed from: j, reason: collision with root package name */
    private AEGIFOutlineTextView f431923j;

    /* renamed from: k, reason: collision with root package name */
    private String f431924k;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<String> f431926m;

    /* renamed from: l, reason: collision with root package name */
    private int f431925l = 0;

    /* renamed from: n, reason: collision with root package name */
    private boolean f431927n = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            e.this.f431922i.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            e.this.h();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class c implements Observer<com.tencent.aelight.camera.ae.gif.c> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.aelight.camera.ae.gif.c cVar) {
            String qqStr;
            com.tencent.aelight.camera.ae.gif.giftext.viewmodel.a.L1().removeObservers(e.this.f431915b);
            if (cVar == null || cVar.f65339b == null) {
                cVar = new com.tencent.aelight.camera.ae.gif.c();
                cVar.f65339b = "default";
            }
            String str = (String) e.this.f431914a.get(cVar.f65339b);
            if (!cVar.f65339b.equals("default")) {
                qqStr = HardCodeUtil.qqStr(R.string.j7z) + str + HardCodeUtil.qqStr(R.string.j7s);
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.j7o);
                cVar.f65338a.addAll(e.f431913o);
            }
            e.this.f431919f.setText(qqStr);
            if (e.this.f431926m.size() != 0 || e.this.f431927n) {
                return;
            }
            e.this.f431926m.addAll(cVar.f65338a);
            e.this.p();
            e.this.f431927n = true;
        }
    }

    public e(BaseVMPeakActivity baseVMPeakActivity, RelativeLayout relativeLayout, AEGIFOutlineTextView aEGIFOutlineTextView) {
        this.f431915b = baseVMPeakActivity;
        this.f431916c = relativeLayout;
        if (relativeLayout != null) {
            this.f431919f = (TextView) relativeLayout.findViewById(R.id.rz8);
            this.f431920g = (ProgressBar) this.f431916c.findViewById(R.id.s0z);
            this.f431917d = (RecyclerView) this.f431916c.findViewById(R.id.rz9);
            this.f431918e = (ImageView) this.f431916c.findViewById(R.id.rz5);
        }
        this.f431923j = aEGIFOutlineTextView;
        HashMap<String, String> hashMap = new HashMap<>();
        this.f431914a = hashMap;
        hashMap.put("happy", HardCodeUtil.qqStr(R.string.j85));
        this.f431914a.put("neutral", HardCodeUtil.qqStr(R.string.j7h));
        this.f431914a.put("sad", HardCodeUtil.qqStr(R.string.j7n));
        this.f431914a.put("anger", HardCodeUtil.qqStr(R.string.j7y));
        this.f431914a.put("disgust", HardCodeUtil.qqStr(R.string.j7q));
        this.f431914a.put("fear", HardCodeUtil.qqStr(R.string.j7l));
    }

    private void j(String str, String str2, String str3) {
        int c16;
        int c17;
        this.f431923j.setText(str);
        ViewGroup.LayoutParams layoutParams = this.f431923j.getLayoutParams();
        if (str.indexOf(10) > 0) {
            c16 = x.c(this.f431915b, 73.2f);
        } else {
            c16 = x.c(this.f431915b, 41.0f);
        }
        layoutParams.height = c16;
        this.f431923j.setLayoutParams(layoutParams);
        this.f431923j.setTextColor(str2);
        this.f431923j.setOutlineColor(str3);
        this.f431923j.setOutlineWidth(x.c(this.f431915b, 4.0f));
        if (str.indexOf(10) > 0) {
            c17 = x.c(this.f431915b, 26.0f);
        } else {
            c17 = x.c(this.f431915b, 30.0f);
        }
        this.f431923j.setTextSize(c17);
        this.f431923j.invalidate();
    }

    public void h() {
        Log.d("AEGIFTextMvp", "Clearing smart text");
        this.f431918e.setSelected(true);
        sq.b bVar = this.f431922i;
        if (bVar != null) {
            bVar.u();
        }
        this.f431924k = "";
        this.f431925l = 0;
        t(false, true);
        this.f431923j.setShadowParam(3.0f, 0.0f, 1.0f, "#73000000");
        j(HardCodeUtil.qqStr(R.string.f171564j81), "#ccffffff", "#000000");
    }

    public void i(String str) {
        int c16;
        int c17;
        this.f431923j.setText(str);
        this.f431923j.setOutlineWidth(x.c(this.f431915b, 4.0f));
        ViewGroup.LayoutParams layoutParams = this.f431923j.getLayoutParams();
        AEGIFOutlineTextView aEGIFOutlineTextView = this.f431923j;
        if (str.indexOf(10) > 0) {
            c16 = x.c(this.f431915b, 26.0f);
        } else {
            c16 = x.c(this.f431915b, 30.0f);
        }
        aEGIFOutlineTextView.setTextSize(c16);
        if (str.indexOf(10) > 0) {
            c17 = x.c(this.f431915b, 73.2f);
        } else {
            c17 = x.c(this.f431915b, 41.0f);
        }
        layoutParams.height = c17;
        this.f431923j.setLayoutParams(layoutParams);
    }

    public ArrayList<rq.b> k() {
        ArrayList<rq.b> arrayList = new ArrayList<>();
        Iterator<String> it = this.f431926m.iterator();
        while (it.hasNext()) {
            arrayList.add(new rq.b(it.next()));
        }
        return arrayList;
    }

    public RecyclerView l() {
        return this.f431917d;
    }

    public int m() {
        return this.f431925l;
    }

    public String n() {
        return this.f431924k;
    }

    public void o() {
        this.f431924k = "";
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 0);
        this.f431921h = staggeredGridLayoutManager;
        staggeredGridLayoutManager.setGapStrategy(0);
        this.f431917d.setLayoutManager(this.f431921h);
        this.f431917d.setItemAnimator(null);
        this.f431917d.setVisibility(4);
        this.f431918e.setVisibility(4);
        q();
    }

    public void p() {
        Log.d("AEGIFTextMvp", "On loading completed...");
        this.f431920g.setVisibility(4);
        sq.b bVar = new sq.b(this.f431915b, this);
        this.f431922i = bVar;
        bVar.setHasStableIds(true);
        this.f431917d.setAdapter(this.f431922i);
        this.f431917d.setClipToPadding(false);
        this.f431917d.setClipChildren(false);
        this.f431917d.setVisibility(0);
        this.f431917d.addOnScrollListener(new a());
        this.f431918e.setVisibility(0);
        this.f431918e.setOnClickListener(new b());
    }

    public void q() {
        Log.d("AEGIFTextMvp", "On loading...");
        this.f431920g.setVisibility(0);
        this.f431926m = new ArrayList<>();
        h();
        com.tencent.aelight.camera.ae.gif.giftext.viewmodel.a.L1().observe(this.f431915b, new c());
    }

    public void r(String str) {
        sq.b bVar;
        this.f431924k = str;
        if (!this.f431926m.contains(str) && (bVar = this.f431922i) != null) {
            bVar.u();
        }
        i(str);
        this.f431918e.setSelected(false);
    }

    public void s(String str, String str2, String str3) {
        this.f431923j.setTextColor(str2);
        this.f431923j.setOutlineColor(str3);
        r(str);
    }

    public void t(boolean z16, boolean z17) {
        this.f431923j.setStroke(z16);
        this.f431923j.setShadow(z17);
    }

    public void u(int i3) {
        this.f431925l = i3;
    }
}

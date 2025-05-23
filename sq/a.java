package sq;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFOutlineTextView;
import com.tencent.aelight.camera.ae.gif.giftext.DrawableImageView;
import com.tencent.aelight.camera.ae.util.i;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.light.device.LightDeviceUtils;
import rq.c;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends RecyclerView.Adapter<f> {
    private View D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    private Context f434146d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.gif.giftext.viewmodel.b f434147e;

    /* renamed from: f, reason: collision with root package name */
    private LifecycleOwner f434148f;

    /* renamed from: h, reason: collision with root package name */
    private List<rq.a> f434149h;

    /* renamed from: i, reason: collision with root package name */
    private String f434150i;

    /* renamed from: m, reason: collision with root package name */
    private e f434151m;
    private boolean F = i.b();
    private HashMap<String, SoftReference<com.tencent.aelight.camera.ae.gif.giftext.view.a>> G = new HashMap<>();
    private Set<Integer> C = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: sq.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class ViewOnClickListenerC11246a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rq.a f434152d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f434153e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f434154f;

        ViewOnClickListenerC11246a(rq.a aVar, int i3, f fVar) {
            this.f434152d = aVar;
            this.f434153e = i3;
            this.f434154f = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            rq.a aVar = this.f434152d;
            if (aVar.f431891b == 13) {
                boolean z16 = !aVar.a();
                if (z16) {
                    a.this.C.add(Integer.valueOf(this.f434153e));
                    a.this.E(true);
                } else {
                    a.this.C.remove(Integer.valueOf(this.f434153e));
                    if (a.this.C.size() < 1) {
                        a.this.E(false);
                    }
                }
                this.f434152d.b(z16);
                this.f434154f.f(z16);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.this.f434151m.b();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface e {
        void b();
    }

    public a(Context context, List<rq.a> list, String str) {
        this.f434146d = context;
        this.f434149h = list;
        this.f434150i = str;
        this.E = ((int) (LightDeviceUtils.getScreenWidth(context) * 0.44f)) + 1;
        List<rq.a> list2 = this.f434149h;
        if (list2 == null || list2.size() == 0) {
            return;
        }
        this.f434149h.get(0).b(true);
        this.C.add(0);
    }

    private void B(ImageView imageView, String str, int i3) {
        SoftReference<com.tencent.aelight.camera.ae.gif.giftext.view.a> softReference = this.G.get(str);
        com.tencent.aelight.camera.ae.gif.giftext.view.a aVar = softReference != null ? softReference.get() : null;
        if (aVar == null) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles.length > 0) {
                        for (int i16 = 0; i16 < listFiles.length; i16++) {
                            String format = String.format(str + "/frame_%03d.png", Integer.valueOf(i16));
                            if (new File(format).exists()) {
                                arrayList.add(format);
                            }
                        }
                    }
                }
            }
            com.tencent.aelight.camera.ae.gif.giftext.view.a aVar2 = new com.tencent.aelight.camera.ae.gif.giftext.view.a(this.f434146d, arrayList, 55L);
            aVar2.p(false);
            this.G.put(str, new SoftReference<>(aVar2));
            aVar = aVar2;
        }
        if (QLog.isColorLevel()) {
            QLog.d("zswp20pro", 2, "playAnimationDrawable, position = " + i3);
        }
        if (imageView.getDrawable() != null && imageView.getDrawable() != aVar && (imageView.getDrawable() instanceof com.tencent.aelight.camera.ae.gif.giftext.view.a)) {
            ((com.tencent.aelight.camera.ae.gif.giftext.view.a) imageView.getDrawable()).stop();
            imageView.setImageDrawable(null);
        }
        imageView.setImageDrawable(aVar);
        aVar.start();
    }

    private void D(AEGIFOutlineTextView aEGIFOutlineTextView) {
        com.tencent.aelight.camera.ae.gif.giftext.viewmodel.b bVar = this.f434147e;
        if (bVar != null) {
            bVar.N1().observe(this.f434148f, new b(aEGIFOutlineTextView));
            this.f434147e.O1().observe(this.f434148f, new c(aEGIFOutlineTextView));
        }
        aEGIFOutlineTextView.setOnClickListener(new d());
        aEGIFOutlineTextView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z16) {
        View view = this.D;
        if (view != null) {
            view.setEnabled(z16);
            if (z16) {
                ((TextView) this.D).setText(HardCodeUtil.qqStr(R.string.f171560j72));
            } else {
                ((TextView) this.D).setText(HardCodeUtil.qqStr(R.string.j7b));
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(f fVar) {
        super.onViewRecycled(fVar);
        if (fVar.f434162e == null || fVar.f434162e.getDrawable() == null || !(fVar.f434162e.getDrawable() instanceof com.tencent.aelight.camera.ae.gif.giftext.view.a)) {
            return;
        }
        ((com.tencent.aelight.camera.ae.gif.giftext.view.a) fVar.f434162e.getDrawable()).stop();
        fVar.f434162e.setImageDrawable(null);
    }

    public void C(e eVar) {
        this.f434151m = eVar;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f434149h.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void v(View view) {
        this.D = view;
    }

    public void w(com.tencent.aelight.camera.ae.gif.giftext.viewmodel.b bVar, LifecycleOwner lifecycleOwner) {
        this.f434147e = bVar;
        this.f434148f = lifecycleOwner;
    }

    public Set<Integer> x() {
        return this.C;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(f fVar, int i3) {
        rq.a aVar = this.f434149h.get(i3);
        fVar.f434163f.setImageDrawable(VasApngUtil.getApngURLDrawable("https://qd.myapp.com/myapp/qqteam/QIM/ae_gif_loading.png", new int[]{0}, this.f434146d.getResources().getDrawable(R.drawable.f159998iy2)));
        fVar.f434164h.setVisibility(4);
        fVar.f(aVar.a());
        switch (aVar.f431891b) {
            case 10:
            case 11:
            case 12:
                fVar.f434161d.setVisibility(4);
                fVar.f434163f.setVisibility(0);
                break;
            case 13:
                fVar.f434163f.setVisibility(8);
                if (i3 == 0) {
                    D(fVar.f434164h);
                    fVar.f434164h.setVisibility(0);
                }
                fVar.f434161d.setVisibility(0);
                if (this.C.contains(Integer.valueOf(i3))) {
                    fVar.f(true);
                    E(true);
                } else {
                    fVar.f(false);
                }
                B(fVar.f434162e, aVar.f431896g, i3);
                break;
        }
        ViewGroup.LayoutParams layoutParams = fVar.itemView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = this.E;
        fVar.itemView.setLayoutParams(layoutParams);
        fVar.itemView.setOnClickListener(new ViewOnClickListenerC11246a(aVar, i3, fVar));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public f onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new f(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f167503do2, viewGroup, false), this.f434150i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class b implements Observer<c.a> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AEGIFOutlineTextView f434156d;

        b(AEGIFOutlineTextView aEGIFOutlineTextView) {
            this.f434156d = aEGIFOutlineTextView;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(c.a aVar) {
            if (aVar != null) {
                this.f434156d.setTextColor(aVar.f431901a);
                this.f434156d.setOutlineColor(aVar.f431902b);
                if (aVar.f431901a.equals("#ccffffff")) {
                    this.f434156d.setShadowParam(3.0f, 0.0f, 1.0f, "#73000000");
                    this.f434156d.setShadow(true);
                    this.f434156d.setStroke(false);
                } else {
                    this.f434156d.setShadow(false);
                    this.f434156d.setStroke(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class c implements Observer<String> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AEGIFOutlineTextView f434158d;

        c(AEGIFOutlineTextView aEGIFOutlineTextView) {
            this.f434158d = aEGIFOutlineTextView;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            int i3;
            if (str == null || str.equals("")) {
                str = HardCodeUtil.qqStr(R.string.f171561j73);
            }
            ViewGroup.LayoutParams layoutParams = this.f434158d.getLayoutParams();
            if (str.indexOf(10) > 0) {
                i3 = (a.this.E * 3) / 10;
            } else {
                i3 = (a.this.E * 11) / 50;
            }
            layoutParams.height = i3;
            this.f434158d.setTextSize(x.j(a.this.f434146d, 23.0f));
            this.f434158d.setOutlineWidth(x.c(a.this.f434146d, 2.0f));
            this.f434158d.setText(str);
            this.f434158d.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class f extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        private ImageView f434161d;

        /* renamed from: e, reason: collision with root package name */
        private DrawableImageView f434162e;

        /* renamed from: f, reason: collision with root package name */
        private ImageView f434163f;

        /* renamed from: h, reason: collision with root package name */
        private AEGIFOutlineTextView f434164h;

        /* renamed from: i, reason: collision with root package name */
        private RelativeLayout f434165i;

        /* renamed from: m, reason: collision with root package name */
        ImageView f434166m;

        public f(View view, String str) {
            super(view);
            this.f434161d = (ImageView) view.findViewById(R.id.rpi);
            this.f434165i = (RelativeLayout) view.findViewById(R.id.f163782rz4);
            this.f434162e = (DrawableImageView) view.findViewById(R.id.rn7);
            this.f434163f = (ImageView) view.findViewById(R.id.rn8);
            AEGIFOutlineTextView aEGIFOutlineTextView = (AEGIFOutlineTextView) view.findViewById(R.id.rxq);
            this.f434164h = aEGIFOutlineTextView;
            aEGIFOutlineTextView.setFontId(str);
            ImageView imageView = (ImageView) view.findViewById(R.id.rvp);
            this.f434166m = imageView;
            imageView.setBackgroundResource(a.this.F ? R.drawable.ixr : R.drawable.ixq);
            this.f434162e.setBackgroundResource(a.this.F ? R.color.f9088p : R.color.f9078o);
        }

        public void f(boolean z16) {
            if (z16) {
                if (a.this.F) {
                    this.f434161d.setImageResource(R.drawable.ixn);
                    return;
                } else {
                    this.f434161d.setImageResource(R.drawable.aio_long_shot_mosaic_checked_enable);
                    return;
                }
            }
            this.f434161d.setImageResource(R.drawable.ixo);
        }
    }
}

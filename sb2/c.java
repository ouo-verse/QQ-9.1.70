package sb2;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.now.focusanchor.commonwidget.FrameAnimationView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.imageview.CircleBoarderImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends RecyclerView.Adapter<a> implements ub2.a {

    /* renamed from: d, reason: collision with root package name */
    private BaseActivity f433622d;

    /* renamed from: e, reason: collision with root package name */
    private List<vb2.c> f433623e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        CircleBoarderImageView f433624d;

        /* renamed from: e, reason: collision with root package name */
        TextView f433625e;

        /* renamed from: f, reason: collision with root package name */
        FrameAnimationView f433626f;

        public a(View view) {
            super(view);
            this.f433624d = (CircleBoarderImageView) view.findViewById(R.id.vc5);
            this.f433625e = (TextView) view.findViewById(R.id.vc6);
            this.f433626f = (FrameAnimationView) view.findViewById(R.id.vc7);
        }
    }

    public c(BaseActivity baseActivity, List<vb2.c> list) {
        this.f433622d = baseActivity;
        this.f433623e = list;
        vb2.b.c().f(this);
    }

    @Override // ub2.a
    public void g(List<vb2.c> list) {
        this.f433623e.clear();
        this.f433623e.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f433623e.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i3) {
        vb2.c cVar = this.f433623e.get(i3);
        aVar.f433625e.setText(cVar.c());
        ((IImageLoader) QRoute.api(IImageLoader.class)).displayImage(aVar.f433624d, cVar.a(), new ColorDrawable(0), new ColorDrawable(0), 80, 80, null, false);
        aVar.f433626f.setAnimationRes(R.drawable.f161156k52);
        aVar.f433626f.a();
        bc2.a.c(String.valueOf(cVar.e()));
        EventCollector.getInstance().onRecyclerBindViewHolder(aVar, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new a(View.inflate(viewGroup.getContext(), R.layout.fpi, null));
    }

    @Override // ub2.a
    public void a(int i3, String str) {
    }
}

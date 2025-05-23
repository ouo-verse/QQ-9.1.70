package vc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.util.l;
import com.qzone.widget.ExtendGridView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends BaseAdapter {
    private static final int C = ViewUtils.dpToPx(10.0f);
    private static final int D = -ViewUtils.dpToPx(6.0f);

    /* renamed from: d, reason: collision with root package name */
    private final Context f441349d;

    /* renamed from: e, reason: collision with root package name */
    private int f441350e;

    /* renamed from: f, reason: collision with root package name */
    ExtendGridView f441351f;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<String> f441352h;

    /* renamed from: i, reason: collision with root package name */
    public c f441353i;

    /* renamed from: m, reason: collision with root package name */
    View f441354m;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f441359d;

        b(int i3) {
            this.f441359d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c cVar = a.this.f441353i;
            if (cVar != null) {
                cVar.onItemDelete(this.f441359d);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface c {
        void onItemDelete(int i3);
    }

    public a(Context context, ExtendGridView extendGridView, View view) {
        this.f441351f = extendGridView;
        this.f441349d = context;
        this.f441354m = view;
    }

    private void e() {
        if (getCount() <= 0) {
            this.f441351f.setVisibility(8);
        }
        int dimensionPixelSize = this.f441349d.getResources().getDimensionPixelSize(R.dimen.f158794p3);
        int i3 = this.f441350e != 0 ? D : 0;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f441351f.getLayoutParams();
        marginLayoutParams.width = (dimensionPixelSize * getCount()) + (this.f441349d.getResources().getDimensionPixelSize(R.dimen.f158795p4) * 2);
        marginLayoutParams.setMargins(C, 0, 0, i3);
        this.f441351f.setLayoutParams(marginLayoutParams);
        this.f441351f.setNumColumns(getCount());
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i3) {
        ArrayList<String> arrayList = this.f441352h;
        if (arrayList == null || arrayList.size() <= i3) {
            return null;
        }
        return this.f441352h.get(i3);
    }

    public void b(int i3) {
        ArrayList<String> arrayList = this.f441352h;
        if (arrayList == null || arrayList.size() <= i3) {
            return;
        }
        this.f441352h.remove(i3);
        e();
        notifyDataSetChanged();
    }

    public void c(c cVar) {
        this.f441353i = cVar;
    }

    public void d(int i3, ArrayList<String> arrayList) {
        this.f441350e = i3;
        if (arrayList == null) {
            return;
        }
        this.f441352h = arrayList;
        e();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<String> arrayList = this.f441352h;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    /* compiled from: P */
    /* renamed from: vc.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11412a implements IPicLoadStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f441355d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f441356e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Option f441357f;

        C11412a(ImageView imageView, String str, Option option) {
            this.f441355d = imageView;
            this.f441356e = str;
            this.f441357f = option;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState == null || !loadState.isFinishSuccess()) {
                return;
            }
            QLog.i("QZoneCommentImageTipsAdapter", 2, "[bindImage] success ");
            this.f441355d.setTag(this.f441356e);
            if (this.f441357f.getAnimatable() != null) {
                this.f441357f.getAnimatable().stop();
            }
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View inflate = view == null ? LayoutInflater.from(this.f441349d).inflate(R.layout.f1294766, (ViewGroup) null) : view;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.mss);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.msq);
        int dimensionPixelSize = this.f441349d.getResources().getDimensionPixelSize(R.dimen.f158794p3);
        int dimensionPixelSize2 = this.f441349d.getResources().getDimensionPixelSize(R.dimen.f158793p2);
        imageView.setTag(null);
        String item = getItem(i3);
        if (item != null) {
            Option requestHeight = Option.obtain().setUrl(item).setTargetView(imageView).setRequestWidth(dimensionPixelSize).setRequestHeight(dimensionPixelSize2);
            com.tencent.mobileqq.qzone.picload.c.a().i(requestHeight, new C11412a(imageView, item, requestHeight));
        }
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) inflate.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
        }
        inflate.setLayoutParams(layoutParams);
        frameLayout.setOnClickListener(new b(i3));
        imageView.setContentDescription(l.a(R.string.m5q) + (i3 + 1));
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return inflate;
    }
}

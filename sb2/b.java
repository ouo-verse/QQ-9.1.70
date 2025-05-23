package sb2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.imageview.CircleBoarderImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qb2.d;
import tb2.a;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends d {
    private long C;
    private final int D;

    /* renamed from: e, reason: collision with root package name */
    public CircleBoarderImageView f433614e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f433615f;

    /* renamed from: h, reason: collision with root package name */
    public TextView f433616h;

    /* renamed from: i, reason: collision with root package name */
    public RecyclerView f433617i;

    /* renamed from: m, reason: collision with root package name */
    public View f433618m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (System.currentTimeMillis() >= b.this.C + 1000) {
                b.this.C = System.currentTimeMillis();
                Intent intent = new Intent(view.getContext(), (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", qb2.a.a());
                intent.putExtra("hide_more_button", true);
                intent.addFlags(536870912);
                view.getContext().startActivity(intent);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b(View view) {
        super(view);
        int i3;
        this.D = 1000;
        this.f433614e = (CircleBoarderImageView) view.findViewById(R.id.f164551a35);
        this.f433615f = (TextView) view.findViewById(R.id.tv_name);
        this.f433616h = (TextView) view.findViewById(R.id.f108046c2);
        this.f433617i = (RecyclerView) view.findViewById(R.id.vc8);
        this.f433618m = view.findViewById(R.id.yn5);
        if (view.getContext() != null) {
            i3 = view.getContext().getResources().getDimensionPixelSize(R.dimen.dbu);
        } else {
            i3 = -1;
        }
        this.f433617i.addItemDecoration(new dc2.a(i3 <= 0 ? 25 : i3));
        this.f433618m.setOnClickListener(new a());
        if (view.getContext() instanceof Activity) {
            Activity activity = (Activity) view.getContext();
            this.f433617i.addOnItemTouchListener(new tb2.a(activity, new C11220b(activity)));
        }
    }

    /* compiled from: P */
    /* renamed from: sb2.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C11220b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f433620a;

        C11220b(Activity activity) {
            this.f433620a = activity;
        }

        @Override // tb2.a.b
        public void onItemClick(View view, int i3) {
            vb2.c cVar = vb2.b.c().b().get(i3);
            cc2.a.b(this.f433620a, cVar.b(), cVar.d(), "", "", "");
            bc2.a.b(String.valueOf(cVar.e()), i3);
        }

        @Override // tb2.a.b
        public void a(View view, int i3) {
        }
    }
}

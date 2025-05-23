package uc2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.model.i;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import uc2.a;
import uc2.c;
import uc2.f;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f extends uc2.c<i, c> {
    private final int E;
    private final int F;
    private final int G;
    private final int H;
    private ValueAnimator I;
    private b J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f438786d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f438787e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f438788f;

        a(c cVar, int i3, i iVar) {
            this.f438786d = cVar;
            this.f438787e = i3;
            this.f438788f = iVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewUtils.updateLPHeight(this.f438786d.itemView, this.f438787e);
            f.this.I = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ViewUtils.updateLPHeight(this.f438786d.G, this.f438787e - f.this.H);
            i iVar = this.f438788f;
            iVar.f256030c = iVar.f256031d;
            this.f438786d.H.k0(iVar.f256029b);
            this.f438786d.H.w0(this.f438788f.f256031d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void a(com.tencent.mobileqq.onlinestatus.model.d dVar, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class c extends c.a<i> {
        ImageView E;
        TextView F;
        RecyclerView G;
        uc2.a H;

        public c(@NonNull View view) {
            super(view);
            this.E = (ImageView) view.findViewById(R.id.y9g);
            this.F = (TextView) view.findViewById(R.id.f111526lg);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f7918493);
            this.G = recyclerView;
            uc2.a aVar = new uc2.a(recyclerView.getContext());
            this.H = aVar;
            this.G.setAdapter(aVar);
            RecyclerView recyclerView2 = this.G;
            recyclerView2.setLayoutManager(new GridLayoutManager(recyclerView2.getContext(), 5));
        }
    }

    public f(Context context) {
        super(context);
        this.E = ViewUtils.dpToPx(18.0f);
        this.F = ViewUtils.dpToPx(147.0f);
        this.H = ViewUtils.dpToPx(52.0f);
        this.G = ViewUtils.dpToPx(81.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(c cVar, i iVar, View view, int i3) {
        uc2.a aVar = cVar.H;
        if (aVar == null) {
            return;
        }
        if (aVar.t0(i3)) {
            x0(cVar, iVar);
            return;
        }
        if (OnlineStatusToggleUtils.n()) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = cVar.G.findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition instanceof a.C11337a) {
                ((a.C11337a) findViewHolderForAdapterPosition).I.setVisibility(8);
            }
        }
        y0(cVar, cVar.H.getItem(i3), iVar.f256032e + i3);
    }

    private void x0(final c cVar, i iVar) {
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusFriendListCardRvAdapter", 2, "doExpandAnim: item: " + ((Object) cVar.F.getText()));
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        int height = cVar.itemView.getHeight();
        int i3 = (((iVar.f256031d - 1) / 5) * this.G) + this.F;
        ValueAnimator ofInt = ValueAnimator.ofInt(height, i3);
        this.I = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: uc2.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                f.z0(f.c.this, valueAnimator2);
            }
        });
        this.I.setDuration(500L);
        this.I.addListener(new a(cVar, i3, iVar));
        this.I.start();
    }

    private void y0(c cVar, com.tencent.mobileqq.onlinestatus.model.d dVar, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusFriendListCardRvAdapter", 2, "doShowDetailDialog: item: " + ((Object) cVar.F.getText()) + ", click: " + dVar.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().m() + ", flatIndex: " + i3);
        }
        b bVar = this.J;
        if (bVar != null) {
            bVar.a(dVar, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z0(c cVar, ValueAnimator valueAnimator) {
        ViewUtils.updateLPHeight(cVar.itemView, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    @Override // uc2.c
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public void o0(final c cVar, int i3) {
        final i item;
        au auVar;
        if (cVar != null && (item = getItem(i3)) != null && item.f256029b != null && (auVar = item.f256028a) != null && item.f256031d != 0) {
            String str = auVar.f255490c;
            TextView textView = cVar.F;
            textView.setText(textView.getResources().getString(R.string.f201454uu, str, Integer.valueOf(item.f256029b.size())));
            if (af.C().e0(item.f256028a)) {
                cVar.E.setImageDrawable(cVar.E.getResources().getDrawable(R.drawable.n4w));
            } else {
                cVar.E.setImageDrawable(bs.I(item.f256028a, this.E, false));
            }
            ViewGroup.LayoutParams layoutParams = cVar.itemView.getLayoutParams();
            layoutParams.height = (((item.f256030c - 1) / 5) * this.G) + this.F;
            cVar.itemView.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = cVar.G.getLayoutParams();
            layoutParams2.height = layoutParams.height - this.H;
            cVar.G.setLayoutParams(layoutParams2);
            cVar.H.k0(item.f256029b.subList(0, item.f256030c));
            cVar.H.w0(item.f256030c);
            cVar.H.x0(item.f256031d);
            cVar.H.s0(new c.b() { // from class: uc2.d
                @Override // uc2.c.b
                public final void onItemClick(View view, int i16) {
                    f.this.A0(cVar, item, view, i16);
                }
            });
        }
    }

    @Override // uc2.c
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public c q0(ViewGroup viewGroup, int i3) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fde, viewGroup, false));
    }

    public void D0(b bVar) {
        this.J = bVar;
    }

    @Override // uc2.c
    public int m0(int i3) {
        return 0;
    }
}

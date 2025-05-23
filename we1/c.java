package we1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends we1.a {

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<RecyclerView.ViewHolder> f445500c;

    /* renamed from: d, reason: collision with root package name */
    private long f445501d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f445502d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f445503e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f445504f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f445505h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f445506i;

        a(int i3, View view, int i16, ViewPropertyAnimator viewPropertyAnimator, RecyclerView.ViewHolder viewHolder) {
            this.f445502d = i3;
            this.f445503e = view;
            this.f445504f = i16;
            this.f445505h = viewPropertyAnimator;
            this.f445506i = viewHolder;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f445502d != 0) {
                this.f445503e.setTranslationX(0.0f);
            }
            if (this.f445504f != 0) {
                this.f445503e.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f445505h.setListener(null);
            this.f445505h.setUpdateListener(null);
            c.this.f445500c.remove(this.f445506i);
            c.this.f445497a.b();
            c.this.f445497a.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d(RecyclerView.ViewHolder viewHolder);

        boolean e(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18);

        void f(RecyclerView.ViewHolder viewHolder, boolean z16);

        void g(RecyclerView.ViewHolder viewHolder, boolean z16);
    }

    public c(TimeInterpolator timeInterpolator, b bVar) {
        super(timeInterpolator, bVar);
        this.f445500c = new ArrayList<>();
    }

    private void j(GuildChannelListAnim.g gVar) {
        this.f445497a.a();
    }

    private void k(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
        View view = viewHolder.itemView;
        int i19 = i17 - i3;
        int i26 = i18 - i16;
        if (i19 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i26 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f445500c.add(viewHolder);
        animate.setInterpolator(this.f445498b);
        animate.setDuration(this.f445501d);
        if (QLog.isColorLevel()) {
            QLog.i("Guild.MF.Rt.Anim.GuildChannelListChangeAnimationRunner", 1, "moveImpl withChang finalY:" + i18);
        }
        animate.setUpdateListener(l());
        animate.setListener(new a(i19, view, i26, animate, viewHolder)).start();
    }

    @NonNull
    private ValueAnimator.AnimatorUpdateListener l() {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: we1.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.m(valueAnimator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(ValueAnimator valueAnimator) {
        this.f445497a.c();
    }

    @Override // we1.a
    @Nullable
    public GuildChannelListAnim.g a(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        if (!(itemHolderInfo instanceof GuildChannelListAnim.f)) {
            return null;
        }
        GuildChannelListAnim.f fVar = (GuildChannelListAnim.f) itemHolderInfo;
        if (!fVar.f214302b && !fVar.f214301a) {
            return null;
        }
        return new GuildChannelListAnim.g(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2);
    }

    @Override // we1.a
    public boolean b(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i3, int i16, int i17, int i18, ArrayList<GuildChannelListAnim.e> arrayList, ArrayList<GuildChannelListAnim.g> arrayList2) {
        if (!arrayList2.isEmpty()) {
            for (int i19 = 0; i19 < arrayList2.size(); i19++) {
                GuildChannelListAnim.g gVar = arrayList2.get(i19);
                RecyclerView.ViewHolder viewHolder3 = gVar.f214303a;
                if (viewHolder == viewHolder3 && viewHolder2 == gVar.f214304b) {
                    if (viewHolder != viewHolder2) {
                        viewHolder3.itemView.setAlpha(0.0f);
                    }
                    View view = viewHolder2.itemView;
                    int translationX = i3 + ((int) view.getTranslationX());
                    int translationY = i16 + ((int) viewHolder2.itemView.getTranslationY());
                    int i26 = i18 - translationY;
                    if (i17 - translationX != 0) {
                        view.setTranslationX(-r4);
                    }
                    if (i26 != 0) {
                        view.setTranslationY(-i26);
                    }
                    gVar.f214308f = i18;
                    gVar.f214307e = translationY;
                    gVar.f214309g = translationX;
                    gVar.f214310h = i17;
                    return true;
                }
            }
        }
        if (viewHolder == viewHolder2) {
            return this.f445497a.e(viewHolder, i3, i16, i17, i18);
        }
        float translationX2 = viewHolder.itemView.getTranslationX();
        float translationY2 = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        this.f445497a.d(viewHolder);
        int i27 = (int) ((i17 - i3) - translationX2);
        int i28 = (int) ((i18 - i16) - translationY2);
        viewHolder.itemView.setTranslationX(translationX2);
        viewHolder.itemView.setTranslationY(translationY2);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            this.f445497a.d(viewHolder2);
            viewHolder2.itemView.setTranslationX(-i27);
            viewHolder2.itemView.setTranslationY(-i28);
            viewHolder2.itemView.setAlpha(0.0f);
        }
        arrayList.add(new GuildChannelListAnim.e(viewHolder, viewHolder2, i3, i16, i17, i18));
        return true;
    }

    @Override // we1.a
    public void c(GuildChannelListAnim.g gVar, long j3) {
        this.f445501d = j3;
        j(gVar);
        int i3 = gVar.f214308f;
        int i16 = gVar.f214307e;
        if (i3 != i16) {
            k(gVar.f214304b, gVar.f214309g, i16, gVar.f214310h, i3);
        } else {
            this.f445497a.a();
        }
    }

    @Override // we1.a
    public void d(RecyclerView.ViewHolder viewHolder) {
        if (!this.f445500c.remove(viewHolder)) {
        } else {
            throw new IllegalStateException("after animation is cancelled, item should not be in mMoveAnimations list");
        }
    }

    @Override // we1.a
    public void e(RecyclerView.ViewHolder viewHolder) {
        if (this.f445500c.remove(viewHolder)) {
            viewHolder.itemView.animate().cancel();
        }
    }

    @Override // we1.a
    public void f() {
        for (int size = this.f445500c.size() - 1; size >= 0; size--) {
            this.f445500c.get(size).itemView.animate().cancel();
        }
    }

    @Override // we1.a
    public boolean g() {
        return !this.f445500c.isEmpty();
    }
}

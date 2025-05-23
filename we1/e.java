package we1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.aio.input.at.trooptag.dialogui.delegate.HashTagGroupAdapterDelegate;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim;
import com.tencent.qphone.base.util.QLog;
import cp0.HashTagGroupData;
import java.util.ArrayList;
import we1.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e extends we1.a {

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<RecyclerView.ViewHolder> f445509c;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<HashTagGroupAdapterDelegate.b> f445510d;

    /* renamed from: e, reason: collision with root package name */
    private long f445511e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GuildChannelListAnim.g f445512d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HashTagGroupAdapterDelegate.b f445513e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f445514f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f445515h;

        a(GuildChannelListAnim.g gVar, HashTagGroupAdapterDelegate.b bVar, ViewPropertyAnimator viewPropertyAnimator, int i3) {
            this.f445512d = gVar;
            this.f445513e = bVar;
            this.f445514f = viewPropertyAnimator;
            this.f445515h = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f445512d.f214303a.itemView.setAlpha(1.0f);
            e.this.f445497a.g(this.f445512d.f214303a, true);
            this.f445513e.getCollapseIcon().setTag(null);
            this.f445514f.setListener(null);
            ViewCompat.setRotation(this.f445513e.getCollapseIcon(), this.f445515h);
            e.this.f445510d.remove(this.f445513e);
            RecyclerView.ViewHolder viewHolder = this.f445512d.f214303a;
            HashTagGroupAdapterDelegate.b bVar = this.f445513e;
            if (viewHolder != bVar) {
                e.this.f445497a.g(bVar, false);
            }
            e.this.f445497a.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f445513e.getCollapseIcon().setTag(Boolean.TRUE);
            e.this.f445497a.f(this.f445513e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f445517d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f445518e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f445519f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f445520h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f445521i;

        b(int i3, View view, int i16, ViewPropertyAnimator viewPropertyAnimator, RecyclerView.ViewHolder viewHolder) {
            this.f445517d = i3;
            this.f445518e = view;
            this.f445519f = i16;
            this.f445520h = viewPropertyAnimator;
            this.f445521i = viewHolder;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f445517d != 0) {
                this.f445518e.setTranslationX(0.0f);
            }
            if (this.f445519f != 0) {
                this.f445518e.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f445520h.setListener(null);
            this.f445520h.setUpdateListener(null);
            e.this.f445509c.remove(this.f445521i);
            e.this.f445497a.b();
            e.this.f445497a.a();
        }
    }

    public e(TimeInterpolator timeInterpolator, c.b bVar) {
        super(timeInterpolator, bVar);
        this.f445509c = new ArrayList<>();
        this.f445510d = new ArrayList<>();
    }

    private void k(GuildChannelListAnim.g gVar) {
        boolean z16;
        boolean z17;
        RecyclerView.ViewHolder viewHolder = gVar.f214304b;
        if (!(viewHolder instanceof HashTagGroupAdapterDelegate.b)) {
            this.f445497a.a();
            return;
        }
        Object tag = ((HashTagGroupAdapterDelegate.b) viewHolder).itemView.getTag(R.id.wht);
        if (tag instanceof HashTagGroupData) {
            z16 = ((HashTagGroupData) tag).getIsCollapse();
            z17 = true;
        } else {
            z16 = false;
            z17 = false;
        }
        if (!z17) {
            QLog.e("Guild.MF.Rt.Anim.GuildFeedGroupListChangeAnimationRunner", 2, "animateChangeImpl channelGroup is null");
            gVar.f214304b.itemView.setTranslationY(0.0f);
            gVar.f214303a.itemView.setAlpha(1.0f);
            this.f445497a.g(gVar.f214304b, false);
            RecyclerView.ViewHolder viewHolder2 = gVar.f214303a;
            if (viewHolder2 != gVar.f214304b) {
                this.f445497a.g(viewHolder2, true);
            }
            this.f445497a.a();
            return;
        }
        l(gVar, z16);
        this.f445497a.a();
    }

    private void l(GuildChannelListAnim.g gVar, boolean z16) {
        int i3;
        int i16;
        RecyclerView.ViewHolder viewHolder = gVar.f214304b;
        if (!(viewHolder instanceof HashTagGroupAdapterDelegate.b)) {
            this.f445497a.a();
            return;
        }
        HashTagGroupAdapterDelegate.b bVar = (HashTagGroupAdapterDelegate.b) viewHolder;
        ViewPropertyAnimator animate = bVar.getCollapseIcon().animate();
        if (z16) {
            i3 = 0;
        } else {
            i3 = -90;
        }
        if (z16) {
            i16 = -90;
        } else {
            i16 = 0;
        }
        this.f445510d.add(bVar);
        bVar.getCollapseIcon().setRotation(i3);
        animate.setDuration(this.f445511e).rotation(i16).setListener(new a(gVar, bVar, animate, i16)).start();
    }

    private void m(RecyclerView.ViewHolder viewHolder, int i3, int i16, int i17, int i18) {
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
        this.f445509c.add(viewHolder);
        animate.setInterpolator(this.f445498b);
        animate.setDuration(this.f445511e);
        if (QLog.isColorLevel()) {
            QLog.i("Guild.MF.Rt.Anim.GuildFeedGroupListChangeAnimationRunner", 1, "moveImpl withChang finalY:" + i18);
        }
        animate.setUpdateListener(n());
        animate.setListener(new b(i19, view, i26, animate, viewHolder)).start();
    }

    @NonNull
    private ValueAnimator.AnimatorUpdateListener n() {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: we1.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.o(valueAnimator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(ValueAnimator valueAnimator) {
        this.f445497a.c();
    }

    @Override // we1.a
    @Nullable
    public GuildChannelListAnim.g a(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        if (!(itemHolderInfo instanceof GuildChannelListAnim.f) || !(viewHolder instanceof HashTagGroupAdapterDelegate.b) || !(viewHolder2 instanceof HashTagGroupAdapterDelegate.b)) {
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
                        view.setTranslationX(-r5);
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
            try {
                return this.f445497a.e(viewHolder, i3, i16, i17, i18);
            } catch (Throwable th5) {
                QLog.e("Guild.MF.Rt.Anim.GuildFeedGroupListChangeAnimationRunner", 1, "mCallback.onAnimateMove error!", th5);
            }
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
        this.f445511e = j3;
        k(gVar);
        int i3 = gVar.f214308f;
        int i16 = gVar.f214307e;
        if (i3 != i16) {
            m(gVar.f214304b, gVar.f214309g, i16, gVar.f214310h, i3);
        } else {
            this.f445497a.a();
        }
    }

    @Override // we1.a
    public void d(RecyclerView.ViewHolder viewHolder) {
        if (!this.f445510d.remove(viewHolder)) {
            if (!this.f445509c.remove(viewHolder)) {
                return;
            } else {
                throw new IllegalStateException("after animation is cancelled, item should not be in mMoveAnimations list");
            }
        }
        throw new IllegalStateException("after animation is cancelled, item should not be in mGroupArrowIconAnimations list");
    }

    @Override // we1.a
    public void e(RecyclerView.ViewHolder viewHolder) {
        if (this.f445509c.remove(viewHolder)) {
            viewHolder.itemView.animate().cancel();
        }
        if (viewHolder instanceof HashTagGroupAdapterDelegate.b) {
            HashTagGroupAdapterDelegate.b bVar = (HashTagGroupAdapterDelegate.b) viewHolder;
            if (this.f445510d.remove(bVar)) {
                bVar.getCollapseIcon().animate().cancel();
            }
        }
    }

    @Override // we1.a
    public void f() {
        for (int size = this.f445510d.size() - 1; size >= 0; size--) {
            this.f445510d.get(size).getCollapseIcon().animate().cancel();
        }
        for (int size2 = this.f445509c.size() - 1; size2 >= 0; size2--) {
            this.f445509c.get(size2).itemView.animate().cancel();
        }
    }

    @Override // we1.a
    public boolean g() {
        if (this.f445510d.isEmpty() && this.f445509c.isEmpty()) {
            return false;
        }
        return true;
    }
}

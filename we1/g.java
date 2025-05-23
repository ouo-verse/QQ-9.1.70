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
import com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim;
import com.tencent.mobileqq.guild.profile.myguild.GroupData;
import com.tencent.mobileqq.guild.profile.myguild.adapterDelegate.GroupAdapterDelegate;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import we1.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g extends we1.a {

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<RecyclerView.ViewHolder> f445524c;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<GroupAdapterDelegate.a> f445525d;

    /* renamed from: e, reason: collision with root package name */
    private long f445526e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GuildChannelListAnim.g f445527d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GroupAdapterDelegate.a f445528e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f445529f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f445530h;

        a(GuildChannelListAnim.g gVar, GroupAdapterDelegate.a aVar, ViewPropertyAnimator viewPropertyAnimator, int i3) {
            this.f445527d = gVar;
            this.f445528e = aVar;
            this.f445529f = viewPropertyAnimator;
            this.f445530h = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f445527d.f214303a.itemView.setAlpha(1.0f);
            g.this.f445497a.g(this.f445527d.f214303a, true);
            this.f445528e.getCollapseIcon().setTag(null);
            this.f445529f.setListener(null);
            ViewCompat.setRotation(this.f445528e.getCollapseIcon(), this.f445530h);
            g.this.f445525d.remove(this.f445528e);
            RecyclerView.ViewHolder viewHolder = this.f445527d.f214303a;
            GroupAdapterDelegate.a aVar = this.f445528e;
            if (viewHolder != aVar) {
                g.this.f445497a.g(aVar, false);
            }
            g.this.f445497a.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f445528e.getCollapseIcon().setTag(Boolean.TRUE);
            g.this.f445497a.f(this.f445528e, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f445532d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f445533e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f445534f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f445535h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f445536i;

        b(int i3, View view, int i16, ViewPropertyAnimator viewPropertyAnimator, RecyclerView.ViewHolder viewHolder) {
            this.f445532d = i3;
            this.f445533e = view;
            this.f445534f = i16;
            this.f445535h = viewPropertyAnimator;
            this.f445536i = viewHolder;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f445532d != 0) {
                this.f445533e.setTranslationX(0.0f);
            }
            if (this.f445534f != 0) {
                this.f445533e.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f445535h.setListener(null);
            this.f445535h.setUpdateListener(null);
            g.this.f445524c.remove(this.f445536i);
            g.this.f445497a.b();
            g.this.f445497a.a();
        }
    }

    public g(TimeInterpolator timeInterpolator, c.b bVar) {
        super(timeInterpolator, bVar);
        this.f445524c = new ArrayList<>();
        this.f445525d = new ArrayList<>();
    }

    private void k(GuildChannelListAnim.g gVar) {
        boolean z16;
        boolean z17;
        RecyclerView.ViewHolder viewHolder = gVar.f214304b;
        if (!(viewHolder instanceof GroupAdapterDelegate.a)) {
            this.f445497a.a();
            return;
        }
        Object tag = ((GroupAdapterDelegate.a) viewHolder).itemView.getTag();
        if (tag instanceof GroupData) {
            z16 = ((GroupData) tag).getIsCollapse();
            z17 = true;
        } else {
            z16 = false;
            z17 = false;
        }
        if (!z17) {
            QLog.e("Guild.MF.Rt.Anim.GuildGuildListChangeAnimationRunner", 2, "animateChangeImpl channelGroup is null");
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
        if (!(viewHolder instanceof GroupAdapterDelegate.a)) {
            this.f445497a.a();
            return;
        }
        GroupAdapterDelegate.a aVar = (GroupAdapterDelegate.a) viewHolder;
        ViewPropertyAnimator animate = aVar.getCollapseIcon().animate();
        if (z16) {
            i3 = 90;
        } else {
            i3 = 0;
        }
        if (z16) {
            i16 = 0;
        } else {
            i16 = 90;
        }
        this.f445525d.add(aVar);
        aVar.getCollapseIcon().setRotation(i3);
        animate.setDuration(this.f445526e).rotation(i16).setListener(new a(gVar, aVar, animate, i16)).start();
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
        this.f445524c.add(viewHolder);
        animate.setInterpolator(this.f445498b);
        animate.setDuration(this.f445526e);
        if (QLog.isColorLevel()) {
            QLog.i("Guild.MF.Rt.Anim.GuildGuildListChangeAnimationRunner", 1, "moveImpl withChang finalY:" + i18);
        }
        animate.setUpdateListener(n());
        animate.setListener(new b(i19, view, i26, animate, viewHolder)).start();
    }

    @NonNull
    private ValueAnimator.AnimatorUpdateListener n() {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: we1.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                g.this.o(valueAnimator);
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
        if (!(itemHolderInfo instanceof GuildChannelListAnim.f) || !(viewHolder instanceof GroupAdapterDelegate.a) || !(viewHolder2 instanceof GroupAdapterDelegate.a)) {
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
        this.f445526e = j3;
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
        if (!this.f445525d.remove(viewHolder)) {
            if (!this.f445524c.remove(viewHolder)) {
                return;
            } else {
                throw new IllegalStateException("after animation is cancelled, item should not be in mMoveAnimations list");
            }
        }
        throw new IllegalStateException("after animation is cancelled, item should not be in mGroupArrowIconAnimations list");
    }

    @Override // we1.a
    public void e(RecyclerView.ViewHolder viewHolder) {
        if (this.f445524c.remove(viewHolder)) {
            viewHolder.itemView.animate().cancel();
        }
        if (viewHolder instanceof GroupAdapterDelegate.a) {
            GroupAdapterDelegate.a aVar = (GroupAdapterDelegate.a) viewHolder;
            if (this.f445525d.remove(aVar)) {
                aVar.getCollapseIcon().animate().cancel();
            }
        }
    }

    @Override // we1.a
    public void f() {
        for (int size = this.f445525d.size() - 1; size >= 0; size--) {
            this.f445525d.get(size).getCollapseIcon().animate().cancel();
        }
        for (int size2 = this.f445524c.size() - 1; size2 >= 0; size2--) {
            this.f445524c.get(size2).itemView.animate().cancel();
        }
    }

    @Override // we1.a
    public boolean g() {
        if (this.f445525d.isEmpty() && this.f445524c.isEmpty()) {
            return false;
        }
        return true;
    }
}

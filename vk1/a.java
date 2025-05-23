package vk1;

import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj1.d;
import qj1.e;
import qj1.f;
import qj1.j;
import qj1.k;
import qj1.l;
import qj1.n;
import qj1.o;
import qj1.p;
import qj1.q;
import qj1.r;
import qj1.t;
import qj1.w;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\nB\u000f\u0012\u0006\u0010G\u001a\u00020F\u00a2\u0006\u0004\bH\u0010IJ\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0011\u001a\u00020\rH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0013\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u000fH\u0096\u0001J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0096\u0001J\t\u0010\u0019\u001a\u00020\rH\u0096\u0001J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0015H\u0096\u0001J\t\u0010\u001c\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0015H\u0096\u0001J\t\u0010\u001e\u001a\u00020\u0015H\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0015H\u0096\u0001J\t\u0010 \u001a\u00020\u000bH\u0096\u0001J\t\u0010!\u001a\u00020\u000bH\u0096\u0001J\t\u0010\"\u001a\u00020\rH\u0096\u0001J\t\u0010#\u001a\u00020\u0015H\u0096\u0001J\u0011\u0010&\u001a\n\u0018\u00010$j\u0004\u0018\u0001`%H\u0096\u0001J\t\u0010(\u001a\u00020'H\u0096\u0001JO\u00100\u001a\u0016\u0012\u0004\u0012\u00020'\u0012\f\u0012\n\u0018\u00010$j\u0004\u0018\u0001`/0.2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010,\u001a\u00020\u00152\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000f\u00102\u001a\b\u0012\u0004\u0012\u0002010\u0014H\u0096\u0001J\u000f\u00104\u001a\b\u0012\u0004\u0012\u0002030\u0014H\u0096\u0001J\u000f\u00106\u001a\b\u0012\u0004\u0012\u0002050\u0014H\u0096\u0001J\u000f\u00108\u001a\b\u0012\u0004\u0012\u0002070\u0014H\u0096\u0001J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u0014H\u0096\u0001R\u0014\u0010=\u001a\u00020\u00158\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020\u000b8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020\u000b8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bA\u0010?R\u0014\u0010E\u001a\u00020$8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bC\u0010D\u00a8\u0006J"}, d2 = {"Lvk1/a;", "Lvk1/b;", "Lqj1/d;", "Lqj1/j;", "Lqj1/n;", "Lqj1/b;", "Lqj1/k;", "Lqj1/p;", "Lqj1/o;", "Lqj1/f;", "Lqj1/e;", "", "getChannelId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "B", "getFeedId", "getGuildId", "K", "", "", "getFunctionList", HippyTKDListViewAdapter.X, "u", "r", "L", "getCommentCount", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "e", "getPreferStatus", "d", "getCreateTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "E", "", "Lcom/tencent/mobileqq/guild/feed/displayable/GuildFeedRichMediaData;", DomainData.DOMAIN_NAME, "Landroid/text/SpannableStringBuilder;", "v", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "hideUrlTypes", "emojiSize", "traceId", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/feed/displayable/TouchMovementMethod;", "y", "Lqj1/l;", "c", "Lqj1/t;", h.F, "Lqj1/w;", "f", "Lqj1/r;", "H", "Lqj1/q;", "b", "getFeedType", "()I", "feedType", "g", "()J", "channelTopTimestamp", "getTopTimestamp", "topTimestamp", "a", "()Ljava/lang/Object;", "raw", "Lqj1/h;", "feed", "<init>", "(Lqj1/h;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements b, d, j, n, qj1.b, k, p, o, f, e {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ qj1.h f441752a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ qj1.h f441753b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ qj1.h f441754c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ qj1.h f441755d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ qj1.h f441756e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ qj1.h f441757f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ qj1.h f441758g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ qj1.h f441759h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ qj1.h f441760i;

    public a(@NotNull qj1.h feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.f441752a = feed;
        this.f441753b = feed;
        this.f441754c = feed;
        this.f441755d = feed;
        this.f441756e = feed;
        this.f441757f = feed;
        this.f441758g = feed;
        this.f441759h = feed;
        this.f441760i = feed;
    }

    @Override // qj1.b
    public boolean A() {
        return this.f441755d.A();
    }

    @Override // qj1.c
    public boolean B() {
        return this.f441752a.B();
    }

    @Override // qj1.p
    public int E() {
        return this.f441757f.E();
    }

    @Override // qj1.e
    @NotNull
    public List<r> H() {
        return this.f441760i.H();
    }

    @Override // qj1.c
    public boolean K() {
        return this.f441752a.K();
    }

    @Override // qj1.n
    @Nullable
    public String L() {
        return this.f441754c.L();
    }

    @Override // qj1.o
    @NotNull
    public Object a() {
        return this.f441758g.a();
    }

    @Override // qj1.e
    @NotNull
    public List<q> b() {
        return this.f441760i.b();
    }

    @Override // qj1.e
    @NotNull
    public List<l> c() {
        return this.f441760i.c();
    }

    @Override // qj1.b
    public int d() {
        return this.f441755d.d();
    }

    @Override // qj1.b
    public int e() {
        return this.f441755d.e();
    }

    @Override // qj1.e
    @NotNull
    public List<w> f() {
        return this.f441760i.f();
    }

    @Override // qj1.k
    public long g() {
        return this.f441756e.g();
    }

    @Override // qj1.c
    public long getChannelId() {
        return this.f441752a.getChannelId();
    }

    @Override // qj1.b
    public int getCommentCount() {
        return this.f441755d.getCommentCount();
    }

    @Override // qj1.k
    public long getCreateTime() {
        return this.f441756e.getCreateTime();
    }

    @Override // qj1.g
    @NotNull
    public String getFeedId() {
        return this.f441752a.getFeedId();
    }

    @Override // qj1.g
    public int getFeedType() {
        return this.f441752a.getFeedType();
    }

    @Override // qj1.j
    @Nullable
    public List<Integer> getFunctionList() {
        return this.f441753b.getFunctionList();
    }

    @Override // qj1.c
    public long getGuildId() {
        return this.f441752a.getGuildId();
    }

    @Override // qj1.b
    public int getPreferStatus() {
        return this.f441755d.getPreferStatus();
    }

    @Override // qj1.k
    public long getTopTimestamp() {
        return this.f441756e.getTopTimestamp();
    }

    @Override // qj1.e
    @NotNull
    public List<t> h() {
        return this.f441760i.h();
    }

    @Override // qj1.p
    @NotNull
    public String i() {
        return this.f441757f.i();
    }

    @Override // qj1.k
    public long m() {
        return this.f441756e.m();
    }

    @Override // qj1.f
    @Nullable
    public Object n() {
        return this.f441759h.n();
    }

    @Override // qj1.c
    @Nullable
    public String q() {
        return this.f441752a.q();
    }

    @Override // qj1.n
    @NotNull
    public String r() {
        return this.f441754c.r();
    }

    @Override // qj1.n
    @Nullable
    public String u() {
        return this.f441754c.u();
    }

    @Override // qj1.e
    @NotNull
    public SpannableStringBuilder v() {
        return this.f441760i.v();
    }

    @Override // qj1.j
    public boolean x() {
        return this.f441753b.x();
    }

    @Override // qj1.e
    @NotNull
    public Pair<SpannableStringBuilder, Object> y(@Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull List<Integer> hideUrlTypes, int emojiSize, @Nullable String traceId) {
        Intrinsics.checkNotNullParameter(hideUrlTypes, "hideUrlTypes");
        return this.f441760i.y(joinInfoParam, hideUrlTypes, emojiSize, traceId);
    }
}

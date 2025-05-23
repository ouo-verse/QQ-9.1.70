package wk1;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.base.GuideBarGuildInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010\u001aJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\tR\u0014\u0010\u001f\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\tR\u0016\u0010#\u001a\u0004\u0018\u00010 8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u0004\u0018\u00010$8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lwk1/a;", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/base/GuideBarGuildInfo;", "a", "", "d", "Lwk1/n;", "j", "()Z", "isNotFromGuildHome", "", "c", "()Ljava/lang/String;", "guildId", "Lwk1/g;", "()Lwk1/g;", "guildOperationDelegate", "Landroidx/lifecycle/LifecycleOwner;", "g", "()Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "", "f", "()I", "getSourceBusinessType$annotations", "()V", "sourceBusinessType", tl.h.F, "isExperiment", "i", "isMemberSync", "", "b", "()[I", "colorConfig", "Lco1/k;", "e", "()Lco1/k;", "reportDelegate", "<init>", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a {

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f445746e = {Reflection.property1(new PropertyReference1Impl(a.class, "isNotFromGuildHome", "isNotFromGuildHome()Z", 0))};

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final n isNotFromGuildHome = new n();

    @NotNull
    public abstract Flow<GuideBarGuildInfo> a();

    @Nullable
    public abstract int[] b();

    @NotNull
    public abstract String c();

    @Nullable
    public abstract g d();

    @Nullable
    public abstract co1.k e();

    public abstract int f();

    @Nullable
    public abstract LifecycleOwner g();

    public abstract boolean h();

    public abstract boolean i();

    public final boolean j() {
        return this.isNotFromGuildHome.a(this, f445746e[0]);
    }
}

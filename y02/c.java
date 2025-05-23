package y02;

import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Ly02/c;", "", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f449220a = new c();

    c() {
    }

    @JvmStatic
    public static final boolean a() {
        boolean a16 = a.a("exp_subscribe_channel", "exp_subscribe_channel_B");
        Logger.f235387a.d().d("GuildRecentChannelHeadABTestUtils", 1, "isExperiment isExpOn: " + a16);
        a.d("exp_subscribe_channel");
        return a16;
    }
}

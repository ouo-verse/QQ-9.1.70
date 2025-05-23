package uj1;

import com.tencent.mobileqq.guild.feed.event.GuildFeedSquareFeedVideoPlayingEvent;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Luj1/a;", "", "", "a", "", "b", "", "Ljava/lang/String;", "TAG", "c", "I", "guildSquareFeedVideoPlayingPosition", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f439069a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "GuildAdVideoPlayManager";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int guildSquareFeedVideoPlayingPosition = -1;

    a() {
    }

    public final int a() {
        QLog.d(TAG, 1, "getGuildSquareFeedVideoPlayingPosition:" + guildSquareFeedVideoPlayingPosition);
        return guildSquareFeedVideoPlayingPosition;
    }

    public final void b() {
        QLog.d(TAG, 1, "resetGuildSquareFeedVideoPlaying");
        guildSquareFeedVideoPlayingPosition = -1;
        bl.c().a(new GuildFeedSquareFeedVideoPlayingEvent(false));
    }
}

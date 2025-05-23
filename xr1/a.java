package xr1;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.profile.me.aj;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.l;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.util.LinkedList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\rR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lxr1/a;", "", "", "c", "", "channelId", "d", "Lcom/tencent/common/app/AppInterface;", "b", "guildId", "", "a", "Ljava/lang/Object;", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "channelQueue", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", ITVKPlayerEventListener.KEY_USER_INFO, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static LinkedList<String> channelQueue;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f448428a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object lock = new Object();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ev userInfo = aj.l();

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Object elementAt;
        LinkedList<String> linkedList = new LinkedList<>();
        channelQueue = linkedList;
        Set<String> V = bw.V();
        int size = V.size();
        for (int i3 = 0; i3 < size; i3++) {
            elementAt = CollectionsKt___CollectionsKt.elementAt(V, i3);
            linkedList.offer(elementAt);
        }
    }

    a() {
    }

    private final AppInterface b() {
        AppInterface appInterface = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).appInterface();
        Intrinsics.checkNotNullExpressionValue(appInterface, "api(IQQGuildUtilApi::class.java).appInterface()");
        return appInterface;
    }

    private final boolean c() {
        return bw.W();
    }

    private final boolean d(String channelId) {
        IRuntimeService runtimeService = b().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "getApp().getRuntimeServi\u2026va, ProcessConstant.MAIN)");
        IGProChannelInfo channelInfo = ((IGPSService) runtimeService).getChannelInfo(channelId);
        if (channelInfo == null || channelInfo.getFinalMsgNotify() == 1) {
            return true;
        }
        return false;
    }

    public final void a(@Nullable String guildId, @Nullable String channelId) {
        Set set;
        if (!TextUtils.isEmpty(guildId) && !TextUtils.isEmpty(channelId)) {
            if (!l.f235569a.b()) {
                QLog.d("GuildNewUserChannelBehaviorCounter", 1, "addChannel| return for no needShow");
                return;
            }
            if (c()) {
                QLog.d("GuildNewUserChannelBehaviorCounter", 1, "addChannel| return for hasShow");
                return;
            }
            Intrinsics.checkNotNull(channelId);
            if (d(channelId)) {
                QLog.d("GuildNewUserChannelBehaviorCounter", 1, "addChannel| return for MsgNotify is open");
                return;
            }
            String str = guildId + "-" + channelId;
            synchronized (lock) {
                LinkedList<String> linkedList = channelQueue;
                if (linkedList != null) {
                    if (linkedList.contains(str)) {
                        linkedList.remove(str);
                        linkedList.offer(str);
                    } else {
                        if (linkedList.size() >= 3) {
                            linkedList.poll();
                        }
                        linkedList.offer(str);
                    }
                    set = CollectionsKt___CollectionsKt.toSet(linkedList);
                    bw.D1(set);
                    Unit unit = Unit.INSTANCE;
                }
            }
            return;
        }
        QLog.d("GuildNewUserChannelBehaviorCounter", 1, "addChannel| return for text is null, guildId = " + guildId + ", channelId = " + channelId);
    }
}

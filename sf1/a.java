package sf1;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.qqguildsdk.data.type.IChannelType;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lsf1/a;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final HashMap<Integer, Integer> f433762b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR0\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lsf1/a$a;", "", "", "channelType", "applicationId", "", "b", "a", "ALL_SUPPORT_STANDALONE_OPEN", "I", "CHANNEL_DETAIL_SUPPORT_STANDALONE_OPEN", "CHANNEL_SUPPORT_STANDALONE_OPEN", "GUEST_CHANNEL_SUPPORT_STANDALONE_OPEN", "GUEST_DETAIL_SUPPORT_STANDALONE_OPEN", "MASTER_CHANNEL_SUPPORT_STANDALONE_OPEN", "MASTER_DETAIL_SUPPORT_STANDALONE_OPEN", "NONE_SUPPORT_STANDALONE_OPEN", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "channelIsSupportStandaloneOpenTypes", "Ljava/util/HashMap;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    @SuppressLint({"WrongConstant"})
    /* renamed from: sf1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a(int channelType, int applicationId) {
            boolean z16 = false;
            if (a.f433762b.get(Integer.valueOf(applicationId)) != null) {
                Integer num = (Integer) a.f433762b.get(Integer.valueOf(applicationId));
                if (num != null && (num.intValue() & 1) == 0) {
                    z16 = true;
                }
                return !z16;
            }
            Integer num2 = (Integer) a.f433762b.get(Integer.valueOf(channelType));
            if (num2 != null && (num2.intValue() & 1) == 0) {
                z16 = true;
            }
            return !z16;
        }

        @JvmStatic
        public final boolean b(int channelType, int applicationId) {
            boolean z16 = false;
            if (a.f433762b.get(Integer.valueOf(applicationId)) != null) {
                Integer num = (Integer) a.f433762b.get(Integer.valueOf(applicationId));
                if (num != null && (num.intValue() & 16) == 0) {
                    z16 = true;
                }
                return !z16;
            }
            Integer num2 = (Integer) a.f433762b.get(Integer.valueOf(channelType));
            if (num2 != null && (num2.intValue() & 16) == 0) {
                z16 = true;
            }
            return !z16;
        }

        Companion() {
        }
    }

    static {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        f433762b = hashMap;
        hashMap.put(1, 17);
        Integer valueOf = Integer.valueOf(PlayerResources.RawId.BASE);
        hashMap.put(2, valueOf);
        hashMap.put(5, 17);
        hashMap.put(6, 16);
        hashMap.put(7, valueOf);
        hashMap.put(8, valueOf);
        hashMap.put(Integer.valueOf(IChannelType.APP_SUB_CHANNEL_TYPE_SCHEDULE), 16);
        hashMap.put(Integer.valueOf(IChannelType.APP_SUB_CHANNEL_TYPE_KARAOKE), 16);
        hashMap.put(Integer.valueOf(IChannelType.APP_SUB_CHANNEL_TYPE_LINK), 16);
        hashMap.put(1000001, 16);
        hashMap.put(Integer.valueOf(IChannelType.APP_SUB_CHANNEL_TYPE_GAMECENTER_QA), 16);
    }
}

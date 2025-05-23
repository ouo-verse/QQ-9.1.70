package sz1;

import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lsz1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "k", "()J", "type", "b", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "desc", "<init>", "(JLjava/lang/String;)V", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: sz1.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class JoinTimeItem {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final JoinTimeItem f435008d = new JoinTimeItem(JoinTimeType.THIRTY_MINUTES, "30\u5206\u949f");

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final JoinTimeItem f435009e = new JoinTimeItem(3600, "1\u5c0f\u65f6");

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final JoinTimeItem f435010f = new JoinTimeItem(JoinTimeType.THREE_HOUR, "3\u5c0f\u65f6");

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final JoinTimeItem f435011g = new JoinTimeItem(JoinTimeType.SIX_HOUR, "6\u5c0f\u65f6");

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final JoinTimeItem f435012h = new JoinTimeItem(43200, "12\u5c0f\u65f6");

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final JoinTimeItem f435013i = new JoinTimeItem(86400, "1\u5929");

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final JoinTimeItem f435014j = new JoinTimeItem(259200, "3\u5929");

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final JoinTimeItem f435015k = new JoinTimeItem(JoinTimeType.SEVEN_DAY, "7\u5929");

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final JoinTimeItem f435016l = new JoinTimeItem(JoinTimeType.FIFTEEN_DAY, "15\u5929");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u0017\u0010\r\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR\u0017\u0010\u000f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\nR\u0017\u0010\u0011\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0012\u0010\nR\u0017\u0010\u0013\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0015\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\nR\u0017\u0010\u0017\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\nR\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u001a\u0010\n\u00a8\u0006\u001d"}, d2 = {"Lsz1/a$a;", "", "", "type", "", "b", "Lsz1/a;", "thirtyMinutes", "Lsz1/a;", "g", "()Lsz1/a;", "anHour", "a", "threeHour", "i", "sixHour", "f", "twelveHour", "j", "oneDay", "d", "threeDay", h.F, "sevenDay", "e", "fifteenDay", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sz1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final JoinTimeItem a() {
            return JoinTimeItem.f435009e;
        }

        @JvmStatic
        @NotNull
        public final String b(long type) {
            if (type == JoinTimeType.THIRTY_MINUTES) {
                return g().getDesc();
            }
            if (type == 3600) {
                return a().getDesc();
            }
            if (type == JoinTimeType.THREE_HOUR) {
                return i().getDesc();
            }
            if (type == JoinTimeType.SIX_HOUR) {
                return f().getDesc();
            }
            if (type == 43200) {
                return j().getDesc();
            }
            if (type == 86400) {
                return d().getDesc();
            }
            if (type == 259200) {
                return h().getDesc();
            }
            if (type == JoinTimeType.SEVEN_DAY) {
                return e().getDesc();
            }
            if (type == JoinTimeType.FIFTEEN_DAY) {
                return c().getDesc();
            }
            return "";
        }

        @NotNull
        public final JoinTimeItem c() {
            return JoinTimeItem.f435016l;
        }

        @NotNull
        public final JoinTimeItem d() {
            return JoinTimeItem.f435013i;
        }

        @NotNull
        public final JoinTimeItem e() {
            return JoinTimeItem.f435015k;
        }

        @NotNull
        public final JoinTimeItem f() {
            return JoinTimeItem.f435011g;
        }

        @NotNull
        public final JoinTimeItem g() {
            return JoinTimeItem.f435008d;
        }

        @NotNull
        public final JoinTimeItem h() {
            return JoinTimeItem.f435014j;
        }

        @NotNull
        public final JoinTimeItem i() {
            return JoinTimeItem.f435010f;
        }

        @NotNull
        public final JoinTimeItem j() {
            return JoinTimeItem.f435012h;
        }

        Companion() {
        }
    }

    public JoinTimeItem(long j3, @NotNull String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.type = j3;
        this.desc = desc;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JoinTimeItem)) {
            return false;
        }
        JoinTimeItem joinTimeItem = (JoinTimeItem) other;
        if (this.type == joinTimeItem.type && Intrinsics.areEqual(this.desc, joinTimeItem.desc)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.type) * 31) + this.desc.hashCode();
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: k, reason: from getter */
    public final long getType() {
        return this.type;
    }

    @NotNull
    public String toString() {
        return "JoinTimeItem(type=" + this.type + ", desc=" + this.desc + ")";
    }
}

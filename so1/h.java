package so1;

import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b&\u0018\u0000 \r2\u00020\u0001:\u0002\u0006\u000bB%\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H&R\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u00020\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u000e\u001a\u00020\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0007\u001a\u0004\b\r\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lso1/h;", "", "other", "", "e", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "b", "channelId", "d", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ$\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0005\u00a8\u0006\n"}, d2 = {"Lso1/h$a;", "", "", "Lso1/h$b;", "list1", "list2", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: so1.h$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        protected final boolean a(@NotNull List<MicUser> list1, @NotNull List<MicUser> list2) {
            Intrinsics.checkNotNullParameter(list1, "list1");
            Intrinsics.checkNotNullParameter(list2, "list2");
            if (list1.size() != list2.size()) {
                return false;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (MicUser micUser : list1) {
                linkedHashMap.put(micUser.getTinyId(), micUser);
            }
            for (MicUser micUser2 : list2) {
                MicUser micUser3 = (MicUser) linkedHashMap.get(micUser2.getTinyId());
                if (micUser3 == null || !Intrinsics.areEqual(micUser3, micUser2)) {
                    return false;
                }
            }
            return true;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lso1/h$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tinyId", "avatarMeta", "c", "Z", "()Z", "isMicOpening", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: so1.h$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class MicUser {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String tinyId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String avatarMeta;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isMicOpening;

        public MicUser(@NotNull String tinyId, @NotNull String avatarMeta, boolean z16) {
            Intrinsics.checkNotNullParameter(tinyId, "tinyId");
            Intrinsics.checkNotNullParameter(avatarMeta, "avatarMeta");
            this.tinyId = tinyId;
            this.avatarMeta = avatarMeta;
            this.isMicOpening = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAvatarMeta() {
            return this.avatarMeta;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getTinyId() {
            return this.tinyId;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsMicOpening() {
            return this.isMicOpening;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MicUser)) {
                return false;
            }
            MicUser micUser = (MicUser) other;
            if (Intrinsics.areEqual(this.tinyId, micUser.tinyId) && Intrinsics.areEqual(this.avatarMeta, micUser.avatarMeta) && this.isMicOpening == micUser.isMicOpening) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.tinyId.hashCode() * 31) + this.avatarMeta.hashCode()) * 31;
            boolean z16 = this.isMicOpening;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "MicUser(tinyId=" + this.tinyId + ", avatarMeta=" + this.avatarMeta + ", isMicOpening=" + this.isMicOpening + ")";
        }
    }

    public h() {
        this(null, null, null, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmStatic
    public static final boolean a(@NotNull List<MicUser> list, @NotNull List<MicUser> list2) {
        return INSTANCE.a(list, list2);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public String getTitle() {
        return this.title;
    }

    public abstract boolean e(@NotNull Object other);

    public h(@NotNull String guildId, @NotNull String channelId, @NotNull String title) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(title, "title");
        this.guildId = guildId;
        this.channelId = channelId;
        this.title = title;
    }

    public /* synthetic */ h(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3);
    }
}

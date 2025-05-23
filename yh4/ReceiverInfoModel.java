package yh4;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002JE\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u00c6\u0001J\t\u0010\u0010\u001a\u00020\nH\u00d6\u0001R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0017\u0010\r\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001e\u001a\u0004\b#\u0010 R\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b\u0018\u0010 \"\u0004\b$\u0010\"\u00a8\u0006'"}, d2 = {"Lyh4/b;", "", "", "hashCode", "other", "", "equals", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "uid", "priority", "", "desc", "fake", "isCertain", "chosen", "a", "toString", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "g", "()Ltrpc/yes/common/CommonOuterClass$QQUserId;", "b", "I", "f", "()I", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "Z", "e", "()Z", "setFake", "(Z)V", h.F, "i", "<init>", "(Ltrpc/yes/common/CommonOuterClass$QQUserId;ILjava/lang/String;ZZZ)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yh4.b, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class ReceiverInfoModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final CommonOuterClass$QQUserId uid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int priority;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String desc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean fake;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isCertain;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean chosen;

    public ReceiverInfoModel(@NotNull CommonOuterClass$QQUserId uid, int i3, @NotNull String desc, boolean z16, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.uid = uid;
        this.priority = i3;
        this.desc = desc;
        this.fake = z16;
        this.isCertain = z17;
        this.chosen = z18;
    }

    public static /* synthetic */ ReceiverInfoModel b(ReceiverInfoModel receiverInfoModel, CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, String str, boolean z16, boolean z17, boolean z18, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            commonOuterClass$QQUserId = receiverInfoModel.uid;
        }
        if ((i16 & 2) != 0) {
            i3 = receiverInfoModel.priority;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            str = receiverInfoModel.desc;
        }
        String str2 = str;
        if ((i16 & 8) != 0) {
            z16 = receiverInfoModel.fake;
        }
        boolean z19 = z16;
        if ((i16 & 16) != 0) {
            z17 = receiverInfoModel.isCertain;
        }
        boolean z26 = z17;
        if ((i16 & 32) != 0) {
            z18 = receiverInfoModel.chosen;
        }
        return receiverInfoModel.a(commonOuterClass$QQUserId, i17, str2, z19, z26, z18);
    }

    @NotNull
    public final ReceiverInfoModel a(@NotNull CommonOuterClass$QQUserId uid, int priority, @NotNull String desc, boolean fake, boolean isCertain, boolean chosen) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new ReceiverInfoModel(uid, priority, desc, fake, isCertain, chosen);
    }

    /* renamed from: c, reason: from getter */
    public final boolean getChosen() {
        return this.chosen;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getFake() {
        return this.fake;
    }

    public boolean equals(@Nullable Object other) {
        return super.equals(other);
    }

    /* renamed from: f, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final CommonOuterClass$QQUserId getUid() {
        return this.uid;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsCertain() {
        return this.isCertain;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final void i(boolean z16) {
        this.chosen = z16;
    }

    @NotNull
    public String toString() {
        return "ReceiverInfoModel(uid=" + this.uid + ", priority=" + this.priority + ", desc=" + this.desc + ", fake=" + this.fake + ", isCertain=" + this.isCertain + ", chosen=" + this.chosen + ")";
    }

    public /* synthetic */ ReceiverInfoModel(CommonOuterClass$QQUserId commonOuterClass$QQUserId, int i3, String str, boolean z16, boolean z17, boolean z18, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(commonOuterClass$QQUserId, i3, str, (i16 & 8) != 0 ? false : z16, (i16 & 16) != 0 ? false : z17, (i16 & 32) != 0 ? false : z18);
    }
}

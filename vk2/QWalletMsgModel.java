package vk2;

import com.tencent.mobileqq.app.AppConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\nB+\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lvk2/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lvk2/c;", "a", "Lvk2/c;", "c", "()Lvk2/c;", "hbModel", "b", "I", "d", "()I", "messageType", "Ljava/lang/String;", "e", "()Ljava/lang/String;", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "fromHbList", "<init>", "(Lvk2/c;ILjava/lang/String;I)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vk2.d, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class QWalletMsgModel {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final ArrayList<Integer> f441802f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static ArrayList<Integer> f441803g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final QWalletHbModel hbModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int messageType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String senderUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int fromHbList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lvk2/d$a;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "MSG_TYPE_FOR_GUILD", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "setMSG_TYPE_FOR_GUILD", "(Ljava/util/ArrayList;)V", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vk2.d$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ArrayList<Integer> a() {
            return QWalletMsgModel.f441803g;
        }

        Companion() {
        }
    }

    static {
        ArrayList<Integer> arrayListOf;
        ArrayList<Integer> arrayListOf2;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(18, 17, 19, 21, 22, 26, 23, 24, 25, 27, 28, 29);
        f441802f = arrayListOf;
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(2, 3, 31);
        f441803g = arrayListOf2;
    }

    public QWalletMsgModel(@NotNull QWalletHbModel hbModel, int i3, @Nullable String str, int i16) {
        Intrinsics.checkNotNullParameter(hbModel, "hbModel");
        this.hbModel = hbModel;
        this.messageType = i3;
        this.senderUin = str;
        this.fromHbList = i16;
    }

    /* renamed from: b, reason: from getter */
    public final int getFromHbList() {
        return this.fromHbList;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final QWalletHbModel getHbModel() {
        return this.hbModel;
    }

    /* renamed from: d, reason: from getter */
    public final int getMessageType() {
        return this.messageType;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getSenderUin() {
        return this.senderUin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QWalletMsgModel)) {
            return false;
        }
        QWalletMsgModel qWalletMsgModel = (QWalletMsgModel) other;
        if (Intrinsics.areEqual(this.hbModel, qWalletMsgModel.hbModel) && this.messageType == qWalletMsgModel.messageType && Intrinsics.areEqual(this.senderUin, qWalletMsgModel.senderUin) && this.fromHbList == qWalletMsgModel.fromHbList) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.hbModel.hashCode() * 31) + this.messageType) * 31;
        String str = this.senderUin;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.fromHbList;
    }

    @NotNull
    public String toString() {
        return "QWalletMsgModel(hbModel=" + this.hbModel + ", messageType=" + this.messageType + ", senderUin=" + this.senderUin + ", fromHbList=" + this.fromHbList + ')';
    }

    public /* synthetic */ QWalletMsgModel(QWalletHbModel qWalletHbModel, int i3, String str, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(qWalletHbModel, i3, str, (i17 & 8) != 0 ? 0 : i16);
    }
}

package ry2;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\u000bR%\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lry2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "totalCount", "b", "getMessageUnreadCount", "messageUnreadCount", "c", "getOtherUnreadCount", "otherUnreadCount", "d", "getValidationMessageUnread", "validationMessageUnread", "", "e", "Ljava/util/Map;", "getMap", "()Ljava/util/Map;", "map", "<init>", "(IIIILjava/util/Map;)V", "(I)V", "qq-appbadge-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int totalCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int messageUnreadCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int otherUnreadCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int validationMessageUnread;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Map<Integer, Integer> map;

    public a(int i3, int i16, int i17, int i18, @Nullable Map<Integer, Integer> map) {
        this.totalCount = i3;
        this.messageUnreadCount = i16;
        this.otherUnreadCount = i17;
        this.validationMessageUnread = i18;
        this.map = map;
    }

    /* renamed from: a, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.totalCount == aVar.totalCount && this.messageUnreadCount == aVar.messageUnreadCount && this.otherUnreadCount == aVar.otherUnreadCount && this.validationMessageUnread == aVar.validationMessageUnread && Intrinsics.areEqual(this.map, aVar.map)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = ((((((this.totalCount * 31) + this.messageUnreadCount) * 31) + this.otherUnreadCount) * 31) + this.validationMessageUnread) * 31;
        Map<Integer, Integer> map = this.map;
        if (map == null) {
            hashCode = 0;
        } else {
            hashCode = map.hashCode();
        }
        return i3 + hashCode;
    }

    @NotNull
    public String toString() {
        StringBuilder sb5 = new StringBuilder("{\n");
        sb5.append("\t\"message_unread\": " + this.messageUnreadCount + ",\n");
        sb5.append("\t\"other_unread\": " + this.otherUnreadCount + ",\n");
        sb5.append("\t\"validation_message_unread\": " + this.validationMessageUnread + ",\n");
        Map<Integer, Integer> map = this.map;
        if (map != null) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                sb5.append("\t\"" + entry.getKey().intValue() + "\": " + entry.getValue().intValue() + ",\n");
            }
        }
        sb5.deleteCharAt(sb5.length() - 1).setLength(sb5.length() - 1);
        sb5.append('}');
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    public a(int i3) {
        this(i3, 0, 0, 0, null);
    }
}

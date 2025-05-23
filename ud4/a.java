package ud4;

import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lud4/a;", "", "", "name", "tag", "", "b", "a", "", "Z", "isEnableRecord", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lud4/a$a;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "costTimeRecordList", "<init>", "()V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static boolean isEnableRecord;

    /* renamed from: c, reason: collision with root package name */
    public static final a f438857c = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<RecordItem> costTimeRecordList = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\r\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lud4/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "b", "c", "tag", "", "J", "()J", "startTimeMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
    /* renamed from: ud4.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes26.dex */
    private static final /* data */ class RecordItem {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String name;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String tag;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long startTimeMs;

        public RecordItem(@NotNull String name, @NotNull String tag, long j3) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(tag, "tag");
            this.name = name;
            this.tag = tag;
            this.startTimeMs = j3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: b, reason: from getter */
        public final long getStartTimeMs() {
            return this.startTimeMs;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof RecordItem) {
                    RecordItem recordItem = (RecordItem) other;
                    if (!Intrinsics.areEqual(this.name, recordItem.name) || !Intrinsics.areEqual(this.tag, recordItem.tag) || this.startTimeMs != recordItem.startTimeMs) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            String str = this.name;
            int i16 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            String str2 = this.tag;
            if (str2 != null) {
                i16 = str2.hashCode();
            }
            return ((i17 + i16) * 31) + androidx.fragment.app.a.a(this.startTimeMs);
        }

        @NotNull
        public String toString() {
            return "RecordItem(name=" + this.name + ", tag=" + this.tag + ", startTimeMs=" + this.startTimeMs + ")";
        }
    }

    a() {
    }

    public final void a(@NotNull String tag) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        if (!isEnableRecord) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        CopyOnWriteArrayList<RecordItem> copyOnWriteArrayList = costTimeRecordList;
        ArrayList<RecordItem> arrayList = new ArrayList();
        for (Object obj : copyOnWriteArrayList) {
            if (Intrinsics.areEqual(((RecordItem) obj).getTag(), tag)) {
                arrayList.add(obj);
            }
        }
        for (RecordItem recordItem : arrayList) {
            Log.i("TavCutPerformance", "name:" + recordItem.getName() + ",cost:" + (currentTimeMillis - recordItem.getStartTimeMs()) + "ms");
            costTimeRecordList.remove(recordItem);
        }
    }

    public final void b(@NotNull String name, @NotNull String tag) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        if (!isEnableRecord) {
            return;
        }
        costTimeRecordList.add(new RecordItem(name, tag, System.currentTimeMillis()));
    }
}

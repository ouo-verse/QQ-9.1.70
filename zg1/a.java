package zg1;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0000H&\u00a8\u0006\u000b"}, d2 = {"Lzg1/a;", "", "", "getItemType", "", "getItemId", "newItem", "", "a", "b", "c", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f452505a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0007R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\r\u0010\u0007R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0007R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0003\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Lzg1/a$a;", "", "", "b", "I", "count", "c", "()I", "TYPE_SIMPLE_FEED", "d", "TYPE_SINGLE_IMAGE", "e", "TYPE_SINGLE_VIDEO", "f", "g", "TYPE_THIRD_PARTY_SHARED_GRAPHIC", "TYPE_SMALL_WORLD", h.F, "a", "TYPE_LONG_CONTENT", "i", "TYPE_NO_MORE", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zg1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f452505a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static int count;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_SIMPLE_FEED;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_SINGLE_IMAGE;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_SINGLE_VIDEO;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_THIRD_PARTY_SHARED_GRAPHIC;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_SMALL_WORLD;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_LONG_CONTENT;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_NO_MORE;

        static {
            int i3 = count + 1;
            TYPE_SIMPLE_FEED = i3;
            int i16 = i3 + 1;
            TYPE_SINGLE_IMAGE = i16;
            int i17 = i16 + 1;
            TYPE_SINGLE_VIDEO = i17;
            int i18 = i17 + 1;
            TYPE_THIRD_PARTY_SHARED_GRAPHIC = i18;
            int i19 = i18 + 1;
            TYPE_SMALL_WORLD = i19;
            int i26 = i19 + 1;
            TYPE_LONG_CONTENT = i26;
            int i27 = i26 + 1;
            count = i27;
            TYPE_NO_MORE = i27;
        }

        Companion() {
        }

        public final int a() {
            return TYPE_LONG_CONTENT;
        }

        public final int b() {
            return TYPE_NO_MORE;
        }

        public final int c() {
            return TYPE_SIMPLE_FEED;
        }

        public final int d() {
            return TYPE_SINGLE_IMAGE;
        }

        public final int e() {
            return TYPE_SINGLE_VIDEO;
        }

        public final int f() {
            return TYPE_SMALL_WORLD;
        }

        public final int g() {
            return TYPE_THIRD_PARTY_SHARED_GRAPHIC;
        }
    }

    boolean a(@NotNull a newItem);

    boolean b(@NotNull a newItem);

    @Nullable
    Object c(@NotNull a newItem);

    long getItemId();

    int getItemType();
}

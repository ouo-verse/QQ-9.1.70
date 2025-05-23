package zj1;

import com.tencent.mobileqq.guild.feed.feedsquare.data.h;
import ij1.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2 = {"Lzj1/a;", "", "<init>", "()V", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\n\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lzj1/a$a;", "Lzj1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "c", "()Z", "isFirstScreen", "b", "I", "()I", "oldItemCount", "", "Lij1/g;", "Ljava/util/List;", "()Ljava/util/List;", "feedList", "<init>", "(ZILjava/util/List;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zj1.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnFeedLoadCompletedMessage extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isFirstScreen;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int oldItemCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final List<g> feedList;

        /* JADX WARN: Multi-variable type inference failed */
        public OnFeedLoadCompletedMessage(boolean z16, int i3, @Nullable List<? extends g> list) {
            this.isFirstScreen = z16;
            this.oldItemCount = i3;
            this.feedList = list;
        }

        @Nullable
        public final List<g> a() {
            return this.feedList;
        }

        /* renamed from: b, reason: from getter */
        public final int getOldItemCount() {
            return this.oldItemCount;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsFirstScreen() {
            return this.isFirstScreen;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnFeedLoadCompletedMessage)) {
                return false;
            }
            OnFeedLoadCompletedMessage onFeedLoadCompletedMessage = (OnFeedLoadCompletedMessage) other;
            if (this.isFirstScreen == onFeedLoadCompletedMessage.isFirstScreen && this.oldItemCount == onFeedLoadCompletedMessage.oldItemCount && Intrinsics.areEqual(this.feedList, onFeedLoadCompletedMessage.feedList)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.isFirstScreen;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = ((r06 * 31) + this.oldItemCount) * 31;
            List<g> list = this.feedList;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            return "OnFeedLoadCompletedMessage(isFirstScreen=" + this.isFirstScreen + ", oldItemCount=" + this.oldItemCount + ", feedList=" + this.feedList + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0013\u0010\u0011R\u001f\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\n\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lzj1/a$b;", "Lzj1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "d", "()Z", "isScrolling", "b", "I", "()I", "firstVisiblePos", "c", "lastVisiblePos", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "Ljava/util/List;", "()Ljava/util/List;", "feedList", "<init>", "(ZIILjava/util/List;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zj1.a$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnFeedScrollStateChangedMessage extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isScrolling;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int firstVisiblePos;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int lastVisiblePos;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final List<h> feedList;

        /* JADX WARN: Multi-variable type inference failed */
        public OnFeedScrollStateChangedMessage(boolean z16, int i3, int i16, @Nullable List<? extends h> list) {
            this.isScrolling = z16;
            this.firstVisiblePos = i3;
            this.lastVisiblePos = i16;
            this.feedList = list;
        }

        @Nullable
        public final List<h> a() {
            return this.feedList;
        }

        /* renamed from: b, reason: from getter */
        public final int getFirstVisiblePos() {
            return this.firstVisiblePos;
        }

        /* renamed from: c, reason: from getter */
        public final int getLastVisiblePos() {
            return this.lastVisiblePos;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsScrolling() {
            return this.isScrolling;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnFeedScrollStateChangedMessage)) {
                return false;
            }
            OnFeedScrollStateChangedMessage onFeedScrollStateChangedMessage = (OnFeedScrollStateChangedMessage) other;
            if (this.isScrolling == onFeedScrollStateChangedMessage.isScrolling && this.firstVisiblePos == onFeedScrollStateChangedMessage.firstVisiblePos && this.lastVisiblePos == onFeedScrollStateChangedMessage.lastVisiblePos && Intrinsics.areEqual(this.feedList, onFeedScrollStateChangedMessage.feedList)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.isScrolling;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = ((((r06 * 31) + this.firstVisiblePos) * 31) + this.lastVisiblePos) * 31;
            List<h> list = this.feedList;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            return "OnFeedScrollStateChangedMessage(isScrolling=" + this.isScrolling + ", firstVisiblePos=" + this.firstVisiblePos + ", lastVisiblePos=" + this.lastVisiblePos + ", feedList=" + this.feedList + ")";
        }
    }
}

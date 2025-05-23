package tl1;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStLike;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b#\b\u0016\u0018\u00002\u00020\u0001: \u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006$"}, d2 = {"Ltl1/g;", "", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", h.F, "i", "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", ReportConstant.COSTREPORT_PREFIX, "t", "u", "v", "w", HippyTKDListViewAdapter.X, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "aa", "ab", ac.f283467k0, "ad", "ae", "af", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class g {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Ltl1/g$a;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", NodeProps.VISIBLE, "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ChangeCommentListVisibilityMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean visible;

        public ChangeCommentListVisibilityMessage(boolean z16) {
            this.visible = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getVisible() {
            return this.visible;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ChangeCommentListVisibilityMessage) && this.visible == ((ChangeCommentListVisibilityMessage) other).visible) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.visible;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "ChangeCommentListVisibilityMessage(visible=" + this.visible + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Ltl1/g$aa;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "callSource", "b", "I", "c", "()I", "vmIdentifier", "Ljava/lang/Object;", "()Ljava/lang/Object;", "payload", "<init>", "(Ljava/lang/String;ILjava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$aa, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ReloadMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String callSource;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int vmIdentifier;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Object payload;

        public ReloadMessage(@NotNull String callSource, int i3, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(callSource, "callSource");
            this.callSource = callSource;
            this.vmIdentifier = i3;
            this.payload = obj;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getCallSource() {
            return this.callSource;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Object getPayload() {
            return this.payload;
        }

        /* renamed from: c, reason: from getter */
        public final int getVmIdentifier() {
            return this.vmIdentifier;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReloadMessage)) {
                return false;
            }
            ReloadMessage reloadMessage = (ReloadMessage) other;
            if (Intrinsics.areEqual(this.callSource, reloadMessage.callSource) && this.vmIdentifier == reloadMessage.vmIdentifier && Intrinsics.areEqual(this.payload, reloadMessage.payload)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.callSource.hashCode() * 31) + this.vmIdentifier) * 31;
            Object obj = this.payload;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "ReloadMessage(callSource=" + this.callSource + ", vmIdentifier=" + this.vmIdentifier + ", payload=" + this.payload + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Ltl1/g$ab;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "b", "()I", "position", "Z", "()Z", "anim", "<init>", "(IZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$ab, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ScrollToPositionMessageData extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int position;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean anim;

        public ScrollToPositionMessageData(int i3, boolean z16) {
            this.position = i3;
            this.anim = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getAnim() {
            return this.anim;
        }

        /* renamed from: b, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScrollToPositionMessageData)) {
                return false;
            }
            ScrollToPositionMessageData scrollToPositionMessageData = (ScrollToPositionMessageData) other;
            if (this.position == scrollToPositionMessageData.position && this.anim == scrollToPositionMessageData.anim) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = this.position * 31;
            boolean z16 = this.anim;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return i3 + i16;
        }

        @NotNull
        public String toString() {
            return "ScrollToPositionMessageData(position=" + this.position + ", anim=" + this.anim + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0012\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Ltl1/g$ac;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljl1/b;", "a", "Ljl1/b;", "()Ljl1/b;", "contentData", "b", "Z", "()Z", "topOrUnTop", "<init>", "(Ljl1/b;Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$ac, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class TopCommentItemMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final jl1.b contentData;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean topOrUnTop;

        public TopCommentItemMessage(@NotNull jl1.b contentData, boolean z16) {
            Intrinsics.checkNotNullParameter(contentData, "contentData");
            this.contentData = contentData;
            this.topOrUnTop = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final jl1.b getContentData() {
            return this.contentData;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getTopOrUnTop() {
            return this.topOrUnTop;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TopCommentItemMessage)) {
                return false;
            }
            TopCommentItemMessage topCommentItemMessage = (TopCommentItemMessage) other;
            if (Intrinsics.areEqual(this.contentData, topCommentItemMessage.contentData) && this.topOrUnTop == topCommentItemMessage.topOrUnTop) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.contentData.hashCode() * 31;
            boolean z16 = this.topOrUnTop;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "TopCommentItemMessage(contentData=" + this.contentData + ", topOrUnTop=" + this.topOrUnTop + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u000f\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\n\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Ltl1/g$ad;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "c", "()I", "position", "b", "Z", "d", "()Z", "isSuccess", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStLike;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStLike;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStLike;", "likeInfo", "Lhl1/g;", "Lhl1/g;", "()Lhl1/g;", "contentData", "<init>", "(IZLcom/tencent/qqnt/kernelgpro/nativeinterface/GProStLike;Lhl1/g;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$ad, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class UpdateCommentListPreferStatusMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int position;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GProStLike likeInfo;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final hl1.g contentData;

        public UpdateCommentListPreferStatusMessage(int i3, boolean z16, @NotNull GProStLike likeInfo, @NotNull hl1.g contentData) {
            Intrinsics.checkNotNullParameter(likeInfo, "likeInfo");
            Intrinsics.checkNotNullParameter(contentData, "contentData");
            this.position = i3;
            this.isSuccess = z16;
            this.likeInfo = likeInfo;
            this.contentData = contentData;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final hl1.g getContentData() {
            return this.contentData;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final GProStLike getLikeInfo() {
            return this.likeInfo;
        }

        /* renamed from: c, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateCommentListPreferStatusMessage)) {
                return false;
            }
            UpdateCommentListPreferStatusMessage updateCommentListPreferStatusMessage = (UpdateCommentListPreferStatusMessage) other;
            if (this.position == updateCommentListPreferStatusMessage.position && this.isSuccess == updateCommentListPreferStatusMessage.isSuccess && Intrinsics.areEqual(this.likeInfo, updateCommentListPreferStatusMessage.likeInfo) && Intrinsics.areEqual(this.contentData, updateCommentListPreferStatusMessage.contentData)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = this.position * 31;
            boolean z16 = this.isSuccess;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return ((((i3 + i16) * 31) + this.likeInfo.hashCode()) * 31) + this.contentData.hashCode();
        }

        @NotNull
        public String toString() {
            return "UpdateCommentListPreferStatusMessage(position=" + this.position + ", isSuccess=" + this.isSuccess + ", likeInfo=" + this.likeInfo + ", contentData=" + this.contentData + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Ltl1/g$ae;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "isAllowComment", "b", "isFeedPosterSelf", "<init>", "(ZZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$ae, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class UpdateFeedAllowCommentMessage {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isAllowComment;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isFeedPosterSelf;

        public UpdateFeedAllowCommentMessage(boolean z16, boolean z17) {
            this.isAllowComment = z16;
            this.isFeedPosterSelf = z17;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsAllowComment() {
            return this.isAllowComment;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsFeedPosterSelf() {
            return this.isFeedPosterSelf;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateFeedAllowCommentMessage)) {
                return false;
            }
            UpdateFeedAllowCommentMessage updateFeedAllowCommentMessage = (UpdateFeedAllowCommentMessage) other;
            if (this.isAllowComment == updateFeedAllowCommentMessage.isAllowComment && this.isFeedPosterSelf == updateFeedAllowCommentMessage.isFeedPosterSelf) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.isAllowComment;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.isFeedPosterSelf;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "UpdateFeedAllowCommentMessage(isAllowComment=" + this.isAllowComment + ", isFeedPosterSelf=" + this.isFeedPosterSelf + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Ltl1/g$af;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "topState", "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$af, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class UpdateFeedChannelTopStateMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean topState;

        public UpdateFeedChannelTopStateMessage(boolean z16) {
            this.topState = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getTopState() {
            return this.topState;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UpdateFeedChannelTopStateMessage) && this.topState == ((UpdateFeedChannelTopStateMessage) other).topState) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.topState;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "UpdateFeedChannelTopStateMessage(topState=" + this.topState + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Ltl1/g$b;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "isVisible", "<init>", "(Z)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class CommentListVisibilityChangeMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isVisible;

        public CommentListVisibilityChangeMessage(boolean z16) {
            this.isVisible = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsVisible() {
            return this.isVisible;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof CommentListVisibilityChangeMessage) && this.isVisible == ((CommentListVisibilityChangeMessage) other).isVisible) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.isVisible;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "CommentListVisibilityChangeMessage(isVisible=" + this.isVisible + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Ltl1/g$c;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lhl1/g;", "a", "Lhl1/g;", "()Lhl1/g;", "contentData", "b", "I", "getPosition", "()I", "position", "<init>", "(Lhl1/g;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$c, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class DeleteCommentListItemMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final hl1.g contentData;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int position;

        public DeleteCommentListItemMessage(@NotNull hl1.g contentData, int i3) {
            Intrinsics.checkNotNullParameter(contentData, "contentData");
            this.contentData = contentData;
            this.position = i3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final hl1.g getContentData() {
            return this.contentData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DeleteCommentListItemMessage)) {
                return false;
            }
            DeleteCommentListItemMessage deleteCommentListItemMessage = (DeleteCommentListItemMessage) other;
            if (Intrinsics.areEqual(this.contentData, deleteCommentListItemMessage.contentData) && this.position == deleteCommentListItemMessage.position) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.contentData.hashCode() * 31) + this.position;
        }

        @NotNull
        public String toString() {
            return "DeleteCommentListItemMessage(contentData=" + this.contentData + ", position=" + this.position + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ltl1/g$d;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljl1/b;", "a", "Ljl1/b;", "()Ljl1/b;", "commentItemData", "<init>", "(Ljl1/b;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$d, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ExpandCommentItemMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final jl1.b commentItemData;

        public ExpandCommentItemMessage(@NotNull jl1.b commentItemData) {
            Intrinsics.checkNotNullParameter(commentItemData, "commentItemData");
            this.commentItemData = commentItemData;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final jl1.b getCommentItemData() {
            return this.commentItemData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ExpandCommentItemMessage) && Intrinsics.areEqual(this.commentItemData, ((ExpandCommentItemMessage) other).commentItemData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.commentItemData.hashCode();
        }

        @NotNull
        public String toString() {
            return "ExpandCommentItemMessage(commentItemData=" + this.commentItemData + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ltl1/g$e;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljl1/h;", "a", "Ljl1/h;", "()Ljl1/h;", "replyItemData", "<init>", "(Ljl1/h;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$e, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ExpandReplyListMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final jl1.h replyItemData;

        public ExpandReplyListMessage(@NotNull jl1.h replyItemData) {
            Intrinsics.checkNotNullParameter(replyItemData, "replyItemData");
            this.replyItemData = replyItemData;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final jl1.h getReplyItemData() {
            return this.replyItemData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ExpandReplyListMessage) && Intrinsics.areEqual(this.replyItemData, ((ExpandReplyListMessage) other).replyItemData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.replyItemData.hashCode();
        }

        @NotNull
        public String toString() {
            return "ExpandReplyListMessage(replyItemData=" + this.replyItemData + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Ltl1/g$f;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "businessType", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "extensionInfo", "c", "searchExtensionInfo", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$f, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class FeedDetailChannelExtensionInfoMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int businessType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String extensionInfo;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String searchExtensionInfo;

        public FeedDetailChannelExtensionInfoMessage(int i3, @NotNull String extensionInfo, @NotNull String searchExtensionInfo) {
            Intrinsics.checkNotNullParameter(extensionInfo, "extensionInfo");
            Intrinsics.checkNotNullParameter(searchExtensionInfo, "searchExtensionInfo");
            this.businessType = i3;
            this.extensionInfo = extensionInfo;
            this.searchExtensionInfo = searchExtensionInfo;
        }

        /* renamed from: a, reason: from getter */
        public final int getBusinessType() {
            return this.businessType;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getExtensionInfo() {
            return this.extensionInfo;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getSearchExtensionInfo() {
            return this.searchExtensionInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeedDetailChannelExtensionInfoMessage)) {
                return false;
            }
            FeedDetailChannelExtensionInfoMessage feedDetailChannelExtensionInfoMessage = (FeedDetailChannelExtensionInfoMessage) other;
            if (this.businessType == feedDetailChannelExtensionInfoMessage.businessType && Intrinsics.areEqual(this.extensionInfo, feedDetailChannelExtensionInfoMessage.extensionInfo) && Intrinsics.areEqual(this.searchExtensionInfo, feedDetailChannelExtensionInfoMessage.searchExtensionInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.businessType * 31) + this.extensionInfo.hashCode()) * 31) + this.searchExtensionInfo.hashCode();
        }

        @NotNull
        public String toString() {
            return "FeedDetailChannelExtensionInfoMessage(businessType=" + this.businessType + ", extensionInfo=" + this.extensionInfo + ", searchExtensionInfo=" + this.searchExtensionInfo + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ltl1/g$g;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljl1/h;", "a", "Ljl1/h;", "()Ljl1/h;", "replyItemData", "<init>", "(Ljl1/h;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$g, reason: collision with other inner class name and from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class FoldReplyListMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final jl1.h replyItemData;

        public FoldReplyListMessage(@NotNull jl1.h replyItemData) {
            Intrinsics.checkNotNullParameter(replyItemData, "replyItemData");
            this.replyItemData = replyItemData;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final jl1.h getReplyItemData() {
            return this.replyItemData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof FoldReplyListMessage) && Intrinsics.areEqual(this.replyItemData, ((FoldReplyListMessage) other).replyItemData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.replyItemData.hashCode();
        }

        @NotNull
        public String toString() {
            return "FoldReplyListMessage(replyItemData=" + this.replyItemData + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Ltl1/g$h;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "offset", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$h, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class GetCommentItemOffsetMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int offset;

        public GetCommentItemOffsetMessage(int i3) {
            this.offset = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getOffset() {
            return this.offset;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GetCommentItemOffsetMessage) && this.offset == ((GetCommentItemOffsetMessage) other).offset) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.offset;
        }

        @NotNull
        public String toString() {
            return "GetCommentItemOffsetMessage(offset=" + this.offset + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Ltl1/g$i;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "itemGroupPosition", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$i, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class GetCommentStructArgs extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int itemGroupPosition;

        public GetCommentStructArgs(int i3) {
            this.itemGroupPosition = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getItemGroupPosition() {
            return this.itemGroupPosition;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GetCommentStructArgs) && this.itemGroupPosition == ((GetCommentStructArgs) other).itemGroupPosition) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.itemGroupPosition;
        }

        @NotNull
        public String toString() {
            return "GetCommentStructArgs(itemGroupPosition=" + this.itemGroupPosition + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0013"}, d2 = {"Ltl1/g$j;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "callSource", "b", "getCommendId", "commendId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$j, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class LoadMoreMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String callSource;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String commendId;

        public /* synthetic */ LoadMoreMessage(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? "" : str2);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getCallSource() {
            return this.callSource;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadMoreMessage)) {
                return false;
            }
            LoadMoreMessage loadMoreMessage = (LoadMoreMessage) other;
            if (Intrinsics.areEqual(this.callSource, loadMoreMessage.callSource) && Intrinsics.areEqual(this.commendId, loadMoreMessage.commendId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.callSource.hashCode() * 31) + this.commendId.hashCode();
        }

        @NotNull
        public String toString() {
            return "LoadMoreMessage(callSource=" + this.callSource + ", commendId=" + this.commendId + ")";
        }

        public LoadMoreMessage(@NotNull String callSource, @NotNull String commendId) {
            Intrinsics.checkNotNullParameter(callSource, "callSource");
            Intrinsics.checkNotNullParameter(commendId, "commendId");
            this.callSource = callSource;
            this.commendId = commendId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u001a\u0010\u0016\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00130\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00020\u0002\"\u00020\u0003J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\t\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R+\u0010\u0016\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\r\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Ltl1/g$k;", "Ltl1/g;", "", "", "whats", "", "c", "", "toString", "hashCode", "", "other", "equals", "a", "I", "b", "()I", "itemSize", "Ljava/util/Queue;", "Lkotlin/Pair;", "Ljava/util/Queue;", "()Ljava/util/Queue;", "changeSourceList", "<init>", "(ILjava/util/Queue;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$k, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnDataChangedRenderOnScreenMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int itemSize;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Queue<Pair<Integer, Object>> changeSourceList;

        public OnDataChangedRenderOnScreenMessage(int i3, @NotNull Queue<Pair<Integer, Object>> changeSourceList) {
            Intrinsics.checkNotNullParameter(changeSourceList, "changeSourceList");
            this.itemSize = i3;
            this.changeSourceList = changeSourceList;
        }

        @NotNull
        public final Queue<Pair<Integer, Object>> a() {
            return this.changeSourceList;
        }

        /* renamed from: b, reason: from getter */
        public final int getItemSize() {
            return this.itemSize;
        }

        public final boolean c(@NotNull int... whats) {
            Object obj;
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(whats, "whats");
            Iterator<T> it = this.changeSourceList.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Pair pair = (Pair) next;
                int length = whats.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    int i16 = whats[i3];
                    if (((Number) pair.getFirst()).intValue() == i16) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        obj = Integer.valueOf(i16);
                        break;
                    }
                    i3++;
                }
                if (obj != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    obj = next;
                    break;
                }
            }
            if (obj != null) {
                return true;
            }
            return false;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnDataChangedRenderOnScreenMessage)) {
                return false;
            }
            OnDataChangedRenderOnScreenMessage onDataChangedRenderOnScreenMessage = (OnDataChangedRenderOnScreenMessage) other;
            if (this.itemSize == onDataChangedRenderOnScreenMessage.itemSize && Intrinsics.areEqual(this.changeSourceList, onDataChangedRenderOnScreenMessage.changeSourceList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.itemSize * 31) + this.changeSourceList.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnDataChangedRenderOnScreenMessage(itemSize=" + this.itemSize + ", changeSourceList=" + this.changeSourceList + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\f\u0010\u0012R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Ltl1/g$l;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lhl1/g;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "dataList", "I", "()I", "changedSource", "c", "Ljava/lang/Object;", "()Ljava/lang/Object;", "payload", "<init>", "(Ljava/util/List;ILjava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$l, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnDataListChangedMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<hl1.g> dataList;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int changedSource;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Object payload;

        /* JADX WARN: Multi-variable type inference failed */
        public OnDataListChangedMessage(@NotNull List<? extends hl1.g> dataList, int i3, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            this.dataList = dataList;
            this.changedSource = i3;
            this.payload = obj;
        }

        /* renamed from: a, reason: from getter */
        public final int getChangedSource() {
            return this.changedSource;
        }

        @NotNull
        public final List<hl1.g> b() {
            return this.dataList;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final Object getPayload() {
            return this.payload;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnDataListChangedMessage)) {
                return false;
            }
            OnDataListChangedMessage onDataListChangedMessage = (OnDataListChangedMessage) other;
            if (Intrinsics.areEqual(this.dataList, onDataListChangedMessage.dataList) && this.changedSource == onDataListChangedMessage.changedSource && Intrinsics.areEqual(this.payload, onDataListChangedMessage.payload)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.dataList.hashCode() * 31) + this.changedSource) * 31;
            Object obj = this.payload;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "OnDataListChangedMessage(dataList=" + this.dataList + ", changedSource=" + this.changedSource + ", payload=" + this.payload + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ltl1/g$m;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "feedDetailMainData", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$m, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnGetFeedDetailMainDataMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final FeedDetailMainData feedDetailMainData;

        public OnGetFeedDetailMainDataMessage(@Nullable FeedDetailMainData feedDetailMainData) {
            this.feedDetailMainData = feedDetailMainData;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final FeedDetailMainData getFeedDetailMainData() {
            return this.feedDetailMainData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnGetFeedDetailMainDataMessage) && Intrinsics.areEqual(this.feedDetailMainData, ((OnGetFeedDetailMainDataMessage) other).feedDetailMainData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            FeedDetailMainData feedDetailMainData = this.feedDetailMainData;
            if (feedDetailMainData == null) {
                return 0;
            }
            return feedDetailMainData.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnGetFeedDetailMainDataMessage(feedDetailMainData=" + this.feedDetailMainData + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u000e\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Ltl1/g$n;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "changedSource", "b", "c", "position", "Ljava/lang/Object;", "()Ljava/lang/Object;", "payload", "<init>", "(IILjava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$n, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnItemDataChangedMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int changedSource;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int position;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Object payload;

        public /* synthetic */ OnItemDataChangedMessage(int i3, int i16, Object obj, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, i16, (i17 & 4) != 0 ? null : obj);
        }

        /* renamed from: a, reason: from getter */
        public final int getChangedSource() {
            return this.changedSource;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Object getPayload() {
            return this.payload;
        }

        /* renamed from: c, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnItemDataChangedMessage)) {
                return false;
            }
            OnItemDataChangedMessage onItemDataChangedMessage = (OnItemDataChangedMessage) other;
            if (this.changedSource == onItemDataChangedMessage.changedSource && this.position == onItemDataChangedMessage.position && Intrinsics.areEqual(this.payload, onItemDataChangedMessage.payload)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int i3 = ((this.changedSource * 31) + this.position) * 31;
            Object obj = this.payload;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            return "OnItemDataChangedMessage(changedSource=" + this.changedSource + ", position=" + this.position + ", payload=" + this.payload + ")";
        }

        public OnItemDataChangedMessage(int i3, int i16, @Nullable Object obj) {
            this.changedSource = i3;
            this.position = i16;
            this.payload = obj;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ltl1/g$o;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getCallSource", "()Ljava/lang/String;", "callSource", "<init>", "(Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$o, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnLoadBeginMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String callSource;

        public OnLoadBeginMessage(@NotNull String callSource) {
            Intrinsics.checkNotNullParameter(callSource, "callSource");
            this.callSource = callSource;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnLoadBeginMessage) && Intrinsics.areEqual(this.callSource, ((OnLoadBeginMessage) other).callSource)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.callSource.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnLoadBeginMessage(callSource=" + this.callSource + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Ltl1/g$p;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "isSuccess", "()Z", "b", "isFinish", "<init>", "(ZZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$p, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnLoadCommentCompletedMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isFinish;

        public OnLoadCommentCompletedMessage(boolean z16, boolean z17) {
            this.isSuccess = z16;
            this.isFinish = z17;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnLoadCommentCompletedMessage)) {
                return false;
            }
            OnLoadCommentCompletedMessage onLoadCommentCompletedMessage = (OnLoadCommentCompletedMessage) other;
            if (this.isSuccess == onLoadCommentCompletedMessage.isSuccess && this.isFinish == onLoadCommentCompletedMessage.isFinish) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.isSuccess;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.isFinish;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "OnLoadCommentCompletedMessage(isSuccess=" + this.isSuccess + ", isFinish=" + this.isFinish + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001f\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\n\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Ltl1/g$q;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "d", "()Z", "isSuccess", "b", "I", "()I", "errorCode", "c", "isDbCache", "", "Lhl1/g;", "Ljava/util/List;", "()Ljava/util/List;", "contentList", "<init>", "(ZIZLjava/util/List;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$q, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnLoadMainCompletedMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int errorCode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isDbCache;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final List<hl1.g> contentList;

        /* JADX WARN: Multi-variable type inference failed */
        public OnLoadMainCompletedMessage(boolean z16, int i3, boolean z17, @Nullable List<? extends hl1.g> list) {
            this.isSuccess = z16;
            this.errorCode = i3;
            this.isDbCache = z17;
            this.contentList = list;
        }

        @Nullable
        public final List<hl1.g> a() {
            return this.contentList;
        }

        /* renamed from: b, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsDbCache() {
            return this.isDbCache;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnLoadMainCompletedMessage)) {
                return false;
            }
            OnLoadMainCompletedMessage onLoadMainCompletedMessage = (OnLoadMainCompletedMessage) other;
            if (this.isSuccess == onLoadMainCompletedMessage.isSuccess && this.errorCode == onLoadMainCompletedMessage.errorCode && this.isDbCache == onLoadMainCompletedMessage.isDbCache && Intrinsics.areEqual(this.contentList, onLoadMainCompletedMessage.contentList)) {
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
            boolean z16 = this.isSuccess;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = ((r06 * 31) + this.errorCode) * 31;
            boolean z17 = this.isDbCache;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            int i17 = (i16 + i3) * 31;
            List<hl1.g> list = this.contentList;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return i17 + hashCode;
        }

        @NotNull
        public String toString() {
            return "OnLoadMainCompletedMessage(isSuccess=" + this.isSuccess + ", errorCode=" + this.errorCode + ", isDbCache=" + this.isDbCache + ", contentList=" + this.contentList + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ltl1/g$r;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getCallSource", "()Ljava/lang/String;", "callSource", "<init>", "(Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$r, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnLoadMoreBeginMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String callSource;

        public OnLoadMoreBeginMessage(@NotNull String callSource) {
            Intrinsics.checkNotNullParameter(callSource, "callSource");
            this.callSource = callSource;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnLoadMoreBeginMessage) && Intrinsics.areEqual(this.callSource, ((OnLoadMoreBeginMessage) other).callSource)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.callSource.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnLoadMoreBeginMessage(callSource=" + this.callSource + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Ltl1/g$s;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "isSuccess", "()Z", "b", "isFinish", "<init>", "(ZZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$s, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnLoadMoreCompletedMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isFinish;

        public OnLoadMoreCompletedMessage(boolean z16, boolean z17) {
            this.isSuccess = z16;
            this.isFinish = z17;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnLoadMoreCompletedMessage)) {
                return false;
            }
            OnLoadMoreCompletedMessage onLoadMoreCompletedMessage = (OnLoadMoreCompletedMessage) other;
            if (this.isSuccess == onLoadMoreCompletedMessage.isSuccess && this.isFinish == onLoadMoreCompletedMessage.isFinish) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.isSuccess;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.isFinish;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "OnLoadMoreCompletedMessage(isSuccess=" + this.isSuccess + ", isFinish=" + this.isFinish + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ltl1/g$t;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getCallSource", "()Ljava/lang/String;", "callSource", "<init>", "(Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$t, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnPreloadBeginMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String callSource;

        public OnPreloadBeginMessage(@NotNull String callSource) {
            Intrinsics.checkNotNullParameter(callSource, "callSource");
            this.callSource = callSource;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnPreloadBeginMessage) && Intrinsics.areEqual(this.callSource, ((OnPreloadBeginMessage) other).callSource)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.callSource.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnPreloadBeginMessage(callSource=" + this.callSource + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Ltl1/g$u;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "b", "()Z", "isSuccess", "useCacheToRender", "<init>", "(ZZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$u, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnPreloadMainCompletedMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean useCacheToRender;

        public OnPreloadMainCompletedMessage(boolean z16, boolean z17) {
            this.isSuccess = z16;
            this.useCacheToRender = z17;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getUseCacheToRender() {
            return this.useCacheToRender;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnPreloadMainCompletedMessage)) {
                return false;
            }
            OnPreloadMainCompletedMessage onPreloadMainCompletedMessage = (OnPreloadMainCompletedMessage) other;
            if (this.isSuccess == onPreloadMainCompletedMessage.isSuccess && this.useCacheToRender == onPreloadMainCompletedMessage.useCacheToRender) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.isSuccess;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.useCacheToRender;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "OnPreloadMainCompletedMessage(isSuccess=" + this.isSuccess + ", useCacheToRender=" + this.useCacheToRender + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Ltl1/g$v;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "isSuccess", "()Z", "b", "isFinish", "<init>", "(ZZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$v, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnReLoadCommentCompletedMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isFinish;

        public OnReLoadCommentCompletedMessage(boolean z16, boolean z17) {
            this.isSuccess = z16;
            this.isFinish = z17;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnReLoadCommentCompletedMessage)) {
                return false;
            }
            OnReLoadCommentCompletedMessage onReLoadCommentCompletedMessage = (OnReLoadCommentCompletedMessage) other;
            if (this.isSuccess == onReLoadCommentCompletedMessage.isSuccess && this.isFinish == onReLoadCommentCompletedMessage.isFinish) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.isSuccess;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.isFinish;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "OnReLoadCommentCompletedMessage(isSuccess=" + this.isSuccess + ", isFinish=" + this.isFinish + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ltl1/g$w;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "getWhich", "()I", "which", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$w, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnReloadBeginMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int which;

        public OnReloadBeginMessage(int i3) {
            this.which = i3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnReloadBeginMessage) && this.which == ((OnReloadBeginMessage) other).which) {
                return true;
            }
            return false;
        }

        /* renamed from: hashCode, reason: from getter */
        public int getWhich() {
            return this.which;
        }

        @NotNull
        public String toString() {
            return "OnReloadBeginMessage(which=" + this.which + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ltl1/g$x;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljl1/b;", "a", "Ljl1/b;", "()Ljl1/b;", "contentData", "<init>", "(Ljl1/b;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$x, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnResendCommentItem extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final jl1.b contentData;

        public OnResendCommentItem(@NotNull jl1.b contentData) {
            Intrinsics.checkNotNullParameter(contentData, "contentData");
            this.contentData = contentData;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final jl1.b getContentData() {
            return this.contentData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnResendCommentItem) && Intrinsics.areEqual(this.contentData, ((OnResendCommentItem) other).contentData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.contentData.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnResendCommentItem(contentData=" + this.contentData + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ltl1/g$y;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljl1/h;", "a", "Ljl1/h;", "()Ljl1/h;", "contentData", "<init>", "(Ljl1/h;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$y, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class OnResendReplyItem extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final jl1.h contentData;

        public OnResendReplyItem(@NotNull jl1.h contentData) {
            Intrinsics.checkNotNullParameter(contentData, "contentData");
            this.contentData = contentData;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final jl1.h getContentData() {
            return this.contentData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnResendReplyItem) && Intrinsics.areEqual(this.contentData, ((OnResendReplyItem) other).contentData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.contentData.hashCode();
        }

        @NotNull
        public String toString() {
            return "OnResendReplyItem(contentData=" + this.contentData + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Ltl1/g$z;", "Ltl1/g;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "type", "b", "Ljava/lang/String;", "getDataChangedSource", "()Ljava/lang/String;", "dataChangedSource", "<init>", "(ILjava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: tl1.g$z, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ReloadCommentDataMessage extends g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String dataChangedSource;

        public ReloadCommentDataMessage(int i3, @NotNull String dataChangedSource) {
            Intrinsics.checkNotNullParameter(dataChangedSource, "dataChangedSource");
            this.type = i3;
            this.dataChangedSource = dataChangedSource;
        }

        /* renamed from: a, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReloadCommentDataMessage)) {
                return false;
            }
            ReloadCommentDataMessage reloadCommentDataMessage = (ReloadCommentDataMessage) other;
            if (this.type == reloadCommentDataMessage.type && Intrinsics.areEqual(this.dataChangedSource, reloadCommentDataMessage.dataChangedSource)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.type * 31) + this.dataChangedSource.hashCode();
        }

        @NotNull
        public String toString() {
            return "ReloadCommentDataMessage(type=" + this.type + ", dataChangedSource=" + this.dataChangedSource + ")";
        }
    }
}

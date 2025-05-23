package v50;

import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tianshu.QQCircleTianShu$AdItem;
import tianshu.QQCircleTianShu$AdPlacementInfo;
import tianshu.QQCircleTianShu$RspEntry;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00072\u00020\u0001:\u0002\u0011\u0010B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lv50/a;", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "", "f", "Lv50/a$a;", "e", "stFeed", "position", "", "name", "", "c", "d", "", "b", "a", "Lfeedcloud/FeedCloudMeta$StFeed;", "I", "iAdId", "Lv50/a$a;", "challengeTopicBean", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int position = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int iAdId = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ChallengeTopicBean challengeTopicBean = ChallengeTopicBean.INSTANCE.a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\b\r\b\u0082\b\u0018\u0000 #2\u00020\u0001:\u0001\u0005B=\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012\u00a8\u0006$"}, d2 = {"Lv50/a$a;", "", "", "adId", "", "a", "", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "getTopicTitle", "()Ljava/lang/String;", "topicTitle", "b", "Z", "getNeedShowFlag", "()Z", "needShowFlag", "c", "getHasData", "hasData", "", "d", "Ljava/util/List;", "getPriorityADList", "()Ljava/util/List;", "priorityADList", "e", "isOwner", "f", "isStudyMode", "<init>", "(Ljava/lang/String;ZZLjava/util/List;ZZ)V", "g", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: v50.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes4.dex */
    public static final /* data */ class ChallengeTopicBean {

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String topicTitle;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needShowFlag;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean hasData;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<Integer> priorityADList;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isOwner;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isStudyMode;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lv50/a$a$a;", "", "Lv50/a$a;", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: v50.a$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final ChallengeTopicBean a() {
                return new ChallengeTopicBean("", false, false, new ArrayList(), false, true);
            }

            Companion() {
            }
        }

        public ChallengeTopicBean(@NotNull String topicTitle, boolean z16, boolean z17, @NotNull List<Integer> priorityADList, boolean z18, boolean z19) {
            Intrinsics.checkNotNullParameter(topicTitle, "topicTitle");
            Intrinsics.checkNotNullParameter(priorityADList, "priorityADList");
            this.topicTitle = topicTitle;
            this.needShowFlag = z16;
            this.hasData = z17;
            this.priorityADList = priorityADList;
            this.isOwner = z18;
            this.isStudyMode = z19;
        }

        public final boolean a(int adId) {
            if (this.isStudyMode || !this.hasData) {
                return false;
            }
            if (!this.isOwner && (!this.needShowFlag || this.priorityADList.contains(Integer.valueOf(adId)))) {
                return false;
            }
            return true;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChallengeTopicBean)) {
                return false;
            }
            ChallengeTopicBean challengeTopicBean = (ChallengeTopicBean) other;
            if (Intrinsics.areEqual(this.topicTitle, challengeTopicBean.topicTitle) && this.needShowFlag == challengeTopicBean.needShowFlag && this.hasData == challengeTopicBean.hasData && Intrinsics.areEqual(this.priorityADList, challengeTopicBean.priorityADList) && this.isOwner == challengeTopicBean.isOwner && this.isStudyMode == challengeTopicBean.isStudyMode) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.topicTitle.hashCode() * 31;
            boolean z16 = this.needShowFlag;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.hasData;
            int i18 = z17;
            if (z17 != 0) {
                i18 = 1;
            }
            int hashCode2 = (((i17 + i18) * 31) + this.priorityADList.hashCode()) * 31;
            boolean z18 = this.isOwner;
            int i19 = z18;
            if (z18 != 0) {
                i19 = 1;
            }
            int i26 = (hashCode2 + i19) * 31;
            boolean z19 = this.isStudyMode;
            if (!z19) {
                i3 = z19 ? 1 : 0;
            }
            return i26 + i3;
        }

        @NotNull
        public String toString() {
            return "ChallengeTopicBean(topicTitle='" + this.topicTitle + "', needShowFlag=" + this.needShowFlag + ", hasData=" + this.hasData + ", priorityADList=" + this.priorityADList + ", isOwner=" + this.isOwner + ", isStudyMode=" + this.isStudyMode + ")";
        }
    }

    private final ChallengeTopicBean e() {
        List<FeedCloudCommon$Entry> list;
        boolean z16;
        boolean z17;
        PBRepeatMessageField<FeedCloudMeta$StTagInfo> pBRepeatMessageField;
        List<FeedCloudMeta$StTagInfo> list2;
        PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField2;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField;
        String str;
        PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField3;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.data;
        List<FeedCloudCommon$Entry> list3 = null;
        if (feedCloudMeta$StFeed != null && (pBRepeatMessageField3 = feedCloudMeta$StFeed.extInfo) != null) {
            list = pBRepeatMessageField3.get();
        } else {
            list = null;
        }
        String d16 = bh.d(list, "canshow_publishchallenge_tag");
        boolean z18 = false;
        if (d16 != null && d16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return ChallengeTopicBean.INSTANCE.a();
        }
        boolean areEqual = Intrinsics.areEqual(d16, "true");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.data;
        if (feedCloudMeta$StFeed2 != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed2.poster) != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null && (str = pBStringField.get()) != null) {
            z17 = QCircleCommonUtil.isOwner(str);
        } else {
            z17 = false;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed3 = this.data;
        if (feedCloudMeta$StFeed3 != null && (pBRepeatMessageField2 = feedCloudMeta$StFeed3.extInfo) != null) {
            list3 = pBRepeatMessageField2.get();
        }
        String d17 = bh.d(list3, "challenge_tagTitle");
        if (d17 == null) {
            d17 = "";
        }
        String str2 = d17;
        List<Integer> arrayList = new ArrayList<>();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed4 = this.data;
        if (feedCloudMeta$StFeed4 != null && (pBRepeatMessageField = feedCloudMeta$StFeed4.tagInfos) != null && (list2 = pBRepeatMessageField.get()) != null) {
            for (FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo : list2) {
                if (feedCloudMeta$StTagInfo.nature.get() == 2 && Intrinsics.areEqual(feedCloudMeta$StTagInfo.tagName.get(), str2)) {
                    arrayList = feedCloudMeta$StTagInfo.optInfo.priorityAdvIDs.get();
                    Intrinsics.checkNotNullExpressionValue(arrayList, "it.optInfo.priorityAdvIDs.get()");
                    z18 = true;
                }
            }
        }
        return new ChallengeTopicBean(str2, areEqual, z18, arrayList, z17, ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch());
    }

    private final int f(FeedCloudMeta$StFeed data) {
        List<QQCircleTianShu$RspEntry> list;
        Object obj;
        PBRepeatMessageField<QQCircleTianShu$AdItem> pBRepeatMessageField;
        List<QQCircleTianShu$AdItem> list2;
        Object firstOrNull;
        PBUInt32Field pBUInt32Field;
        PBUInt32Field pBUInt32Field2;
        PBRepeatMessageField<QQCircleTianShu$RspEntry> pBRepeatMessageField2;
        QQCircleTianShu$AdPlacementInfo qQCircleTianShu$AdPlacementInfo = null;
        if (data != null && (pBRepeatMessageField2 = data.tianshuEntry) != null) {
            list = pBRepeatMessageField2.get();
        } else {
            list = null;
        }
        if (list == null) {
            return -1;
        }
        Iterator it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                QQCircleTianShu$RspEntry qQCircleTianShu$RspEntry = (QQCircleTianShu$RspEntry) obj;
                boolean z16 = false;
                if (qQCircleTianShu$RspEntry != null && (pBUInt32Field2 = qQCircleTianShu$RspEntry.key) != null && pBUInt32Field2.get() == 1038) {
                    z16 = true;
                }
            } else {
                obj = null;
                break;
            }
        }
        QQCircleTianShu$RspEntry qQCircleTianShu$RspEntry2 = (QQCircleTianShu$RspEntry) obj;
        if (qQCircleTianShu$RspEntry2 != null) {
            qQCircleTianShu$AdPlacementInfo = qQCircleTianShu$RspEntry2.value;
        }
        if (qQCircleTianShu$AdPlacementInfo != null && (pBRepeatMessageField = qQCircleTianShu$AdPlacementInfo.lst) != null && (list2 = pBRepeatMessageField.get()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
            QQCircleTianShu$AdItem qQCircleTianShu$AdItem = (QQCircleTianShu$AdItem) firstOrNull;
            if (qQCircleTianShu$AdItem == null || (pBUInt32Field = qQCircleTianShu$AdItem.iAdId) == null) {
                return -1;
            }
            return pBUInt32Field.get();
        }
        return -1;
    }

    public final boolean a() {
        return b();
    }

    public final boolean b() {
        return this.challengeTopicBean.a(this.iAdId);
    }

    public final void c(@Nullable FeedCloudMeta$StFeed stFeed, int position, @NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        QLog.d("QFSChallengeTopicMutexModel", 1, "onBindData: " + hashCode() + ", position:" + position + ", name:" + name);
        this.data = stFeed;
        this.position = position;
    }

    public final void d() {
        this.iAdId = f(this.data);
        ChallengeTopicBean e16 = e();
        this.challengeTopicBean = e16;
        QLog.d("QFSChallengeTopicMutexModel", 1, "onFeedSelected position:" + this.position + ", iAdId:" + this.iAdId + ", challengeTopicBean:" + e16);
    }
}

package vn2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqdataline.api.IQQDataLineApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatSummaryItem;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgItem;
import com.tencent.qqnt.search.api.ISearchConvertAPI;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import com.tencent.robot.api.IRobotAIORouteApi;
import com.tencent.robot.api.IRobotIdentityApi;
import com.tencent.robot.api.RobotAIORouteArgs;
import ep2.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u0001:Bm\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\b\u0010/\u001a\u0004\u0018\u00010\u000b\u0012\b\u00100\u001a\u0004\u0018\u00010\u000b\u0012\u001a\u00103\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u000101j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`2\u0012\u0010\u00106\u001a\f\u0012\u0006\b\u0001\u0012\u000205\u0018\u000104\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001f\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020\u000b\u00a2\u0006\u0004\b7\u00108J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010$\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010'\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#R\u0017\u0010*\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010\u001eR\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010!\u00a8\u0006;"}, d2 = {"Lvn2/b;", "Lep2/d;", "Landroid/content/Context;", "context", "", "K", "Landroid/view/View;", "view", "J", "", "k", "", "l", "", "u", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "", "v", "H", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatSummaryItem;", "T", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatSummaryItem;", "I", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatSummaryItem;", "searchChatSummaryItem", "U", "getQueryId", "()I", "queryId", "V", "Ljava/lang/String;", "getRecallReason", "()Ljava/lang/String;", "recallReason", "W", "getUid", "uid", "X", "getChatType", "chatType", "Y", "uin", "Lcom/tencent/common/app/AppInterface;", "app", "originalKeyword", "segmentKeyword", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "splitKeywords", "", "Lcom/tencent/mobileqq/fts/v1/FTSEntity;", "entityList", "<init>", "(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/List;Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatSummaryItem;ILjava/lang/String;)V", "Z", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends d {

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final SearchChatSummaryItem searchChatSummaryItem;

    /* renamed from: U, reason: from kotlin metadata */
    private final int queryId;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final String recallReason;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final String uid;

    /* renamed from: X, reason: from kotlin metadata */
    private final int chatType;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private String uin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@Nullable AppInterface appInterface, @Nullable String str, @Nullable String str2, @Nullable ArrayList<String> arrayList, @Nullable List<? extends FTSEntity> list, @NotNull SearchChatSummaryItem searchChatSummaryItem, int i3, @NotNull String recallReason) {
        super(str, str2, arrayList, list);
        String str3;
        Object obj;
        Intrinsics.checkNotNullParameter(searchChatSummaryItem, "searchChatSummaryItem");
        Intrinsics.checkNotNullParameter(recallReason, "recallReason");
        this.searchChatSummaryItem = searchChatSummaryItem;
        this.queryId = i3;
        this.recallReason = recallReason;
        if (searchChatSummaryItem.buddyChatInfo.size() > 0) {
            str3 = searchChatSummaryItem.buddyChatInfo.get(0).peerUid;
            Intrinsics.checkNotNullExpressionValue(str3, "{\n        searchChatSumm\u2026ChatInfo[0].peerUid\n    }");
        } else if (searchChatSummaryItem.groupChatInfo.size() > 0) {
            str3 = String.valueOf(searchChatSummaryItem.groupChatInfo.get(0).groupCode);
        } else if (searchChatSummaryItem.dataLineChatInfo.size() <= 0) {
            str3 = "";
        } else {
            str3 = searchChatSummaryItem.dataLineChatInfo.get(0).uid;
            Intrinsics.checkNotNullExpressionValue(str3, "{\n        searchChatSumm\u2026LineChatInfo[0].uid\n    }");
        }
        this.uid = str3;
        this.chatType = searchChatSummaryItem.chatType;
        this.uin = "";
        Intrinsics.checkNotNullExpressionValue(searchChatSummaryItem.buddyChatInfo, "searchChatSummaryItem.buddyChatInfo");
        if (!r1.isEmpty()) {
            obj = Long.valueOf(searchChatSummaryItem.buddyChatInfo.get(0).peerUin);
        } else {
            Intrinsics.checkNotNullExpressionValue(searchChatSummaryItem.groupChatInfo, "searchChatSummaryItem.groupChatInfo");
            if (!r1.isEmpty()) {
                obj = Long.valueOf(searchChatSummaryItem.groupChatInfo.get(0).groupCode);
            } else {
                Intrinsics.checkNotNullExpressionValue(searchChatSummaryItem.discussChatInfo, "searchChatSummaryItem.discussChatInfo");
                if (!r1.isEmpty()) {
                    obj = Long.valueOf(searchChatSummaryItem.discussChatInfo.get(0).discussCode);
                } else {
                    Intrinsics.checkNotNullExpressionValue(searchChatSummaryItem.dataLineChatInfo, "searchChatSummaryItem.dataLineChatInfo");
                    if (!r1.isEmpty()) {
                        obj = ((IQQDataLineApi) QRoute.api(IQQDataLineApi.class)).changeUid2Uin(searchChatSummaryItem.dataLineChatInfo.get(0).uid);
                    } else {
                        QLog.i("QQSearch.Local.NTFtsMessageSearchResultModel", 1, "search but type error");
                        obj = 0L;
                    }
                }
            }
        }
        this.uin = obj.toString();
    }

    private final boolean J(View view) {
        if (view != null && TextUtils.equals(AppConstants.VALUE.UIN_QZONE, this.uin) && ((IQzoneMsgApi) QRoute.api(IQzoneMsgApi.class)).openContentBox(view.getContext())) {
            return true;
        }
        return false;
    }

    private final boolean K(Context context) {
        Object first;
        if (!(context instanceof Activity) || this.searchChatSummaryItem.msgCount != 1 || this.chatType != 1 || !((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).isRobotUin(this.uin)) {
            return false;
        }
        Bundle bundle = new Bundle();
        ArrayList<SearchMsgItem> arrayList = this.searchChatSummaryItem.msgItem;
        Intrinsics.checkNotNullExpressionValue(arrayList, "searchChatSummaryItem.msgItem");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        SearchMsgItem searchMsgItem = (SearchMsgItem) first;
        bundle.putLong("key_navigate_msgid", searchMsgItem.msgId);
        bundle.putLong("key_navigate_msgseq", searchMsgItem.msgSeq);
        ((IRobotAIORouteApi) QRoute.api(IRobotAIORouteApi.class)).fetchAndRouteToRobotAIO(new RobotAIORouteArgs((Activity) context, this.uin, null, null, null, false, bundle, null, null, 444, null));
        return true;
    }

    @Override // ep2.d
    @Nullable
    public CharSequence G() {
        Object first;
        SearchChatSummaryItem searchChatSummaryItem = this.searchChatSummaryItem;
        boolean z16 = true;
        if (searchChatSummaryItem.msgCount != 1) {
            return null;
        }
        ArrayList<SearchMsgItem> arrayList = searchChatSummaryItem.msgItem;
        Intrinsics.checkNotNullExpressionValue(arrayList, "searchChatSummaryItem.msgItem");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        String str = ((SearchMsgItem) first).senderRemark;
        if (str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        return str;
    }

    @Override // ep2.d
    @Nullable
    public CharSequence H() {
        Object first;
        SearchChatSummaryItem searchChatSummaryItem = this.searchChatSummaryItem;
        boolean z16 = true;
        if (searchChatSummaryItem.msgCount != 1) {
            return null;
        }
        ArrayList<SearchMsgItem> arrayList = searchChatSummaryItem.msgItem;
        Intrinsics.checkNotNullExpressionValue(arrayList, "searchChatSummaryItem.msgItem");
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        String str = ((SearchMsgItem) first).senderNick;
        if (str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        return str;
    }

    @NotNull
    /* renamed from: I, reason: from getter */
    public final SearchChatSummaryItem getSearchChatSummaryItem() {
        return this.searchChatSummaryItem;
    }

    @Override // com.tencent.mobileqq.search.model.v
    @NotNull
    /* renamed from: h, reason: from getter */
    public String getRecallReason() {
        return this.recallReason;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        int i3;
        int i16 = this.chatType;
        if (i16 == 1) {
            return 1;
        }
        if (i16 == 2) {
            return 4;
        }
        if (i16 != 3) {
            if (i16 != 8) {
                if (!QLog.isColorLevel()) {
                    return 1;
                }
                QLog.d("QQSearch.Local.NTFtsMessageSearchResultModel", 4, "Face type is illegal. type = " + this.searchChatSummaryItem.chatType);
                return 1;
            }
            String str = this.uid;
            if (Intrinsics.areEqual(str, PeerUid.DATALINE_PAD_UID)) {
                i3 = 107;
            } else if (Intrinsics.areEqual(str, PeerUid.DATALINE_PHONE_UID)) {
                i3 = 120;
            } else {
                i3 = 102;
            }
            return i3;
        }
        return 101;
    }

    @Override // com.tencent.mobileqq.search.model.t
    @NotNull
    /* renamed from: l, reason: from getter */
    public String getUin() {
        return this.uin;
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: m */
    public CharSequence getDescription() {
        ISearchConvertAPI iSearchConvertAPI = (ISearchConvertAPI) QRoute.api(ISearchConvertAPI.class);
        SearchChatSummaryItem searchChatSummaryItem = this.searchChatSummaryItem;
        String keyword = this.G;
        Intrinsics.checkNotNullExpressionValue(keyword, "keyword");
        String str = this.H;
        ArrayList<String> mSplitKeywords = this.I;
        Intrinsics.checkNotNullExpressionValue(mSplitKeywords, "mSplitKeywords");
        CharSequence description = iSearchConvertAPI.getDescription(searchChatSummaryItem, keyword, str, mSplitKeywords);
        if (description == null) {
            return "";
        }
        return description;
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: t */
    public CharSequence getSubTitle() {
        CharSequence subTitle = ((ISearchConvertAPI) QRoute.api(ISearchConvertAPI.class)).getSubTitle(this.searchChatSummaryItem);
        if (subTitle == null) {
            return "";
        }
        return subTitle;
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: u */
    public CharSequence getTitle() {
        CharSequence title = ((ISearchConvertAPI) QRoute.api(ISearchConvertAPI.class)).getTitle(this.searchChatSummaryItem);
        if (title == null) {
            return "";
        }
        return title;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(@Nullable View view) {
        Context context;
        Object first;
        Object first2;
        if (J(view)) {
            return;
        }
        if (view != null) {
            context = view.getContext();
        } else {
            context = null;
        }
        if (K(context)) {
            return;
        }
        SearchChatSummaryItem searchChatSummaryItem = this.searchChatSummaryItem;
        if (searchChatSummaryItem.msgCount == 1) {
            ArrayList<SearchMsgItem> arrayList = searchChatSummaryItem.msgItem;
            Intrinsics.checkNotNullExpressionValue(arrayList, "searchChatSummaryItem.msgItem");
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            long j3 = ((SearchMsgItem) first).msgSeq;
            ArrayList<SearchMsgItem> arrayList2 = this.searchChatSummaryItem.msgItem;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "searchChatSummaryItem.msgItem");
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
            long j16 = ((SearchMsgItem) first2).msgId;
            CharSequence title = ((ISearchConvertAPI) QRoute.api(ISearchConvertAPI.class)).getTitle(this.searchChatSummaryItem);
            if (title == null) {
                title = "";
            }
            Intrinsics.checkNotNull(view);
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(view.getContext(), RouterConstants.UI_ROUTE_CHAT_ACTVITY);
            activityURIRequest.extra().putString("key_chat_name", title.toString());
            activityURIRequest.extra().putString("key_peerId", this.uid);
            activityURIRequest.extra().putInt("key_chat_type", this.chatType);
            activityURIRequest.extra().putLong("key_navigate_msgid", j16);
            activityURIRequest.extra().putLong("key_navigate_msgseq", j3);
            activityURIRequest.setFlags(268435456);
            QRoute.startUri(activityURIRequest, (o) null);
            return;
        }
        ISearchUtilFetcher iSearchUtilFetcher = (ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class);
        Intrinsics.checkNotNull(view);
        iSearchUtilFetcher.fTSEntitySearchDetailActivityLaunch(view.getContext(), getKeywords(), this.H, ((ISearchConvertAPI) QRoute.api(ISearchConvertAPI.class)).getTitle(this.searchChatSummaryItem), this.S, 2, this.uid, this.chatType, this.queryId, this.searchChatSummaryItem.msgCount);
    }
}

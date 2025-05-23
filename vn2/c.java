package vn2;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.qqnt.kernel.nativeinterface.SearchChatSummaryItem;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.search.api.ISearchConvertAPI;
import ep2.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001-Be\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\u001a\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010$j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`%\u0012\u0010\u0010)\u001a\f\u0012\u0006\b\u0001\u0012\u00020(\u0018\u00010'\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001c\u00a8\u0006."}, d2 = {"Lvn2/c;", "Lep2/d;", "", "k", "", "l", "", "u", "K", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "view", "", "v", "", "J", "I", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatSummaryItem;", "T", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatSummaryItem;", "searchChatSummaryItem", "U", "queryId", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "V", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "tempChatGameSession", "W", "Ljava/lang/String;", "uid", "X", "uin", "Lcom/tencent/common/app/AppInterface;", "app", "originalKeyword", "segmentKeyword", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "splitKeywords", "", "Lcom/tencent/mobileqq/fts/v1/FTSEntity;", "entityList", "<init>", "(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/List;Lcom/tencent/qqnt/kernel/nativeinterface/SearchChatSummaryItem;I)V", "Y", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c extends d {

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final SearchChatSummaryItem searchChatSummaryItem;

    /* renamed from: U, reason: from kotlin metadata */
    private final int queryId;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private final TempChatGameSession tempChatGameSession;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private String uid;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private String uin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@Nullable AppInterface appInterface, @Nullable String str, @Nullable String str2, @Nullable ArrayList<String> arrayList, @Nullable List<? extends FTSEntity> list, @NotNull SearchChatSummaryItem searchChatSummaryItem, int i3) {
        super(str, str2, arrayList, list);
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(searchChatSummaryItem, "searchChatSummaryItem");
        this.searchChatSummaryItem = searchChatSummaryItem;
        this.queryId = i3;
        this.uid = "";
        this.uin = "";
        ArrayList<TempChatGameSession> arrayList2 = searchChatSummaryItem.tmpChatInfo;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "searchChatSummaryItem.tmpChatInfo");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
        TempChatGameSession tempChatGameSession = (TempChatGameSession) firstOrNull;
        this.tempChatGameSession = tempChatGameSession;
        if (tempChatGameSession != null) {
            QRouteApi api = QRoute.api(IGameMsgNtApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IGameMsgNtApi::class.java)");
            IGameMsgNtApi iGameMsgNtApi = (IGameMsgNtApi) api;
            this.uid = iGameMsgNtApi.createUidFromTinyId(tempChatGameSession.selfTinyId, tempChatGameSession.peerTinyId);
            this.uin = iGameMsgNtApi.createConvertUinFromTinyId(tempChatGameSession.selfTinyId, tempChatGameSession.peerTinyId);
        }
    }

    @Override // ep2.d
    public /* bridge */ /* synthetic */ CharSequence G() {
        return (CharSequence) I();
    }

    @Override // ep2.d
    public /* bridge */ /* synthetic */ CharSequence H() {
        return (CharSequence) J();
    }

    @Nullable
    public Void I() {
        return null;
    }

    @Nullable
    public Void J() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public String getSubTitleSpans() {
        return "";
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 119;
    }

    @Override // com.tencent.mobileqq.search.model.t
    @NotNull
    /* renamed from: l, reason: from getter */
    public String getUin() {
        return this.uin;
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    public CharSequence m() {
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
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        TempChatGameSession tempChatGameSession = this.tempChatGameSession;
        if (tempChatGameSession != null) {
            return ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).getFriendNickName(tempChatGameSession);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(@Nullable View view) {
        Context context;
        TempChatGameSession tempChatGameSession;
        if (view != null) {
            context = view.getContext();
        } else {
            context = null;
        }
        Context context2 = context;
        if (context2 == null || (tempChatGameSession = this.tempChatGameSession) == null) {
            return;
        }
        if (this.searchChatSummaryItem.msgCount == 1) {
            ((IGameMsgAioNtApi) QRoute.api(IGameMsgAioNtApi.class)).enterGameMsgAio(context2, tempChatGameSession, 6);
        } else {
            ((ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class)).fTSEntitySearchDetailActivityLaunch(context2, getKeyword(), this.H, getTitleSpans(), this.S, 2, this.uid, 105, this.queryId, this.searchChatSummaryItem.msgCount);
        }
    }
}

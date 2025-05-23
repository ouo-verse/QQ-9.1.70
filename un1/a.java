package un1;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.guild.api.FeedPreloadInfo;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj1.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0015\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fH\u0016J\"\u0010\u000e\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lun1/a;", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lvn1/a;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onDetachedFromRecyclerView", "", "items", "setItems", "Ljava/lang/Runnable;", "callback", "", "position", "", "getItemId", "un1/a$a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lun1/a$a;", "scrollDispatcher", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "feedsManager", "<init>", "(Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends AsyncListDifferDelegationAdapter<vn1.a> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C11360a scrollDispatcher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"un1/a$a", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/b;", "", "fromIndex", "toIndex", "", "Lcom/tencent/mobileqq/guild/api/b;", "i", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: un1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C11360a extends com.tencent.mobileqq.guild.discoveryv2.content.base.b {
        C11360a() {
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.b
        @NotNull
        public List<FeedPreloadInfo> i(int fromIndex, int toIndex) {
            vn1.b bVar;
            Object obj;
            GProStFeed gProStFeed;
            h d16;
            List<vn1.a> items = a.this.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "items");
            List<vn1.a> g16 = g(items, fromIndex, toIndex);
            ArrayList arrayList = new ArrayList();
            for (vn1.a aVar : g16) {
                FeedPreloadInfo feedPreloadInfo = null;
                if (aVar instanceof vn1.b) {
                    bVar = (vn1.b) aVar;
                } else {
                    bVar = null;
                }
                if (bVar != null && (d16 = bVar.d()) != null) {
                    obj = d16.a();
                } else {
                    obj = null;
                }
                if (obj instanceof GProStFeed) {
                    gProStFeed = (GProStFeed) obj;
                } else {
                    gProStFeed = null;
                }
                if (gProStFeed != null && ((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).checkCanPreload(gProStFeed)) {
                    String str = gProStFeed.poster.nick;
                    Intrinsics.checkNotNullExpressionValue(str, "gproStFeed.poster.nick");
                    GProStChannelSign gProStChannelSign = gProStFeed.channelInfo.sign;
                    long j3 = gProStChannelSign.guildId;
                    long j16 = gProStChannelSign.channelId;
                    String str2 = gProStFeed.idd;
                    Intrinsics.checkNotNullExpressionValue(str2, "gproStFeed.idd");
                    String str3 = gProStFeed.poster.idd;
                    Intrinsics.checkNotNullExpressionValue(str3, "gproStFeed.poster.idd");
                    feedPreloadInfo = new FeedPreloadInfo(str, j3, j16, str2, str3, gProStFeed.createTime, gProStFeed.meta.lastModifiedTime);
                }
                if (feedPreloadInfo != null) {
                    arrayList.add(feedPreloadInfo);
                }
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull AdapterDelegatesManager<List<vn1.a>> feedsManager) {
        super(d.f439267a, feedsManager);
        Intrinsics.checkNotNullParameter(feedsManager, "feedsManager");
        this.scrollDispatcher = new C11360a();
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return getItems().get(position).getItemId();
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.scrollDispatcher.b(recyclerView);
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.scrollDispatcher.c(recyclerView);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        this.scrollDispatcher.d(holder);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        this.scrollDispatcher.e(holder);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter
    public void setItems(@Nullable List<vn1.a> items) {
        super.setItems(items);
        this.scrollDispatcher.h(items);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter
    public void setItems(@Nullable List<vn1.a> items, @Nullable Runnable callback) {
        super.setItems(items, callback);
        this.scrollDispatcher.h(items);
    }
}

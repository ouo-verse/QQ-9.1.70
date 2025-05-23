package q90;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import feedcloud.FeedCloudRead$StCollectionDetail;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010(\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001b\u00a8\u0006-"}, d2 = {"Lq90/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lq90/b;", "", "Lfeedcloud/FeedCloudRead$StCollectionDetail;", "details", "", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "i0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "detailsList", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getAlbumScheme", "()Ljava/lang/String;", "l0", "(Ljava/lang/String;)V", "albumScheme", "Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;", "D", "Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;", "getSearchInfo", "()Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;", "m0", "(Lcom/tencent/biz/qqcircle/immersive/bean/QFSSearchInfo;)V", "searchInfo", "E", "getAlbumId", "k0", "albumId", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c extends RecyclerView.Adapter<b> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QFSSearchInfo searchInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<FeedCloudRead$StCollectionDetail> detailsList = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String albumScheme = "";

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String albumId = "";

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.detailsList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (ab0.a.a(position, this.detailsList)) {
            return;
        }
        FeedCloudRead$StCollectionDetail feedCloudRead$StCollectionDetail = this.detailsList.get(position);
        holder.s(this.searchInfo);
        holder.r(this.albumScheme);
        holder.q(this.albumId);
        holder.l(feedCloudRead$StCollectionDetail, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grs, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new b(itemView);
    }

    public final void k0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final void l0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumScheme = str;
    }

    public final void m0(@Nullable QFSSearchInfo qFSSearchInfo) {
        this.searchInfo = qFSSearchInfo;
    }

    public final void setData(@NotNull List<FeedCloudRead$StCollectionDetail> details) {
        Intrinsics.checkNotNullParameter(details, "details");
        this.detailsList.clear();
        this.detailsList.addAll(details);
        if (this.detailsList.size() >= 6) {
            this.detailsList.add(new FeedCloudRead$StCollectionDetail());
        }
        notifyDataSetChanged();
    }
}

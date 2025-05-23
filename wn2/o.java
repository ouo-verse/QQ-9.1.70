package wn2;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.SearchCoreBuddyItem;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010$\u001a\u00020\u0006\u0012\u0006\u0010%\u001a\u00020\u0014\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lwn2/o;", "Lcom/tencent/mobileqq/search/model/k;", "Landroid/view/View;", "view", "", "v", "", "k", "", "l", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", ReportConstant.COSTREPORT_PREFIX, "", "r", "", "G", "M", "keyword", "", "N", "L", "K", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchCoreBuddyItem;", "X", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchCoreBuddyItem;", "getItem", "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchCoreBuddyItem;", "setItem", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchCoreBuddyItem;)V", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Y", "Ljava/lang/String;", "Lcom/tencent/common/app/AppInterface;", "app", IProfileCardConst.KEY_FROM_TYPE, "recentIndex", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchCoreBuddyItem;Ljava/lang/String;Lcom/tencent/common/app/AppInterface;IJ)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class o extends com.tencent.mobileqq.search.model.k {

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private SearchCoreBuddyItem item;

    /* renamed from: Y, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public String keyword;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull SearchCoreBuddyItem item, @NotNull String keyword, @NotNull AppInterface app, int i3, long j3) {
        super(app, i3, j3);
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(app, "app");
        this.item = item;
        this.keyword = keyword;
    }

    @Override // com.tencent.mobileqq.search.model.k
    @NotNull
    public Object G() {
        return String.valueOf(this.item.uin);
    }

    @Override // com.tencent.mobileqq.search.model.k
    @NotNull
    public String K() {
        return "";
    }

    @Override // com.tencent.mobileqq.search.model.k
    @NotNull
    /* renamed from: L */
    public String getTitle() {
        boolean z16;
        String str;
        String str2 = this.item.remark;
        boolean z17 = false;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            String str3 = this.item.nick;
            if (str3 == null || str3.length() == 0) {
                z17 = true;
            }
            if (z17) {
                str = String.valueOf(this.item.uin);
            } else {
                str = this.item.nick;
            }
            Intrinsics.checkNotNullExpressionValue(str, "{\n            if (item.n\u2026k\n            }\n        }");
            return str;
        }
        String str4 = this.item.remark;
        Intrinsics.checkNotNullExpressionValue(str4, "{\n            item.remark\n        }");
        return str4;
    }

    @Override // com.tencent.mobileqq.search.model.k
    public int M() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.k
    protected long N(@Nullable String keyword) {
        return 0L;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.t
    @NotNull
    /* renamed from: l */
    public String getUin() {
        return String.valueOf(this.item.uin);
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: m */
    public CharSequence getDescription() {
        return "\u6765\u81ea\u5206\u7ec4\uff1a\u7279\u522b\u5173\u5fc3";
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    public CharSequence o() {
        return "";
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    @NotNull
    /* renamed from: s, reason: from getter */
    public String getKeyword() {
        return this.keyword;
    }

    @Override // com.tencent.mobileqq.search.model.k, com.tencent.mobileqq.search.model.y
    public void v(@Nullable View view) {
        super.v(view);
        ISearchPieceFetcher iSearchPieceFetcher = (ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class);
        Intrinsics.checkNotNull(view);
        iSearchPieceFetcher.setContactSearchRecentAndHistoryWithoutFriend(view.getContext(), this.G, getUin(), this.item.nick, this.keyword, view);
        SearchUtils.f1(this.G, getTitle(), getUin(), "", 0);
    }
}

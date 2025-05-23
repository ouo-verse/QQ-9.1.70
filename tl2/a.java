package tl2;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.web.WebPageData;
import com.tencent.mobileqq.qwallet.web.WebViewWithOutTitleFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Ltl2/a;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "position", "", "getItemId", "getItemCount", "Landroidx/fragment/app/Fragment;", "createFragment", "", "Lcom/tencent/mobileqq/qwallet/web/WebPageData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "webPageItemList", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/util/List;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a extends FragmentStateAdapter {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<WebPageData> webPageItemList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Fragment fragment, @NotNull List<WebPageData> webPageItemList) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(webPageItemList, "webPageItemList");
        this.webPageItemList = webPageItemList;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int position) {
        WebPageData webPageData = this.webPageItemList.get(position);
        WebViewWithOutTitleFragment webViewWithOutTitleFragment = new WebViewWithOutTitleFragment();
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        intent.putExtra("url", webPageData.getUrl());
        bundle.putParcelable("intent", intent);
        webViewWithOutTitleFragment.setArguments(bundle);
        return webViewWithOutTitleFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.webPageItemList.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        int i3;
        String url = this.webPageItemList.get(position).getUrl();
        if (url != null) {
            i3 = url.hashCode();
        } else {
            i3 = 0;
        }
        return i3;
    }
}

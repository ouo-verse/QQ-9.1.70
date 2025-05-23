package s14;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.robot.adelie.homepage.category.viewmodel.BannerDelegateData;
import com.tencent.robot.adelie.homepage.category.viewmodel.HotDelegateData;
import com.tencent.robot.adelie.homepage.category.viewmodel.RecommendCardType;
import com.tencent.robot.adelie.homepage.category.viewmodel.RegularDelegateData;
import com.tencent.robot.adelie.homepage.category.viewmodel.RoleDelegateData;
import com.tencent.robot.adelie.homepage.category.viewmodel.ToolDelegateData;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c extends AsyncListDifferDelegationAdapter<com.tencent.robot.adelie.homepage.category.viewmodel.a> {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends DiffUtil.ItemCallback<com.tencent.robot.adelie.homepage.category.viewmodel.a> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NonNull com.tencent.robot.adelie.homepage.category.viewmodel.a aVar, @NonNull com.tencent.robot.adelie.homepage.category.viewmodel.a aVar2) {
            return Objects.equals(aVar, aVar2);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NonNull com.tencent.robot.adelie.homepage.category.viewmodel.a aVar, @NonNull com.tencent.robot.adelie.homepage.category.viewmodel.a aVar2) {
            return Objects.equals(aVar, aVar2);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object getChangePayload(@NonNull com.tencent.robot.adelie.homepage.category.viewmodel.a aVar, @NonNull com.tencent.robot.adelie.homepage.category.viewmodel.a aVar2) {
            return new Object();
        }
    }

    public c(AdapterDelegatesManager adapterDelegatesManager) {
        super(new a(), adapterDelegatesManager);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        RobotCoreInfo data;
        List<com.tencent.robot.adelie.homepage.category.viewmodel.a> items = getItems();
        if (items != null && items.size() != 0 && i3 < items.size()) {
            com.tencent.robot.adelie.homepage.category.viewmodel.a aVar = items.get(i3);
            if (!(aVar instanceof BannerDelegateData) && !(aVar instanceof HotDelegateData) && !(aVar instanceof RoleDelegateData) && !(aVar instanceof ToolDelegateData)) {
                if ((aVar instanceof RegularDelegateData) && (data = ((RegularDelegateData) aVar).getData()) != null) {
                    return data.robotUin;
                }
                return i3;
            }
            return aVar.hashCode();
        }
        return i3;
    }

    public boolean i0(int i3) {
        List<com.tencent.robot.adelie.homepage.category.viewmodel.a> items = getItems();
        if (items == null || items.size() == 0 || i3 >= items.size() || items.get(i3).getType() != RecommendCardType.REGULAR) {
            return true;
        }
        return false;
    }
}

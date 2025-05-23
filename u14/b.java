package u14;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.robot.adelie.homepage.category.section.h;
import com.tencent.robot.adelie.homepage.category.viewmodel.RegularDelegateData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b extends AbsItemAdapterDelegate<RegularDelegateData, com.tencent.robot.adelie.homepage.category.viewmodel.a> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NonNull com.tencent.robot.adelie.homepage.category.viewmodel.a aVar, @NonNull List<com.tencent.robot.adelie.homepage.category.viewmodel.a> list, int i3) {
        return aVar instanceof RegularDelegateData;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.ds6;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull List<Class<? extends Section<RegularDelegateData>>> list) {
        list.add(h.class);
    }
}

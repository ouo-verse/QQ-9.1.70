package z80;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.R;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.HashMap;
import java.util.List;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends BaseListViewAdapter<ba0.b> {
    private void i0(View view, ba0.b bVar) {
        FeedCloudCommon$StCommonExt e16 = bVar.e();
        if (e16 != null && e16.has()) {
            List<FeedCloudCommon$Entry> list = e16.mapInfo.get();
            if (list.isEmpty()) {
                return;
            }
            HashMap hashMap = new HashMap(list.size());
            String str = null;
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
                String str2 = feedCloudCommon$Entry.key.get();
                String str3 = feedCloudCommon$Entry.value.get();
                if ("elementId".equals(str2)) {
                    str = str3;
                } else {
                    hashMap.put(str2, str3);
                }
            }
            hashMap.put("xsj_query_text", bVar.d());
            if (!TextUtils.isEmpty(str)) {
                i.k(view, str, hashMap, bVar.hashCode());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof ba0.a) {
            ba0.b bVar = (ba0.b) this.mDataList.get(i3);
            ((ba0.a) viewHolder).t(bVar, i3);
            i0(viewHolder.itemView, bVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new ba0.a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168754gr4, viewGroup, false));
    }
}

package sa;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.block.aa;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e extends aa {
    @Override // com.qzone.reborn.feedx.block.aa, androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        QLog.d("QZAlbumxListLoadMoreAdapter", 1, "onCreateViewHolder  hashcode = " + hashCode());
        aa.b bVar = new aa.b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f128072d, viewGroup, false));
        this.f54760m = bVar;
        return bVar;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter
    public void setLoadState(boolean z16, boolean z17) {
        super.setLoadState(z16, z17);
        if (z17) {
            return;
        }
        onLoadMoreEnd(false);
    }
}

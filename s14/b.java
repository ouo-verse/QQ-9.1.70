package s14;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.qqmc.RobotQQMC;
import com.tencent.util.LoadingUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b extends RFWAbsLoadMoreAdapter {
    private AtomicBoolean C = new AtomicBoolean(false);
    private boolean D = !RobotQQMC.INSTANCE.enableHomePageBottomTab();

    /* renamed from: m, reason: collision with root package name */
    private a f433080m;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a extends RecyclerView.ViewHolder {
        private final ImageView E;
        private final TextView F;

        public a(View view) {
            super(view);
            ImageView imageView = (ImageView) view.findViewById(R.id.ysu);
            this.E = imageView;
            this.F = (TextView) view.findViewById(R.id.yt9);
            imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(view.getContext(), 2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return BusinessInfoCheckUpdateItem.UIAPPID_AIO_ADD;
    }

    public void hide() {
        this.C.getAndSet(true);
        a aVar = this.f433080m;
        if (aVar == null) {
            return;
        }
        aVar.itemView.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter, com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter
    public void onAdapterDestroyed(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        super.onAdapterDestroyed(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f167571ds3, viewGroup, false));
        this.f433080m = aVar;
        if (this.D) {
            ((LinearLayout) aVar.itemView.findViewById(R.id.ysh)).setVisibility(8);
        }
        if (this.C.get()) {
            this.f433080m.itemView.setVisibility(8);
        }
        return this.f433080m;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("AdelieLoadMoreAdapter", 1, "onLoadMoreEnd hasMore: " + z16 + ",mLoadMoreViewHolder = " + this.f433080m);
        }
        a aVar = this.f433080m;
        if (aVar == null) {
            return;
        }
        aVar.E.setVisibility(8);
        if (z16) {
            this.f433080m.F.setText("\u52a0\u8f7d\u5b8c\u6210");
        } else {
            this.f433080m.F.setText("\u6ca1\u6709\u66f4\u591a\u6570\u636e\u5566");
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        if (QLog.isColorLevel()) {
            QLog.d("AdelieLoadMoreAdapter", 1, "onLoadMoreStart mLoadMoreViewHolder: " + this.f433080m);
        }
        a aVar = this.f433080m;
        if (aVar == null) {
            return;
        }
        aVar.E.setVisibility(0);
        this.f433080m.F.setText("\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u5019\u2026");
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter
    public void setLoadState(boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("AdelieLoadMoreAdapter", 1, "setLoadState start isLoading: " + z16 + ",hasMore = " + z17 + ",mIsLoading = " + isLoadingMore() + ",mHasMore = " + canLoadMore());
        }
        super.setLoadState(z16, z17);
    }

    public void show() {
        this.C.getAndSet(false);
        a aVar = this.f433080m;
        if (aVar == null) {
            return;
        }
        aVar.itemView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter
    public void startLoadMore(int i3, int i16, int i17) {
        if (this.mRecyclerView == null) {
            return;
        }
        super.startLoadMore(i3, i16, i17);
    }
}

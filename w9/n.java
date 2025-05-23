package w9;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J*\u0010\u0012\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lw9/n;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "", "v", "comment", "w", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "u", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "mReplyList", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "f", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "mConcatAdapter", "Li9/e;", tl.h.F, "Li9/e;", "mReplyListAdapter", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class n extends com.qzone.reborn.base.l<Comment> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mReplyList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter mConcatAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private i9.e mReplyListAdapter;

    private final void v() {
        i9.e eVar = new i9.e();
        this.mReplyListAdapter = eVar;
        Intrinsics.checkNotNull(eVar);
        eVar.setHasStableIds(true);
        this.mConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.mReplyListAdapter});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(Comment data, int position, List<Object> payload) {
        w(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f199472};
    }

    private final void w(Comment comment) {
        if (comment == null) {
            return;
        }
        List<Reply> list = comment.replies;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Reply reply = list.get(i3);
                if (reply != null) {
                    com.qzone.reborn.albumx.common.bean.g gVar = new com.qzone.reborn.albumx.common.bean.g();
                    gVar.e(reply.replyId);
                    gVar.f(reply);
                    gVar.d(comment);
                    arrayList.add(gVar);
                }
            }
            i9.e eVar = this.mReplyListAdapter;
            if (eVar == null) {
                return;
            }
            eVar.setItems(arrayList);
            return;
        }
        i9.e eVar2 = this.mReplyListAdapter;
        if (eVar2 == null) {
            return;
        }
        eVar2.setItems(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        RecyclerView recyclerView = containerView != null ? (RecyclerView) containerView.findViewById(R.id.ml9) : null;
        this.mReplyList = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new SafeLinearLayoutManager(p()));
        }
        RecyclerView recyclerView2 = this.mReplyList;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(null);
        }
        v();
        RecyclerView recyclerView3 = this.mReplyList;
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setAdapter(this.mConcatAdapter);
    }
}

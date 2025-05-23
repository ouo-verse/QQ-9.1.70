package w9;

import android.view.View;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lw9/ad;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/g;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "w", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mCommentTime", "f", "mCommentReplyText", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class ad extends com.qzone.reborn.base.l<com.qzone.reborn.albumx.common.bean.g> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mCommentTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mCommentReplyText;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(View view, final ad this$0, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWIocAbilityProvider.g().getIoc(l9.g.class).originView(view).done(new OnPromiseResolved() { // from class: w9.ac
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                ad.y(ad.this, (l9.g) obj);
            }
        }).run();
        EventCollector.getInstance().onViewClicked(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void y(ad this$0, l9.g gVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        T mData = this$0.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        gVar.S1((com.qzone.reborn.albumx.common.bean.g) mData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(com.qzone.reborn.albumx.common.bean.g data, int position, List<Object> payload) {
        Reply stReply;
        User user;
        Reply stReply2;
        User user2;
        Reply stReply3;
        TextView textView = this.mCommentTime;
        if (textView != null) {
            textView.setText(rn.a.b((data == null || (stReply3 = data.getStReply()) == null) ? 0L : stReply3.date * 1000));
        }
        boolean z16 = false;
        if (data != null && (stReply2 = data.getStReply()) != null && (user2 = stReply2.user) != null && user2.uin == LoginData.getInstance().getUin()) {
            z16 = true;
        }
        if (!z16) {
            if (!Intrinsics.areEqual((data == null || (stReply = data.getStReply()) == null || (user = stReply.user) == null) ? null : user.uid, LoginData.getInstance().getUid())) {
                return;
            }
        }
        TextView textView2 = this.mCommentReplyText;
        if (textView2 == null) {
            return;
        }
        textView2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f199573};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(final View containerView) {
        this.mCommentTime = containerView != null ? (TextView) containerView.findViewById(R.id.f162773mk1) : null;
        TextView textView = containerView != null ? (TextView) containerView.findViewById(R.id.ml_) : null;
        this.mCommentReplyText = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: w9.ab
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ad.x(containerView, this, view);
                }
            });
        }
    }
}

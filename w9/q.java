package w9;

import android.view.View;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J*\u0010\u0010\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lw9/q;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "w", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mCommentTime", "f", "mCommentReplyText", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class q extends com.qzone.reborn.base.l<Comment> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mCommentTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mCommentReplyText;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(View view, final q this$0, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWIocAbilityProvider.g().getIoc(l9.g.class).originView(view).done(new OnPromiseResolved() { // from class: w9.p
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                q.y(q.this, (l9.g) obj);
            }
        }).run();
        EventCollector.getInstance().onViewClicked(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void y(q this$0, l9.g gVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        T mData = this$0.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        gVar.q0((Comment) mData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z() {
        TextView textView;
        TextView textView2 = this.mCommentTime;
        if (textView2 == null || this.mData == 0) {
            return;
        }
        Intrinsics.checkNotNull(textView2);
        textView2.setText(rn.a.b(((Comment) this.mData).time * 1000));
        if ((((Comment) this.mData).user.uin == LoginData.getInstance().getUin() || Intrinsics.areEqual(((Comment) this.mData).user.uid, LoginData.getInstance().getUid())) && (textView = this.mCommentReplyText) != null) {
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(final View containerView) {
        Intrinsics.checkNotNull(containerView);
        this.mCommentTime = (TextView) containerView.findViewById(R.id.f162773mk1);
        TextView textView = (TextView) containerView.findViewById(R.id.ml_);
        this.mCommentReplyText = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: w9.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.x(containerView, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(Comment data, int position, List<Object> payload) {
        z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f199573};
    }
}

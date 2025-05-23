package w9;

import android.text.TextUtils;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\u0014\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lw9/aa;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/g;", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "reply", "", "K", "L", "J", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "e", "Ljava/lang/String;", "TAG", "f", "REPLY_TO_TARGET_USER_HEADER", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", tl.h.F, "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "mNickName", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "mAvatar", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mReplyContent", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class aa extends com.qzone.reborn.base.l<com.qzone.reborn.albumx.common.bean.g> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "CommonReplyContentSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String REPLY_TO_TARGET_USER_HEADER = "\u56de\u590d";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneNickNameView mNickName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView mAvatar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView mReplyContent;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(View view, final aa this$0, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWIocAbilityProvider.g().getIoc(l9.g.class).originView(view).done(new OnPromiseResolved() { // from class: w9.z
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                aa.C(aa.this, (l9.g) obj);
            }
        }).run();
        EventCollector.getInstance().onViewClicked(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void C(aa this$0, l9.g gVar) {
        User user;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Reply stReply = ((com.qzone.reborn.albumx.common.bean.g) this$0.mData).getStReply();
        if (stReply == null || (user = stReply.user) == null) {
            return;
        }
        gVar.X7(user);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(View view, final aa this$0, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWIocAbilityProvider.g().getIoc(l9.g.class).originView(view).done(new OnPromiseResolved() { // from class: w9.y
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                aa.F(aa.this, (l9.g) obj);
            }
        }).run();
        EventCollector.getInstance().onViewClicked(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void F(aa this$0, l9.g gVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        T mData = this$0.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        gVar.S1((com.qzone.reborn.albumx.common.bean.g) mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G(View view, final aa this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWIocAbilityProvider.g().getIoc(l9.g.class).originView(view).done(new OnPromiseResolved() { // from class: w9.x
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                aa.H(aa.this, (l9.g) obj);
            }
        }).run();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void H(aa this$0, l9.g gVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QZoneRichTextView qZoneRichTextView = this$0.mReplyContent;
        Intrinsics.checkNotNull(qZoneRichTextView);
        T mData = this$0.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        gVar.r1(qZoneRichTextView, (com.qzone.reborn.albumx.common.bean.g) mData);
    }

    private final void K(Reply reply) {
        User user;
        QZoneUserAvatarView qZoneUserAvatarView = this.mAvatar;
        if (qZoneUserAvatarView != null) {
            qZoneUserAvatarView.setUser((reply == null || (user = reply.user) == null) ? 0L : user.uin);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f20097g};
    }

    private final void L(Reply reply) {
        User user;
        String str = (reply == null || (user = reply.user) == null) ? null : user.nickName;
        QZoneNickNameView qZoneNickNameView = this.mNickName;
        if (qZoneNickNameView != null) {
            qZoneNickNameView.setRichText(str);
        }
        QZoneNickNameView qZoneNickNameView2 = this.mNickName;
        if (qZoneNickNameView2 != null) {
            qZoneNickNameView2.setMaxLine(1);
        }
    }

    private final void J(Reply reply) {
        String str = reply != null ? reply.content : null;
        if ((reply != null ? reply.targetUser : null) != null && !TextUtils.isEmpty(reply.targetUser.nickName)) {
            str = this.REPLY_TO_TARGET_USER_HEADER + " " + reply.targetUser.nickName + MsgSummary.STR_COLON + str;
        }
        QZoneRichTextView qZoneRichTextView = this.mReplyContent;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setRichText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindData(com.qzone.reborn.albumx.common.bean.g data, int position, List<Object> payload) {
        K(data != null ? data.getStReply() : null);
        L(data != null ? data.getStReply() : null);
        J(data != null ? data.getStReply() : null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(final View containerView) {
        this.mNickName = containerView != null ? (QZoneNickNameView) containerView.findViewById(R.id.f162778ml1) : null;
        this.mAvatar = containerView != null ? (QZoneUserAvatarView) containerView.findViewById(R.id.mlp) : null;
        this.mReplyContent = containerView != null ? (QZoneRichTextView) containerView.findViewById(R.id.mld) : null;
        QZoneNickNameView qZoneNickNameView = this.mNickName;
        if (qZoneNickNameView != null) {
            qZoneNickNameView.setOnClickListener(new View.OnClickListener() { // from class: w9.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    aa.B(containerView, this, view);
                }
            });
        }
        QZoneRichTextView qZoneRichTextView = this.mReplyContent;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setOnClickListener(new View.OnClickListener() { // from class: w9.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    aa.D(containerView, this, view);
                }
            });
        }
        QZoneRichTextView qZoneRichTextView2 = this.mReplyContent;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: w9.w
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean G;
                    G = aa.G(containerView, this, view);
                    return G;
                }
            });
        }
        QZoneRichTextView qZoneRichTextView3 = this.mReplyContent;
        if (qZoneRichTextView3 != null) {
            qZoneRichTextView3.setTextColorLink(ResourcesCompat.getColor(qZoneRichTextView3.getResources(), R.color.f156540dj, null));
        }
    }
}

package w9;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.feedx.widget.comment.QZoneFeedxCommentImageItem;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\u0014\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010*\u00a8\u0006."}, d2 = {"Lw9/l;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "comment", "", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "L", "M", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", BdhLogUtil.LogTag.Tag_Conn, "", "e", "Ljava/lang/String;", "TAG", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "f", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "mNickName", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", tl.h.F, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "mAvatar", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mCommentContent", "Landroidx/recyclerview/widget/RecyclerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView;", "mCommentPictureGridView", "Lcom/qzone/reborn/feedx/widget/comment/a;", "Lcom/qzone/reborn/feedx/widget/comment/a;", "mCommentImageAdapter", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class l extends com.qzone.reborn.base.l<Comment> {

    /* renamed from: C, reason: from kotlin metadata */
    private com.qzone.reborn.feedx.widget.comment.a mCommentImageAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "CommonCommentContentSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneNickNameView mNickName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView mAvatar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView mCommentContent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mCommentPictureGridView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(View view, final l this$0, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWIocAbilityProvider.g().getIoc(l9.g.class).originView(view).done(new OnPromiseResolved() { // from class: w9.h
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                l.F(l.this, (l9.g) obj);
            }
        }).run();
        EventCollector.getInstance().onViewClicked(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void F(l this$0, l9.g gVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        User user = ((Comment) this$0.mData).user;
        Intrinsics.checkNotNullExpressionValue(user, "mData.user");
        gVar.X7(user);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(View view, final l this$0, View view2) {
        EventCollector.getInstance().onViewClickedBefore(view2);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWIocAbilityProvider.g().getIoc(l9.g.class).originView(view).done(new OnPromiseResolved() { // from class: w9.j
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                l.H(l.this, (l9.g) obj);
            }
        }).run();
        EventCollector.getInstance().onViewClicked(view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void H(l this$0, l9.g gVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        T mData = this$0.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        gVar.v8((Comment) mData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J(View view, final l this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWIocAbilityProvider.g().getIoc(l9.g.class).originView(view).done(new OnPromiseResolved() { // from class: w9.k
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                l.K(l.this, (l9.g) obj);
            }
        }).run();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void K(l this$0, l9.g gVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QZoneRichTextView qZoneRichTextView = this$0.mCommentContent;
        Intrinsics.checkNotNull(qZoneRichTextView);
        T mData = this$0.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        gVar.W3(qZoneRichTextView, (Comment) mData);
    }

    private final void L(Comment comment) {
        QZoneRichTextView qZoneRichTextView = this.mCommentContent;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setRichText(comment != null ? comment.comment : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(l this$0, final Comment comment, final View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWIocAbilityProvider.g().getIoc(l9.g.class).originView(this$0.mRootView).done(new OnPromiseResolved() { // from class: w9.i
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                l.O(view, comment, (l9.g) obj);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(View view, Comment comment, l9.g gVar) {
        Intrinsics.checkNotNull(view);
        gVar.W3(view, comment);
    }

    private final void P(Comment comment) {
        User user;
        QZoneUserAvatarView qZoneUserAvatarView = this.mAvatar;
        if (qZoneUserAvatarView != null) {
            qZoneUserAvatarView.setUser((comment == null || (user = comment.user) == null) ? 0L : user.uin);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onBindData(Comment data, int position, List<Object> payload) {
        P(data);
        Q(data);
        L(data);
        M(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(final View containerView) {
        Intrinsics.checkNotNull(containerView);
        this.mNickName = (QZoneNickNameView) containerView.findViewById(R.id.f162778ml1);
        this.mAvatar = (QZoneUserAvatarView) containerView.findViewById(R.id.mlp);
        this.mCommentContent = (QZoneRichTextView) containerView.findViewById(R.id.mld);
        RecyclerView recyclerView = (RecyclerView) containerView.findViewById(R.id.msz);
        this.mCommentPictureGridView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(containerView.getContext(), 0, false));
        }
        QZoneNickNameView qZoneNickNameView = this.mNickName;
        if (qZoneNickNameView != null) {
            qZoneNickNameView.setOnClickListener(new View.OnClickListener() { // from class: w9.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.D(containerView, this, view);
                }
            });
        }
        QZoneRichTextView qZoneRichTextView = this.mCommentContent;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setOnClickListener(new View.OnClickListener() { // from class: w9.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.G(containerView, this, view);
                }
            });
        }
        QZoneRichTextView qZoneRichTextView2 = this.mCommentContent;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setOnLongClickListener(new View.OnLongClickListener() { // from class: w9.g
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean J;
                    J = l.J(containerView, this, view);
                    return J;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f199270};
    }

    private final void Q(Comment comment) {
        User user;
        String str = (comment == null || (user = comment.user) == null) ? null : user.nickName;
        QZoneNickNameView qZoneNickNameView = this.mNickName;
        if (qZoneNickNameView != null) {
            qZoneNickNameView.setRichText(str);
        }
        QZoneNickNameView qZoneNickNameView2 = this.mNickName;
        if (qZoneNickNameView2 != null) {
            qZoneNickNameView2.setMaxLine(1);
        }
    }

    private final void M(final Comment comment) {
        ArrayList<PictureItem> arrayList;
        if (comment == null) {
            RecyclerView recyclerView = this.mCommentPictureGridView;
            if (recyclerView == null) {
                return;
            }
            recyclerView.setVisibility(8);
            return;
        }
        ArrayList<PictureItem> arrayList2 = comment.commentPictureItems;
        if (arrayList2 != null && arrayList2.size() > 0) {
            arrayList = comment.commentPictureItems;
            Intrinsics.checkNotNullExpressionValue(arrayList, "{\n                commen\u2026s //\u8bc4\u8bba\u63d2\u56fe\u7684\u56fe\u7247\n            }");
        } else {
            arrayList = new ArrayList<>();
        }
        if (bl.b(arrayList)) {
            RecyclerView recyclerView2 = this.mCommentPictureGridView;
            if (recyclerView2 == null) {
                return;
            }
            recyclerView2.setVisibility(8);
            return;
        }
        RecyclerView recyclerView3 = this.mCommentPictureGridView;
        if (recyclerView3 != null) {
            recyclerView3.setVisibility(0);
        }
        if (this.mCommentImageAdapter == null) {
            com.qzone.reborn.feedx.widget.comment.a aVar = new com.qzone.reborn.feedx.widget.comment.a();
            this.mCommentImageAdapter = aVar;
            Intrinsics.checkNotNull(aVar);
            aVar.j0(new QZoneFeedxCommentImageItem.d() { // from class: w9.d
                @Override // com.qzone.reborn.feedx.widget.comment.QZoneFeedxCommentImageItem.d
                public final void a(View view, int i3) {
                    l.N(l.this, comment, view, i3);
                }
            });
            RecyclerView recyclerView4 = this.mCommentPictureGridView;
            if (recyclerView4 != null) {
                recyclerView4.setAdapter(this.mCommentImageAdapter);
            }
        }
        com.qzone.reborn.feedx.widget.comment.a aVar2 = this.mCommentImageAdapter;
        Intrinsics.checkNotNull(aVar2);
        aVar2.i0(comment);
        com.qzone.reborn.feedx.widget.comment.a aVar3 = this.mCommentImageAdapter;
        Intrinsics.checkNotNull(aVar3);
        aVar3.setDatas(arrayList);
    }
}

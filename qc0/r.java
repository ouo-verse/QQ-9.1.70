package qc0;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalFeedUrgeCardFrameLayout;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lqc0/r;", "Lcom/tencent/biz/qqcircle/bizparts/c;", "Landroid/os/Bundle;", "initParams", "", "onInitBlock", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "p0", "loadData", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "adapter", "Lcom/tencent/biz/richframework/widget/BaseWidgetView;", "createBlockRootView", "", "getLogTag", "Lcom/tencent/biz/qqcircle/immersive/personal/data/w;", "userInfoData", "i0", "Lcom/tencent/biz/qqcircle/immersive/personal/part/QFSPersonalFeedUrgeCardFrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/immersive/personal/part/QFSPersonalFeedUrgeCardFrameLayout;", "mUrgeCardFragment", "D", "Lcom/tencent/biz/qqcircle/immersive/personal/data/w;", "mUserInfoData", "<init>", "()V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class r extends com.tencent.biz.qqcircle.bizparts.c {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QFSPersonalFeedUrgeCardFrameLayout mUrgeCardFragment;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private w mUserInfoData;

    public r() {
        super(new Bundle());
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    @Nullable
    protected BaseWidgetView<?> createBlockRootView(@Nullable ViewGroup viewGroup, @Nullable MultiViewBlock<?> adapter) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QFSPersonalFeedUrgeCardFrameLayout qFSPersonalFeedUrgeCardFrameLayout = new QFSPersonalFeedUrgeCardFrameLayout(context);
        this.mUrgeCardFragment = qFSPersonalFeedUrgeCardFrameLayout;
        qFSPersonalFeedUrgeCardFrameLayout.l0(this.mUserInfoData);
        QFSPersonalFeedUrgeCardFrameLayout qFSPersonalFeedUrgeCardFrameLayout2 = this.mUrgeCardFragment;
        if (qFSPersonalFeedUrgeCardFrameLayout2 != null) {
            qFSPersonalFeedUrgeCardFrameLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
        return this.mUrgeCardFragment;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    @NotNull
    protected String getLogTag() {
        return "QFSPYMKUrgeCardAdapter";
    }

    public final void i0(@Nullable w userInfoData) {
        this.mUserInfoData = userInfoData;
        QFSPersonalFeedUrgeCardFrameLayout qFSPersonalFeedUrgeCardFrameLayout = this.mUrgeCardFragment;
        if (qFSPersonalFeedUrgeCardFrameLayout != null) {
            qFSPersonalFeedUrgeCardFrameLayout.l0(userInfoData);
        }
        notifyDataSetChanged();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(@Nullable LoadInfo p06) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(@Nullable Bundle initParams) {
    }
}

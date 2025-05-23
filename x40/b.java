package x40;

import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QFSReportBottomSheetPart;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.bizparts.aw;
import com.tencent.biz.qqcircle.bizparts.bq;
import com.tencent.biz.qqcircle.bizparts.bv;
import com.tencent.biz.qqcircle.bizparts.bz;
import com.tencent.biz.qqcircle.bizparts.de;
import com.tencent.biz.qqcircle.helpers.f;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.part.QFSEmojiCommentPanelPart;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerPageDecorationPopupWindowPart;
import com.tencent.biz.qqcircle.immersive.part.QFSMainShoppingCartPart;
import com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipPart;
import com.tencent.biz.qqcircle.immersive.part.QFSPushBoxSharePart;
import com.tencent.biz.qqcircle.immersive.part.QFSPushRocketProgressPart;
import com.tencent.biz.qqcircle.immersive.part.QFSTagPolymerizationTaskDoneDialogPart;
import com.tencent.biz.qqcircle.immersive.part.ak;
import com.tencent.biz.qqcircle.immersive.part.cp;
import com.tencent.biz.qqcircle.immersive.part.ex;
import com.tencent.biz.qqcircle.immersive.part.ez;
import com.tencent.biz.qqcircle.immersive.search.QFSPersonalPanelPart;
import com.tencent.biz.qqcircle.utils.cb;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import feedcloud.FeedCloudMeta$StFeed;
import g50.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import y40.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"Lx40/b;", "Lz40/a;", "Lcom/tencent/biz/qqcircle/immersive/layer/base/a;", "builder", "", "Lcom/tencent/biz/richframework/part/Part;", "e", "", "w", "Ljava/lang/Class;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class b extends z40.a {
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    @NotNull
    protected List<Part> e(@NotNull com.tencent.biz.qqcircle.immersive.layer.base.a builder) {
        List<Part> mutableListOf;
        Intrinsics.checkNotNullParameter(builder, "builder");
        com.tencent.biz.qqcircle.immersive.layer.biz.a aVar = (com.tencent.biz.qqcircle.immersive.layer.biz.a) builder;
        g gVar = new g(aVar.b(), w());
        QFSPersonalPanelPart qFSPersonalPanelPart = new QFSPersonalPanelPart();
        bq bqVar = new bq();
        bv bvVar = new bv();
        bz bzVar = new bz();
        QFSEmojiCommentPanelPart qFSEmojiCommentPanelPart = new QFSEmojiCommentPanelPart();
        cp cpVar = new cp();
        QFSSharePart qFSSharePart = new QFSSharePart();
        QCircleLightInteractListPart qCircleLightInteractListPart = new QCircleLightInteractListPart();
        qCircleLightInteractListPart.setReportBeanAgent(aVar.a());
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(gVar, qFSPersonalPanelPart, bqVar, bvVar, bzVar, qFSEmojiCommentPanelPart, cpVar, qFSSharePart, qCircleLightInteractListPart, new QCircleRichMediaDownLoadPart(), new QFSMainTabTipPart(true), new QFSMainShoppingCartPart(), new QFSPushBoxSharePart(), new QFSPushRocketProgressPart(), new com.tencent.biz.qqcircle.immersive.part.push.a(), new k60.a(true), new QFSTagPolymerizationTaskDoneDialogPart(), new de(), new ak(), new aw());
        f.f84618a.a(mutableListOf, aVar.a(), true);
        mutableListOf.add(new QFSReportBottomSheetPart());
        mutableListOf.add(new QFSLayerPageDecorationPopupWindowPart());
        if (cb.c()) {
            mutableListOf.add(new ez());
            mutableListOf.add(new ex());
        }
        com.tencent.biz.qqcircle.immersive.layer.base.b.a(mutableListOf);
        return mutableListOf;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    @NotNull
    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> q() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> q16 = super.q();
        q16.add(c.class);
        Intrinsics.checkNotNullExpressionValue(q16, "super.assemblePicOrVideo\u2026er::class.java)\n        }");
        return q16;
    }

    public int w() {
        return 13;
    }
}

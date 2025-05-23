package r44;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotQzoneData;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotQzoneDataType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lr44/c;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotQzoneData;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/ImageView;", "u", "(Landroid/widget/ImageView;)V", "picIv", "e", "Landroid/view/View;", "r", "()Landroid/view/View;", "v", "(Landroid/view/View;)V", "videoIcon", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c extends Section<GroupRobotQzoneData> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public ImageView picIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public View videoIcon;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(LoadState loadState, Option option) {
        r01.c cVar;
        if (loadState.isFinishSuccess()) {
            Animatable animatable = option.getAnimatable();
            if (animatable instanceof r01.c) {
                cVar = (r01.c) animatable;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                cVar.setLoopCount(1);
                cVar.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.dkv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026R.id.info_card_qzone_pic)");
        u((ImageView) findViewById);
        View findViewById2 = containerView.findViewById(R.id.f165805dl0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026nfo_card_qzone_pic_video)");
        v(findViewById2);
    }

    @NotNull
    public final ImageView q() {
        ImageView imageView = this.picIv;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("picIv");
        return null;
    }

    @NotNull
    public final View r() {
        View view = this.videoIcon;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("videoIcon");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable GroupRobotQzoneData data, int position, @Nullable List<Object> payload) {
        int i3;
        if (data == null) {
            return;
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(data.imageUrl).setTargetView(q()), new IPicLoadStateListener() { // from class: r44.b
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                c.t(loadState, option);
            }
        });
        View r16 = r();
        if (data.dataType == GroupRobotQzoneDataType.KVIDEO) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        r16.setVisibility(i3);
    }

    public final void u(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.picIv = imageView;
    }

    public final void v(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.videoIcon = view;
    }
}

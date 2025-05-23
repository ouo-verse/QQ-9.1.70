package xb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J*\u0010\u0010\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lxb/e;", "Lv9/b;", "Lhb/h;", "", "getLogTag", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "data", "", "position", "", "", "payload", "w", "j", "", "attached", "onAttachedChanged", "v", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivAuthorityPrivate", "Lcom/tencent/mobileqq/quibadge/QUIBadge;", tl.h.F, "Lcom/tencent/mobileqq/quibadge/QUIBadge;", "redDotView", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e extends v9.b implements hb.h {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView ivAuthorityPrivate;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUIBadge redDotView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(hb.b bVar) {
        bVar.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumListNameSection";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // hb.h
    public void j() {
        QUIBadge qUIBadge = this.redDotView;
        QUIBadge qUIBadge2 = null;
        if (qUIBadge == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redDotView");
            qUIBadge = null;
        }
        qUIBadge.setVisibility(8);
        if (((CommonAlbumListBean) this.mData).getAlbumInfo().getQzAlbumType() != 14) {
            return;
        }
        boolean p16 = dh.a.f393805d.p();
        if (p16) {
            QUIBadge qUIBadge3 = this.redDotView;
            if (qUIBadge3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("redDotView");
                qUIBadge3 = null;
            }
            qUIBadge3.setVisibility(0);
            QUIBadge qUIBadge4 = this.redDotView;
            if (qUIBadge4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("redDotView");
            } else {
                qUIBadge2 = qUIBadge4;
            }
            qUIBadge2.setRedDot();
        }
        QLog.i("QZ_QFS_QZAlbumxAlbumListNameSection", 1, "updateRedDotView, type is qcircle, showEntranceRedDot=" + p16);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
        if (attached) {
            RFWIocAbilityProvider.g().registerIoc(getRootView(), this, hb.h.class);
        } else {
            RFWIocAbilityProvider.g().unregisterSingleIoc(getRootView(), hb.h.class);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n3s) {
            RFWIocAbilityProvider.g().getIoc(hb.b.class).originView(getRootView()).done(new OnPromiseResolved() { // from class: xb.d
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    e.z((hb.b) obj);
                }
            }).run();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v9.b, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        super.onInitView(containerView);
        View findViewById = containerView.findViewById(R.id.ku8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026v_authority_private_lock)");
        this.ivAuthorityPrivate = (ImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.miv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.qui_badge_red_dot)");
        this.redDotView = (QUIBadge) findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v9.b, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w */
    public void onBindData(CommonAlbumListBean data, int position, List<Object> payload) {
        super.onBindData(data, position, payload);
        ImageView imageView = this.ivAuthorityPrivate;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivAuthorityPrivate");
            imageView = null;
        }
        imageView.setVisibility(8);
        if (data != null && data.getAlbumInfo().getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType() == 3) {
            ImageView imageView2 = this.ivAuthorityPrivate;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivAuthorityPrivate");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
        }
        ImageView imageView3 = this.ivAuthorityPrivate;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivAuthorityPrivate");
            imageView3 = null;
        }
        if (imageView3.getVisibility() == 0) {
            TextView v3 = v();
            CharSequence text = v().getText();
            v3.setContentDescription((text != null ? text.toString() : null) + " \u79c1\u5bc6\u76f8\u518c");
        } else {
            TextView v16 = v();
            CharSequence text2 = v().getText();
            v16.setContentDescription(text2 != null ? text2.toString() : null);
        }
        j();
    }
}

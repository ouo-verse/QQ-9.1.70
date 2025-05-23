package yb;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr;
import com.qzone.reborn.base.l;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nc.ao;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J(\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0014R\u0014\u0010\u001f\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010&\u00a8\u0006."}, d2 = {"Lyb/b;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonClientAttr;", "data", "", "u", "v", HippyTKDListViewAdapter.X, "w", "", "uin", "", BdhLogUtil.LogTag.Tag_Conn, "Lnc/ao;", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "D", "e", "Ljava/lang/String;", "TAG", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "f", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarView", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "nickView", "i", "tipsView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "roleView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends l<CommonClientAttr> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZAlbumxAlbumMemberItemSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView nickView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView tipsView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView roleView;

    private final boolean A(CommonClientAttr data) {
        ao y16 = y();
        if (y16 != null && y16.e2()) {
            return Intrinsics.areEqual(data.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin(), LoginData.getInstance().getUinString()) || y16.f2();
        }
        return false;
    }

    private final boolean B(CommonClientAttr data) {
        ao y16 = y();
        return (y16 == null || !y16.f2() || C(data.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin())) ? false : true;
    }

    private final boolean C(String uin) {
        ao y16 = y();
        if (y16 == null) {
            return false;
        }
        return y16.g2(uin);
    }

    private final void u(CommonClientAttr data) {
        if (ef.d.k(data.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin()) == 0) {
            return;
        }
        QZoneUserAvatarView qZoneUserAvatarView = this.avatarView;
        if (qZoneUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qZoneUserAvatarView = null;
        }
        qZoneUserAvatarView.setUser(ef.d.k(data.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin()));
    }

    private final void v(CommonClientAttr data) {
        TextView textView = this.nickView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickView");
            textView = null;
        }
        textView.setText(data.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getNick());
    }

    private final void w(CommonClientAttr data) {
        TextView textView = null;
        if (!z(data)) {
            TextView textView2 = this.roleView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roleView");
                textView2 = null;
            }
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(11, -1);
            TextView textView3 = this.roleView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roleView");
                textView3 = null;
            }
            textView3.setLayoutParams(layoutParams2);
        }
        if (data.getAttr().getFamilyRole() == 0) {
            QLog.i(this.TAG, 2, data.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getNick() + " family role = 0");
            return;
        }
        TextView textView4 = this.roleView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleView");
        } else {
            textView = textView4;
        }
        textView.setText(com.qzone.reborn.albumx.qzonex.utils.b.f53400a.c(data.getAttr().getFamilyRole()));
    }

    private final void x(CommonClientAttr data) {
        TextView textView = this.tipsView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            textView = null;
        }
        textView.setVisibility(0);
        if (C(data.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin())) {
            if (data.getAttr().getTotal() == 0) {
                TextView textView3 = this.tipsView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tipsView");
                    textView3 = null;
                }
                TextView textView4 = this.tipsView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tipsView");
                } else {
                    textView2 = textView4;
                }
                textView3.setText(textView2.getResources().getString(R.string.f1342188));
                return;
            }
            TextView textView5 = this.tipsView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsView");
                textView5 = null;
            }
            TextView textView6 = this.tipsView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            } else {
                textView2 = textView6;
            }
            textView5.setText(textView2.getResources().getString(R.string.f1342087, Integer.valueOf(data.getAttr().getTotal())));
            return;
        }
        if (data.getAttr().getTotal() == 0) {
            TextView textView7 = this.tipsView;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            } else {
                textView2 = textView7;
            }
            textView2.setVisibility(8);
            return;
        }
        TextView textView8 = this.tipsView;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
            textView8 = null;
        }
        TextView textView9 = this.tipsView;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsView");
        } else {
            textView2 = textView9;
        }
        textView8.setText(textView2.getResources().getString(R.string.f134238_, Integer.valueOf(data.getAttr().getTotal())));
    }

    private final ao y() {
        ao aoVar = (ao) t(ao.class);
        if (aoVar == null) {
            return null;
        }
        return aoVar;
    }

    private final boolean z(CommonClientAttr data) {
        return A(data) || B(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonClientAttr data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        u(data);
        v(data);
        x(data);
        w(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.nby);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.qzone_user_avatar)");
        this.avatarView = (QZoneUserAvatarView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f18773w);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.album_member_nick)");
        this.nickView = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f18803z);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.album_member_tips)");
        this.tipsView = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.f18783x);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.album_member_role)");
        this.roleView = (TextView) findViewById4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }
}

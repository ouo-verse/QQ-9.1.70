package yb;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr;
import com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog;
import com.qzone.reborn.base.l;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nc.ao;
import tl.h;
import wa.QZAlbumxParentFamilyBean;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J8\u0010\u001d\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\"\u001a\u00020!H\u0014J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\tH\u0014J(\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00192\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001bH\u0014R\u0014\u0010+\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lyb/g;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonClientAttr;", "data", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "emId", "Landroid/view/View;", "view", BdhLogUtil.LogTag.Tag_Conn, "B", "uin", "", "N", "Lnc/ao;", "D", "K", "L", "M", "J", "clickedView", "Lcom/tencent/widget/ActionSheet;", "actionSheet", "", "which", "", "currentBtnList", "H", UserInfo.SEX_FEMALE, "G", ExifInterface.LATITUDE_SOUTH, "", "getViewStubLayoutId", "containerView", "onInitView", "position", "", "payload", "O", "e", "Ljava/lang/String;", "TAG", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "itemLayout", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "arrowView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g extends l<CommonClientAttr> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZAlbumxAlbumMemberRootSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout itemLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView arrowView;

    private final void A(CommonClientAttr data) {
        ImageView imageView = null;
        if (K(data)) {
            ImageView imageView2 = this.arrowView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arrowView");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView3 = this.arrowView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arrowView");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ao D() {
        ao aoVar = (ao) t(ao.class);
        if (aoVar == null) {
            return null;
        }
        return aoVar;
    }

    private final void F(CommonClientAttr data, View view) {
        B("em_qz_change_identity", view);
        J(data);
    }

    private final void G(CommonClientAttr data) {
        ao D = D();
        if (D != null) {
            D.k2(data);
        }
    }

    private final void H(View clickedView, ActionSheet actionSheet, int which, List<Integer> currentBtnList, CommonClientAttr data) {
        if (which >= currentBtnList.size() || which < 0) {
            return;
        }
        int intValue = currentBtnList.get(which).intValue();
        if (intValue == R.string.f1341986) {
            F(data, clickedView);
        } else if (intValue == R.string.f1342289) {
            S(data, clickedView);
        }
        actionSheet.dismiss();
    }

    private final void J(CommonClientAttr data) {
        QZAlbumxParentFamilyBean b16 = com.qzone.reborn.albumx.qzonex.utils.b.f53400a.b(data.getAttr().getFamilyRole());
        Activity activity = p();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        QZAlbumxParentingSelectIdentityDialog qZAlbumxParentingSelectIdentityDialog = new QZAlbumxParentingSelectIdentityDialog(activity, b16);
        qZAlbumxParentingSelectIdentityDialog.b0(new a(b16, data));
        qZAlbumxParentingSelectIdentityDialog.show();
    }

    private final boolean K(CommonClientAttr data) {
        return L(data) || M(data);
    }

    private final boolean L(CommonClientAttr data) {
        ao D = D();
        if (D != null && D.e2()) {
            return Intrinsics.areEqual(data.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin(), LoginData.getInstance().getUinString()) || D.f2();
        }
        return false;
    }

    private final boolean M(CommonClientAttr data) {
        ao D = D();
        return (D == null || !D.f2() || N(data.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin())) ? false : true;
    }

    private final boolean N(String uin) {
        ao D = D();
        if (D == null) {
            return false;
        }
        return D.g2(uin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(g this$0, CommonClientAttr data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.Q(data);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Q(final CommonClientAttr data) {
        Dialog createDialog = ActionSheetHelper.createDialog(p(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        final ArrayList arrayList = new ArrayList();
        if (L(data)) {
            actionSheet.addButton(R.string.f1341986);
            C("em_qz_change_identity", actionSheet.getActionContentView());
            arrayList.add(Integer.valueOf(R.string.f1341986));
        }
        if (M(data)) {
            actionSheet.addButton(R.string.f1342289, 3);
            C("em_qz_remove_member", actionSheet.getActionContentView());
            arrayList.add(Integer.valueOf(R.string.f1342289));
        }
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: yb.d
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                g.R(g.this, actionSheet, arrayList, data, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.f185563ox);
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(g this$0, ActionSheet actionSheet, List currentBtnList, CommonClientAttr data, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(currentBtnList, "$currentBtnList");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.H(view, actionSheet, i3, currentBtnList, data);
    }

    private final void S(final CommonClientAttr data, View view) {
        B("em_qz_remove_member", view);
        DialogUtil.createCustomDialog(p(), 230, (String) null, p().getString(R.string.f1341683), "\u53d6\u6d88", "\u5220\u9664", new DialogInterface.OnClickListener() { // from class: yb.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                g.T(g.this, data, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: yb.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                g.U(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(g this$0, CommonClientAttr data, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.G(data);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindData(final CommonClientAttr data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        A(data);
        if (K(data)) {
            RelativeLayout relativeLayout = this.itemLayout;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemLayout");
                relativeLayout = null;
            }
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: yb.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.P(g.this, data, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f18793y);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026album_member_root_layout)");
        this.itemLayout = (RelativeLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f18753u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026(R.id.album_member_arrow)");
        this.arrowView = (ImageView) findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    private final void B(String emId, View view) {
        if (view == null) {
            return;
        }
        fo.c.d(emId, "pg_qz_album_members", view);
    }

    private final void C(String emId, View view) {
        if (view == null) {
            return;
        }
        fo.c.f(emId, "pg_qz_album_members", view);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"yb/g$a", "Lcom/qzone/reborn/albumx/qzonex/view/QZAlbumxParentingSelectIdentityDialog$b;", "", "onCancel", "Lwa/b;", "selectedBean", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements QZAlbumxParentingSelectIdentityDialog.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QZAlbumxParentFamilyBean f449957b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CommonClientAttr f449958c;

        a(QZAlbumxParentFamilyBean qZAlbumxParentFamilyBean, CommonClientAttr commonClientAttr) {
            this.f449957b = qZAlbumxParentFamilyBean;
            this.f449958c = commonClientAttr;
        }

        @Override // com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog.b
        public void a(QZAlbumxParentFamilyBean selectedBean) {
            RFWLog.i(g.this.TAG, RFWLog.USR, "onConfirm  selectedIdentityBean=" + this.f449957b + ", afterSelectedBean=" + selectedBean);
            if (selectedBean == null || TextUtils.isEmpty(selectedBean.getName())) {
                return;
            }
            this.f449958c.getAttr().n(selectedBean.getRoleId());
            ao D = g.this.D();
            if (D != null) {
                D.n2(this.f449958c);
            }
        }

        @Override // com.qzone.reborn.albumx.qzonex.view.QZAlbumxParentingSelectIdentityDialog.b
        public void onCancel() {
        }
    }
}

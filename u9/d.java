package u9;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.base.l;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.widget.QZoneAsyncTextView;
import com.qzone.util.ar;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J*\u0010\u0017\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0014J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010%R\"\u00100\u001a\u00020)8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00106\u001a\u00020#8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b1\u0010%\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00108\u001a\u00020#8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b2\u0010%\u001a\u0004\b1\u00103\"\u0004\b7\u00105R\"\u0010@\u001a\u0002098\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010C\u001a\u00020#8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010%\u001a\u0004\bA\u00103\"\u0004\bB\u00105R\u0016\u0010F\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010!R$\u0010T\u001a\u0004\u0018\u00010M8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010W\u00a8\u0006["}, d2 = {"Lu9/d;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "checked", UserInfo.SEX_FEMALE, HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Req, "U", "V", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "G", "T", "W", ExifInterface.LATITUDE_SOUTH, "", "e", "Ljava/lang/String;", "TAG", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "llContentLayout", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "tvTime", "i", "tvTimeDesc", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "y", "()Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "L", "(Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;)V", "avatarUser", BdhLogUtil.LogTag.Tag_Conn, "D", "()Landroid/widget/TextView;", "P", "(Landroid/widget/TextView;)V", "tvUserName", "O", "tvUploadNum", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Landroid/widget/ImageView;", "M", "(Landroid/widget/ImageView;)V", "ivLocationIcon", "B", "N", "tvLocation", "Lcom/qzone/reborn/widget/QZoneAsyncTextView;", "Lcom/qzone/reborn/widget/QZoneAsyncTextView;", "tvContent", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "H", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "cbOperateSelect", "I", "llUserLineLayout", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", "J", "Lcom/qzone/reborn/albumx/common/viewmodel/e;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/qzone/reborn/albumx/common/viewmodel/e;", "setOperateViewModel", "(Lcom/qzone/reborn/albumx/common/viewmodel/e;)V", "operateViewModel", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "K", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "checkListener", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class d extends l<CommonGridItemData> {

    /* renamed from: C, reason: from kotlin metadata */
    protected TextView tvUserName;

    /* renamed from: D, reason: from kotlin metadata */
    protected TextView tvUploadNum;

    /* renamed from: E, reason: from kotlin metadata */
    protected ImageView ivLocationIcon;

    /* renamed from: F, reason: from kotlin metadata */
    protected TextView tvLocation;

    /* renamed from: G, reason: from kotlin metadata */
    private QZoneAsyncTextView tvContent;

    /* renamed from: H, reason: from kotlin metadata */
    private QUICheckBox cbOperateSelect;

    /* renamed from: I, reason: from kotlin metadata */
    private LinearLayout llUserLineLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private com.qzone.reborn.albumx.common.viewmodel.e operateViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private CompoundButton.OnCheckedChangeListener checkListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "CommonAlbumDetailContentSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout llContentLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView tvTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView tvTimeDesc;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    protected QZoneUserAvatarView avatarUser;

    /* JADX WARN: Multi-variable type inference failed */
    private final void F(boolean checked) {
        com.qzone.reborn.albumx.common.viewmodel.e eVar;
        T t16 = this.mData;
        if (t16 == 0 || (eVar = this.operateViewModel) == null) {
            return;
        }
        if (checked) {
            eVar.P1(((CommonGridItemData) t16).getBatchBean().getTimeId());
        } else {
            eVar.j2(((CommonGridItemData) t16).getBatchBean().getTimeId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(d this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(d this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(d this$0, Unit unit) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Q() {
        com.qzone.reborn.albumx.common.viewmodel.e eVar;
        QUICheckBox qUICheckBox = this.cbOperateSelect;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = null;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cbOperateSelect");
            qUICheckBox = null;
        }
        qUICheckBox.setVisibility(8);
        TextView textView = this.tvTime;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTime");
            textView = null;
        }
        if (textView.getVisibility() == 8 || this.mData == 0 || (eVar = this.operateViewModel) == null) {
            return;
        }
        Intrinsics.checkNotNull(eVar);
        if (Intrinsics.areEqual(eVar.d2().getValue(), Boolean.TRUE)) {
            QUICheckBox qUICheckBox2 = this.cbOperateSelect;
            if (qUICheckBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cbOperateSelect");
                qUICheckBox2 = null;
            }
            qUICheckBox2.setVisibility(0);
            QUICheckBox qUICheckBox3 = this.cbOperateSelect;
            if (qUICheckBox3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cbOperateSelect");
                qUICheckBox3 = null;
            }
            qUICheckBox3.setOnCheckedChangeListener(null);
            QUICheckBox qUICheckBox4 = this.cbOperateSelect;
            if (qUICheckBox4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cbOperateSelect");
                qUICheckBox4 = null;
            }
            com.qzone.reborn.albumx.common.viewmodel.e eVar2 = this.operateViewModel;
            Intrinsics.checkNotNull(eVar2);
            qUICheckBox4.setChecked(eVar2.R1(((CommonGridItemData) this.mData).getBatchBean().getTimeId()));
            QUICheckBox qUICheckBox5 = this.cbOperateSelect;
            if (qUICheckBox5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cbOperateSelect");
                qUICheckBox5 = null;
            }
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener2 = this.checkListener;
            if (onCheckedChangeListener2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkListener");
            } else {
                onCheckedChangeListener = onCheckedChangeListener2;
            }
            qUICheckBox5.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void R() {
        QZoneAsyncTextView qZoneAsyncTextView = null;
        if (TextUtils.isEmpty(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getDesc())) {
            QZoneAsyncTextView qZoneAsyncTextView2 = this.tvContent;
            if (qZoneAsyncTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvContent");
            } else {
                qZoneAsyncTextView = qZoneAsyncTextView2;
            }
            qZoneAsyncTextView.setVisibility(8);
            return;
        }
        QZoneAsyncTextView qZoneAsyncTextView3 = this.tvContent;
        if (qZoneAsyncTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvContent");
            qZoneAsyncTextView3 = null;
        }
        qZoneAsyncTextView3.setVisibility(0);
        QZoneAsyncTextView qZoneAsyncTextView4 = this.tvContent;
        if (qZoneAsyncTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvContent");
            qZoneAsyncTextView4 = null;
        }
        qZoneAsyncTextView4.setExactWidth(pl.a.f426446a.o(p()) - ar.e(32.0f));
        QZoneAsyncTextView qZoneAsyncTextView5 = this.tvContent;
        if (qZoneAsyncTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvContent");
        } else {
            qZoneAsyncTextView = qZoneAsyncTextView5;
        }
        qZoneAsyncTextView.setText(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getDesc());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void U() {
        TextView textView = null;
        if (TextUtils.isEmpty(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME java.lang.String())) {
            TextView textView2 = this.tvTime;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTime");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.tvTime;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTime");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.tvTime;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTime");
        } else {
            textView = textView4;
        }
        textView.setText(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME java.lang.String());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void V() {
        TextView textView = null;
        if (!TextUtils.isEmpty(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME java.lang.String()) && !TextUtils.isEmpty(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getCom.tencent.mobileqq.wink.api.QQWinkConstants.TAB_SUBTITLE java.lang.String())) {
            TextView textView2 = this.tvTimeDesc;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTimeDesc");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this.tvTimeDesc;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTimeDesc");
            } else {
                textView = textView3;
            }
            textView.setText(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getCom.tencent.mobileqq.wink.api.QQWinkConstants.TAB_SUBTITLE java.lang.String());
            return;
        }
        TextView textView4 = this.tvTimeDesc;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTimeDesc");
        } else {
            textView = textView4;
        }
        textView.setVisibility(8);
    }

    private final void x() {
        LinearLayout linearLayout = this.llUserLineLayout;
        QZoneAsyncTextView qZoneAsyncTextView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llUserLineLayout");
            linearLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        TextView textView = this.tvTime;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTime");
            textView = null;
        }
        if (textView.getVisibility() == 8) {
            marginLayoutParams.topMargin = ef.d.b(0);
        } else {
            marginLayoutParams.topMargin = ef.d.b(12);
        }
        QZoneAsyncTextView qZoneAsyncTextView2 = this.tvContent;
        if (qZoneAsyncTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvContent");
            qZoneAsyncTextView2 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = qZoneAsyncTextView2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        if (y().getVisibility() == 8) {
            marginLayoutParams.topMargin = ef.d.b(0);
            TextView textView2 = this.tvTime;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTime");
                textView2 = null;
            }
            if (textView2.getVisibility() == 8) {
                marginLayoutParams2.topMargin = ef.d.b(0);
            } else {
                marginLayoutParams2.topMargin = ef.d.b(12);
            }
        } else {
            marginLayoutParams2.topMargin = ef.d.b(8);
        }
        LinearLayout linearLayout2 = this.llUserLineLayout;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llUserLineLayout");
            linearLayout2 = null;
        }
        linearLayout2.setLayoutParams(marginLayoutParams);
        QZoneAsyncTextView qZoneAsyncTextView3 = this.tvContent;
        if (qZoneAsyncTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvContent");
        } else {
            qZoneAsyncTextView = qZoneAsyncTextView3;
        }
        qZoneAsyncTextView.setLayoutParams(marginLayoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: A, reason: from getter */
    public final com.qzone.reborn.albumx.common.viewmodel.e getOperateViewModel() {
        return this.operateViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TextView B() {
        TextView textView = this.tvLocation;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvLocation");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TextView C() {
        TextView textView = this.tvUploadNum;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvUploadNum");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TextView D() {
        TextView textView = this.tvUserName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvUserName");
        return null;
    }

    protected final void L(QZoneUserAvatarView qZoneUserAvatarView) {
        Intrinsics.checkNotNullParameter(qZoneUserAvatarView, "<set-?>");
        this.avatarUser = qZoneUserAvatarView;
    }

    protected final void M(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivLocationIcon = imageView;
    }

    protected final void N(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvLocation = textView;
    }

    protected final void O(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvUploadNum = textView;
    }

    protected final void P(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvUserName = textView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void S() {
        if (TextUtils.isEmpty(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getLbs().getLocation())) {
            B().setVisibility(8);
            z().setVisibility(8);
        } else {
            B().setVisibility(0);
            z().setVisibility(0);
            B().setText(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getLbs().getLocation());
        }
    }

    public abstract void T();

    public abstract void W();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        MutableLiveData<Unit> c26;
        MutableLiveData<Boolean> d26;
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mfp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.ll_content_layout)");
        this.llContentLayout = (LinearLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.nkb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.tv_time)");
        this.tvTime = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.nkc);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.tv_time_desc)");
        this.tvTimeDesc = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.f19094r);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.avatar_user)");
        L((QZoneUserAvatarView) findViewById4);
        View findViewById5 = containerView.findViewById(R.id.nkr);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewById(R.id.tv_user_name)");
        P((TextView) findViewById5);
        View findViewById6 = containerView.findViewById(R.id.nkq);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewById(R.id.tv_upload_num)");
        O((TextView) findViewById6);
        View findViewById7 = containerView.findViewById(R.id.lcb);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewById(R.id.iv_location_icon)");
        M((ImageView) findViewById7);
        View findViewById8 = containerView.findViewById(R.id.mgl);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "containerView.findViewById(R.id.ll_user_line)");
        this.llUserLineLayout = (LinearLayout) findViewById8;
        rn.h.a(z(), "qui_position", R.color.qui_common_icon_secondary);
        View findViewById9 = containerView.findViewById(R.id.nj5);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "containerView.findViewById(R.id.tv_location)");
        N((TextView) findViewById9);
        View findViewById10 = containerView.findViewById(R.id.nie);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "containerView.findViewById(R.id.tv_content)");
        this.tvContent = (QZoneAsyncTextView) findViewById10;
        View findViewById11 = containerView.findViewById(R.id.f19666a);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "containerView.findViewById(R.id.cb_operate_select)");
        this.cbOperateSelect = (QUICheckBox) findViewById11;
        this.checkListener = new CompoundButton.OnCheckedChangeListener() { // from class: u9.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                d.H(d.this, compoundButton, z16);
            }
        };
        QUICheckBox qUICheckBox = this.cbOperateSelect;
        QUICheckBox qUICheckBox2 = null;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cbOperateSelect");
            qUICheckBox = null;
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.checkListener;
        if (onCheckedChangeListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkListener");
            onCheckedChangeListener = null;
        }
        qUICheckBox.setOnCheckedChangeListener(onCheckedChangeListener);
        l9.c cVar = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, containerView, null);
        com.qzone.reborn.albumx.common.viewmodel.e qf5 = cVar != null ? cVar.qf() : null;
        this.operateViewModel = qf5;
        if (qf5 != null && (d26 = qf5.d2()) != null) {
            d26.observe(r(), new Observer() { // from class: u9.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    d.J(d.this, (Boolean) obj);
                }
            });
        }
        com.qzone.reborn.albumx.common.viewmodel.e eVar = this.operateViewModel;
        if (eVar != null && (c26 = eVar.c2()) != null) {
            c26.observe(r(), new Observer() { // from class: u9.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    d.K(d.this, (Unit) obj);
                }
            });
        }
        QUICheckBox qUICheckBox3 = this.cbOperateSelect;
        if (qUICheckBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cbOperateSelect");
        } else {
            qUICheckBox2 = qUICheckBox3;
        }
        fo.b bVar = new fo.b();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("check_type", 1);
        bVar.l(linkedHashMap);
        Unit unit = Unit.INSTANCE;
        fo.c.o(qUICheckBox2, "em_qz_select_a_single_photo", bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final QZoneUserAvatarView y() {
        QZoneUserAvatarView qZoneUserAvatarView = this.avatarUser;
        if (qZoneUserAvatarView != null) {
            return qZoneUserAvatarView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("avatarUser");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ImageView z() {
        ImageView imageView = this.ivLocationIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivLocationIcon");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n4b};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonGridItemData data, int position, List<Object> payload) {
        if (data != null) {
            U();
            V();
            W();
            T();
            S();
            R();
            x();
            Q();
        }
    }
}

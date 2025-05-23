package sh;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.widget.halfscreen.QZoneFeedxBaseFloatingView;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0019\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lsh/d;", "Landroid/app/Dialog;", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, ExifInterface.LATITUDE_SOUTH, "Landroid/content/Context;", "context", "", "W", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/app/Activity;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/qzone/reborn/feedx/widget/halfscreen/QZoneFeedxBaseFloatingView;", "D", "Lcom/qzone/reborn/feedx/widget/halfscreen/QZoneFeedxBaseFloatingView;", BdhLogUtil.LogTag.Tag_Req, "()Lcom/qzone/reborn/feedx/widget/halfscreen/QZoneFeedxBaseFloatingView;", "containerView", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "E", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "halfScreenFloatingView", "<init>", "(Landroid/app/Activity;Lcom/qzone/reborn/feedx/widget/halfscreen/QZoneFeedxBaseFloatingView;)V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends ReportDialog {

    /* renamed from: F, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int G = 450;
    private static final float H = ar.e(560.0f) / ar.e(375.0f);
    private static final float I = ar.e(560.0f) / ar.e(775.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private final Activity activity;

    /* renamed from: D, reason: from kotlin metadata */
    private final QZoneFeedxBaseFloatingView containerView;

    /* renamed from: E, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView halfScreenFloatingView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lsh/d$a;", "", "Landroid/content/Context;", "context", "", "a", "CONTAINER_MAX_WIDTH", "I", "", "DIALOG_WIDTH_RATIO", UserInfo.SEX_FEMALE, "PAD_DIALOG_HEIGHT_RATIO", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sh.d$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(Context context) {
            float f16;
            int o16;
            Intrinsics.checkNotNullParameter(context, "context");
            pl.a aVar = pl.a.f426446a;
            if (aVar.y()) {
                f16 = d.I;
                o16 = aVar.n(context);
            } else {
                f16 = d.H;
                o16 = aVar.o(context);
            }
            return (int) (f16 * o16);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"sh/d$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MAX_HEIGHT, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b extends e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57179d() {
            return d.this.getContainerView();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            Companion companion = d.INSTANCE;
            Context context = d.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return companion.a(context);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Activity activity, QZoneFeedxBaseFloatingView qZoneFeedxBaseFloatingView) {
        super(activity, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.containerView = qZoneFeedxBaseFloatingView;
    }

    private final void Q() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        window.setSoftInputMode(19);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("QZoneFeedxHalfScreenDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    private final void S() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.halfScreenFloatingView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = null;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.setDraggable(true);
        if (W(getContext())) {
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.halfScreenFloatingView;
            if (qUSHalfScreenFloatingView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
                qUSHalfScreenFloatingView3 = null;
            }
            qUSHalfScreenFloatingView3.setMaxWidthDp(G);
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView4 = null;
        }
        qUSHalfScreenFloatingView4.setQUSDragFloatController(new b());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView5 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
        } else {
            qUSHalfScreenFloatingView2 = qUSHalfScreenFloatingView5;
        }
        qUSHalfScreenFloatingView2.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: sh.c
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                d.U(d.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* renamed from: R, reason: from getter */
    public final QZoneFeedxBaseFloatingView getContainerView() {
        return this.containerView;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Q();
        setContentView(R.layout.cmw);
        View findViewById = findViewById(R.id.miy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qus_floating_half_screen)");
        this.halfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        S();
    }

    private final boolean W(Context context) {
        Resources resources;
        Configuration configuration = (context == null || (resources = context.getResources()) == null) ? null : resources.getConfiguration();
        return configuration != null && configuration.orientation == 2;
    }
}

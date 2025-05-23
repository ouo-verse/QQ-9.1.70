package y14;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.robot.qqmc.RobotQQMC;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y14.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Ly14/c;", "Landroid/app/Dialog;", "", "initWindow", "initView", BdhLogUtil.LogTag.Tag_Req, "W", "X", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mQusHalfScreenFloatingView", "Landroid/view/View;", "D", "Landroid/view/View;", "mContainer", "Landroid/widget/Button;", "E", "Landroid/widget/Button;", "mButton", "Lcom/tencent/biz/qqstory/storyHome/discover/RoundCornerImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qqstory/storyHome/discover/RoundCornerImageView;", "mPicImageView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "G", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QUSHalfScreenFloatingView mQusHalfScreenFloatingView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View mContainer;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Button mButton;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RoundCornerImageView mPicImageView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"y14/c$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF52508d() {
            return c.this.mContainer;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"y14/c$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: y14.c$c, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class ViewTreeObserverOnGlobalLayoutListenerC11584c implements ViewTreeObserver.OnGlobalLayoutListener {
        ViewTreeObserverOnGlobalLayoutListenerC11584c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(c this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.X();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            View view = c.this.mContainer;
            if (view != null) {
                final c cVar = c.this;
                view.post(new Runnable() { // from class: y14.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.ViewTreeObserverOnGlobalLayoutListenerC11584c.b(c.this);
                    }
                });
            }
            View view2 = c.this.mContainer;
            if (view2 != null && (viewTreeObserver = view2.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Context context) {
        super(context, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void R() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mQusHalfScreenFloatingView;
        Intrinsics.checkNotNull(qUSHalfScreenFloatingView);
        qUSHalfScreenFloatingView.t();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R();
    }

    private final void W() {
        ViewTreeObserver viewTreeObserver;
        View view = this.mContainer;
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC11584c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X() {
        int screenWidth;
        ViewGroup.LayoutParams layoutParams;
        View view = this.mContainer;
        if (view != null) {
            if (view.getWidth() > 0) {
                screenWidth = view.getWidth();
            } else {
                screenWidth = ViewUtils.getScreenWidth();
            }
        } else {
            screenWidth = ViewUtils.getScreenWidth();
        }
        int dip2px = (int) ((screenWidth - ViewUtils.dip2px(28.0f)) / 1.52d);
        RoundCornerImageView roundCornerImageView = this.mPicImageView;
        if (roundCornerImageView != null) {
            layoutParams = roundCornerImageView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.height = dip2px;
        }
        RoundCornerImageView roundCornerImageView2 = this.mPicImageView;
        if (roundCornerImageView2 != null) {
            roundCornerImageView2.setLayoutParams(layoutParams);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AdelieHomePageGuideDialog", 2, "initView pic height = " + dip2px);
        }
    }

    private final void initView() {
        Button button;
        RoundCornerImageView roundCornerImageView;
        View inflate = getLayoutInflater().inflate(R.layout.dsm, (ViewGroup) null);
        this.mContainer = inflate;
        if (inflate != null) {
            button = (Button) inflate.findViewById(R.id.ama);
        } else {
            button = null;
        }
        this.mButton = button;
        View view = this.mContainer;
        if (view != null) {
            roundCornerImageView = (RoundCornerImageView) view.findViewById(R.id.y1w);
        } else {
            roundCornerImageView = null;
        }
        this.mPicImageView = roundCornerImageView;
        Button button2 = this.mButton;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: y14.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.S(c.this, view2);
                }
            });
        }
        X();
        RoundCornerImageView roundCornerImageView2 = this.mPicImageView;
        if (roundCornerImageView2 != null) {
            roundCornerImageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        RoundCornerImageView roundCornerImageView3 = this.mPicImageView;
        if (roundCornerImageView3 != null) {
            roundCornerImageView3.setCorner(ViewUtils.dpToPx(8.0f));
        }
        Option option = Option.obtain().setTargetView(this.mPicImageView).setUrl(RobotQQMC.INSTANCE.getGuidePicUrl());
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, null);
    }

    private final void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("AdelieHomePageGuideDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    public final void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        W();
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindow();
        setContentView(R.layout.e3i);
        this.mQusHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById(R.id.f66733bf);
        initView();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mQusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.setQUSDragFloatController(new b());
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.mQusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView2 != null) {
            qUSHalfScreenFloatingView2.setIsHeightWrapContent(true);
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.mQusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView3 != null) {
            qUSHalfScreenFloatingView3.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: y14.a
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    c.U(c.this);
                }
            });
        }
    }
}

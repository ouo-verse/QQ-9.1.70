package w34;

import android.app.Activity;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.qqui.RoundRectImageView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppSearchDtReportHelper;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import com.tencent.robot.relation.api.IRobotRelationService;
import h44.OpenRobotProfileCardArgs;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s34.c;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00100\u00182\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020'H\u0014J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J(\u0010/\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020*2\u0006\u0010,\u001a\u00020+2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010-H\u0014R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010>R\u0016\u0010E\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010>R\u0016\u0010G\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010>R\u0016\u0010H\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010>R\u0018\u0010K\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010J\u00a8\u0006O"}, d2 = {"Lw34/e;", "Lw34/a;", "Landroid/view/View;", "containerView", "", "D", BdhLogUtil.LogTag.Tag_Conn, "G", "H", UserInfo.SEX_FEMALE, "B", "Ls34/b;", "data", "u", BdhLogUtil.LogTag.Tag_Req, "", "", "payloadList", "w", "U", "X", "V", "W", ExifInterface.LATITUDE_SOUTH, "", "", "y", "J", "troopUin", "robotUin", "P", "errorMsg", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "N", "L", "M", HippyTKDListViewAdapter.X, "O", "", "getViewStubLayoutId", "onInitView", "Ls34/a;", "", "position", "", "payload", "K", "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "e", "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "mAvatar", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mRedDot", "Lcom/tencent/biz/qui/quibutton/QUIButton;", h.F, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mAddButton", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mTitleText", "Landroid/view/ViewGroup;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup;", "mLabelContainer", "mLabel1", "mLabel2", "E", "mLabel3", "mDescText", "Ll34/c;", "Ll34/c;", "mRobotItemListener", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class e extends a {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mLabel1;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mLabel2;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mLabel3;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mDescText;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private l34.c mRobotItemListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundRectImageView mAvatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mRedDot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUIButton mAddButton;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mTitleText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mLabelContainer;

    private final void A() {
        QQToast.makeText(BaseApplication.getContext(), 2, R.string.f222266d2, 0).show();
    }

    private final void B() {
        View mRootView = this.mRootView;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        this.mRobotItemListener = l34.e.c(mRootView);
    }

    private final void C(View containerView) {
        View findViewById = containerView.findViewById(R.id.f7619410);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.robot_add_button)");
        QUIButton qUIButton = (QUIButton) findViewById;
        this.mAddButton = qUIButton;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
            qUIButton = null;
        }
        qUIButton.setPadding(0, 0, 0, 0);
    }

    private final void D(View containerView) {
        View findViewById = containerView.findViewById(R.id.f7627418);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.robot_avatar)");
        this.mAvatar = (RoundRectImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f763241c);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026.id.robot_avatar_red_dot)");
        this.mRedDot = (ImageView) findViewById2;
        RoundRectImageView roundRectImageView = this.mAvatar;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            roundRectImageView = null;
        }
        roundRectImageView.setCornerRadiusAndMode(this.mRootView.getResources().getDimensionPixelSize(R.dimen.c_7), 1);
    }

    private final void F(View containerView) {
        View findViewById = containerView.findViewById(R.id.f765141v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.robot_desc)");
        this.mDescText = (TextView) findViewById;
    }

    private final void G(View containerView) {
        View findViewById = containerView.findViewById(R.id.f769042x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.robot_label_ll)");
        this.mLabelContainer = (ViewGroup) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f768742u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.robot_label_1)");
        this.mLabel1 = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f768842v);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.robot_label_2)");
        this.mLabel2 = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.f768942w);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.robot_label_3)");
        this.mLabel3 = (TextView) findViewById4;
    }

    private final void H(View containerView) {
        View findViewById = containerView.findViewById(R.id.f775744q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.robot_title)");
        this.mTitleText = (TextView) findViewById;
    }

    private final void J(s34.b data) {
        if (FastClickUtils.isFastDoubleClick("RobotContentSectiononAddButtonClick")) {
            return;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.ci7, 0).show();
        } else {
            P(data.getTroopUin(), data.k(), data);
            N(data.k());
        }
    }

    private final void L(s34.b data) {
        if (FastClickUtils.isFastDoubleClick("RobotContentSectiononContentItemClick")) {
            return;
        }
        x(data.k());
        M(data.k(), data.getTroopUin());
        O(data.k());
    }

    private final void M(String robotUin, String troopUin) {
        Activity p16 = p();
        Intrinsics.checkNotNull(p16);
        ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(p16, robotUin, troopUin, 1, 0, null, 48, null));
    }

    private final void N(String robotUin) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        ReportController.o((AppInterface) peekAppRuntime, "dc00898", "", "", "", "0X8009FA0", 0, 0, robotUin, "", "", "");
    }

    private final void O(String robotUin) {
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "", "0X8009F9F", 0, 0, robotUin, "", "", "");
    }

    private final void P(final String troopUin, final String robotUin, s34.b data) {
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IRobotRelationService.class, "");
        } else {
            iRuntimeService = null;
        }
        IRobotRelationService iRobotRelationService = (IRobotRelationService) iRuntimeService;
        if (iRobotRelationService != null) {
            GroupRobotBaseInfo groupRobotBaseInfo = new GroupRobotBaseInfo();
            groupRobotBaseInfo.robotUin = Util.toLongOrDefault(data.k(), 0L);
            groupRobotBaseInfo.robotName = data.getRobotName();
            groupRobotBaseInfo.robotAvatar = data.getRobotAvatar();
            groupRobotBaseInfo.robotDesc = data.getRobotDesc();
            Unit unit = Unit.INSTANCE;
            iRobotRelationService.addRobotToTroop(robotUin, troopUin, groupRobotBaseInfo, new ISetAddRobotToGroupCallback() { // from class: w34.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback
                public final void onResult(int i3, String str) {
                    e.Q(robotUin, troopUin, this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(String robotUin, String troopUin, e this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotContentSection", 1, "sendAddRobotRequest " + i3 + " " + str + " " + robotUin + " " + troopUin);
        if (i3 == 0) {
            this$0.A();
        } else {
            this$0.z(str);
        }
    }

    private final void R(s34.b data) {
        QUIButton qUIButton = this.mAddButton;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
            qUIButton = null;
        }
        q(qUIButton, "em_qqrobot_add_robot", y(data));
        q(this.mRootView, "em_bas_robot_articles", y(data));
    }

    private final void S(final s34.b data) {
        QLog.i("RobotContentSection", 1, "updateRobotAddButton " + data.k() + " " + data.getIsAdded());
        QUIButton qUIButton = null;
        if (data.getIsAdded()) {
            QUIButton qUIButton2 = this.mAddButton;
            if (qUIButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
                qUIButton2 = null;
            }
            qUIButton2.setEnabled(false);
            QUIButton qUIButton3 = this.mAddButton;
            if (qUIButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
                qUIButton3 = null;
            }
            qUIButton3.setClickable(false);
            QUIButton qUIButton4 = this.mAddButton;
            if (qUIButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
                qUIButton4 = null;
            }
            QUIButton qUIButton5 = this.mAddButton;
            if (qUIButton5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
                qUIButton5 = null;
            }
            qUIButton4.setText(qUIButton5.getContext().getString(R.string.yku));
            QUIButton qUIButton6 = this.mAddButton;
            if (qUIButton6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
                qUIButton6 = null;
            }
            qUIButton6.setOnClickListener(null);
            return;
        }
        QUIButton qUIButton7 = this.mAddButton;
        if (qUIButton7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
            qUIButton7 = null;
        }
        qUIButton7.setEnabled(true);
        QUIButton qUIButton8 = this.mAddButton;
        if (qUIButton8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
            qUIButton8 = null;
        }
        qUIButton8.setClickable(true);
        QUIButton qUIButton9 = this.mAddButton;
        if (qUIButton9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
            qUIButton9 = null;
        }
        QUIButton qUIButton10 = this.mAddButton;
        if (qUIButton10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
            qUIButton10 = null;
        }
        qUIButton9.setText(qUIButton10.getContext().getString(R.string.ykt));
        QUIButton qUIButton11 = this.mAddButton;
        if (qUIButton11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
        } else {
            qUIButton = qUIButton11;
        }
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: w34.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.T(e.this, data, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(e this$0, s34.b data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.J(data);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void U(s34.b data) {
        n34.c cVar = n34.c.f418125a;
        String k3 = data.k();
        RoundRectImageView roundRectImageView = this.mAvatar;
        ImageView imageView = null;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            roundRectImageView = null;
        }
        cVar.a(k3, roundRectImageView);
        n34.d dVar = n34.d.f418126a;
        ImageView imageView2 = this.mRedDot;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRedDot");
        } else {
            imageView = imageView2;
        }
        dVar.a(imageView, data.getTroopUin(), data.k());
    }

    private final void V(s34.b data) {
        boolean z16;
        String robotDesc = data.getRobotDesc();
        if (robotDesc.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        TextView textView = null;
        if (z16) {
            TextView textView2 = this.mDescText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDescText");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.mDescText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDescText");
            textView3 = null;
        }
        textView3.setVisibility(0);
        TextView textView4 = this.mDescText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDescText");
        } else {
            textView = textView4;
        }
        textView.setText(Html.fromHtml(robotDesc));
    }

    private final void W(s34.b data) {
        int i3;
        List<String> i16 = data.i();
        ViewGroup viewGroup = this.mLabelContainer;
        TextView textView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLabelContainer");
            viewGroup = null;
        }
        List<String> list = i16;
        if (!list.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        viewGroup.setVisibility(i3);
        TextView textView2 = this.mLabel1;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLabel1");
            textView2 = null;
        }
        textView2.setVisibility(8);
        TextView textView3 = this.mLabel2;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLabel2");
            textView3 = null;
        }
        textView3.setVisibility(8);
        TextView textView4 = this.mLabel3;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLabel3");
            textView4 = null;
        }
        textView4.setVisibility(8);
        if (!list.isEmpty()) {
            TextView textView5 = this.mLabel1;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLabel1");
                textView5 = null;
            }
            textView5.setVisibility(0);
            TextView textView6 = this.mLabel1;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLabel1");
                textView6 = null;
            }
            textView6.setText(i16.get(0));
        }
        if (i16.size() > 1) {
            TextView textView7 = this.mLabel2;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLabel2");
                textView7 = null;
            }
            textView7.setVisibility(0);
            TextView textView8 = this.mLabel2;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLabel2");
                textView8 = null;
            }
            textView8.setText(i16.get(1));
        }
        if (i16.size() > 2) {
            TextView textView9 = this.mLabel3;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLabel3");
                textView9 = null;
            }
            textView9.setVisibility(0);
            TextView textView10 = this.mLabel3;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLabel3");
            } else {
                textView = textView10;
            }
            textView.setText(i16.get(2));
        }
    }

    private final void X(s34.b data) {
        TextView textView = this.mTitleText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleText");
            textView = null;
        }
        textView.setText(data.getRobotName());
    }

    private final void u(final s34.b data) {
        QLog.i("RobotContentSection", 1, "bindAll, " + data.k() + " " + data.getRobotName() + " " + data.getIsAdded());
        U(data);
        X(data);
        V(data);
        W(data);
        S(data);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: w34.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.v(e.this, data, view);
            }
        });
        R(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(e this$0, s34.b data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.L(data);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void w(s34.b data, List<? extends Object> payloadList) {
        QLog.i("RobotContentSection", 1, "bindByPayload, " + data.k() + " " + data.getRobotName() + " " + data.getIsAdded());
        Iterator<T> it = payloadList.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof c.RobotAddedStatePayload) {
                S(data);
            }
        }
    }

    private final void x(String robotUin) {
        ImageView imageView = this.mRedDot;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRedDot");
            imageView = null;
        }
        if (imageView.getVisibility() == 0) {
            n34.d.f418126a.c(robotUin);
            ImageView imageView3 = this.mRedDot;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRedDot");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setVisibility(8);
        }
    }

    private final Map<String, Object> y(s34.b data) {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("bot_name", data.getRobotName()), TuplesKt.to("bot_uin", data.k()), TuplesKt.to("rank", Integer.valueOf(data.getRank())), TuplesKt.to(MiniAppSearchDtReportHelper.DT_ELEMENT_CLASSIFICATION_NAME, data.getCategoryName()));
        return mapOf;
    }

    private final void z(String errorMsg) {
        boolean z16;
        if (errorMsg != null && errorMsg.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            errorMsg = BaseApplication.getContext().getString(R.string.f222136cp);
        }
        Intrinsics.checkNotNullExpressionValue(errorMsg, "if (errorMsg.isNullOrEmp\u2026add_failed) else errorMsg");
        QQToast.makeText(BaseApplication.getContext(), 1, errorMsg, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull s34.a data, int position, @Nullable List<Object> payload) {
        Object obj;
        boolean z16;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof s34.b)) {
            return;
        }
        List<? extends Object> list = null;
        if (payload != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) payload);
            obj = firstOrNull;
        } else {
            obj = null;
        }
        if (obj instanceof List) {
            list = (List) obj;
        }
        List<? extends Object> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            u((s34.b) data);
        } else {
            w((s34.b) data, list);
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
        D(containerView);
        H(containerView);
        F(containerView);
        C(containerView);
        G(containerView);
        B();
    }
}

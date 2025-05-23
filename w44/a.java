package w44;

import android.graphics.Bitmap;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.robot.data.RobotInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001f\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u001f\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00168\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001bR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001b\u00a8\u0006+"}, d2 = {"Lw44/a;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "", "init", "S1", "i", "Ljava/lang/String;", "getMFrom", "()Ljava/lang/String;", "Q1", "(Ljava/lang/String;)V", "mFrom", "Lcom/tencent/robot/data/RobotInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/data/RobotInfo;", "M1", "()Lcom/tencent/robot/data/RobotInfo;", "R1", "(Lcom/tencent/robot/data/RobotInfo;)V", "robotInfo", "Landroidx/lifecycle/MutableLiveData;", "Landroid/graphics/Bitmap;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "L1", "()Landroidx/lifecycle/MutableLiveData;", "cardCache", "", "D", "P1", "isConfigurationChanged", "E", "N1", "shareCache", UserInfo.SEX_FEMALE, "O1", HippyReporter.RemoveEngineReason.THEME_CHANGED, "<init>", "()V", "G", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends BaseViewModel {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isConfigurationChanged;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Bitmap> shareCache;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> themeChanged;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RobotInfo robotInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mFrom = "";

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Bitmap> cardCache = new MutableLiveData<>(null);

    public a() {
        Boolean bool = Boolean.FALSE;
        this.isConfigurationChanged = new MutableLiveData<>(bool);
        this.shareCache = new MutableLiveData<>(null);
        this.themeChanged = new MutableLiveData<>(bool);
    }

    @NotNull
    public final MutableLiveData<Bitmap> L1() {
        return this.cardCache;
    }

    @Nullable
    /* renamed from: M1, reason: from getter */
    public final RobotInfo getRobotInfo() {
        return this.robotInfo;
    }

    @NotNull
    public final MutableLiveData<Bitmap> N1() {
        return this.shareCache;
    }

    @NotNull
    public final MutableLiveData<Boolean> O1() {
        return this.themeChanged;
    }

    @NotNull
    public final MutableLiveData<Boolean> P1() {
        return this.isConfigurationChanged;
    }

    public final void Q1(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mFrom = str;
    }

    public final void R1(@Nullable RobotInfo robotInfo) {
        this.robotInfo = robotInfo;
    }

    public final void S1() {
        Bitmap value = this.cardCache.getValue();
        if (value != null) {
            value.recycle();
        }
        this.cardCache.setValue(null);
        Bitmap value2 = this.shareCache.getValue();
        if (value2 != null) {
            value2.recycle();
        }
        this.shareCache.setValue(null);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "robot.qr.QRDisplayRobotViewModel";
    }

    public final void init() {
    }
}

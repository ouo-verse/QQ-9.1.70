package w94;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uv4.ad;
import uv4.ae;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R9\u0010\u0010\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR+\u0010\u0015\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00110\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lw94/a;", "Landroidx/lifecycle/ViewModel;", "", "authorUIN", "ugcId", "", "N1", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/HashMap;", "", "Luv4/ae;", "Lkotlin/collections/HashMap;", "i", "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "ugcDetailLiveData", "Lkotlin/Pair;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "L1", "errorLiveData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<HashMap<String, ae>> ugcDetailLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Pair<Integer, String>> errorLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lw94/a$a;", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lw94/a;", "a", "", "authorUIN", "ugcId", "", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: w94.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(FragmentActivity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ViewModel viewModel = h.a(activity).get(a.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(acti\u2026ItemDetailVM::class.java)");
            return (a) viewModel;
        }

        public final String b(long authorUIN, long ugcId) {
            return authorUIN + "_" + ugcId;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"w94/a$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/ae;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements e<ae> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f445104d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f445105e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f445106f;

        b(long j3, long j16, a aVar) {
            this.f445104d = j3;
            this.f445105e = j16;
            this.f445106f = aVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ae result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("UGCItemDetailVM", 1, "requestUGCGoodsDetail success");
            String b16 = a.INSTANCE.b(this.f445104d, this.f445105e);
            if (this.f445106f.M1().getValue() == null) {
                this.f445106f.M1().setValue(new HashMap<>());
            }
            HashMap<String, ae> value = this.f445106f.M1().getValue();
            if (value != null) {
                value.put(b16, result);
            }
            this.f445106f.M1().postValue(value);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("UGCItemDetailVM", 1, "requestUGCGoodsDetail fail error:" + error + ", message:" + message);
            this.f445106f.L1().postValue(new Pair<>(Integer.valueOf(error), message));
        }
    }

    public final MutableLiveData<Pair<Integer, String>> L1() {
        return this.errorLiveData;
    }

    public final MutableLiveData<HashMap<String, ae>> M1() {
        return this.ugcDetailLiveData;
    }

    public final void N1(long authorUIN, long ugcId) {
        QLog.i("UGCItemDetailVM", 1, "requestUGCGoodsDetail authorUIN:" + authorUIN + " ugcID:" + ugcId);
        ad adVar = new ad();
        adVar.f440116b = ugcId;
        adVar.f440115a = authorUIN;
        t94.b.b(t94.b.f435619a, adVar, new b(authorUIN, ugcId, this), 0, 4, null);
    }
}

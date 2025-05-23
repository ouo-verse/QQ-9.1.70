package ul1;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \f2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lul1/a;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "d", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "a", "(Ljava/lang/String;)V", "content", "<init>", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements IConfigData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String content;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lul1/a$a;", "", "", "conf", "Lul1/a;", "a", "CONFIG_ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ul1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final a a(@NotNull String conf) {
            Intrinsics.checkNotNullParameter(conf, "conf");
            String string = BaseApplication.context.getResources().getString(R.string.f170933zy0);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026_standard_dialog_content)");
            a aVar = new a(string);
            if (TextUtils.isEmpty(conf)) {
                QLog.d("FeedStandardConfBean", 1, "parse null, return default bean");
                return aVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(conf);
                String optString = jSONObject.optString("content", BaseApplication.context.getResources().getString(R.string.f170933zy0));
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"co\u2026standard_dialog_content))");
                aVar.a(optString);
                if (QLog.isColorLevel()) {
                    QLog.i("FeedStandardConfBean", 2, "parse FeedStandardConfBean =  " + jSONObject);
                }
            } catch (Exception e16) {
                QLog.e("FeedStandardConfBean", 1, "parse FeedStandardConfBean:" + conf + " exception: " + e16);
            }
            return aVar;
        }

        Companion() {
        }
    }

    public a(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
    }

    public final void a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    @NotNull
    public String toString() {
        return "FeedStandardConfBean{content=" + this.content + "}";
    }
}

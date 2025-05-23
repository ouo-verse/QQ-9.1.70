package t53;

import android.content.Intent;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportQueue;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J+\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u0007H\u0007J;\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u0007H\u0007J3\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\n2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u0007H\u0007J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nR\"\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\n*\u0004\u0018\u00010\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\u0019*\u0004\u0018\u00010\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001e\u001a\u00020\n*\u0004\u0018\u00010\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u001a\u0010 \u001a\u00020\n*\u0004\u0018\u00010\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0017R\u001a\u0010\"\u001a\u00020\n*\u0004\u0018\u00010\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0017\u00a8\u0006%"}, d2 = {"Lt53/a;", "", "Landroid/content/Intent;", "intent", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData$a;", "", "Lkotlin/ExtensionFunctionType;", "block", "c", "", "materialType", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "a", "currentMaterialInfo", "b", "j", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setCurrentMaterialInfo", "(Ljava/lang/String;)V", "f", "(Landroid/content/Intent;)Ljava/lang/String;", "enterFeedId", "", "g", "(Landroid/content/Intent;)I", "enterFeedPos", "e", "enterFeedAuthorUin", "i", "enterSealTransfer", h.F, "enterMaterialInfo", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f435443a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String currentMaterialInfo = "";

    a() {
    }

    @JvmStatic
    public static final void a(@Nullable Intent intent, @NotNull String materialType, @NotNull String materialId, @NotNull Function1<? super WinkDc5507ReportData.a, Unit> block) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(materialType, "materialType");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Intrinsics.checkNotNullParameter(block, "block");
        if (materialType.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str = "";
        if (z16) {
            if (materialId.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.mo162put(materialId);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(materialType, jSONArray);
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
                    try {
                        currentMaterialInfo = jSONObject2;
                        str = jSONObject2;
                    } catch (Exception e16) {
                        e = e16;
                        str = jSONObject2;
                        QLog.e("WinkDcReportUtil", 1, e, new Object[0]);
                        b(intent, str, block);
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            }
        }
        b(intent, str, block);
    }

    @JvmStatic
    public static final void b(@Nullable Intent intent, @NotNull String currentMaterialInfo2, @NotNull Function1<? super WinkDc5507ReportData.a, Unit> block) {
        Intrinsics.checkNotNullParameter(currentMaterialInfo2, "currentMaterialInfo");
        Intrinsics.checkNotNullParameter(block, "block");
        WinkDc5507ReportData.a aVar = new WinkDc5507ReportData.a();
        a aVar2 = f435443a;
        WinkDc5507ReportData.a f16 = aVar.g(aVar2.f(intent)).h(Integer.valueOf(aVar2.g(intent))).c(aVar2.e(intent)).i(aVar2.i(intent)).a(Long.valueOf(System.currentTimeMillis())).e(currentMaterialInfo2).f(aVar2.h(intent));
        block.invoke(f16);
        WinkDc5507ReportData data = f16.getData();
        if (QLog.isColorLevel()) {
            QLog.d("WinkDcReportUtil", 1, "dc5507Report, data:" + data);
        }
        WinkDc5507ReportQueue.f327374a.c(data, 1);
    }

    @JvmStatic
    public static final void c(@Nullable Intent intent, @NotNull Function1<? super WinkDc5507ReportData.a, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        b(intent, "", block);
    }

    private final String e(Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getStringExtra("key_enter_wink_feed_authorUin");
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String f(Intent intent) {
        String p16;
        if (intent == null || (p16 = intent.getStringExtra("key_enter_wink_feed_id")) == null) {
            p16 = WinkContext.INSTANCE.d().p("xsj_feed_id");
        }
        if (p16 == null) {
            return "";
        }
        return p16;
    }

    private final int g(Intent intent) {
        if (intent == null) {
            return -1;
        }
        return intent.getIntExtra("key_enter_wink_feed_position", -1);
    }

    private final String h(Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getStringExtra("key_enter_wink_feed_materialInfo");
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String i(Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getStringExtra("key_enter_wink_seal_transfer");
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final String d() {
        return currentMaterialInfo;
    }

    public final void j(@NotNull String materialType, @NotNull String materialId) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(materialType, "materialType");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        if (materialType.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (materialId.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.mo162put(materialId);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(materialType, jSONArray);
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
                    currentMaterialInfo = jSONObject2;
                } catch (Exception e16) {
                    QLog.e("WinkDcReportUtil", 1, e16, new Object[0]);
                }
            }
        }
    }
}

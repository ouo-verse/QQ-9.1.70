package vm1;

import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import wm1.AtInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lvm1/a;", "Lvm1/d;", "Lwm1/a;", "atInfo", "", "c", "Lwm1/i;", "wordInfo", "Lnm1/b;", "translateInfo", "Lorg/json/JSONObject;", "b", "a", "", "Ljava/lang/Integer;", "mPatternId", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer mPatternId;

    private final String c(AtInfo atInfo) {
        String removePrefix;
        String i3 = atInfo.getAtSpan().i();
        Intrinsics.checkNotNullExpressionValue(i3, "atInfo.atSpan.memberNickText");
        removePrefix = StringsKt__StringsKt.removePrefix(i3, (CharSequence) "@");
        return removePrefix;
    }

    @Override // vm1.d
    @Nullable
    public JSONObject a(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        AtInfo atInfo = (AtInfo) wordInfo;
        int g16 = atInfo.getAtSpan().g();
        if (g16 != 1) {
            if (g16 != 8) {
                if (g16 != 64) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", 3);
                    jSONObject.put("id", String.valueOf(this.mPatternId));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", atInfo.getAtSpan().j());
                    jSONObject2.put("nick", c(atInfo));
                    Unit unit = Unit.INSTANCE;
                    jSONObject.put(QCircleAlphaUserReporter.KEY_USER, jSONObject2);
                    return jSONObject;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("type", 3);
                jSONObject3.put("id", String.valueOf(this.mPatternId));
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("id", "at_online");
                jSONObject4.put("nick", c(atInfo));
                Unit unit2 = Unit.INSTANCE;
                jSONObject3.put(QCircleAlphaUserReporter.KEY_USER, jSONObject4);
                return jSONObject3;
            }
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("type", 3);
            jSONObject5.put("id", String.valueOf(this.mPatternId));
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("id", "at_role");
            jSONObject6.put("nick", c(atInfo));
            Unit unit3 = Unit.INSTANCE;
            jSONObject5.put(QCircleAlphaUserReporter.KEY_USER, jSONObject6);
            return jSONObject5;
        }
        JSONObject jSONObject7 = new JSONObject();
        jSONObject7.put("type", 3);
        jSONObject7.put("id", String.valueOf(this.mPatternId));
        JSONObject jSONObject8 = new JSONObject();
        jSONObject8.put("id", "at_all");
        jSONObject8.put("nick", c(atInfo));
        Unit unit4 = Unit.INSTANCE;
        jSONObject7.put(QCircleAlphaUserReporter.KEY_USER, jSONObject8);
        return jSONObject7;
    }

    @Override // vm1.d
    @Nullable
    public JSONObject b(@NotNull wm1.i wordInfo, @NotNull nm1.b translateInfo) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Intrinsics.checkNotNullParameter(wordInfo, "wordInfo");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        if (translateInfo.a() == null) {
            return null;
        }
        AtInfo atInfo = (AtInfo) wordInfo;
        this.mPatternId = Integer.valueOf(sm1.a.f433976a.a());
        int g16 = atInfo.getAtSpan().g();
        if (g16 != 1) {
            if (g16 != 8) {
                if (g16 != 64) {
                    jSONObject2 = new JSONObject();
                    jSONObject2.put("type", 1);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("id", atInfo.getAtSpan().j());
                    jSONObject3.put("nick", c(atInfo));
                    Unit unit = Unit.INSTANCE;
                    jSONObject2.put(QCircleAlphaUserReporter.KEY_USER, jSONObject3);
                } else {
                    jSONObject = new JSONObject();
                    jSONObject.put("type", 4);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("guild_id", translateInfo.a().h().h());
                    jSONObject4.put("name", c(atInfo));
                    Unit unit2 = Unit.INSTANCE;
                    jSONObject.put("guild_info", jSONObject4);
                }
            } else {
                jSONObject2 = new JSONObject();
                jSONObject2.put("type", 2);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("role_id", atInfo.getAtSpan().f().getRoleId());
                jSONObject5.put("name", c(atInfo));
                jSONObject5.put("color", atInfo.getAtSpan().f().getColor() & 4294967295L);
                Unit unit3 = Unit.INSTANCE;
                jSONObject2.put("role_group_id", jSONObject5);
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("type", 2);
            jSONObject6.put("pattern_id", String.valueOf(this.mPatternId));
            jSONObject6.put("at_content", jSONObject2);
            return jSONObject6;
        }
        jSONObject = new JSONObject();
        jSONObject.put("type", 3);
        JSONObject jSONObject7 = new JSONObject();
        jSONObject7.put("guild_id", translateInfo.a().h().h());
        jSONObject7.put("name", c(atInfo));
        Unit unit4 = Unit.INSTANCE;
        jSONObject.put("guild_info", jSONObject7);
        jSONObject2 = jSONObject;
        JSONObject jSONObject62 = new JSONObject();
        jSONObject62.put("type", 2);
        jSONObject62.put("pattern_id", String.valueOf(this.mPatternId));
        jSONObject62.put("at_content", jSONObject2);
        return jSONObject62;
    }
}

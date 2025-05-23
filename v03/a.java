package v03;

import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lv03/a;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lv03/a$a;", "c", "", "d", "", "packageId", "", "b", "a", "Ljava/util/List;", "getConfigList", "()Ljava/util/List;", "configList", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f440717a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<C11384a> configList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B7\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012R'\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0005\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lv03/a$a;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "d", "()Ljava/util/ArrayList;", "packageIds", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "nameText", "addText", WadlProxyConsts.KEY_JUMP_URL, "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: v03.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C11384a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<String> packageIds;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String nameText;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String addText;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String jumpUrl;

        public C11384a(@NotNull ArrayList<String> packageIds, @NotNull String nameText, @NotNull String addText, @NotNull String jumpUrl) {
            Intrinsics.checkNotNullParameter(packageIds, "packageIds");
            Intrinsics.checkNotNullParameter(nameText, "nameText");
            Intrinsics.checkNotNullParameter(addText, "addText");
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            this.packageIds = packageIds;
            this.nameText = nameText;
            this.addText = addText;
            this.jumpUrl = jumpUrl;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAddText() {
            return this.addText;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getNameText() {
            return this.nameText;
        }

        @NotNull
        public final ArrayList<String> d() {
            return this.packageIds;
        }
    }

    static {
        a aVar = new a();
        f440717a = aVar;
        configList = aVar.d();
    }

    a() {
    }

    private final C11384a c(JSONObject json) {
        try {
            JSONArray optJSONArray = json.optJSONArray("packageIds");
            Intrinsics.checkNotNullExpressionValue(optJSONArray, "json.optJSONArray(\"packageIds\")");
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(optJSONArray.get(i3).toString());
            }
            String nameText = json.optString("nameText");
            String addText = json.optString("addText");
            String jumpUrl = json.optString(WadlProxyConsts.KEY_JUMP_URL);
            Intrinsics.checkNotNullExpressionValue(nameText, "nameText");
            Intrinsics.checkNotNullExpressionValue(addText, "addText");
            Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
            return new C11384a(arrayList, nameText, addText, jumpUrl);
        } catch (Exception e16) {
            QLog.e("VasFreshElementToggle", 1, "parseConfig", e16);
            return null;
        }
    }

    private final List<C11384a> d() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = VasToggle.VAS_FRESHELEMENT_EMOJI.getJson().optJSONArray("business");
            Intrinsics.checkNotNullExpressionValue(optJSONArray, "json.optJSONArray(\"business\")");
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                C11384a c16 = c(new JSONObject(optJSONArray.get(i3).toString()));
                if (c16 != null) {
                    arrayList.add(c16);
                }
            }
        } catch (Exception e16) {
            QLog.e("VasFreshElementToggle", 1, "parseFresh", e16);
        }
        return arrayList;
    }

    @Nullable
    public final C11384a a(@NotNull String packageId) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        for (C11384a c11384a : configList) {
            if (c11384a.d().contains(packageId)) {
                return c11384a;
            }
        }
        return null;
    }

    public final boolean b(@NotNull String packageId) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        if (a(packageId) != null) {
            return true;
        }
        return false;
    }
}

package wj4;

import android.graphics.Color;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b4\b\u0086\b\u0018\u0000 <2\u00020\u0001:\u0001\nBo\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\t\u0012\u0006\u0010#\u001a\u00020\t\u0012\u0006\u0010&\u001a\u00020\t\u0012\u0006\u0010-\u001a\u00020\u0007\u0012\u0006\u00102\u001a\u00020\u0004\u0012\u0006\u00104\u001a\u00020\t\u0012\u0006\u00107\u001a\u00020\u0007\u0012\u0006\u00109\u001a\u00020\u0004\u00a2\u0006\u0004\b:\u0010;J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\"\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010#\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR\"\u0010&\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b%\u0010\u000fR\"\u0010-\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00102\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010.\u001a\u0004\b\n\u0010/\"\u0004\b0\u00101R\"\u00104\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b3\u0010\u000fR\"\u00107\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010(\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R\"\u00109\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010.\u001a\u0004\b$\u0010/\"\u0004\b8\u00101\u00a8\u0006="}, d2 = {"Lwj4/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "k", "()F", "setTotalWidth", "(F)V", "totalWidth", "b", "j", "setTotalHeight", "totalHeight", "c", "d", "setLoveLeftPadding", "loveLeftPadding", "f", "setLoveWidth", "loveWidth", "e", "setLoveToNamePadding", "loveToNamePadding", "setLevelHOffset", "levelHOffset", "g", "setNameHOffset", "nameHOffset", h.F, "setLevelTextSize", "levelTextSize", "i", "Z", "l", "()Z", "setLevelBold", "(Z)V", "isLevelBold", "I", "()I", "setLeveTextColor", "(I)V", "leveTextColor", "setNameTextSize", "nameTextSize", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setNameBold", "isNameBold", "setNameTextColor", "nameTextColor", "<init>", "(FFFFFFFFZIFZI)V", DomainData.DOMAIN_NAME, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wj4.a, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class MedalDrawConfig {

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private float totalWidth;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private float totalHeight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private float loveLeftPadding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private float loveWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private float loveToNamePadding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private float levelHOffset;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private float nameHOffset;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private float levelTextSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isLevelBold;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private int leveTextColor;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private float nameTextSize;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isNameBold;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private int nameTextColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lwj4/a$a;", "", "", "wnsKey", "Lwj4/a;", "defConfig", "a", "c", "b", "", "DEFAULT_HEIGHT", UserInfo.SEX_FEMALE, "DEFAULT_WIDTH", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: wj4.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final MedalDrawConfig a(String wnsKey, MedalDrawConfig defConfig) {
            try {
                String d16 = ht3.a.d(wnsKey, "");
                if (TextUtils.isEmpty(d16)) {
                    return defConfig;
                }
                JSONObject jSONObject = new JSONObject(d16);
                return new MedalDrawConfig((float) jSONObject.getDouble("totalWidth"), (float) jSONObject.getDouble("totalHeight"), (float) jSONObject.getDouble("loveLeftPadding"), (float) jSONObject.getDouble("loveWidth"), (float) jSONObject.getDouble("loveToNamePadding"), (float) jSONObject.getDouble("levelHOffset"), (float) jSONObject.getDouble("nameHOffset"), (float) jSONObject.getDouble("levelTextSize"), jSONObject.getBoolean("isLevelBold"), Color.parseColor(jSONObject.getString("leveTextColor")), (float) jSONObject.getDouble("nameTextSize"), jSONObject.getBoolean("isNameBold"), Color.parseColor(jSONObject.getString("nameTextColor")));
            } catch (Exception e16) {
                AegisLogger.INSTANCE.i("MedalDrawConfig", "parseFansGroupDrawConfig", "exception=" + e16);
                return defConfig;
            }
        }

        @NotNull
        public final MedalDrawConfig b() {
            return a("qqlive_android_profile_diamond_medal_json", new MedalDrawConfig(60.0f, 16.0f, 7.0f, 8.6f, 7.5f, 1.5f, 1.5f, 10.0f, true, Color.parseColor("#FFFFFF"), 10.0f, true, Color.parseColor("#FFFFFF")));
        }

        @NotNull
        public final MedalDrawConfig c() {
            return a("qqlive_android_profile_fan_medal_json_v2", new MedalDrawConfig(60.0f, 16.0f, 7.0f, 8.6f, -2.0f, 1.5f, 1.5f, 10.0f, true, Color.parseColor("#FFFFFF"), 10.0f, true, Color.parseColor("#FFFFFF")));
        }

        Companion() {
        }
    }

    public MedalDrawConfig(float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, boolean z16, int i3, float f36, boolean z17, int i16) {
        this.totalWidth = f16;
        this.totalHeight = f17;
        this.loveLeftPadding = f18;
        this.loveWidth = f19;
        this.loveToNamePadding = f26;
        this.levelHOffset = f27;
        this.nameHOffset = f28;
        this.levelTextSize = f29;
        this.isLevelBold = z16;
        this.leveTextColor = i3;
        this.nameTextSize = f36;
        this.isNameBold = z17;
        this.nameTextColor = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getLeveTextColor() {
        return this.leveTextColor;
    }

    /* renamed from: b, reason: from getter */
    public final float getLevelHOffset() {
        return this.levelHOffset;
    }

    /* renamed from: c, reason: from getter */
    public final float getLevelTextSize() {
        return this.levelTextSize;
    }

    /* renamed from: d, reason: from getter */
    public final float getLoveLeftPadding() {
        return this.loveLeftPadding;
    }

    /* renamed from: e, reason: from getter */
    public final float getLoveToNamePadding() {
        return this.loveToNamePadding;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MedalDrawConfig)) {
            return false;
        }
        MedalDrawConfig medalDrawConfig = (MedalDrawConfig) other;
        if (Float.compare(this.totalWidth, medalDrawConfig.totalWidth) == 0 && Float.compare(this.totalHeight, medalDrawConfig.totalHeight) == 0 && Float.compare(this.loveLeftPadding, medalDrawConfig.loveLeftPadding) == 0 && Float.compare(this.loveWidth, medalDrawConfig.loveWidth) == 0 && Float.compare(this.loveToNamePadding, medalDrawConfig.loveToNamePadding) == 0 && Float.compare(this.levelHOffset, medalDrawConfig.levelHOffset) == 0 && Float.compare(this.nameHOffset, medalDrawConfig.nameHOffset) == 0 && Float.compare(this.levelTextSize, medalDrawConfig.levelTextSize) == 0 && this.isLevelBold == medalDrawConfig.isLevelBold && this.leveTextColor == medalDrawConfig.leveTextColor && Float.compare(this.nameTextSize, medalDrawConfig.nameTextSize) == 0 && this.isNameBold == medalDrawConfig.isNameBold && this.nameTextColor == medalDrawConfig.nameTextColor) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final float getLoveWidth() {
        return this.loveWidth;
    }

    /* renamed from: g, reason: from getter */
    public final float getNameHOffset() {
        return this.nameHOffset;
    }

    /* renamed from: h, reason: from getter */
    public final int getNameTextColor() {
        return this.nameTextColor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((((((((((((Float.floatToIntBits(this.totalWidth) * 31) + Float.floatToIntBits(this.totalHeight)) * 31) + Float.floatToIntBits(this.loveLeftPadding)) * 31) + Float.floatToIntBits(this.loveWidth)) * 31) + Float.floatToIntBits(this.loveToNamePadding)) * 31) + Float.floatToIntBits(this.levelHOffset)) * 31) + Float.floatToIntBits(this.nameHOffset)) * 31) + Float.floatToIntBits(this.levelTextSize)) * 31;
        boolean z16 = this.isLevelBold;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int floatToIntBits2 = (((((floatToIntBits + i16) * 31) + this.leveTextColor) * 31) + Float.floatToIntBits(this.nameTextSize)) * 31;
        boolean z17 = this.isNameBold;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((floatToIntBits2 + i3) * 31) + this.nameTextColor;
    }

    /* renamed from: i, reason: from getter */
    public final float getNameTextSize() {
        return this.nameTextSize;
    }

    /* renamed from: j, reason: from getter */
    public final float getTotalHeight() {
        return this.totalHeight;
    }

    /* renamed from: k, reason: from getter */
    public final float getTotalWidth() {
        return this.totalWidth;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsLevelBold() {
        return this.isLevelBold;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsNameBold() {
        return this.isNameBold;
    }

    @NotNull
    public String toString() {
        return "MedalDrawConfig(totalWidth=" + this.totalWidth + ", totalHeight=" + this.totalHeight + ", loveLeftPadding=" + this.loveLeftPadding + ", loveWidth=" + this.loveWidth + ", loveToNamePadding=" + this.loveToNamePadding + ", levelHOffset=" + this.levelHOffset + ", nameHOffset=" + this.nameHOffset + ", levelTextSize=" + this.levelTextSize + ", isLevelBold=" + this.isLevelBold + ", leveTextColor=" + this.leveTextColor + ", nameTextSize=" + this.nameTextSize + ", isNameBold=" + this.isNameBold + ", nameTextColor=" + this.nameTextColor + ")";
    }
}
